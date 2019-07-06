package com.example.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.model.Employee;
import com.example.service.EmployeeServiceImpl;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public InsertForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblFirstName = new JLabel("First Name");
		contentPane.add(lblFirstName);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblFirstName);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblLastName, 92, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblFirstName, 0, SpringLayout.WEST, lblLastName);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblFirstName, -25, SpringLayout.NORTH, lblLastName);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblLastName, 43, SpringLayout.WEST, contentPane);
		contentPane.add(lblLastName);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 50, SpringLayout.EAST, lblLastName);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, textField_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, -3, SpringLayout.NORTH, lblLastName);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblId, 0, SpringLayout.WEST, lblFirstName);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblId, -19, SpringLayout.NORTH, lblFirstName);
		contentPane.add(lblId);
		
		textField_2 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_2, 0, SpringLayout.NORTH, lblId);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSalary = new JLabel("Salary");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblSalary, 27, SpringLayout.SOUTH, lblLastName);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblSalary, 0, SpringLayout.WEST, lblFirstName);
		contentPane.add(lblSalary);
		
		textField_3 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_3, 0, SpringLayout.NORTH, lblSalary);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_3, 0, SpringLayout.WEST, textField);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee employee = new Employee(Integer.parseInt(textField_2.getText()), textField.getText(), textField_1.getText(),
						Integer.parseInt(textField_3.getText()));
				
				EmployeeServiceImpl service = new EmployeeServiceImpl();
						
				if(service.insert(employee)) {
	
                    JOptionPane.showMessageDialog(null, "success", "Inserted successfully", EXIT_ON_CLOSE);
                    DisplayForm frame = new DisplayForm();
					frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "failed", "Invalid data", EXIT_ON_CLOSE);
				}
						
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnInsert, 28, SpringLayout.SOUTH, textField_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnInsert, 67, SpringLayout.WEST, contentPane);
		contentPane.add(btnInsert);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayForm frame = new DisplayForm();
				frame.setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCancel, 0, SpringLayout.NORTH, btnInsert);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCancel, 31, SpringLayout.EAST, btnInsert);
		contentPane.add(btnCancel);
	}
}
