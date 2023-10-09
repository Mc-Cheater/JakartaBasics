package net.adil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/RedirectServlet")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
			StringBuilder output=new StringBuilder();
			output.append("<h1>Welcome to the redirection servlet</h1>");
		if(request.getHeader("User-Agent").contains("Chrome")) {
			output.append("<h2> It seems that you are using a Chrome  browser</h2>");
		}
		else {
			output.append("<h2>It seems that you are not using  Chrome</h2>");
		//	try {
		//		wait(1000);
				response.sendRedirect("http://www.fsr.ac.ma");
			//} catch (InterruptedException e) {
				// TODO Auto-generated catch block
		//		e.printStackTrace();
		//	}
		}
		response.getWriter().println(output.toString());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
