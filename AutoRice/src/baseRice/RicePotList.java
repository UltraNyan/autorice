package baseRice;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import java.io.File;
import java.util.ArrayList;

public class RicePotList {

	public static ArrayList<String> RicePotListGen() {

		ArrayList<String> ricePotList = new ArrayList<String>();

		try {

			File fXmlFile = new File("/home/swag/Sauce/autoricer/AutoRice/src/baseRice/rice.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("file");

			//System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getTextContent());
				ricePotList.add(nNode.getTextContent());


			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ricePotList;
	}
	


}
