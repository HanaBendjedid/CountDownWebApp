package org.pigne;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountDown extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String diff = diff();
		request.setAttribute("diff", diff);
		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/CountDownView.jsp")
				.forward(request, response);
	}

	private String diff() {
		String theDate = "11-24-2014" 12:30:00";
		String pattern = "MM-dd-yyyy" HH:mm:ss";
		Date d2 = null;
		try {
			d2 = new SimpleDateFormat(pattern).parse(theDate);
		} catch (ParseException e) {
			return "server error...";
		}
		Date d1 = new Date();

		long diff = d2.getTime() - d1.getTime();

		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);
		return diffDays + " jour(s) " + diffHours + " heure(s) " + diffMinutes
				+ " minute(s) " + diffSeconds + " seconde(s).....";

	}
}
