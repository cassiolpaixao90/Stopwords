package br.com.cassiolpaixao90.WordSemantic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import br.com.cassiolpaixao90.WordSemantic.Interfaces.ExtractorFileTxt;
import br.com.cassiolpaixao90.utils.Constantes;

public class StopWords implements ExtractorFileTxt {
	Scanner readStopWordFile;
	List<String> listStopWord = null; 

	public boolean searchForStopWord(String word,List<String> textForCheck) {
		boolean achou = false;
		for (int i = 0; i < textForCheck.size(); i++) {			
			if(!textForCheck.contains(word)){ 
				achou = true;
				break;
			} 
		}
		return achou;
	}

	public List<String> readStopWords(String stopWordsFilename) throws Exception { 
		this.listStopWord = new ArrayList<String>();
		try {  
			readStopWordFile = new Scanner(new File(stopWordsFilename));
			readStopWordFile.useDelimiter("\r\n");
			while (readStopWordFile.hasNext()) { 
				this.listStopWord.add(readStopWordFile.next()); 
			}
			return this.listStopWord;
		}catch (FileNotFoundException ex) {
            System.err.println("Exception : "+ex.getMessage());
        }
		return null;
	}
 
	public List<String> removeStopWords(String nome, List<String> stopWords) {
		this.listStopWord = new ArrayList<String>();
		try {
			StringTokenizer tokenizer = new StringTokenizer(nome, " ");
			while (tokenizer.hasMoreElements()) { 
				String newName = tokenizer.nextElement().toString(); 
				boolean retorno = searchForStopWord(newName, stopWords);
				if (retorno){
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
		Constantes constantes = new Constantes();
		String nome ="à a teste então porque"; 
		List<String> lista = stopWords.readStopWords(constantes.get("outputfile")); 
		List<String> listaNova = stopWords.removeStopWords(nome, lista);
		String nome1 = (String) listaNova.toString();
		System.out.println(nome1);
		
	}
}
