package br.com.cassiolpaixao90.conf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Configuracao {

	private static final String CONFIG = "/configuracao/config.txt";

	public String lerArquivoConfiguracao(String nomepath) {
		Properties properties = new Properties();
		try {
			InputStream in = this.getClass().getResourceAsStream(CONFIG);
			properties.load(in);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return properties.getProperty(nomepath);
	}

	public List<String> readStopWords(List<?> list, String stopWordsFilename) throws Exception {
		ArrayList<String> listStopWord = new ArrayList<String>();
		InputStream in = this.getClass().getResourceAsStream(stopWordsFilename);
		if (in == null) {
			return null;
		}
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if (list.contains(line)) {
					listStopWord.add(line);
				}
			}
			bufferedReader.close();
			bufferedReader = null;
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return listStopWord;
	}

}
