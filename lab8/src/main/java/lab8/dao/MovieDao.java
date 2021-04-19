package lab8.dao;

import java.util.List;

import lab8.Conexiune;

public interface MovieDao {
	public List<Movie> getMovies();

	public Movie getMovie(int id);

	public Movie getMovie(String titleName);

	public void update(Movie m);

	public void delete(Movie m);

	public Conexiune getConnection();

	public void addMovie(Movie m);
}
