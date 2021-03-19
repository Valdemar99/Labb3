package org.ics.ejb.lab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.ejb.ics.Movie;
import examples.facade.ics.Facade;
import examples.facade.ics.FacadeLocal;


/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	FacadeLocal facade;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html><head>");
		out.println("<title>Lab3</title>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("</head><body>");
		
		out.println("<h2>Film</h2>");

		Movie movie = facade.findByMovieID(1);
		if(movie != null) {
			out.print("<p>" + movie.getTitle() + " ");
			out.print(movie.getPrice()+" kr </p>");
			movie.setPrice(47.50);
			facade.updateMovie(movie);
			
			out.print("<h4>**** Movie update ****</h4>");
			movie = facade.findByMovieID(1);
			out.print("<p>" + movie.getTitle() + " ");
			out.print(movie.getPrice() + " kr</p>");
			
			out.print("<h4>**** MovieFacade create ****");
			
			movie = new Movie();
			movie.setIdMovie(2);
			movie.setTitle("Harry Potter och de Vises Sten");
			movie.setPrice(200);
			
//			Movie createdMovie = facade.createMovie(movie);
//			out.print("<p>" + createdMovie.getTitle() + " ");
//			out.print(createdMovie.getPrice() + " kr</p>");
			
//			out.print("<h2>**** MovieEAO Delete ****</h2>");
//			facade.deleteMovie(1);
//			facade.deleteMovie(2);
			
			
		} else {
			out.print("<p>" + "Filmen finns inte." + "</p>");
		}
		
		out.println("</body></html>");
		out.close();
	}
}
