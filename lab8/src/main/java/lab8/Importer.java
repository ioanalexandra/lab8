package lab8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import lab8.dao.Movie;
import lab8.dao.MovieDaoManager;

public class Importer {
	public void read(String path) {
		try {
			CsvToBean<Movie> b = new CsvToBeanBuilder<Movie>(new FileReader(path)).withType(Movie.class).build();
			Iterator<Movie> it = b.iterator();
			MovieDaoManager moviesManager = new MovieDaoManager();
			while (it.hasNext()) {
				// System.out.println(it.next());
				moviesManager.addMovie(it.next());
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
