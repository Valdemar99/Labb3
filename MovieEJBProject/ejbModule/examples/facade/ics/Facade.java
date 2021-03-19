package examples.facade.ics;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import examples.eao.ics.MovieEAOLocal;
import examples.ejb.ics.Movie;

/**
 * Session Bean implementation class Facade
 */
@Stateless
public class Facade implements FacadeLocal {
	
	@EJB
	private MovieEAOLocal movieEAO;

    /**
     * Default constructor. 
     */
    public Facade() {
        // TODO Auto-generated constructor stub
    }
    
    public Movie findByMovieID(long id) {
    	return movieEAO.findByMovieID(id);
    }
    
    public Movie createMovie(Movie movie) {
    	return movieEAO.createMovie(movie);
    }
    
    public Movie updateMovie(Movie movie) {
    	return movieEAO.updateMovie(movie);
    }
    
    public void deleteMovie(long id) {
    	movieEAO.deleteMovie(id);
    }

}
