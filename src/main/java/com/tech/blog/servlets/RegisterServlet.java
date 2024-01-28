package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class RegisterServlet
 */
@MultipartConfig     //servlet sara data except kr lega data ya image ho
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param out 
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException {
		//fetch all form data
		String check=request.getParameter("check");
		if(check==null)
		{
		out.println("box not checked");
		}else {
			String name=request.getParameter("user_name");
			String email=request.getParameter("user_email");
			String password=request.getParameter("user_password");
			String gender=request.getParameter("gender");
			String about=request.getParameter("about");
			
			
			//create user obj and set all data to that obj  - ab insert karna hai database me user dao me insert ka code likh chuke hai to yha bs obj banna
			User user = new User(name,email,password,gender,about);
			
			UserDao dao=new UserDao(ConnectionProvider.getConnection());
			if(dao.saveUser(user)) //sara data ab dao pass chll gya aur sara data database me chll jyga
			{
				out.println("done");
			}else {
				out.println("error");
			}
			
			
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at:TechBlog ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//response.getWriter().append("Papunjay");
		service(request,response,response.getWriter());
		
	}

}
