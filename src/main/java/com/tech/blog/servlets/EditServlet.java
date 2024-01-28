package com.tech.blog.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.Helper;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
@MultipartConfig
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// fetch all data

		String userEmail = request.getParameter("user_email");
		String userName = request.getParameter("user_name");
		String userPassword = request.getParameter("user_password");
		String userAbout = request.getParameter("user_about");
		Part part = request.getPart("image");
		String imageName = part.getSubmittedFileName();

		// get the user from the session...
		// aur ab new details se old details ko replace kro

		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("currentUser");
		user.setEmail(userEmail);
		user.setName(userName);
		user.setPassword(userPassword);
		user.setAbout(userAbout);
		user.setProfile(imageName);

		String oldFile = user.getProfile();

		// update database...
		UserDao userDao = new UserDao(ConnectionProvider.getConnection());
		boolean ans = userDao.updateUser(user);
		PrintWriter out = response.getWriter();
		if (ans) {

			String path = request.getRealPath("/") + "pics" + File.separator + user.getProfile();
			String pathOldFile = request.getRealPath("/") + "pics" + File.separator + oldFile;
			System.out.println(path);

			if (!oldFile.equals("default.png")) {
				Helper.deleteFile(pathOldFile);
			}

			boolean upload = Helper.saveFile(part.getInputStream(), path);
			if (upload) {
				out.println("Profile Updated ...");
				Message msg = new Message("Profile detalis Updated..", "success", "alert-success");
				s.setAttribute("msg", msg);
			} else {
				Message msg = new Message("Something went wrong..", "error", "alert-danger");
				s.setAttribute("msg", msg);

			}
		} else {
			out.println("Not updated..");
			Message msg = new Message("Something went wrong..", "error", "alert-danger");
			s.setAttribute("msg", msg);
		}
		
		response.sendRedirect("profile.jsp");

		/*
		 * if(ans) { out .println("updated to db"); String path =
		 * request.getRealPath("/")+"pics"+File.separator+user.getProfile();
		 * System.out.println(path); //Helper.deleteFile(path);
		 * if(Helper.saveFile(part.getInputStream(), path)) {
		 * out.println("profile updated..."); }else { /// }
		 * 
		 * }else { out.println("not updated"); }
		 */

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
