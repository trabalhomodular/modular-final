package gui;

import java.sql.SQLException;

import util.SqliteUtil;

public class ProjectMain {

	public static void main(String[] args) {
		try {
			SqliteUtil util = new SqliteUtil();
			util.initDB();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
