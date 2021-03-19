package examples.ejb.ics;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;

import examples.ejb.ics.listeners.MovieAuditor;


@Entity
@EntityListeners(MovieAuditor.class)
@Table(name="Movie")
public class Movie implements Serializable {
	private long idMovie;
	private String title;
	private double price;
	
	@Id
	@Column(name="idMovie")
	public long getIdMovie() {
		return idMovie;
	}
	public void setIdMovie(long idMovie) {
		this.idMovie = idMovie;
	}
	
	@Column(name="title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="price")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@PostLoad
	public void logOperation() {
		System.out.print("@PostLoad on id: "+this.getIdMovie());
		System.out.print(" @PostLoad: "+this.getTitle() + " ");
		System.out.println(this.getPrice());
	}

}