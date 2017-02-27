package br.com.cassiolpaixao90.WordSemantic.Example;

import java.util.List;
import java.util.Scanner;

import br.com.cassiolpaixao90.WordSemantic.StopWords;
import br.com.cassiolpaixao90.WordSemantic.Interfaces.ExtractorFileTxt;

public class TestStopWords {
	@SuppressWarnings("resource")
	public static void main(String[] arg) throws Exception {
		ExtractorFileTxt txt = new StopWords();

		System.out.print("Please type stop words file name: ");
		List<String> stopWords = txt.readStopWords(new Scanner(System.in).next());

		System.out.print("Please type text file name: ");
		txt.removeStopWords(new Scanner(System.in).next(), stopWords);

	}

}
