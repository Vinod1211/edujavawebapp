package javawebapp.controller;

public interface JWAView {

	public String APP_CONTEXT = "/JavaWebApp";
	public String PAGE_FOLDER = "/jsp";
	
	public String LoginView = PAGE_FOLDER+"/LoginView.jsp";
	public String UserView = PAGE_FOLDER+"/UserView.jsp";
	public String home = PAGE_FOLDER+"/home.jsp";
	public String welcomeView = PAGE_FOLDER+"/welcomeView.jsp";
	public String UserViewList = PAGE_FOLDER+"/UserViewList.jsp";
	public String UploadImageView = PAGE_FOLDER+"/UploadImageView.jsp";
	
	public String LoginCTL = APP_CONTEXT+"/LoginCTL";
	public String UserViewCTL = APP_CONTEXT+"/UserViewCTL";
	public String HomeCTL = APP_CONTEXT+"/HomeCTL";
	public String WelcomeCTL = APP_CONTEXT+"/WelcomeCTL";
	public String UserListCTL = APP_CONTEXT+"/UserListCTL";
	public String UploadImageViewCTL = APP_CONTEXT+"/UploadImageViewCTL";
}
