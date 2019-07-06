package com.example.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.service.EmployeeService;
import com.example.service.EmployeeServiceImpl;
import net.miginfocom.swing.MigLayout;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DisplayForm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnFindByName;
	private JLabel lblEnterFirstName;
	private JTextField fName;
	private JTable table_1;
	private JTable table_2;
	private JButton btnNewEmployee;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DisplayForm frame = new DisplayForm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public DisplayForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnLoadData = new JButton("Load data");
		btnLoadData.setBounds(12, 12, 81, 23);
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					EmployeeServiceImpl service = new EmployeeServiceImpl();
					ResultSet rs = service.getAllEmployees();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnLoadData);

		fName = new JTextField();
		fName.setBounds(0, 120, 97, 20);
		contentPane.add(fName);
		fName.setColumns(10);

		lblEnterFirstName = new JLabel("Enter first name to find ");
		lblEnterFirstName.setBounds(5, 94, 114, 14);
		contentPane.add(lblEnterFirstName);

		btnFindByName = new JButton("Find by Name");
		btnFindByName.setBounds(0, 157, 97, 23);
		btnFindByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EmployeeServiceImpl service = new EmployeeServiceImpl();
					ResultSet rs = service.findByFirstName(fName.getText());
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		contentPane.add(btnFindByName);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(149, 40, 275, 210);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		table_1 = new JTable();
		table_1.setBounds(236, 195, 1, 1);
		contentPane.add(table_1);

		table_2 = new JTable();
		table_2.setBounds(118, 214, 1, 1);
		contentPane.add(table_2);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							UpdateFrame frame = new UpdateFrame();
						
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnUpdate.setBounds(0, 191, 89, 23);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DeleteForm frame = new DeleteForm();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnDelete.setBounds(0, 227, 89, 23);
		contentPane.add(btnDelete);

		btnNewEmployee = new JButton("New Employee");
		btnNewEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							InsertForm frame = new InsertForm();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewEmployee.setBounds(4, 60, 115, 23);
		contentPane.add(btnNewEmployee);
	}
}
