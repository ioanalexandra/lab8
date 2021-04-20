package lab8.dao;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvIgnore;

public class Movie {
//obiect de tip movie care e independent de baza de date
	
	// punem adnotari ca sa stie cum sa converteasca OpenCSvul
	@CsvBindByName
	private String title;
	@CsvBindByName
	private int duration;
	@CsvBindByName(column = "date_published")
	private String releaseDate;
	@CsvBindByName(column = "reviews_from_critics")
	private int score;
	@CsvIgnore
	private final int id;
	@CsvBindByName
	private String genre;

	public Movie() {
		id = 1;
	}

	public Movie(String title, int duration, String releaseDate, String genre, int score, int id) {
		this.title = title;
		this.duration = duration;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.score = score;
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", duration=" + duration + ", releaseDate=" + releaseDate + ", genre=" + genre
				+ ", score=" + score + ", id=" + id + "]";
	}

}