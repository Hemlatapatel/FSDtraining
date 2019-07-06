package com.example.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.service.EmployeeServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		
//	}

	/**
	 * Create the frame.
	 */
	public DeleteForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterIdTo = new JLabel("Enter id to delete data");
		lblEnterIdTo.setBounds(31, 43, 130, 20);
		contentPane.add(lblEnterIdTo);

		textField = new JTextField();
		textField.setBounds(208, 43, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Delete ");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeServiceImpl service = new EmployeeServiceImpl();
				if (service.deleteById(Integer.parseInt(textField.getText()))) {
					JOptionPane.showMessageDialog(null, "Successful", "Deleted sucessfully", EXIT_ON_CLOSE);
//					DisplayForm frame = new DisplayForm();
//					frame.setVisible(true);
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
					JOptionPane.showMessageDialog(null, "failed", "No user of this id", EXIT_ON_CLOSE);
				}
			}
		});
		btnNewButton.setBounds(113, 95, 89, 23);
		contentPane.add(btnNewButton);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 DisplayForm frame = new DisplayForm();
					frame.setVisible(true);
			}
		});
		btnCancel.setBounds(205, 95, 89, 23);
		contentPane.add(btnCancel);
	}
}
