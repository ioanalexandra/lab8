package lab8.dao;

public class Movie {
//obiect de tip movie care e independent de baza de date
	private String title, duration, releaseDate;
	private int score;
	private final int id;
	private Genre genre;

	public Movie(String title, String duration, String releaseDate, Genre genre, int score, int id) {
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
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