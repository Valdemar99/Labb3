package examples.eao.ics;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import examples.ejb.ics.Movie;

/**
 * Session Bean implementation class MovieEAOImpl
 */
@Stateless
public class MovieEAOImpl implements MovieEAOLocal {
	
	@PersistenceContext(unitName="LabEJBSql")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public MovieEAOImpl() {
        // TODO Auto-generated constructor stub
    }
    
    public Movie findByMovieID(long id) {
    	return em.find(Movie.class, id);
    }
    
    public Movie createMovie(Movie movie) {
    	em.persist(movie);
    	return movie;
    }
    
    public Movie updateMovie(Movie movie) {
    	em.merge(movie);
    	return movie;
    }
    
    public void deleteMovie(long id) {
    	Movie m = this.findByMovieID(id);
    	if(m != null) {
    		em.remove(m);
    	}
    }
}
