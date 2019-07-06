package com.java.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.network.NetworkingClient;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Network extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblReturnMsg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Network frame = new Network();
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
	public Network() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterYourName = new JLabel("Enter your name");
		lblEnterYourName.setBounds(38, 67, 154, 14);
		contentPane.add(lblEnterYourName);
		
		textField = new JTextField();
		textField.setBounds(166, 64, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		

		lblReturnMsg = new JLabel("Return msg");
		lblReturnMsg.setBounds(262, 108, 137, 14);
		contentPane.add(lblReturnMsg);
		
		JButton btnPressHere = new JButton("Press Here");
		btnPressHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NetworkingClient client = new NetworkingClient(textField.getText());
				
				String msg = client.msgr;
				System.out.println("msg" + msg);
				lblReturnMsg.setText(msg);
			}
			
		});
		btnPressHere.setBounds(105, 104, 89, 23);
		contentPane.add(btnPressHere);
		
	}
}
