

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class CastXml extends DefaultHandler {

	private List<StarInMovie> stars;

	private String tempVal;
	// to maintain context
	private StarInMovie tempStarInMovie;

	public List<StarInMovie> getStars() {
		return stars;
	}

	public void setStars(List<StarInMovie> stars) {
		this.stars = stars;
	}

	public CastXml() {
		stars = new ArrayList<StarInMovie>();
        parseDocument();
	}

	public void runExample() {
		//parseDocument();
		printData();
	}

	private void parseDocument() {

		// get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {

			// get a new instance of parser
			SAXParser sp = spf.newSAXParser();

			// parse the file and also register this class for call backs
			sp.parse("/home/ubuntu/stanford-movies/casts124.xml", this);
			// sp.parse("stanford-movies/casts124.xml", this);

		} catch (SAXException se) {
			se.printStackTrace();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	/**
	 * Iterate through the list and print the contents
	 */
	private void printData() {
        Iterator<StarInMovie> iterator = stars.iterator();
        while (iterator.hasNext()) {
            StarInMovie star = iterator.next();
            if ( star.getFid().trim().isEmpty() ||  star.getName().trim().isEmpty()) {
                iterator.remove();
            }
        }

		System.out.println("No of Stars '" + stars.size() + "'.");

		// Iterator<StarInMovie> it = stars.iterator();
		// while (it.hasNext()) {
		// 	System.out.println(it.next().toString());
		// }
	}

	// Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// reset
		tempVal = "";
		if (qName.equalsIgnoreCase("m")) {
			// create a new instance of star
			tempStarInMovie = new StarInMovie();
		}
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch, start, length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (qName.equalsIgnoreCase("m")) {
			// add it to the list
			stars.add(tempStarInMovie);

		} 
        else if (qName.equalsIgnoreCase("f")) {
            if(tempVal.equalsIgnoreCase("")){ 
				System.out.println("In casts124.xml - at  <m> -  <f> is missing");
				}

			tempStarInMovie.setFid(tempVal);
		} 
        // else if (qName.equalsIgnoreCase("t")) {
		// 	tempStarInMovie.setTitle(tempVal);
		// } 
        else if (qName.equalsIgnoreCase("a")) {
            if(tempVal.equalsIgnoreCase("")){ 
				System.out.println("In casts124.xml - at  <m><f>"+tempStarInMovie.getFid()+" <a> star name is missing");
				}
			tempStarInMovie.setName(tempVal);
		}
	}

	public static void main(String[] args) {
		CastXml spe = new CastXml();
		spe.runExample();
	}

}