

public class Movies {
	//Movie
	private String id;
	private String title;
	private int year;
	private String director;
	private String genre;
	private String uni_id;
	
	

	//GenreInMovie
	private int genreId;
	private String movieId;

	public Movies() {
		// TODO Auto-generated constructor stub
	}
	public Movies(String id, String title, int year, String director, String genre, String uni_id) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.director = director;
	}
	// public Movies(String genre)
	// {
	// 	this.genre = genre;
	// }
	// public Movies(int genreId, String movieId)
	// {
	// 	this.genreId = genreId;
	// 	this.movieId = movieId;
	// }
	public String getId() {
		return id== null ? "" : id;
	}
	public void setId(String id) {
		this.id = id;
	}
    public String getUniId() {
		return uni_id== null ? "" : id;
	}
	public void setUniId(String id) {
		this.uni_id = id;
	}
	public String getTitle() {
		return title== null ? "" : title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year == 0 ? -1 : year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getDirector() {
		return director == null ? "" : director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre== null ? "" : genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
    // public String getStar() {
	// 	return star;
	// }
	// public void setStar(String star) {
	// 	this.star = star;
	// }
	// public int getGenreId() {
	// 	return genreId;
	// }
	// public void setGenreId(int genreId) {
	// 	this.genreId = genreId;
	// }
	// public String getMovieId() {
	// 	return movieId;
	// }
	// public void setMovieId(String movieId) {
	// 	this.movieId = movieId;
	// }
	
//	For Testing Parsing
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Movie Details - ");
        sb.append("Fid: " + getId());
		sb.append(" | ");
		sb.append("Director Name: " + getDirector());
		sb.append(" | ");
		sb.append("Title: " + getTitle());
		sb.append(" | ");
		// sb.append("star: " + getStar());
		// sb.append(" | ");
		sb.append("Year: " + getYear());
		sb.append(" | ");
		sb.append("Genre: " + getGenre());
        sb.append(" | ");
		sb.append("UniId: " + getUniId());
		
		
		return sb.toString();
	}
}