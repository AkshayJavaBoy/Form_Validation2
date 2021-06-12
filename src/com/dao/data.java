package com.dao;

import com.dto.bean;
import com.factory.ConnectionFactory;

import java.sql.*;

public class data

{
	Statement st=null;
	public String get(bean b) {
		String r = "";
		try {
			Connection conn = ConnectionFactory.getConnection();

			Statement st = conn.createStatement();

			int i = st.executeUpdate("insert into Info values('" + b.getName() + "'," + b.getRoll_no() + ",'"
					+ b.getAddr() + "'," + b.getPin_code() + "," + b.getMob_no() + ",'" + b.getTeam() + "')");
			if (i != 0)
				r = "Data inserted Succesfull";

			else
				r = "insertion failure";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;

	}
}
