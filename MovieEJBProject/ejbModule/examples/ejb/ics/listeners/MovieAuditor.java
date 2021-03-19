package examples.ejb.ics.listeners;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import examples.ejb.ics.Movie;

public class MovieAuditor {

	@PrePersist
	public void logCreate(Movie m) {
		System.out.print("@PrePersist id: "+m.getIdMovie());
		System.out.print(" from MovieAuditor - ");
		System.out.print(m.getTitle()+ " ");
		System.out.println(m.getPrice()+ " kr");
	}
	
	@PreUpdate
	public void logPreUpdate(Movie m) {
		System.out.print("@PreUpdate id: "+m.getIdMovie());
		System.out.print(" from MovieAuditor - ");
		System.out.print(m.getTitle()+ " ");
		System.out.println(m.getPrice()+ " kr");
	}
}
