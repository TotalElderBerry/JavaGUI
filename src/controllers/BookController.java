package controllers;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import entities.Book;
import entities.BorrowedBook;
import entities.Student;
import query.BookData;

public class BookController {
	
	BookData bookdata;
	private ArrayList<Book> booklist;
	
	
	public BookController(){
		bookdata = new BookData();
	}
	
	public void displayAll(JTable jTable) throws Exception{
		DefaultTableModel tablemodel = (DefaultTableModel)jTable.getModel();
		tablemodel.setRowCount(0);
		ArrayList<Book> books = bookdata.getAll();
		booklist = books;
		books.forEach(b -> tablemodel.addRow(b.toObject()));
	}
	
	public void insertBook(int id,Student s) throws Exception{
		bookdata.borrowBook(id, s);
	}
	
	public ArrayList<Book> getBooks(){
		return booklist;
	}

	public void displayBorrowedBooks(JTable jTable,Student s){
		
		try {
			DefaultTableModel tablemodel = (DefaultTableModel)jTable.getModel();
			tablemodel.setRowCount(0);
			ArrayList<BorrowedBook> borrowedbooks = s.getBorrowedBooks();
			borrowedbooks.forEach(b -> tablemodel.addRow(b.toObject()));
		}catch(Exception e) {
			System.out.println(e + " yow");
		}
		
	}
	
	
}
