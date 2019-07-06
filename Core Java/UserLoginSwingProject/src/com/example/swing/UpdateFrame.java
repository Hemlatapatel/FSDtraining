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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdateFrame extends JFrame {

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
	public UpdateFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JLabel lblNewLabel = new JLabel("UPDATE EMPLOYEE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 25, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("EMP ID");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 23, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 49, SpringLayout.EAST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField, 0, SpringLayout.SOUTH, lblNewLabel_1);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				EmployeeServiceImpl service = new EmployeeServiceImpl();

				ResultSet rs = service.updateById(Integer.parseInt(textField.getText()));

				try {

					while (rs.next()) {
						JLabel lblNewLabel_2 = new JLabel("First Name");
						sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 23, SpringLayout.SOUTH,
								lblNewLabel_1);
						sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST,
								lblNewLabel);
						contentPane.add(lblNewLabel_2);

						textField_1 = new JTextField(rs.getString(2));
						sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, -3, SpringLayout.NORTH,
								lblNewLabel_2);
						sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
						contentPane.add(textField_1);
						textField_1.setColumns(10);

						JLabel lblNewLabel_3 = new JLabel("Last Name");
						sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 20, SpringLayout.SOUTH,
								lblNewLabel_2);
						sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST,
								lblNewLabel);
						contentPane.add(lblNewLabel_3);

						textField_2 = new JTextField(rs.getString(3));
						sl_contentPane.putConstraint(SpringLayout.NORTH, textField_2, -3, SpringLayout.NORTH,
								lblNewLabel_3);
						sl_contentPane.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, textField);
						contentPane.add(textField_2);
						textField_2.setColumns(10);

						JLabel lblNewLabel_4 = new JLabel("Salary");
						sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 39, SpringLayout.WEST,
								contentPane);
						contentPane.add(lblNewLabel_4);

						textField_3 = new JTextField(String.valueOf(rs.getInt(4)));
						sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 3, SpringLayout.NORTH,
								textField_3);
						sl_contentPane.putConstraint(SpringLayout.NORTH, textField_3, 22, SpringLayout.SOUTH,
								textField_2);
						sl_contentPane.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, textField);
						contentPane.add(textField_3);
						textField_3.setColumns(10);

						JButton btnUpdate = new JButton("Update");
						btnUpdate.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {

								System.out.println("at 122===============");
								Employee employee = new Employee(Integer.parseInt(textField.getText()),
										textField_1.getText(), textField_2.getText(),
										Integer.parseInt(textField_3.getText()));
								if(service.update(employee)) {
									JOptionPane.showMessageDialog(null, "success", "Updated successfully", EXIT_ON_CLOSE);

								} else {
									JOptionPane.showMessageDialog(null, "failed", "error", EXIT_ON_CLOSE);
								}
							}
						});
						sl_contentPane.putConstraint(SpringLayout.SOUTH, btnUpdate, -10, SpringLayout.SOUTH,
								contentPane);
						sl_contentPane.putConstraint(SpringLayout.EAST, btnUpdate, 0, SpringLayout.EAST, textField);
						contentPane.add(btnUpdate);
						contentPane.revalidate();
						
						
						
						JButton btnCancel = new JButton("cancel");
						btnUpdate.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {

								 DisplayForm frame = new DisplayForm();
									frame.setVisible(true);
							}
						});
						sl_contentPane.putConstraint(SpringLayout.SOUTH, btnUpdate, -10, SpringLayout.SOUTH,
								contentPane);
						sl_contentPane.putConstraint(SpringLayout.EAST, btnUpdate, 0, SpringLayout.EAST, textField);
						contentPane.add(btnCancel);
						contentPane.revalidate();
	
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 37, SpringLayout.EAST, textField);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, lblNewLabel_1);
		contentPane.add(btnNewButton);

	}
}
