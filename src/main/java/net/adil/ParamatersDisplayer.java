package net.adil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamatersDisplayer
 */
@WebServlet({ "/ParamatersDisplayer", "/show" })
public class ParamatersDisplayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParamatersDisplayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		PrintWriter out=response.getWriter();
		StringBuilder output=new StringBuilder("<table>  <tr>  <th> name</th> <th> Value</th>  </tr> ");
		
		
		Enumeration <String> parameters=request.getParameterNames();
		
		
		
		List<String> names=Collections.list(parameters);
		for (String name  : names) {
			output.append("<tr> <td>" +name+"</td>")
			.
			append("<td>").
			append(request.getParameter(name)+" </td> </tr>");
			
			
		}
		
		output.append("<tr>  <th>Header name</th> <th> Value</th>  </tr>");
		
		
		Enumeration<String> headers=request.getHeaderNames();
		
		List<String> headersList=Collections.list(headers);
		
		for(String header:headersList) {
			output.append("<tr> <td>" +header+"</td>")
			.
			append("<td>").
			append(request.getHeader(header)+" </td> </tr>");
			
			
		}
		
		
		output.append( "</table>")
		.append("<h6>the method , Server , Client , Port and queryString respectively</h6>" 
				+ request.getMethod() +"</br>"
				+ request.getServerName()+"</br>"
				+ request.getRemoteHost()+"</br>"
				+request.getServerPort()+"</br>"
				+request.getQueryString());
		out.println(output.toString());
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
