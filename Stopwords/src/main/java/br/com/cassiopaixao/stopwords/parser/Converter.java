package br.com.cassiopaixao.stopwords.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import br.com.cassiopaixao.stopwords.constant.Constant;

public abstract class Converter {

	public static List<String> readTxtFile() throws IOException {
		List<String> result = new ArrayList<String>();
		String path = new File(Constant.PATH_STOPWORD_TXT).getAbsolutePath();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				result.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void createStopwordXml() throws ParserConfigurationException,
			UnsupportedEncodingException, FileNotFoundException, IOException,
			TransformerException, URISyntaxException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		Element stopwordsTag = doc.createElement("stopwors");
		doc.appendChild(stopwordsTag);

		List<String> strings = Converter.readTxtFile();
		for (String nome : strings) {
			Element nameTag = doc.createElement("name");
			nameTag.setAttribute("nome", nome);
			stopwordsTag.appendChild(nameTag);
		}

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();

		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount",
				"4");

		DOMSource source = new DOMSource(doc);

		String path = new File(Constant.PATH).getAbsolutePath();
		try (OutputStreamWriter osw = new OutputStreamWriter(
				new FileOutputStream(path), "UTF-8")) {
			StreamResult result = new StreamResult(osw);
			trans.transform(source, result);
		}
	}

	public List<String> readXmlFile() {
		return null;
	}

}
