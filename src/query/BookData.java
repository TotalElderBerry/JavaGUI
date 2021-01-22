package query;

import entities.Book;
import entities.BorrowedBook;
import entities.Student;

import java.util.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import db.DB;

public class BookData {
	
	public ArrayList<Book> getAll() throws Exception{
		ArrayList<Book> books = new ArrayList<>();
		
		Connection con = new DB().getConnection();
		String query = "select * from books";
		Statement ps = con.createStatement();
		ResultSet rs = ps.executeQuery(query);
		
		while(rs.next()) {
			int id = rs.getInt("book_id");
			String title = rs.getString("title");
			String author = rs.getString("author");
			String publisher = rs.getString("publisher");
			String genre = rs.getString("genre");
			int borrowed = rs.getInt("borrowed");
			int reserved = rs.getInt("reserved");
			if(borrowed == 0 && reserved == 0) {
				books.add(new Book(id,title,author,publisher,genre,borrowed,reserved));	
			}
		}
		con.close();
		return books;
	}
	
	public ArrayList<BorrowedBook> getBorrowedBooks(int id) throws Exception{
		ArrayList<BorrowedBook> books = new ArrayList<>();
		
		Connection con = new DB().getConnection();
		String query = "select bk.*,bb.borrow_date,bb.return_date from borrowedbooks bb inner join books bk on bk.book_id = bb.book_id where bb.user_id = "+id;
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery(query);
		
		while(rs.next()) {
			int bid = rs.getInt("book_id");
			String title = rs.getString("title");
			String author = rs.getString("author");
			String publisher = rs.getString("publisher");
			String genre = rs.getString("genre");
			int borrowed = rs.getInt("borrowed");
			int reserved = rs.getInt("reserved");
			String borroweddate = rs.getDate("borrow_date").toString();
			String returndate = rs.getDate("return_date").toString();
			Book bbook = new Book(bid,title,author,publisher,genre,borrowed,reserved);
		
			books.add(new BorrowedBook(bbook,borroweddate,returndate));
		}
		
		con.close();
		return books;
	}
	
	public void borrowBook(int id,Student s) throws Exception {
		Connection con = new DB().getConnection();
		String query = "INSERT INTO borrowedbooks (borrow_date,return_date,user_id,book_id) VALUES (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, dtf.format(date));
		ps.setString(2, dtf.format(newDate));
		ps.setInt(4, id);
		ps.setInt(3, s.getStudId());
		ps.execute();
		
		String query2 = "UPDATE books SET borrowed = 1 where book_id = ?";
		PreparedStatement ps2 = con.prepareStatement(query2);
		ps2.setInt(1, id);
		ps2.execute();
		
		con.close();
	}
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate date = LocalDate.now();
	LocalDate newDate = date.plusWeeks(1);
}
