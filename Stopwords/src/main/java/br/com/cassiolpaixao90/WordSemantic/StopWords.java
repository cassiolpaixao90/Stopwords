package br.com.cassiolpaixao90.WordSemantic;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import br.com.cassiolpaixao90.WordSemantic.Interfaces.ExtractorFileTxt;
import br.com.cassiolpaixao90.conf.Configuracao;

public class StopWords implements ExtractorFileTxt {
	Scanner readStopWordFile;
	List<String> listStopWord = null;

	public boolean searchForStopWord(String word, List<String> textForCheck) {
		boolean achou = false;
		for (int i = 0; i < textForCheck.size(); i++) {
			if (!textForCheck.contains(word)) {
				achou = true;
				break;
			}
		}
		return achou;
	}

	public List<String> readStopWords(String stopWordsFilename) throws Exception {
		this.listStopWord = new ArrayList<String>();

		// InputStream in =
		// ClassLoader.getSystemClassLoader().getResourceAsStream(stopWordsFilename);
		InputStream in = this.getClass().getResourceAsStream(stopWordsFilename);
		if (in == null) {
			return null;
		}

		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(line).append("\n");
				listStopWord.add(stringBuilder.toString());
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return this.listStopWord;
	}

	public List<String> removeStopWords(String nome, List<String> stopWords) {
		this.listStopWord = new ArrayList<String>();
		try {
			StringTokenizer tokenizer = new StringTokenizer(nome, " ");
			while (tokenizer.hasMoreElements()) {
				String newName = tokenizer.nextElement().toString();
				boolean retorno = searchForStopWord(newName, stopWords);
				if (retorno) {
					this.listStopWord.add(newName);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return this.listStopWord;
	}

	public static void main(String[] args) throws Exception {
		StopWords stopWords = new StopWords();
		Configuracao configuracao = new Configuracao();
		String nome = "à a teste então porque";
		List<String> lista = configuracao.readStopWords(tokenizerString(nome),  configuracao.lerArquivoConfiguracao("outputfile"));
		List<String> listaNova = stopWords.removeStopWords(nome, lista);
		String nome1 = (String) listaNova.toString();
		System.out.println(nome1);

	}
	
	public static List<?> tokenizerString(String nome){
		StringTokenizer tokenizer = new StringTokenizer(nome, " ");
		List<String>strings = new ArrayList<String>();
		while (tokenizer.hasMoreElements()) {
			strings.add(tokenizer.nextElement().toString());
		}
		return strings;
		
	}
}
