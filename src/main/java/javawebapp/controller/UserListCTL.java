package javawebapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javawebapp.model.UserModel;
import javawebapp.utility.DataUtility;
import javawebapp.utility.ServletUtility;

/**
 * Servlet implementation class UserListCTL
 */
@WebServlet(name = "UserListCTL", urlPatterns = { "/UserListCTL" })
public class UserListCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		UserModel model=new UserModel();
		long id=DataUtility.getLong(request.getParameter("id"));
	    if(id>0) {
	      UserModel.delete(id);
	      ServletUtility.setSuccessMessage("Data Deleted Successfully", request);
	    }
		
		List list=null;
	    list=model.list();
	    //System.out.println(list.size());
	    
	    if(list==null && list.size()==0){
	      ServletUtility.setErrorMessage("Record Not Found", request);
	    }
	    
	    ServletUtility.setList(list, request);
		ServletUtility.forward(JWAView.UserViewList, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
