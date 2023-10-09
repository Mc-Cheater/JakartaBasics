package net.adil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/*import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
*/
/**
 * Servlet implementation class ServletUploadFile
 */
@WebServlet({ "/ServletUploadFile", "/servletUploadFile" })
public class ServletUploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUploadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletRequestContext helper= new ServletRequestContext(request);
		
		
		PrintWriter out=response.getWriter();
		if(ServletFileUpload.isMultipartContent(request)){
			// create a factory for disk-based (large) file items
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			fileItemFactory.setSizeThreshold(40960); /* the unit is bytes */
			// create a new file upload handler
			ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
			servletFileUpload.setSizeMax(81920); /* the unit is bytes */
			try
			{
			List<?> fileItemsList = servletFileUpload.parseRequest(helper);
			Iterator<?> it = fileItemsList.iterator();
			while (it.hasNext()) {
			DiskFileItem fileItem = (DiskFileItem) it.next();
			if (fileItem.isFormField()) { // classic form field (name = value)
			out.println("<b>Form field:</b><br />\n" + fileItem.getString() + "<br/>");
			} else {
			out.println("<b>File:</b><br/>\n<pre>" + fileItem.getString() +
			"</pre><br/>");
			String directoryPath = "D:\\";
			String fileName = "myFile.txt";
			File dest = new File(directoryPath, fileName);
			FileOutputStream fos = new FileOutputStream(dest);
			fos.write(fileItem.get());
			fos.close();
			}
			}
			}catch(
			FileUploadException e)
			{
			e.printStackTrace();
			}
			}
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
