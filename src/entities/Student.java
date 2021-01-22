package entities;

import java.util.ArrayList;

public class Student{
	private int stud_id;
	private String fname;
	private String lname;
	private ArrayList<BorrowedBook> borrowedbooks;
	
	public Student(int stud_id,String fname,String lname) {
		this.fname = fname;
		this.lname = lname;
		this.stud_id = stud_id;
	}
	public int getStudId() {
		return this.stud_id;
	}
	
	public String getFname() {
		return fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setBorrowedBooks(ArrayList<BorrowedBook> borrowedbooks) {
		this.borrowedbooks = borrowedbooks;
	}
	
	public ArrayList<BorrowedBook> getBorrowedBooks(){
		return borrowedbooks;
	}
}
