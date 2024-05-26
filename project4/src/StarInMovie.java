
public class StarInMovie {
	//Movie

    private String fid;

	// private String title;
	
	
	// //StarInMovie
	// private String starId;
	// private String movieId;
	private String name;


	public StarInMovie() {
		// TODO Auto-generated constructor stub
	}
	
public StarInMovie(String title, String fid, String starId, String movieId, String name) {
		this.fid = fid;
		// this.title = title;
		// this.starId = starId;
		// this.movieId = movieId;
		this.name = name;
	}

// 	public String getTitle() {
// 	return title;
// }

// public void setTitle(String title) {
// 	this.title = title;
// }

public String getFid() {
	return fid;
}

public void setFid(String fid) {
	this.fid = fid;
}

// public String getStarId() {
// 	return starId;
// }

// public void setStarId(String starId) {
// 	this.starId = starId;
// }

// public String getMovieId() {
// 	return movieId;
// }

// public void setMovieId(String movieId) {
// 	this.movieId = movieId;
// }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

	//	For Testing Parsing
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Star In Movie - ");
		sb.append("fid: " + getFid());
		sb.append(" | ");
		// sb.append("Title: " + getTitle());
		// sb.append(" | ");
		sb.append("Actor: " + getName());
		sb.append(" | ");
		return sb.toString();
	}
}