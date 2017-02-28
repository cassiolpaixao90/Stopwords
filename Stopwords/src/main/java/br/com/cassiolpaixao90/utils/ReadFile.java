package br.com.cassiolpaixao90.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import br.com.cassiolpaixao90.conf.Configuracao;

public class ReadFile {

	Properties properties = null;
	InputStream in = null;
	BufferedReader bufferedReader = null;
	List<String> stopWords = null;

	public <T> String readConfig(T nomepath) {
		try {
			this.properties = new Properties();
			this.in = path(Configuracao.getConfig());
			properties.load(in);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return properties.getProperty(nomepath.toString());
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> readStopWords(List<String> nomes, String pathStopWords) throws Exception {
		this.stopWords = new ArrayList<String>();
		this.in = path(pathStopWords);
		if (in == null) {
			return null;
		}
		try {
			this.bufferedReader = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				// if (list.contains(line)) {
				nomes.add(line);
				// }
			}
			bufferedReader.close();
			bufferedReader = null;
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return (List<T>) nomes;
	}

	private InputStream path(String stopWordsFilename) {
		InputStream in = this.getClass().getResourceAsStream(stopWordsFilename);
		return in;
	}

}
