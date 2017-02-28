package br.com.cassiolpaixao90.WordSemantic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import br.com.cassiolpaixao90.WordSemantic.Interfaces.ExtractorFileTxt;
import br.com.cassiolpaixao90.conf.Configuracao;
import br.com.cassiolpaixao90.utils.Util;

public class StopWord implements ExtractorFileTxt {

	private String nome;
	private List<StopWord> stopWords;

	protected static String pathStopWords = null;
	protected Configuracao configuracao = null;

	public StopWord(String nome) {
		this.nome = nome;
	}

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
		this.StopWords = new ArrayList<T>();

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
		String nome = "à a teste então porque";
		
		Configuracao configuracao = new Configuracao();
		List<String> lista = configuracao.readStopWords(Util.tokenizerString(new StopWord(nome)), pathStopWords);
		List<String> listaNova = getStopWords().removeStopWords(nome, lista);
		String nome1 = (String) listaNova.toString();
		System.out.println(nome1);

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void adicionaStopWord(StopWord stopWord){
		stopWords.add(stopWord);
	}

	 

}
