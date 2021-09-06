package com.test.studentapp;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import net.miginfocom.swing.MigLayout;

import java.awt.GridBagLayout;
import javax.swing.JTabbedPane;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import org.apache.catalina.connector.Response;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.internal.build.AllowSysOut;
import org.json.simple.JSONObject;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
//import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import java.awt.SystemColor;

public class StudentsGUI {

	JFrame frame;
	private JTextField textFieldId;
	private JTextField textField_FirstName;
	private JTextField textField_LastName;
	private JTextField textField_Class;
	private JTextField textField_Nationality;
	private static JTextField textField_ResponseMessage;
	private static JTextField textField_ID;
	private static JTextField textFieldClass;
	private JTable tableResults;
	private static JTextField textField_SearchMessage;
	private static  DefaultTableModel dm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentsGUI window = new StudentsGUI();
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
	public StudentsGUI() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		//frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
		frame.setBounds(100, 100, 929, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel Info = new JPanel();
		Info.setBorder(new TitledBorder(null, "Student Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_Info = new GridBagConstraints();
		gbc_Info.fill = GridBagConstraints.BOTH;
		gbc_Info.gridx = 0;
		gbc_Info.gridy = 0;
		frame.getContentPane().add(Info, gbc_Info);
		GridBagLayout gbl_Info = new GridBagLayout();
		gbl_Info.columnWidths = new int[]{0, 0};
		gbl_Info.rowHeights = new int[]{0, 0};
		gbl_Info.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_Info.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		Info.setLayout(gbl_Info);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		Info.add(tabbedPane, gbc_tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("ACTIONS", null, panel, null);
		tabbedPane.setBackgroundAt(0, Color.PINK);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblStudentId = new JLabel("ID:");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblStudentId, "2, 2, 1, 2, left, default");
		
		textFieldId = new JTextField();
		panel.add(textFieldId, "4, 2, left, default");
		textFieldId.setColumns(20);
		
		JLabel lblNewLabel_6 = new JLabel("Response Messsage:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(lblNewLabel_6, "5, 2, left, default");
		
		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblNewLabel, "2, 4, left, default");
		
		textField_FirstName = new JTextField();
		textField_FirstName.setColumns(20);
		panel.add(textField_FirstName, "4, 4, left, default");
		
		textField_ResponseMessage = new JTextField();
		panel.add(textField_ResponseMessage, "5, 4, 1, 3, fill, default");
		textField_ResponseMessage.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblNewLabel_1, "2, 6, left, default");
		
		textField_LastName = new JTextField();
		textField_LastName.setColumns(20);
		panel.add(textField_LastName, "4, 6, left, default");
		
		JLabel lblNewLabel_2 = new JLabel("Class:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblNewLabel_2, "2, 8, left, default");
		
		textField_Class = new JTextField();
		textField_Class.setColumns(20);
		panel.add(textField_Class, "4, 8, left, default");
		
		JLabel lblNewLabel_3 = new JLabel("Nationality:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblNewLabel_3, "2, 10, left, default");
		
		textField_Nationality = new JTextField();
		textField_Nationality.setColumns(20);
		panel.add(textField_Nationality, "4, 10, left, default");
		
		JButton btnPost = new JButton("POST");
		btnPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isError = false;
			
				if(!StringUtil.isNumeric(textFieldId.getText()) || StringUtil.isEmpty(textFieldId.getText())) {
					JOptionPane.showMessageDialog(null, "ID: Please enter Positive Numeric values!!!","Error", JOptionPane.ERROR_MESSAGE);
					isError = true;
					return;
				}
				
				if(!StringUtil.isAlphabet(textField_FirstName.getText())) {
					JOptionPane.showMessageDialog(null, "FirstName: Please enter Alphabets only!!!","Error", JOptionPane.ERROR_MESSAGE);
					isError = true;
				}
				
				if(!StringUtil.isAlphabet(textField_LastName.getText())) {
					JOptionPane.showMessageDialog(null, "LastName: Please enter Alphabets only!!!","Error", JOptionPane.ERROR_MESSAGE);
					isError = true;
				}
				
				if(!StringUtil.isAlphabet(textField_Nationality.getText())) {
					JOptionPane.showMessageDialog(null, "Nationality: Please enter Alphabets only!!!","Error", JOptionPane.ERROR_MESSAGE);
					isError = true;
				}
				
				if(StringUtil.isEmpty(textField_Class.getText())) {
					JOptionPane.showMessageDialog(null, "Class: Please provide Class.eg. 3A!!","Error", JOptionPane.ERROR_MESSAGE);
					isError = true;
				}
				if(isError) {
					//registerClear();
				}else {
				
					JSONObject requestBody=new JSONObject();
					requestBody.put("id",textFieldId.getText());
					requestBody.put	("firstName",textField_FirstName.getText());
					requestBody.put("lastName",textField_LastName.getText());
					requestBody.put("className",textField_Class.getText());
					requestBody.put("nationality",textField_Nationality.getText());
					System.out.print(requestBody);
					textField_ResponseMessage.setText("");
					try {
						String response = HttpRequest.request("http://localhost:8080/student", "POST", requestBody.toString());
						textField_ResponseMessage.setText(response);
					} catch (IOException e1) {
						textField_ResponseMessage.setText("POST request failed!!!");
						e1.printStackTrace();
						if(isError) registerClear();
					}
				}
			}
		}
		);
		btnPost.setHorizontalAlignment(SwingConstants.LEFT);
		btnPost.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btnPost, "2, 12, left, center");
		
		JLabel lblNewLabel_4 = new JLabel("*ID must be Unique. All fields are mandatory");
		panel.add(lblNewLabel_4, "4, 12");
		
		JButton btnPut = new JButton("PUT");
		btnPut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JSONObject requestBody=new JSONObject();
				requestBody.put("id",textFieldId.getText());
				requestBody.put("firstName",textField_FirstName.getText());
				requestBody.put("lastName",textField_LastName.getText());
				requestBody.put("className",textField_Class.getText());
				requestBody.put("nationality",textField_Nationality.getText());
				//System.out.print(requestBody);
				textField_ResponseMessage.setText("");
				try {
					String response = HttpRequest.request("http://localhost:8080/student", "PUT", requestBody.toString());
					textField_ResponseMessage.setText(response);
				} catch (IOException e1) {
					textField_ResponseMessage.setText("PUT request failed!!!");
					e1.printStackTrace();
				}
			}
		});
		btnPut.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPut.setHorizontalAlignment(SwingConstants.LEFT);
		btnPut.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btnPut, "2, 14, left, center");
		
		JLabel lblNewLabel_5 = new JLabel("*ID must be provided. All other fields can be updated");
		panel.add(lblNewLabel_5, "4, 14");
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JSONObject requestBody=new JSONObject();
				requestBody.put("id",textFieldId.getText());
				textField_ResponseMessage.setText("");
				try {
					String response = HttpRequest.request("http://localhost:8080/student", "DELETE", requestBody.toString());
					textField_ResponseMessage.setText(response);
				} catch (IOException e1) {
					textField_ResponseMessage.setText("DELETE request failed!!!");
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setVerticalAlignment(SwingConstants.BOTTOM);
		btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(btnDelete, "2, 16");
		
		JLabel lblNewLabel_5_1 = new JLabel("*ID must be provided");
		panel.add(lblNewLabel_5_1, "4, 16");
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("SEARCH/GET", null, panel_1, null);
		panel_1.setLayout(new MigLayout("", "[][grow]", "[][][][][grow]"));
		
		
		JLabel lblNewLabel_7 = new JLabel("ID:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(lblNewLabel_7, "cell 0 0,alignx left");
		
		textField_ID = new JTextField();
		textField_ID.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(textField_ID, "flowx,cell 1 0,alignx left");
		textField_ID.setColumns(20);
		
		JLabel lblNewLabel_8 = new JLabel("Class: ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(lblNewLabel_8, "cell 0 1,alignx trailing");
		
		textFieldClass = new JTextField();
		textFieldClass.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldClass.setColumns(20);
		panel_1.add(textFieldClass, "flowx,cell 1 1,alignx left");
		
		tableResults = new JTable();
		tableResults.setBackground(SystemColor.menu);
		tableResults.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableResults.setCellSelectionEnabled(true);
		tableResults.setColumnSelectionAllowed(true);
		tableResults.setBorder(null);
		tableResults.setSurrendersFocusOnKeystroke(true);
		
		 dm = new DefaultTableModel(0, 0);
		    String header[] = new String[] { "ID", "FirstName","LastName", "Class","Nationality"};
		    dm.setColumnIdentifiers(header);
		    tableResults.setModel(dm);

		    		
		//panel_1.add(tableResults, "cell 1 3,grow");
		JScrollPane scrollPane = new JScrollPane(tableResults);
		panel_1.add(scrollPane, "flowx,cell 1 3");
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StringUtils.isEmpty(textField_ID.getText()) && StringUtils.isEmpty(textFieldClass.getText())) {
					JOptionPane.showMessageDialog(null, "Please provide Search Criteria!!!","Error", JOptionPane.ERROR_MESSAGE);
					SearchReset();
					
					return;
				}
				String response = null;
				try {
					response = HttpRequest.GetRequest("http://localhost:8080/fetchStudents?Id="+textField_ID.getText()+"&class="+textFieldClass.getText());
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				SetTable(response);
//				if(!response.equalsIgnoreCase("[]")) {
//				response = response.replaceAll("\",\"", "->");
//				response = response.replaceAll("[\\[\\]\" ]", "");
//				String[] responseRows = response.split("->");
//				dm.setRowCount(0);
//				for(String res : responseRows) {
//					res = res.replaceAll("[{}]", "");
//					String[] resData = res.split(",");
//					Vector<Object> data = new Vector<Object>();
//			        data.add(resData[0]);
//			        data.add(resData[1]);
//			        data.add(resData[2]);
//			        data.add(resData[3]);
//			        data.add(resData[4]);
//			        dm.addRow(data);
//				}
//			}else {
//				textField_ResponseMessage.setText("No results found!!!");
//			}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(btnSearch, "cell 1 0");
		
		JButton btnFetchAllData = new JButton("FETCH ALL DATA");
		btnFetchAllData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchReset();
				try {
					String response = HttpRequest.GetRequest("http://localhost:8080/student");
					SetTable(response);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnFetchAllData.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(btnFetchAllData, "cell 1 0");
		
		JLabel lblNewLabel_9 = new JLabel("Response Message:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(lblNewLabel_9, "cell 1 3");
		
		textField_SearchMessage = new JTextField();
		textField_SearchMessage.setHorizontalAlignment(SwingConstants.LEFT);
		textField_SearchMessage.setColumns(30);
		panel_1.add(textField_SearchMessage, "cell 1 3,alignx left");
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SearchReset();				
			}
			
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(btnReset, "cell 1 1");
		
	}
	
		public final void registerClear() {
			textFieldId.setText("");
			textField_FirstName.setText("");
			textField_LastName.setText("");
			textField_Class.setText("");
			textField_Nationality.setText("");
			textField_SearchMessage.setText("");
		}
		
		public static void SetTable(String response) {
			dm.setRowCount(0);
			if(!response.equalsIgnoreCase("[]")) {
				response = response.replaceAll("\",\"", "->");
				response = response.replaceAll("[\\[\\]\" ]", "");
				String[] responseRows = response.split("->");
				for(String res : responseRows) {
					res = res.replaceAll("[{}]", "");
					String[] resData = res.split(",");
					Vector<Object> data = new Vector<Object>();
			        data.add(resData[0]);
			        data.add(resData[1]);
			        data.add(resData[2]);
			        data.add(resData[3]);
			        data.add(resData[4]);
			        dm.addRow(data);
				}
			}else {
				
				textField_SearchMessage.setText("No results found!!!");
			}
		}
		
		public static void SearchReset() {
			textFieldClass.setText("");
			textField_ID.setText("");
			dm.setRowCount(0);
			textField_SearchMessage.setText("");

		}
}
