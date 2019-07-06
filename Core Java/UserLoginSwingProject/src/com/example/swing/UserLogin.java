package com.example.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.example.service.LoginServiceImpl;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class UserLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JPasswordField textField;
	private JButton btnLogin;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
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
	public UserLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel wddlblNewLabel = new JLabel("UserId");
		contentPane.add(wddlblNewLabel);

		textField_1 = new JTextField();
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		lblNewLabel = new JLabel("Password");
		contentPane.add(lblNewLabel);

		textField = new JPasswordField();
		contentPane.add(textField);
		textField.setColumns(10);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// create the LoginServiceObject
				LoginServiceImpl service = new LoginServiceImpl();
				service.login(textField_1.getText(), textField.getText());
				System.out.println("userId: " + textField_1.getText());
				if (service.login(textField_1.getText().trim(), textField.getText().trim())) {
					JOptionPane.showMessageDialog(null, "Successful", "User found", EXIT_ON_CLOSE);

					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								DisplayForm frame = new DisplayForm();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});

				} else {
					JOptionPane.showMessageDialog(null, "Login_denied", "User not found", EXIT_ON_CLOSE);
				}

			}
		});
		contentPane.add(btnLogin);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogin frame = new UserLogin();

				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

			}
		});
		contentPane.add(btnCancel);
	}

}
