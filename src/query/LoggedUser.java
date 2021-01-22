package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DB;
import entities.Student;
import javax.swing.*;


public class LoggedUser extends JFrame{
	
	
	public Student getLoggedUser(String email,String password) throws Exception {
		Student user;
		Connection con = new DB().getConnection();
		String query = "SELECT * from students where email = ? AND password = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1,email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			int studid = rs.getInt("stud_id");
			String fname = rs.getString("fname");
			String lname = rs.getString("lname");
			user = new Student(studid,fname,lname);
		}else {
			throw new Exception();
		}
		
		con.close();
		return user;
	}
}
