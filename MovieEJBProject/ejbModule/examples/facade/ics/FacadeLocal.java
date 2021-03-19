package examples.facade.ics;

import javax.ejb.Local;

import examples.ejb.ics.Movie;


@Local
public interface FacadeLocal {
	public Movie findByMovieID(long id);
	public Movie createMovie(Movie movie);
	public Movie updateMovie(Movie movie);
	public void deleteMovie(long id);
}
