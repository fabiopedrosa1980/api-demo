package br.com.pedrosa.api.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;

public class ApiUtils {
	
	public static Double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public static String getDiaSemana() {
		LocalDate date = LocalDate.now();
		DayOfWeek dow = date.getDayOfWeek();
		Locale ptBr = new Locale("pt", "BR");
		return dow.getDisplayName(TextStyle.FULL, ptBr);
	}
	
	public static Double geraPrecoRandom() {
		return  round(new Random().nextDouble()*10,2);
	}
	
	public static String decode(String value) throws UnsupportedEncodingException {
	    return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
	}
	
	
}