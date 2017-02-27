package br.com.cassiolpaixao90.WordSemantic.Interfaces;

import java.util.List;

public interface ExtractorFileTxt {
	
	public boolean searchForStopWord(String word, List<String> textForCheck);
	public List<String> readStopWords(String stopWordsFilename) throws Exception;
	public List<String> removeStopWords(String textFilename, List<String> stopWords) throws Exception;

}
