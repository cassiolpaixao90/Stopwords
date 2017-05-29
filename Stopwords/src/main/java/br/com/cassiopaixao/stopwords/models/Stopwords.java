package br.com.cassiopaixao.stopwords.models;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author cassioluizpaixao
 *
 */
public class Stopwords implements Serializable {

	private static final long serialVersionUID = 1L;

	public void removeStopword(List<String> wordsList,
			List<String> stopWordsofwordnet) {

		for (int i = 0; i < wordsList.size(); i++) {
			for (int j = 0; j < stopWordsofwordnet.size(); j++) {
				if (stopWordsofwordnet.get(j).contains(wordsList.get(i))) {
					wordsList.remove(i);
				}
			}
		}
		for (String str : wordsList) {
			System.out.print(str + "");
		}
	}
}
