package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controllers.BookController;
import entities.Book;
import entities.Student;
import query.BookData;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class BookListGUI extends JFrame {

	private JPanel contentPane;
	private JTable jTable1;
	private Student s;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookListGUI frame = new BookListGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookListGUI() {
			initialize();
			displayBooks();
	}
	
	public BookListGUI(Student s) {
		this.s = s;
		initialize();
		displayBooks();
	}
	
	private void initialize() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 51, 482, 251);
		contentPane.add(scrollPane);
		
		jTable1 = new JTable();
		jTable1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Title", "Author", "Publisher", "Genre"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(jTable1);
		
		JButton btnBorrow = new JButton("Borrow");
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnBorrowActionPerformed(evt);
			}
		});
		btnBorrow.setBounds(499, 277, 85, 25);
		contentPane.add(btnBorrow);
		
		JLabel lblAvailableBooks = new JLabel("Available Books");
		lblAvailableBooks.setFont(new Font("Dialog", Font.BOLD, 18));
		lblAvailableBooks.setBounds(209, 9, 201, 25);
		contentPane.add(lblAvailableBooks);
		
		JButton btnBorrowedBooks = new JButton("My Books");
		btnBorrowedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrowedBooksActionPerformed(arg0);
			}
		});
		btnBorrowedBooks.setForeground(UIManager.getColor("MenuItem.background"));
		btnBorrowedBooks.setBackground(SystemColor.desktop);
		btnBorrowedBooks.setBounds(25, 5, 109, 34);
		contentPane.add(btnBorrowedBooks);
	}
	
	public void displayBooks() {
		try {
			book = new BookController();
			book.displayAll(jTable1);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	private void btnBorrowActionPerformed(ActionEvent evt) {
		try {
			DefaultTableModel tablemodel = (DefaultTableModel)jTable1.getModel();
			ArrayList<Book> books = book.getBooks();
			int row = jTable1.getSelectedRow();
			int bid = books.get(row).getId();
			System.out.println(books.get(row).getId());
			book.insertBook(bid,s);	
			tablemodel.removeRow(row);

			JOptionPane.showMessageDialog(null, "Book Borrowed");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private void borrowedBooksActionPerformed(ActionEvent e){
		dispose();
		BorrowedBooksGUI window = new BorrowedBooksGUI(s);
		window.setVisible(true);
	}
	
	BookController book;
}
