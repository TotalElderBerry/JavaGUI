package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import controllers.BookController;
import controllers.UserController;
import entities.Student;

public class BorrowedBooksGUI extends JFrame {

	private JPanel contentPane;
	private JTable jTable1;
	private Student student;
	BookController controller;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowedBooksGUI frame = new BorrowedBooksGUI();
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
	public BorrowedBooksGUI() {
//		this.student = loggedUser;
		initialize();
		displayBorrowedBooks();
	}
	
	public BorrowedBooksGUI(Student s) {
		this.student = s;
		initialize();
		displayBorrowedBooks();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 12, 596, 337);
		contentPane.add(contentPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 51, 482, 251);
		contentPane_1.add(scrollPane);
		
		jTable1 = new JTable();
		jTable1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Title", "Date Borrowed", "Return Date"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		jTable1.getColumnModel().getColumn(0).setPreferredWidth(188);
		jTable1.getColumnModel().getColumn(1).setPreferredWidth(127);
		jTable1.getColumnModel().getColumn(2).setPreferredWidth(118);
		scrollPane.setViewportView(jTable1);
		
		JLabel lblBorrowedBooks = new JLabel("Borrowed Books");
		lblBorrowedBooks.setFont(new Font("Dialog", Font.BOLD, 18));
		lblBorrowedBooks.setBounds(208, 0, 201, 25);
		contentPane_1.add(lblBorrowedBooks);
		
	}

	public void setLoggedUser(Student student) {
		this.student = student;
	}
	
	public Student getLoggedUser() {
		return student;
	}
	
	public void displayBorrowedBooks(){
		try {
			System.out.println(student.getFname());
			controller = new BookController();
			controller.displayBorrowedBooks(jTable1,student);
		}catch(Exception e) {
			controller = new BookController();
			controller.displayBorrowedBooks(jTable1,student);
		}
		
	}
}
