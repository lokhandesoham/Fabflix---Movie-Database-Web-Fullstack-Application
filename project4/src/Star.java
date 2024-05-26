

import java.util.ArrayList;

/*import org.apache.commons.lang3.StringUtils;*/

public class Star {
	
	private int birthYear;
	private String name;
	//private ArrayList<Movie> movies;
	
	public Star( int birthYear, String name) {

		this.birthYear = birthYear;
		this.name = name;
	}
	// public Star(String id, String birthYear, String name, ArrayList<Movie> movies) {
	// 	this.movies = movies;
	// 	this.id = id;
	// 	this.birthYear = birthYear;
	// 	this.name = name;
	// }
	public Star() {
		// TODO Auto-generated constructor stub
	}
	// public ArrayList<Movie> getMovies() {
	// 	return movies;
	// }
	// public void setMovies(ArrayList<Movie> movies) {
	// 	this.movies = movies;
	// }
	// public String getId() {
	// 	return id;
	// }
	// public void setId(String id) {
	// 	this.id = id;
	// }
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	For Testing Parsing
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Star Details - ");
		sb.append("Name: " + getName());
		sb.append(" | ");
		sb.append("DOB: " + getBirthYear());
        
		return sb.toString();
	}
}