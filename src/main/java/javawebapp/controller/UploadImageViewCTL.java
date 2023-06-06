package javawebapp.controller;

import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import javawebapp.utility.ServletUtility;



/**
 * Servlet implementation class UploadImageViewCTL
 */
@WebServlet(name = "UploadImageViewCTL", urlPatterns = { "/UploadImageViewCTL" })
@MultipartConfig(maxFileSize = 169999999)
public class UploadImageViewCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImageViewCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletUtility.forward(JWAView.UploadImageView, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 Part part = null;
		    try {
		      part = request.getPart("photo");
		    } catch (IOException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    } catch (ServletException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		    ServletUtility.UploadImage(request, response, fileName);
	}

}
