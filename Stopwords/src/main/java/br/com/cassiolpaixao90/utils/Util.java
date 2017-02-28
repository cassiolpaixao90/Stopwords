package br.com.cassiolpaixao90.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import br.com.cassiolpaixao90.WordSemantic.StopWord;

public class Util {

	private static StringTokenizer tokenizer = null;
	private static List<StopWord> stopWords;
	
	public static List<StopWord> tokenizerString(StopWord stopWord){
		stopWords = new ArrayList<StopWord>();
		tokenizer = new StringTokenizer(stopWord.getNome(), " ");
		while (tokenizer.hasMoreElements()) {
			adicionaStopWord(tokenizer.nextElement().toString());
		}
		return stopWords;
	}

	public static void adicionaStopWord(String nome){
		stopWords.add(new StopWord(nome));
	}
}
