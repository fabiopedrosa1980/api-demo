package br.com.pedrosa.api.service.impl;

import br.com.pedrosa.api.domain.*;
import br.com.pedrosa.api.dto.SaleDTO;
import br.com.pedrosa.api.dto.SaleInDTO;
import br.com.pedrosa.api.exception.ResourceNotFoundException;
import br.com.pedrosa.api.repository.CashBackRepository;
import br.com.pedrosa.api.repository.SaleAlbumRepository;
import br.com.pedrosa.api.repository.SaleRepository;
import br.com.pedrosa.api.service.ConfigPriceService;
import br.com.pedrosa.api.service.SaleService;
import br.com.pedrosa.api.utils.ApiUtils;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
@Log4j2
public class SaleServiceImpl implements SaleService {
	
	private SaleRepository saleRepository;
	private CashBackRepository cashBackRepository;
	private ConfigPriceService configPriceService;
	private SaleAlbumRepository saleAlbumRepository;
	private ModelMapper modelMapper;

	@Override
	public SaleDTO sell(SaleInDTO saleIn) {
		Sale sale = this.convertToEntity(saleIn);
		this.buildSale(sale);
		
		Sale saleReturn = saleRepository.save(sale);
		this.saveCashBack(saleReturn);
		saleReturn.setCashBacks(this.getCashBacksSale(saleReturn));
		
		this.saveSaleAlbum(sale, saleReturn);
		
		return this.convertToDTO(saleReturn);
	}

	private void saveSaleAlbum(Sale sale, Sale saleReturn) {
		sale.getAlbuns().forEach(album -> 
			saleAlbumRepository.save(new SaleAlbum(new SaleAlbumPK(saleReturn.getId(), album.getId())))
		);
	}
	
	void saveCashBack(Sale sale){
		sale.getAlbuns().forEach(album -> {
			log.info("dia da semana" + ApiUtils.getDayOfWeek());
			log.info("genero" +  album.getGenre().getId());
			ConfigPrice cp =  this.configPriceService.findByDayAndGenreId(ApiUtils.getDayOfWeek(), album.getGenre().getId());
			if(cp != null){
				cashBackRepository.save(new CashBack(null,this.buildPrice(album, cp), sale.getId(), album.getId()));
			}
		});
	}
	
	private void buildSale(Sale sale){
		Double total = 0.0;
		Double cashBack = 0.0;
		for (Album album : sale.getAlbuns()) {
			total = buildTotalSale(total, album);
			ConfigPrice cp =  this.configPriceService.findByDayAndGenreId(ApiUtils.getDayOfWeek(), album.getGenre().getId());
			if(cp!=null) {
				cashBack = buildTotalCashBack(cashBack, album, cp);
			}
		}
		sale.setCashBack(cashBack);
		sale.setTotalOrder(total);
	}

	private Double buildTotalCashBack(Double cashBack, Album album, ConfigPrice cp) {
		cashBack += buildPrice(album, cp);
		return ApiUtils.round(cashBack,2);
	}

	private Double buildTotalSale(Double total, Album album) {
		total += album.getPrice();
		return ApiUtils.round(total,2);
	}

	private Double buildPrice(Album album, ConfigPrice cp) {
		return ApiUtils.round(album.getPrice() * (cp.getPercent()/100),2);
	}
	
	@Override
	public SaleDTO findById(Long id) throws ResourceNotFoundException {
		Sale sale = saleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sale not found on "+ id));		

		sale.setCashBacks(getCashBacksSale(sale));

		return this.convertToDTO(sale);
	}

	private Set<CashBack> getCashBacksSale(Sale sale) {
		return cashBackRepository.findByIdSale(sale.getId());
	}

	@Override
	public Page<SaleDTO> findAllSallesByPeriod(String startDate, String endDate, Pageable page) {
		return this.buildPageDTO(saleRepository.findAllSallesByPeriod(startDate, endDate, page));
	}
	
	private Page<SaleDTO> buildPageDTO(Page<Sale> sales) {
		return sales.map(sale -> convertToDTO(sale));
		
	}
	
	private SaleDTO convertToDTO(Sale sale) {

		return modelMapper.map(sale, SaleDTO.class);
	}

	private Sale convertToEntity(SaleInDTO vendaEntradaDTO) {

		return modelMapper.map(vendaEntradaDTO, Sale.class);
	}

}
