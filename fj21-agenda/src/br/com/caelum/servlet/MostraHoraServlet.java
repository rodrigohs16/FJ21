package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraHoraServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		pw.println("<html><body><h1>");
		Calendar calendar = Calendar.getInstance();
		
		pw.println(calendar.getTime());
		
		pw.println("</h1></body><html>");
	}

}
