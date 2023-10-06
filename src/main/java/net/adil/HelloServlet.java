package net.adil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();		
		
		Date today=new Date();
		
		String name=request.getParameter("prenom");
		String fname=request.getParameter("nom");
		
		
		StringBuilder output = new StringBuilder("<h1> this is our first servlet </h1>");
		
		if(name ==null || fname ==null || name.trim() =="" || fname.trim() =="" ) {
			output.append("<h5> you can enter your name and family name as request parameters </h5>");
		}
		else {
			output.append("<p> welcome  MR:" +name +" " +fname+"</p>");
		}
		
		
		output.append("today is the :" +today);
		
		
		out.println(output.toString());
		
		
		
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	
		
	 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().println("<h1>Please</h1>");
		doGet(request, response);
	}

}
