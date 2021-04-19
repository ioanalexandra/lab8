package lab8.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import lab8.Conexiune;
//ia informatiile din baza de date si le introduce intr un obiect
public class MovieDaoManager implements MovieDao, GenreDao {

	public List<Movie> getMovies() {
		List<Movie> movieList = null;
		Statement s = null;
		ResultSet r = null; // avem nevoie de ele pt a rula query
		try {
			s = getConnection().createStatement();
			r = s.executeQuery("Select * from movies ;");
			// preiau rezultatele
			while (r.next()) {
				String title = r.getString("title");
				String releaseDate = r.getString("release_date");
				String duration = r.getString("duration");
				String score = r.getString("score");
				String movieId = r.getString("id");
				movieList.add(new Movie(title, duration, releaseDate, null, Integer.parseInt(score),
						Integer.parseInt(movieId)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (r != null) {
				try {
					r.close();
				} catch (SQLException e) {

				}
			}

			if (s != null) {
				try {
					s.close();
				} catch (SQLException e) {

				}
			}
		}
		return movieList;
	}

	public Movie getMovie(int id) {
		Movie movie = null;
		Statement s = null;
		ResultSet r = null; // avem nevoie de ele pt a rula query
		try {
			s = getConnection().createStatement();
			r = s.executeQuery("Select * from movies where id=" + id + ";");
			// preiau rezultatele
			while (r.next()) {
				String title = r.getString("title");
				String releaseDate = r.getString("release_date");
				String duration = r.getString("duration");
				String score = r.getString("score");
				String movieId = r.getString("id");
				movie = new Movie(title, duration, releaseDate, null, Integer.parseInt(score),
						Integer.parseInt(movieId));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (r != null) {
				try {
					r.close();
				} catch (SQLException e) {

				}
			}

			if (s != null) {
				try {
					s.close();
				} catch (SQLException e) {

				}
			}
		}
		return movie;
	}

	public void update(Movie m) {


	}

	public void delete(Movie m) {

	}

	public Conexiune getConnection() {
		return Conexiune.getInstance();
	}

	public Movie getMovie(String titleName) {
		Movie movie = null;
		Statement s = null;
		ResultSet r = null; // avem nevoie de ele pt a rula query
		try {
			s = getConnection().createStatement();
			r = s.executeQuery("Select * from movies where title LIKE '" + titleName + "';");
			// preiau rezultatele
			while (r.next()) {
				String title = r.getString("title");
				String releaseDate = r.getString("release_date");
				String duration = r.getString("duration");
				String score = r.getString("score");
				String movieId = r.getString("id");
				movie = new Movie(title, duration, releaseDate, null, Integer.parseInt(score),
						Integer.parseInt(movieId));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (r != null) {
				try {
					r.close();
				} catch (SQLException e) {

				}
			}

			if (s != null) {
				try {
					s.close();
				} catch (SQLException e) {

				}
			}
		}
		return movie;
	}

	public void addMovie(Movie m) {

		Statement st = null;
		try {
			st = getConnection().createStatement();
			st.executeUpdate("INSERT INTO movies (title, release_date, duration, score) values('" + m.getTitle()
					+ "', '" + m.getReleaseDate() + "', '" + m.getDuration() + "', '" + m.getScore() + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Genre getMovieGenre(Movie m) {
		Genre genre = null;
		Statement s = null;
		ResultSet r = null; // avem nevoie de ele pt a rula query
		try {
			s = getConnection().createStatement();
			r = s.executeQuery(
					"SELECT g.name AS 'genre' FROM movies m JOIN relation r ON r.movie_id = m.id JOIN genres g ON r.genre_id = g.id WHERE m.id ="
							+ m.getId() + ";");
			// preiau rezultatele
			while (r.next()) {
				String g = r.getString("genre");
				genre = new Genre(g);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (r != null) {
				try {
					r.close();
				} catch (SQLException e) {

				}
			}

			if (s != null) {
				try {
					s.close();
				} catch (SQLException e) {

				}
			}
		}
		return genre;
	}

	public List<Genre> getGenres() {

		return null;
	}

	public void updateGenre(Genre g) {
		// TODO Auto-generated method stub

	}

	public void deleteGenre(Genre g) {
		// TODO Auto-generated method stub

	}

}
