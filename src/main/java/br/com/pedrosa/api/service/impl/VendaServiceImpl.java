package br.com.pedrosa.api.service.impl;

import java.util.Set;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.pedrosa.api.domain.Album;
import br.com.pedrosa.api.domain.CashBack;
import br.com.pedrosa.api.domain.ConfigPreco;
import br.com.pedrosa.api.domain.Venda;
import br.com.pedrosa.api.domain.VendaAlbum;
import br.com.pedrosa.api.domain.VendaAlbumPK;
import br.com.pedrosa.api.dto.VendaDTO;
import br.com.pedrosa.api.dto.VendaEntradaDTO;
import br.com.pedrosa.api.repository.CashBackRepository;
import br.com.pedrosa.api.repository.VendaAlbumRepository;
import br.com.pedrosa.api.repository.VendaRepository;
import br.com.pedrosa.api.service.ConfigPrecoService;
import br.com.pedrosa.api.service.VendaService;
import br.com.pedrosa.api.utils.ApiUtils;

@Service
public class VendaServiceImpl extends AbstractService<Venda, Long> implements VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private CashBackRepository cashBackRepository;
	
	@Autowired
	private ConfigPrecoService configPrecoService;
	
	@Autowired
	private VendaAlbumRepository vendaAlbumRepository;
	
	
	@Autowired
	public void setRepository(VendaRepository vendaRepository) {
		super.setRepository(vendaRepository);
	}
	
	@Override
	public VendaDTO sell(VendaEntradaDTO vendaEntrada) {
		Venda venda = this.convertToEntity(vendaEntrada);
		this.buildSale(venda);
		
		Venda vendaRetorno = super.salvarComRetorno(venda);
		this.saveCashBack(vendaRetorno);
		vendaRetorno.setCashBacks(this.getCashBacksSale(vendaRetorno));
		
		this.saveVendaAlbum(venda, vendaRetorno);
		return this.convertToDTO(vendaRetorno);
	}

	private void saveVendaAlbum(Venda venda, Venda vendaRetorno) {
		Set<Album> albuns = venda.getAlbuns();
		for (Album album : albuns) {
			VendaAlbum va = new VendaAlbum(new VendaAlbumPK(vendaRetorno.getId(), album.getId()));
			vendaAlbumRepository.save(va);
		}
	}
	
	void saveCashBack(Venda venda){
		for (Album album : venda.getAlbuns()) {
			ConfigPreco cp =  this.configPrecoService.findByDiaAndGeneroId(ApiUtils.getDiaSemana(), album.getGenero().getId());
			cashBackRepository.save(new CashBack(this.buildPrice(album, cp), venda.getId(), album.getId()));
		}
	}
	
	private void buildSale(Venda venda){
		Double total = 0.0;
		Double cashBack = 0.0;
		for (Album album : venda.getAlbuns()) {
			total = buildTotalSale(total, album);
			ConfigPreco cp =  this.configPrecoService.findByDiaAndGeneroId(ApiUtils.getDiaSemana(), album.getGenero().getId());
			if(cp!=null) {
				cashBack = buildTotalCashBack(cashBack, album, cp);
			}
		}
		venda.setCashBack(cashBack);
		venda.setValorTotal(total);
	}

	private Double buildTotalCashBack(Double cashBack, Album album, ConfigPreco cp) {
		cashBack += buildPrice(album, cp);
		return ApiUtils.round(cashBack,2);
	}

	private Double buildTotalSale(Double total, Album album) {
		total += album.getPreco();
		return ApiUtils.round(total,2);
	}

	private Double buildPrice(Album album, ConfigPreco cp) {
		return ApiUtils.round(album.getPreco() * (cp.getPorcentagem()/100),2);
	}
	
	@Override
	public VendaDTO findById(Long id) {
		Venda venda = vendaRepository.findById(id).orElse(null);
		venda.setCashBacks(getCashBacksSale(venda));
		return this.convertToDTO(venda);
	}

	private Set<CashBack> getCashBacksSale(Venda venda) {
		Set<CashBack> cbs = cashBackRepository.findByIdVenda(venda.getId());
		return cbs;
	}

	@Override
	public Page<VendaDTO> findAllSallesByPeriod(String startDate, String endDate, Pageable page) {
		return this.buildPageDTO(vendaRepository.findAllSallesByPeriod(startDate, endDate, page));
	}
	
	private Page<VendaDTO> buildPageDTO(Page<Venda> vendas) {
		Page<VendaDTO> dtoVenda = vendas.map(new Function<Venda, VendaDTO>() {
		    @Override
		    public VendaDTO apply(Venda venda) {
		        return convertToDTO(venda);
		    }
		});
		return dtoVenda;
	}
	
	private VendaDTO convertToDTO(Venda venda) {
		VendaDTO generoDTO = modelMapper.map(venda, VendaDTO.class);
		return generoDTO;
	}
	private Venda convertToEntity(VendaEntradaDTO vendaEntradaDTO) {
		Venda venda = modelMapper.map(vendaEntradaDTO, Venda.class);
		return venda;
	}

}
