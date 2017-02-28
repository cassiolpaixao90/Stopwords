package br.com.cassiolpaixao90.conf;

public class Configuracao {

	private static final String CONFIG = "/configuracao/config.txt";
	private static final String STOPWORDS = "outputfile";

	public static String getConfig() {
		return CONFIG;
	}

	public static String getStopwords() {
		return STOPWORDS;
	}

}
