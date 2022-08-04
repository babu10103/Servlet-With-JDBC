package com.hackerrank;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		PrintWriter out = res.getWriter();
		try {
			if(Validate.checkUser(user, pass)) {
				res.sendRedirect("WelcomePage");
			}else {
				out.println("Incorrect username or password.");
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
