package net.adil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServFormPost
 */
@WebServlet({ "/ServFormPost", "/adil/ServFormPost" })
public class ServFormPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServFormPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	
	Map<String,String> credentials=new HashMap<>();
	
	credentials.put("adil", "123");
	credentials.put("admin", "admin");
	credentials.put("root", "root");
	
	Map<String,Map<String,String> >loginToName=new HashMap<>();
	Map<String, String> user=new HashMap<String, String>();
	user.put("nom","Qarboua");
	user.put("prenom","Adil");
	Map<String, String> user1=new HashMap<String, String>();
	user1.put("nom","Qarboua");
	user1.put("prenom","Ahmed");
	Map<String, String> user2=new HashMap<String, String>();
	user2.put("nom","Qarboua");
	user2.put("prenom","Anass");
	loginToName.put("adil", user);
	loginToName.put("admin", user1);
	loginToName.put("root", user2);
	//response.getWriter().println(request.getParameter("login"));
	//response.getWriter().println(request.getParameter("password"));
	if(credentials.get(request.getParameter("login")) != null && request.getParameter("password")!=null && credentials.get(request.getParameter("login")).equals( request.getParameter("password"))) {
		
		RequestDispatcher disp=request.getRequestDispatcher("/hello?nom=" + loginToName.get(request.getParameter("login")).get("nom") +"&"+"prenom="+loginToName.get(request.getParameter("login")).get("prenom"));
		
		//request.setAttribute("nom", loginToName.get(request.getParameter("login")).get("nom"));
		//request.setAttribute("prenom", loginToName.get(request.getParameter("login")).get("prenom"));
		
		disp.forward(request, response);
	}
	else {
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);	}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
