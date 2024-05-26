

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class MainXml extends DefaultHandler 
{

	//HashMap<String, Movies> myMovies;
    List<Movies> myMovies;

    private String tempVal;
    //to maintain context
    private Movies tempMovie;

    public MainXml() {
        myMovies = new ArrayList<Movies>();
        parseDocument();
    }

    public void runExample() {
        //parseDocument();
        printData();
    }
    
    private void parseDocument() {

        //get a factory
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {

            //get a new instance of parser
            SAXParser sp = spf.newSAXParser();

            //parse the file and also register this class for call backs
            sp.parse("/home/ubuntu/stanford-movies/mains243.xml", this);
            // sp.parse("stanford-movies/mains243.xml", this);

        } catch (SAXException se) {
            se.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    /**
     * Iterate through the list and print
     * the contents
     */
    private void printData() {
        Iterator<Movies> iterator = myMovies.iterator();
        while (iterator.hasNext()) {
            Movies movie = iterator.next();
            if ( movie.getId().trim().isEmpty() ||  movie.getTitle().trim().isEmpty() ||movie.getYear() == -1 || movie.getDirector().trim().isEmpty()) {
                iterator.remove();
            }
        }


    	System.out.println("No of Movies '" + myMovies.size() + "'.");

    //    Iterator it = myMovies.iterator();
    //    while (it.hasNext()) {
    //        System.out.println(it.next().getVa.toString());
    //    }
        
        // Iterator<Movies> it = myMovies.iterator();
		// while (it.hasNext()) {
		// 	System.out.println(it.next().toString());
		// }
    }

    //Event Handlers
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //reset
        tempVal = "";
        if (qName.equalsIgnoreCase("film")) {
            //create a new instance of employee
            tempMovie = new Movies();
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException 
    {

        if (qName.equalsIgnoreCase("film")) {
            //add it to the list
            //myMovies.put(tempMovie.getId(), tempMovie);
            myMovies.add(tempMovie);

        } else if (qName.equalsIgnoreCase("t")) 
        {
            if(tempVal.equalsIgnoreCase("")){ 
				System.out.println("In mains243.xml - at actor <film><fid>"+tempMovie.getId()+" title is missing ");
				}
               
            tempMovie.setTitle(tempVal);
               
        } 
        else if (qName.equalsIgnoreCase("fid")) 
        {
            if(tempVal.equalsIgnoreCase("")){ 
				System.out.println("In mains243.xml - at actor <film><fid>"+tempMovie.getId()+" <fid> is missing");
				}
        	tempMovie.setId(tempVal);
        } 
        else if (qName.equalsIgnoreCase("year")) 
        {
        	try {
        	tempMovie.setYear(Integer.parseInt(tempVal));
        	} 
            catch (Exception e) {
                System.out.println("In main243.xml - at actor <film><fid>"+tempMovie.getId()+" <year>"+tempVal+" year is not an integer");
                tempMovie.setYear(-1);
                }
        
        } 
        else if (qName.equalsIgnoreCase("dirn")) 
        {
        	if(tempVal.equalsIgnoreCase("")){ 
				System.out.println("In mains243.xml - at actor <film><fid>"+tempMovie.getId()+" director is missing");
				}
               
            tempMovie.setDirector(tempVal);
               
        } 
        else if (qName.equalsIgnoreCase("cat")) 
        {
        	if(tempVal.equalsIgnoreCase("")){ 
				System.out.println("In mains243.xml - at actor <film><fid>"+tempMovie.getId()+" genre is missing");
				}
            
            tempMovie.setGenre(tempVal);
               
        } 
        else{return;}

        
	}

    public List<Movies> getmyMovies() 
    {
		return myMovies;
    }



    
public static void main(String[] args) {
    	MainXml spe = new MainXml();
        spe.runExample();
    }

}