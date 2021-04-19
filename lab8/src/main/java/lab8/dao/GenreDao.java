package lab8.dao;

import java.util.List;

public interface GenreDao {
	public Genre getMovieGenre(Movie m);

	public List<Genre> getGenres();

	public void updateGenre(Genre g);

	public void deleteGenre(Genre g);
}
