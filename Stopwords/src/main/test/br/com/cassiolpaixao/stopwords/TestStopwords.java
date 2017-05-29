package br.com.cassiolpaixao.stopwords;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.Test;

import br.com.cassiopaixao.stopwords.converter.Converter;

public class TestStopwords {

	@Test
	public void test() throws UnsupportedEncodingException,
			FileNotFoundException, ParserConfigurationException, IOException,
			TransformerException, URISyntaxException {
		
		Converter.createStopwordXml();
	}

}
