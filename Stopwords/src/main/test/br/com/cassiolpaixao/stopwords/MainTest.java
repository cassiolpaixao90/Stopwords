package br.com.cassiolpaixao.stopwords;

public class MainTest {

	public static void main(String[] args) {
		String txt = "OS102086 ; 2010-03-15 ; 0 ; 0 ; 2010-03-18 ; Este � um teste de arquivo;favor n�o quevra lalalalal";
		String[] quebrada = txt.split(";");
		for (String string : quebrada) {
			System.out.println(string);
		}
		
	}
}
