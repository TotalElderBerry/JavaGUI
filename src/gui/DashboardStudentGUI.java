package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class DashboardStudentGUI extends JFrame {
	private JPanel contentPane;
	private Student currentuser;
	JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardStudentGUI frame = new DashboardStudentGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setCurrentUser(Student user) {
		this.currentuser = user;
		lblNewLabel.setText("Welcome " + currentuser.getFname());
	}
	
	public Student getCurrentUser() {
		return currentuser;
	}

	/**
	 * Create the frame.
	 */

	public DashboardStudentGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel = new JLabel();
		lblNewLabel.setText("Welcome");
		lblNewLabel.setBounds(172, 12, 102, 22);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JButton btnBookList = new JButton("Book List");
		btnBookList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new BookListGUI(currentuser).setVisible(true);
			}
		});
		btnBookList.setBackground(UIManager.getColor("MenuItem.selectionBackground"));
		btnBookList.setBounds(28, 79, 146, 103);
		contentPane.add(btnBookList);
		JButton btnBorrowedBooks = new JButton("Borrowed Books");
		btnBorrowedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BorrowedBooksGUI window = new BorrowedBooksGUI(currentuser);
//				window.setLoggedUser(currentuser);
				window.setVisible(true);
				dispose();
			}
		});
		btnBorrowedBooks.setBounds(218, 79, 170, 103);
		contentPane.add(btnBorrowedBooks);	
	}
}
