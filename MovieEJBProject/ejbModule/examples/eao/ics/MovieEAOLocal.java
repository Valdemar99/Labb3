package examples.eao.ics;

import javax.ejb.Local;

import examples.ejb.ics.Movie;

@Local
public interface MovieEAOLocal {
	
	public Movie findByMovieID(long id); 
	public Movie createMovie(Movie movie);
    public Movie updateMovie(Movie movie);
    public void deleteMovie(long id);
}
