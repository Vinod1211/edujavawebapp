package javawebapp.utility;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Part;

/**
 * This class provides utility operation for Servlet container like forward,
 * redirect, handle generic exception=same time exception, manage success and
 * error message, manage default Bean and List, manage pagination parameters
 * 
 * @author Navigable Set
 * @version 1.0
 * @Copyright (c) Navigable Set
 */
public class ServletUtility {
	static String Error = "Invalid data";
	static String SucessMessage = "Done";

	public static void forward(String page, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		RequestDispatcher rd = request.getRequestDispatcher(page);
		System.out.println("The page forwarded to : " + page);
		rd.forward(request, response);
	}

	public static void redirect(String page, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.sendRedirect(page);
	}

	public static void handleException(Exception e, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setAttribute("exception", e);
		ServletUtility.forward("Error Message", request, response);
		e.printStackTrace();
	}

	public static String getErrorMessage(String property, HttpServletRequest request) {
		String val = (String) request.getAttribute(property);
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}

	public static String getMessage(String property, HttpServletRequest request) {
		String val = (String) request.getAttribute(property);
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}

	public static void setErrorMessage(String msg, HttpServletRequest request) {
		request.setAttribute(Error, msg);
	}

	public static String getErrorMessage(HttpServletRequest request) {
		String val = (String) request.getAttribute(Error);
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}

	public static void setSuccessMessage(String msg, HttpServletRequest request) {
		request.setAttribute(SucessMessage, msg);
	}

	public static String getSuccessMessage(HttpServletRequest request) {
		String val = (String) request.getAttribute(SucessMessage);
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}

	public static String getParameter(String property, HttpServletRequest request) {
		String val = (String) request.getParameter(property);
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}

	public static void setList(List list, HttpServletRequest request) {
		request.setAttribute("list", list);
	}

	public static List getList(HttpServletRequest request) {
		return (List) request.getAttribute("list");
	}

	/**
	 * Sets Page Number for List pages
	 * 
	 * @param pageNo
	 * @param request
	 */
	/*
	 * public static void setPageNo(int pageNo, HttpServletRequest request) {
	 * request.setAttribute("pageNo", pageNo); }
	 * 
	 * public static int getPageNo(HttpServletRequest request) { return (Integer)
	 * request.getAttribute("pageNo"); }
	 * 
	 * public static void setSize(int size, HttpServletRequest request) {
	 * request.setAttribute("size", size); }
	 * 
	 * public static int getSize(HttpServletRequest request) { return (Integer)
	 * request.getAttribute("size"); }
	 * 
	 * public static void setPageSize(int pageSize, HttpServletRequest request) {
	 * request.setAttribute("pageSize", pageSize); }
	 * 
	 * public static int getPageSize(HttpServletRequest request) { return (Integer)
	 * request.getAttribute("pageSize"); }
	 */
	public static void setOpration(String msg, HttpServletRequest request) {
		request.setAttribute("Opration", msg);
	}

	public static String getOpration(HttpServletRequest request) {
		String val = (String) request.getAttribute("Opration");
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}

	public static String UploadImage(HttpServletRequest request, HttpServletResponse response, String name)
			throws ServletException, IOException {
		ResourceBundle rb = ResourceBundle.getBundle("javawebapp.System");
		String savePath = rb.getString("ImagePath");
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		Part part = request.getPart("photo");
		String fileName = extractFileName(part);
		part.write(savePath + File.separator + name + fileName);
		return name + fileName;

	}
	
	public static String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
 	}

}