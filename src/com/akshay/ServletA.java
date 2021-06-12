package com.akshay;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.data;
import com.dto.bean;

public class ServletA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

	{

		String n = request.getParameter("name");
		int r = Integer.parseInt(request.getParameter("roll_no"));
		String a = request.getParameter("addr");
		long p = Long.parseLong(request.getParameter("kk"));
		long m = Long.parseLong(request.getParameter("mob_no"));
		String t = request.getParameter("fav_team");
		PrintWriter out = response.getWriter();
		bean b = new bean();
		b.setName(n);
		b.setRoll_no(r);
		b.setAddr(a);
		b.setPin_code(p);
		b.setMob_no(m);
		b.setTeam(t);

		data d = new data();
		String str = d.get(b);

		out.println("<html> <body><center><h1>" + str + " </h1></center><table border ='1'>");
		out.println("<tr><td>Name</td><td>" + n + "</td></tr>");

		out.println("<tr><td>Roll_No</td><td>" + r + "</td></tr>");
		out.println("<tr><td>Addr</td><td>" + a + "</td></tr>");
		out.println("<tr><td>Pin_code</td><td>" + p + "</td></tr>");
		out.println("<tr><td>Mob_No</td><td>" + m + "</td></tr>");
		out.println("<tr><td>Team</td><td>" + t + "</td></tr>");
		out.println("</table></body></html>");

	}

}
