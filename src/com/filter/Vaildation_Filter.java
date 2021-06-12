package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Vaildation_Filter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean flag = true;
		String name_error = "", roll_no_error = "", addr_error = "", team_error = "", mob_no_error = "", pin_error = "";
		long pin = 0, mobile_No = 0;
		int roll = 0;

		String n = request.getParameter("name");

		try {
			roll= Integer.parseInt(request.getParameter("roll_no"));
		} catch (Exception e) {
		}
		String a = request.getParameter("addr");
		try {
			pin = Long.parseLong(request.getParameter("kk"));
			mobile_No = Long.parseLong(request.getParameter("mob_no"));
		} catch (Exception e) {
		}
		String t = request.getParameter("fav_team");
		PrintWriter out = response.getWriter();
		if (n.equals("") || n == null) {
			name_error = "Name is required";
			flag = false;
		}
		if (roll == 0) {
			roll_no_error = "Roll no required";
			flag = false;
		}
		if (a.equals("") || a == null) {
			addr_error = "Address is required";
			flag = false;
		}
		if (pin == 0) {
			pin_error = "Name is required";
			flag = false;
		}
		if (mobile_No == 0) {
			mob_no_error = "Roll no required";
			flag = false;
		}
		if (t.equals("") || t == null) {
			team_error = "Address is required";
			flag = false;
		}

		if (flag == true) {
			chain.doFilter(request, response);
		}

		else {

			out.println("<html><body><center> <h1>INCOMLETE FORM SUBMISSION </h1></font></center>");
			out.println("<form action='first'>");
			out.println("<div><table>");
			out.println("<tr>");
			out.println("<td> NAME </td>");
			out.println("<td><input type='text' name='name' value='" + n + "'/></td>");
			out.println("<td><font color='red' size='4'><b>" + name_error + "</b></font></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td> Roll_No </td>");
			out.println("<td><input type='text' name='roll_no' /></td>");
			out.println("<td><font color='red' size='4'><b>" + roll_no_error + "</b></font></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td> ADDRESS </td>");
			out.println("<td><input type='text' name='addr' value='" + a + "'/></td>");
			out.println("<td><font color='red' size='4'><b>" + addr_error + "</b></font></td>");
			out.println("<tr>");
			out.println("<td> PIN_CODE </td>");
			out.println("<td><input type='text' name='kk'/></td>");
			out.println("<td><font color='red' size='4'><b>" + pin_error + "</b></font></td>");
			out.println("<tr>");
			out.println("<td> MOB_NO</td>");
			out.println("<td><input type='text' name='mob_no'/></td>");
			out.println("<td><font color='red' size='4'><b>" + mob_no_error + "</b></font></td>");
			out.println("<tr>");
			out.println("<td> TEAM </td>");
			out.println("<td><input type='text' name='fav_team' value='" + t + "'/></td>");
			out.println("<td><font color='red' size='4'><b>" + team_error + "</b></font></td>");
			out.println("</tr></table>");
			out.println("<br><tr>");
			out.println("<td><input type='submit' value='submit'/></td></tr><br><br><br>");

			out.println("<h5>  OR YOU WANNA PLAY DREAM 11 ? </h5>");
			out.println("<a href=https://www.dream11.com/><i> YES </i> </a><br>");
			out.println(" <a href=index.html ><i> NO <i></a>");
			out.println("</form></body></html>");
		}

	}
}
