package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JTextField;

import controllers.UserController;
import entities.Student;
import query.LoggedUser;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGUI extends JFrame{

	private JFrame frame;
	private JTextField txtUser;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(197, 5, 55, 22);
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 18));
		panel.add(lblLogin);
		
		txtUser = new JTextField();
		txtUser.setBounds(172, 65, 168, 22);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("P@$$w0rD");
		txtPassword.setBounds(172, 105, 168, 22);
		panel.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(87, 64, 94, 22);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(87, 104, 85, 22);
		panel.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnLoginActionPerformed(evt);
			}
		});
		btnLogin.setBounds(172, 158, 117, 25);
		panel.add(btnLogin);
		
	}
	
	
	public void btnLoginActionPerformed(ActionEvent evt){
		String email = txtUser.getText();
		String password = txtPassword.getText();
		try {
			Student student = new UserController().authenticateUser(email, password);
			DashboardStudentGUI main = new DashboardStudentGUI();	
			main.setCurrentUser(student);
			main.setVisible(true);
			System.out.println(main.getCurrentUser().getFname());
			dispose();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(frame, "Wrong Credentials");
		}
	}
}
