package lab8;

import lab8.dao.Movie;
import lab8.dao.MovieDaoManager;

public class Main {

	public static void main(String[] args) {

		/*
		 * MovieDaoManager moviesManager = new MovieDaoManager(); Movie m =
		 * moviesManager.getMovie(1); Movie m2 =
		 * moviesManager.getMovie("The Godfather"); System.out.println(m);
		 * System.out.println(m2); System.out.println(moviesManager.getMovieGenre(m2));
		 */
		// cream importerul si citim datele din fisier
		Importer imp = new Importer();
		imp.read("C:\\Users\\alexa\\Desktop\\IMDb movies.csv");
	}
}
