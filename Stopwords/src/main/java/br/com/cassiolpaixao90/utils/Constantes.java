package br.com.cassiolpaixao90.utils;

import java.util.HashMap;
import java.util.Properties;

public class Constantes { 
 
	private HashMap<String, String> hashConstantes = new HashMap<String, String>();
	private Properties properties = new Properties();  

	public Constantes() { 
		try {
			this.properties.load(this.getClass().getResourceAsStream("../conf/config.properties"));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} 
		this.hashConstantes.put("outputfile", properties.getProperty("outputfile")); 
	}

	public String get(String nome) {
		return (String) hashConstantes.get(nome);
	}
	
}
 