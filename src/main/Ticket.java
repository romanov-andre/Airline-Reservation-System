package main;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatter;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Ticket extends javax.swing.JInternalFrame {

	private static final long serialVersionUID = 1L;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JTextField flightname;
	private JTextField flightno;
	private JButton jButtonBook;
	private JButton jButtonCancel;
	private JButton jButtonSearch;
	private JButton jButtonSearch2;
	private JLabel jLabelSource;
	private JLabel jLabelFlightno;
	private JLabel jLabelFlightName;
	private JLabel jLabelDepartTime;
	private JLabel jLabelClass;
	private JLabel jLabelPrice;
	private JLabel jLabelSeats;
	private JLabel jLabelDepart;
	private JLabel jLabel3;
	private JLabel jLabelCusID;
	private JLabel jLabelFirstName;
	private JLabel jLabelLastName;
	private JLabel jLabelPassportno;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel jPanel3;
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JComboBox<String> txtclass;
	private JTextField txtcustid;
	private JComboBox<String> txtdepart;
	private JTextField txtdept;
	private JTextField txtfirstname;
	private JTextField txtlastname;
	private JTextField txtpassport;
	private JTextField txtprice;
	private JSpinner txtseats;
	private JComboBox<String> txtsource;
	private JLabel txtticketno;
	private JLabel txttotal;
	private Date txtdate;

	public JTextField getFlightname() {
		return flightname;
	}

	public JTextField getFlightno() {
		return flightno;
	}

	public JButton getjButtonBook() {
		return jButtonBook;
	}

	public JButton getjButtonCancel() {
		return jButtonCancel;
	}

	public JButton getjButtonSearch() {
		return jButtonSearch;
	}

	public JButton getjButtonSearch2() {
		return jButtonSearch2;
	}

	public JLabel getjLabelSource() {
		return jLabelSource;
	}

	public JLabel getjLabelFlightno() {
		return jLabelFlightno;
	}

	public JLabel getjLabelFlightName() {
		return jLabelFlightName;
	}

	public JLabel getjLabelDepartTime() {
		return jLabelDepartTime;
	}

	public JLabel getjLabelClass() {
		return jLabelClass;
	}

	public JLabel getjLabelPrice() {
		return jLabelPrice;
	}

	public JLabel getjLabelSeats() {
		return jLabelSeats;
	}

	public JLabel getjLabelDepart() {
		return jLabelDepart;
	}

	public JLabel getjLabel3() {
		return jLabel3;
	}

	public JLabel getjLabelCusID() {
		return jLabelCusID;
	}

	public JLabel getjLabelFirstName() {
		return jLabelFirstName;
	}

	public JLabel getjLabelLastName() {
		return jLabelLastName;
	}

	public JLabel getjLabelPassportno() {
		return jLabelPassportno;
	}

	public JPanel getjPanel1() {
		return jPanel1;
	}

	public JPanel getjPanel2() {
		return jPanel2;
	}

	public JPanel getjPanel3() {
		return jPanel3;
	}

	public JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public JTable getjTable1() {
		return jTable1;
	}

	public JComboBox<String> getTxtclass() {
		return txtclass;
	}

	public JTextField getTxtcustid() {
		return txtcustid;
	}

	public JComboBox<String> getTxtdepart() {
		return txtdepart;
	}

	public JTextField getTxtdept() {
		return txtdept;
	}

	public JTextField getTxtfirstname() {
		return txtfirstname;
	}

	public JTextField getTxtlastname() {
		return txtlastname;
	}

	public JTextField getTxtpassport() {
		return txtpassport;
	}

	public JTextField getTxtprice() {
		return txtprice;
	}

	public JSpinner getTxtseats() {
		return txtseats;
	}

	public JComboBox<String> getTxtsource() {
		return txtsource;
	}

	public JLabel getTxtticketno() {
		return txtticketno;
	}

	public JLabel getTxttotal() {
		return txttotal;
	}

	public Date getTxtdate() {
		return txtdate;
	}

	public void setTxtdepart(String txtdepart) {
		this.txtdepart.setSelectedItem(txtdepart);
	}

	public void setTxtsource(String txtsource) {
		this.txtsource.setSelectedItem(txtsource);
	}
// End of variables declaration//GEN-END:variables

	public void setId(String id) {
		this.txtcustid.setText(id);}
	public void setTicketid(String ticketno) {
		this.txtticketno.setText(ticketno);}
	public void setFlightid(String flightid) {
		this.flightno.setText(flightid);}
	public void setTxtfirstname(String firstName){
		this.txtfirstname.setText(firstName);}
	public void setTxtlastname(String lastName){
		this.txtfirstname.setText(lastName);}
	public void settxtprice(String price){
		this.txtprice.setText(price);}
	public void setTxtseats(int seats){
		this.txtseats.setValue(seats);}
	public void setTxttotal(int total){
		this.txtseats.setValue(total);}
	public void setDate(String date) {
		this.txtdept.setText(date);}
	public void setPassport(String passport){
		this.txtpassport.setText(passport);}
	public void setFlightClass(String flightClass){
		this.txtclass.setSelectedItem(flightClass);}

	/**
	 * Creates new form Ticket
	 */
	public Ticket() {
		initComponents();
		autoID();
	}
	MysqlDataSource d = null;
	Connection con;
	PreparedStatement pst;
	ResultSetMetaData rsm;
	int c;

	public void setRsm(ResultSetMetaData rsm) {
		this.rsm = rsm;
	}

	public Ticket(MysqlDataSource ds) {
		initComponents();
		this.d = ds;
	}



	public void setTxtSource(String source){this.txtsource.setSelectedItem(source);}
	public void setTxtDepart(String depart){this.txtdepart.setSelectedItem(depart);}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new JPanel();
		txtsource = new JComboBox<>();
		txtdepart = new JComboBox<>();
		jLabelSource = new JLabel();
		jLabelDepart = new JLabel();
		jButtonSearch = new JButton();
		jScrollPane1 = new JScrollPane();
		jTable1 = new JTable();
		jLabel3 = new JLabel();
		txtticketno = new JLabel();
		jPanel3 = new JPanel();
		jLabelCusID = new JLabel();
		jLabelFirstName = new JLabel();
		jLabelLastName = new JLabel();
		txtcustid = new JTextField();
		jLabelPassportno = new JLabel();
		txtfirstname = new JTextField();
		txtlastname = new JTextField();
		txtpassport = new JTextField();
		jButtonSearch2 = new JButton();
		jPanel2 = new JPanel();
		jLabelFlightno = new JLabel();
		jLabelFlightName = new JLabel();
		jLabelDepartTime = new JLabel();
		jLabelClass = new JLabel();
		jLabelPrice = new JLabel();
		jLabelSeats = new JLabel();
		flightno = new JTextField();
		flightname = new JTextField();
		txtdept = new JTextField();
		txtclass = new JComboBox<>();
		txtprice = new JTextField();
		txtseats = new JSpinner();
		jButtonBook = new JButton();
		jButtonCancel = new JButton();
		txttotal = new JLabel();

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
				"Select Country",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 1, 12))); // NOI18N

		txtsource.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
				"Usa", "Srilanka", "Uk", "India", "Canada", "China" }));

		txtdepart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
				"Canada\t", "Srilanka", "Uk", "India", "Usa", "China" }));

		jLabelSource.setText("Source");

		jLabelDepart.setText("Departure");

		jButtonSearch.setText("Search");
		jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(txtsource,
								javax.swing.GroupLayout.PREFERRED_SIZE, 124,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(
								javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								64, Short.MAX_VALUE)
						.addComponent(txtdepart,
								javax.swing.GroupLayout.PREFERRED_SIZE, 111,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(35, 35, 35))
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(54, 54, 54).addComponent(jLabelSource)
						.addPreferredGap(
								javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(jLabelDepart).addGap(87, 87, 87))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jButtonSearch).addGap(49, 49, 49)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(32, 32, 32)
						.addGroup(jPanel1Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelSource).addComponent(jLabelDepart))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtsource,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtdepart,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(
								javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								28, Short.MAX_VALUE)
						.addComponent(jButtonSearch).addContainerGap()));

		jTable1.setModel(
				new javax.swing.table.DefaultTableModel(new Object[][] {

				}, new String[] { "Flight No", "Flight Name", "Source",
						"Departure", "Date", "DepTime", "ArrTime", "Charge" }));
		jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTable1MouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(jTable1);

		jLabel3.setText("Ticket No");

		txtticketno.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		txtticketno.setForeground(new java.awt.Color(255, 0, 0));
		txtticketno.setText("0" + txtticketno.getText());

		jLabelCusID.setText("Customer ID");

		jLabelFirstName.setText("FirstName");

		jLabelLastName.setText("LastName");

		jLabelPassportno.setText("Passportno");

		txtfirstname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txtfirstname.setForeground(new java.awt.Color(255, 0, 0));
		txtfirstname.setText(txtfirstname.getText());

		txtlastname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txtlastname.setForeground(new java.awt.Color(255, 0, 0));
		txtlastname.setText(txtlastname.getText());

		txtpassport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		txtpassport.setForeground(new java.awt.Color(255, 0, 0));
		txtpassport.setText(txtpassport.getText());

		jButtonSearch2.setText("Search");
		jButtonSearch2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addGap(57, 57, 57)
						.addGroup(jPanel3Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addComponent(jLabelCusID)
										.addGap(34, 34, 34)
										.addComponent(txtcustid,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												151,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												15, Short.MAX_VALUE)
										.addComponent(jButtonSearch2))
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addGroup(jPanel3Layout
												.createParallelGroup(
														javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabelFirstName)
												.addComponent(jLabelLastName)
												.addComponent(jLabelPassportno))
										.addGap(56, 56, 56)
										.addGroup(jPanel3Layout
												.createParallelGroup(
														javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(txtpassport)
												.addComponent(txtlastname)
												.addComponent(txtfirstname))))
						.addContainerGap()));
		jPanel3Layout.setVerticalGroup(jPanel3Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addGap(20, 20, 20)
						.addGroup(jPanel3Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelCusID)
								.addComponent(txtcustid,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonSearch2))
						.addGap(26, 26, 26)
						.addGroup(jPanel3Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelFirstName)
								.addComponent(txtfirstname))
						.addGap(31, 31, 31)
						.addGroup(jPanel3Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelLastName)
								.addComponent(txtlastname))
						.addGap(36, 36, 36)
						.addGroup(jPanel3Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelPassportno)
								.addComponent(txtpassport))
						.addContainerGap(37, Short.MAX_VALUE)));

		jLabelFlightno.setText("Flight no");

		jLabelFlightName.setText("Flight Name");

		jLabelDepartTime.setText("Depart Time");

		jLabelClass.setText("Class");

		jLabelPrice.setText("Price");

		jLabelSeats.setText("Seats");

		flightno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		flightno.setForeground(new java.awt.Color(255, 0, 0));
		flightno.setText(flightno.getText());

		flightname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		flightname.setForeground(new java.awt.Color(255, 0, 0));
		flightname.setText(flightname.getText());

		txtdept.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		txtdept.setForeground(new java.awt.Color(255, 0, 0));
		txtdept.setText(txtdept.getText());

		txtclass.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Economy", "Business" }));

		txtseats.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				JComponent comp = txtseats.getEditor();
				JFormattedTextField field = (JFormattedTextField) comp.getComponent(0);
				DefaultFormatter formatter = (DefaultFormatter) field.getFormatter();
				formatter.setCommitsOnValidEdit(true);
				txtseatsStateChanged(evt);
				System.out.println(txtseats.getValue());

			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGap(19, 19, 19)
						.addGroup(jPanel2Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel2Layout.createParallelGroup(
										javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jLabelDepartTime)
										.addComponent(jLabelClass,
												javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabelPrice,
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel2Layout
												.createParallelGroup(
														javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabelFlightno)
												.addComponent(jLabelFlightName)))
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addComponent(jLabelSeats)
										.addGap(35, 35, 35)))
						.addGroup(jPanel2Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addGap(60, 60, 60)
										.addGroup(jPanel2Layout
												.createParallelGroup(
														javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(flightname)
												.addComponent(txtdept)
												.addComponent(flightno)))
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addGap(50, 50, 50)
										.addGroup(jPanel2Layout
												.createParallelGroup(
														javax.swing.GroupLayout.Alignment.LEADING,
														false)
												.addComponent(txtclass, 0, 116,
														Short.MAX_VALUE)
												.addComponent(txtprice)
												.addComponent(txtseats,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														64,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(151, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGap(22, 22, 22)
						.addGroup(jPanel2Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelFlightno).addComponent(flightno))
						.addGap(28, 28, 28)
						.addGroup(jPanel2Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelFlightName)
								.addComponent(flightname))
						.addGap(31, 31, 31)
						.addGroup(jPanel2Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelDepartTime).addComponent(txtdept))
						.addGap(23, 23, 23)
						.addGroup(jPanel2Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelClass).addComponent(txtclass,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel2Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelPrice).addComponent(txtprice,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel2Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabelSeats).addComponent(txtseats,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		jButtonBook.setText("Book");
		jButtonBook.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButtonCancel.setText("Cancel");
		jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonCancelActionPerformed(evt);
			}
		});

		txttotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		txttotal.setForeground(new java.awt.Color(255, 0, 0));
		txttotal.setText(txttotal.getText());

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(32, 32, 32)
						.addGroup(layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jPanel1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout
														.createSequentialGroup()
														.addGap(44, 44, 44)
														.addComponent(jLabel3))
												.addGroup(layout
														.createSequentialGroup()
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(
																txtticketno)))
										.addGap(41, 41, 41)
										.addComponent(jPanel3,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGap(31, 31, 31))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jScrollPane1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														534,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(layout
														.createSequentialGroup()
														.addGap(207, 207, 207)
														.addComponent(txttotal,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																106,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout
														.createSequentialGroup()
														.addGap(51, 51, 51)
														.addComponent(jButtonBook,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																138,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jButtonCancel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																134,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(0, 0,
																Short.MAX_VALUE))
												.addGroup(layout
														.createSequentialGroup()
														.addGap(33, 33, 33)
														.addComponent(jPanel2,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addContainerGap()))))));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(42, 42, 42).addComponent(jPanel1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
								.addGap(53, 53, 53).addComponent(jLabel3)
								.addGap(18, 18, 18).addComponent(txtticketno))
						.addGroup(layout.createSequentialGroup()
								.addGap(31, 31, 31).addComponent(jPanel3,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGap(20, 20, 20)
										.addComponent(jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												213,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(32, 32, 32)
										.addComponent(txttotal,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												24,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jPanel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButtonBook,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														41,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jButtonCancel,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														41,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	public boolean jButton3ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

		String source = txtsource.getSelectedItem().toString().trim();
		String depart = txtdepart.getSelectedItem().toString().trim();
		if(source.equals(depart)){
			JOptionPane.showMessageDialog(this,"Source and Depart cant be same");
			return false;
		}
		try {
			if(d == null) {
				d = new MysqlDataSource();
				d.setUser("root");
				d.setPassword("1234");
				d.setDatabaseName("airline");
			}
			con =  d.getConnection();
			Statement s = con.createStatement();
			pst = con.prepareStatement(
					"SELECT * from flight WHERE source = ? and depart = ?");

			pst.setString(1, source);
			pst.setString(2, depart);
			ResultSet rs = pst.executeQuery();
			if(!rs.next()){
				JOptionPane.showMessageDialog(this,"Flight didnt found");
				return false;
			}
			else{
				JOptionPane.showMessageDialog(this,"Flight found");
			}

			ResultSetMetaData rsm = rs.getMetaData();
            c = rsm.getColumnCount();


			DefaultTableModel Df = (DefaultTableModel) jTable1.getModel();
			Df.setRowCount(0);

			while (rs.next()) {
				Vector<String> v2 = new Vector<String>();

				for (int i = 1; i <= c; i++) {
					v2.add(rs.getString("id"));
					v2.add(rs.getString("flightname"));
					v2.add(rs.getString("source"));
					v2.add(rs.getString("depart"));
					v2.add(rs.getString("date"));
					v2.add(rs.getString("deptime"));
					v2.add(rs.getString("arrtime"));
					v2.add(rs.getString("flightcharge"));
				}

				Df.addRow(v2);

			}

		} catch (SQLException ex) {
			Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		return true;
	}//GEN-LAST:event_jButton3ActionPerformed


	public void print(DefaultTableModel df) {
		print(df);
	}

	public void autoID() {
		try {
			if(d == null) {
				d = new MysqlDataSource();
				d.setUser("root");
				d.setPassword("1234");
				d.setDatabaseName("airline");
			}
			con =  d.getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select MAX(id) from ticket");
			rs.next();
			rs.getString("MAX(id)");
			if (rs.getString("MAX(id)") == null) {
				txtticketno.setText("TO001");
			} else {
				long id = Long.parseLong(rs.getString("MAX(id)").substring(2,
						rs.getString("MAX(id)").length()));
				id++;
				txtticketno.setText("TO" + String.format("%03d", id));

			}

		} catch (SQLException ex) {
			Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE,
					null, ex);
		}

	}



	boolean jButton4ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
		String id = txtcustid.getText();
		System.out.println(id);
		if(id.isEmpty()){
			JOptionPane.showMessageDialog(this, "Empty Id field. \n Please enter a validID");
			return false;
		}
		else{
			System.out.println(" ");
		}
		try {
			if(d == null) {
				d = new MysqlDataSource();
				d.setUser("root");
				d.setPassword("1234");
				d.setDatabaseName("airline");
			}
			con =  d.getConnection();
			pst = con.prepareStatement("select * from customer where id = ?");
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next() == false) {
				JOptionPane.showMessageDialog(this, "Record not Found");
				return false;
			} else {
				String fname = rs.getString("firstname");
				String lname = rs.getString("lastname");
				String passport = rs.getString("passport");
				txtfirstname.setText(fname.trim());
				txtlastname.setText(lname.trim());
				txtpassport.setText(passport.trim());
			}

		} catch (SQLException ex) {
			Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		return true;
	}//GEN-LAST:event_jButton4ActionPerformed

	private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

		DefaultTableModel Df = (DefaultTableModel) jTable1.getModel();

		int selectIndex = jTable1.getSelectedRow();

		flightno.setText(Df.getValueAt(selectIndex, 0).toString());
		flightname.setText(Df.getValueAt(selectIndex, 1).toString());
		txtdept.setText(Df.getValueAt(selectIndex, 5).toString());
		txtprice.setText(Df.getValueAt(selectIndex, 7).toString());

	}//GEN-LAST:event_jTable1MouseClicked

	private void txtseatsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtseatsStateChanged
		System.out.println(txtseats.getValue().toString());
		int price = Integer.parseInt(txtprice.getText());
		int qty = Integer.parseInt(txtseats.getValue().toString());

		int tot = price * qty;
		txttotal.setText(String.valueOf(tot));
	}

	public boolean jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

		String pattern = "\\d\\d\\d\\d-\\d\\d-\\d\\d";
		Pattern compiledPattern = Pattern.compile(pattern);

		String ticketid = txtticketno.getText();
		String flightid = flightno.getText();
		String custid = txtcustid.getText();
		String flightclass = txtclass.getSelectedItem().toString().trim();
		String price = txtprice.getText();
		String seats = txtseats.getValue().toString();
		//DateFormat da = new SimpleDateFormat("yyyy-MM-dd");
		String date = txtdept.getText();

		Matcher m = compiledPattern.matcher(date);
		boolean dateMatch = m.matches();

		if (ticketid.isEmpty() || flightid.isEmpty() || custid.isEmpty() || price.isEmpty()
				|| seats.isEmpty()|| date.isEmpty()){
			JOptionPane.showMessageDialog(this,"Please ensure that no fields are empty");
			return false;
		}
		else if (!dateMatch){
			JOptionPane.showMessageDialog(this, "Please enter depart time in the format yyyy-mm-dd (like 2021-04-20)");
			return false;
		}

		try {
			if(d == null) {
				d = new MysqlDataSource();
				d.setUser("root");
				d.setPassword("1234");
				d.setDatabaseName("airline");
			}
			con =  d.getConnection();
			pst = con.prepareStatement(
					"insert into ticket(id,flightid,custid,class,price,seats,date)values(?,?,?,?,?,?,?)");

			pst.setString(1, ticketid);
			pst.setString(2, flightid);
			pst.setString(3, custid);
			pst.setString(4, flightclass);
			pst.setString(5, price);
			pst.setString(6, seats);
			pst.setString(7, date);

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Ticket Booked...");
		} catch (SQLException ex) {
			Logger.getLogger(Addflight.class.getName()).log(Level.SEVERE, null,
					ex);
			return false;
		}
		return true;
	}

	private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {
		this.hide();
	}

}