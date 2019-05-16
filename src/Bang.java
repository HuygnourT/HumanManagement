import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
public class Bang extends JFrame{
	public Bang()
	{
		initComponent();
		
		tableTitle.add("ID");
        tableTitle.add("Name");
        tableTitle.add("Phone");

        tableList.setModel(new DefaultTableModel(tableRecords, tableTitle));//Set dữ liệu cho bảng

        setSize(500, 600);
        setLocationRelativeTo(null);
        setTitle("Table");
		setVisible(true);
		setResizable(false);
	}
	public void initComponent()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		pBegin = new JPanel(new GridLayout(2,0));
		//pBegin : lbTitle,pInput
		lbTitle = new JLabel("Quản Lý Danh sách");
		lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // set title in center
		pBegin.add(lbTitle);
		
		
		pID = new JPanel(new BorderLayout());
		lbID = new JLabel("ID : ");
		txtID = new JTextField();
		pID.add(lbID,BorderLayout.WEST);
		pID.add(txtID,BorderLayout.CENTER);
		
		pName = new JPanel(new BorderLayout());
		lbName = new JLabel("Name : ");
		txtName = new JTextField();
		pName.add(lbName,BorderLayout.WEST);
		pName.add(txtName,BorderLayout.CENTER);
		
		pPhone = new JPanel(new BorderLayout());
		lbPhone = new JLabel("Phone : ");
		txtPhone = new JTextField();
		pPhone.add(lbPhone,BorderLayout.WEST);
		pPhone.add(txtPhone,BorderLayout.CENTER);
		
		pInput = new JPanel(new GridLayout(3,0));
		pInput.add(pID);
		pInput.add(pName);
		pInput.add(pPhone);
		pBegin.add(pInput);
		add(pBegin,BorderLayout.PAGE_START);
		//pCenter : tableList
	
		jScrollPane1.setViewportView(tableList);
		add(jScrollPane1,BorderLayout.CENTER);
		
		//pEnd : button
		pEnd = new JPanel(new BorderLayout());
		btnAdd = new JButton("Add");
		pEnd.add(btnAdd,BorderLayout.WEST);
		btnDelete = new JButton("Delete");
		pEnd.add(btnDelete,BorderLayout.CENTER);
		btnEdit = new JButton("Edit");
		pEnd.add(btnAdd,BorderLayout.EAST);
		add(pEnd,BorderLayout.PAGE_END);
		
	}
	JScrollPane jScrollPane1 = new JScrollPane();
	JTable tableList = new JTable();
	Vector tableRecords = new Vector();
	Vector tableTitle = new Vector();
	JPanel pBegin,pEnd;
	//pBegin :lbTitle,pInput
	//pCenter : Table
	//pEnd : Button
	JPanel pID,pName,pPhone,pInput;
	
	JLabel lbTitle,lbID,lbName,lbPhone;
	JTextField txtID,txtName,txtPhone;
	JButton btnAdd,btnDelete,btnEdit;
	
	
	public static void main(String[] args) {
		Bang huy = new Bang();
		
	}
	
}
