package br.com.cassiolpaixao90.WordSemantic.Interfaces;

import java.util.List;

public interface IReadFile {

	public <T> String readConfig(T nomepath);
	
	public <T> List<T> readStopWords(List<String> nomes, String pathStopWords) ;
}
