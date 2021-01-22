package controllers;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.BorrowedBook;
import entities.Student;
import query.BookData;
import query.LoggedUser;

public class UserController {
	LoggedUser loggeduser;
	Student student;
	public UserController() {
		loggeduser = new LoggedUser();
	}
	
	public UserController (Student s) {
		loggeduser = new LoggedUser();
		this.student = s;
	}
	
	public Student authenticateUser(String email,String password) throws Exception{
		student = loggeduser.getLoggedUser(email, password);
		ArrayList<BorrowedBook> borrowedbooks = new BookData().getBorrowedBooks(student.getStudId());
		student.setBorrowedBooks(borrowedbooks);
		return student;
	}
	
	
}
