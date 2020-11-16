package br.com.lucaswagner.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JavaUtil {

	public static LocalDate ConverterParaData(String data) {

		String str = data.replaceAll("\\.", "/");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateTime = null;
		
		try {
			dateTime = LocalDate.parse(str, dtf);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro ao Converter a Data");
		}

		return dateTime;
	}
	
	public static String ConverterParaString(LocalDate data){
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String dataStr = data.format(dtf);
		
		return dataStr;
		
	}

}
