
import java.awt.Color;
import java.awt.Font;
import java.awt.JobAttributes;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class QLTV extends JFrame implements ActionListener,KeyListener {
	private JLabel lbTitle,lbMatamvang,lbManhankhau,lbNgayve,lbNgaydi,lbNoiden,lbLydo;
	private JTextField txtMatamvang,txtManhankhau,txtNgayve,txtNgaydi,txtNoiden,txtLydo,txtChon;
	private JButton btnNew,btnEdit,btnAdd,btnDel,btnExit;
	
	JTable table,tableList;
	JScrollPane scrollPane = new JScrollPane();
	Vector tableTitle = new Vector();
	Vector tableRecords = new Vector();
		//Thiet lap cho Jframe
	public QLTV() {
		super("Quản Lý Tạm Vắng");
		super.setSize(800, 700);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		super.setLocation(400, 100);
		//new cac doi tuong
		lbTitle = new JLabel("QUẢN LÝ TẠM VẮNG");
		lbManhankhau = new JLabel("Mã Nhân Khẩu");
		lbMatamvang = new JLabel("Mã Tạm Vắng");
		lbNgaydi = new JLabel("Ngày đi");
		lbNgayve = new JLabel("Ngày về");
		lbLydo = new JLabel("Lí do");
		lbNoiden = new JLabel("Nơi đến");
		
		txtChon = new JTextField();
		txtLydo = new JTextField();
		txtManhankhau = new JTextField();
		txtMatamvang = new JTextField();
		txtNgaydi = new JTextField();
		txtNgayve = new JTextField();
		txtNoiden = new JTextField();
		
		btnNew = new JButton("New");
		btnAdd = new JButton("Add");
		btnEdit = new JButton("Edit");
		btnDel = new JButton("Del");
		btnExit = new JButton("Exit");
		
		this.getContentPane().setLayout(null);
		lbTitle.setBounds(new Rectangle(275,5,300,70));
		lbTitle.setFont(new Font("Tahoma",Font.BOLD,23));
		lbTitle.setForeground(Color.PINK);
		this.getContentPane().add(lbTitle);
		
		lbMatamvang.setBounds(new Rectangle(40,75,150,30));
		lbMatamvang.setFont(new Font("Tahoma",Font.PLAIN,14));
		lbMatamvang.setForeground(Color.PINK);
		txtMatamvang.setBounds(new Rectangle(150,80,110,25));
		this.getContentPane().add(txtMatamvang);
		this.getContentPane().add(lbMatamvang);
		
		lbManhankhau.setBounds(new Rectangle(40,120,150,30));
		lbManhankhau.setFont(new Font("Tahoma",Font.PLAIN,14));
		lbManhankhau.setForeground(Color.PINK);
		txtManhankhau.setBounds(new Rectangle(150,125,110,25));
		this.getContentPane().add(txtManhankhau);
		this.getContentPane().add(lbManhankhau);
		
		lbNgaydi.setBounds(new Rectangle(300,75,150,30));
		lbNgaydi.setFont(new Font("Tahoma",Font.PLAIN,14));
		lbNgaydi.setForeground(Color.PINK);
		txtNgaydi.setBounds(new Rectangle(370,80,110,25));
		this.getContentPane().add(txtNgaydi);
		this.getContentPane().add(lbNgaydi);
		
		lbNgayve.setBounds(new Rectangle(300,120,150,30));
		lbNgayve.setFont(new Font("Tahoma",Font.PLAIN,14));
		lbNgayve.setForeground(Color.PINK);
		txtNgayve.setBounds(new Rectangle(370,125,110,25));
		this.getContentPane().add(txtNgayve);
		this.getContentPane().add(lbNgayve);
		
		lbNoiden.setBounds(new Rectangle(520,75,150,30));
		lbNoiden.setFont(new Font("Tahoma",Font.PLAIN,14));
		lbNoiden.setForeground(Color.PINK);
		txtNoiden.setBounds(new Rectangle(590,80,110,25));
		this.getContentPane().add(txtNoiden);
		this.getContentPane().add(lbNoiden);
		
		lbLydo.setBounds(new Rectangle(520,120,150,30));
		lbLydo.setFont(new Font("Tahoma",Font.PLAIN,14));
		lbLydo.setForeground(Color.PINK);
		txtLydo.setBounds(new Rectangle(590,125,110,25));
		this.getContentPane().add(txtLydo);
		this.getContentPane().add(lbLydo);
		
		ImageIcon newicon = new ImageIcon("images/new.png");
		ImageIcon addicon = new ImageIcon("images/add.png");
		ImageIcon backicon = new ImageIcon("images/back.png");
		ImageIcon editicon = new ImageIcon("images/edit.png");
		ImageIcon deleteicon = new ImageIcon("images/delete.png");
		ImageIcon reseticon = new ImageIcon("images/reset.png");
		//Dua cac button vao Jframe
		btnNew.setBounds(new Rectangle(90,180,97,30));	
		btnNew.setIcon(newicon);
		btnNew.setBackground(Color.PINK);
		btnNew.setFont(new Font("Tahoma",Font.BOLD,12));
		this.getContentPane().add(btnNew);
		
		btnAdd.setBounds(new Rectangle(220,180,97,30));	
		btnAdd.setIcon(addicon);
		btnAdd.setBackground(Color.PINK);
		btnAdd.setFont(new Font("Tahoma",Font.BOLD,12));
		this.getContentPane().add(btnAdd);
		
		btnEdit.setBounds(new Rectangle(350,180,97,30));	
		btnEdit.setIcon(editicon);
		btnEdit.setBackground(Color.PINK);
		btnEdit.setFont(new Font("Tahoma",Font.BOLD,12));
		this.getContentPane().add(btnEdit);
		
		btnDel.setBounds(new Rectangle(480,180,97,30));	
		btnDel.setIcon(deleteicon);
		btnDel.setBackground(Color.PINK);
		btnDel.setFont(new Font("Tahoma",Font.BOLD,12));
		this.getContentPane().add(btnDel);
		
		btnExit.setBounds(new Rectangle(610,180,97,30));	
		btnExit.setIcon(editicon);
		btnExit.setBackground(Color.PINK);
		btnExit.setFont(new Font("Tahoma",Font.BOLD,12));
		this.getContentPane().add(btnExit);
		//tao bang
		
		tableList = new JTable();
		scrollPane.setViewportView(tableList);
		scrollPane.setBounds(new Rectangle(40,250,700,300));
		tableTitle.add("Mã Nhân Khẩu");
        tableTitle.add("Mã Tạm Vắng");
        tableTitle.add("Ngày đến");
        tableTitle.add("Ngày đi");
        tableTitle.add("Nơi đến");
        tableTitle.add("Lý Do");
        tableList.setModel(new DefaultTableModel(tableRecords, tableTitle));
        this.getContentPane().add(scrollPane);
		
		//Dang ky su kien
		btnNew.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnExit.addActionListener(this);
		btnEdit.addActionListener(this);
		
		txtChon.addKeyListener(this);
		txtLydo.addKeyListener(this);
		txtManhankhau.addKeyListener(this);
		txtMatamvang.addKeyListener(this);
		txtNgaydi.addKeyListener(this);
		txtNgayve.addKeyListener(this);
		txtNoiden.addKeyListener(this);
		btnAdd.addKeyListener(this);
		setVisible(true);
	}

	public static void main(String[] args) {
		QLTV qltv = new QLTV();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNew) {
			txtChon.setText("");
			txtLydo.setText("");
			txtManhankhau.setText("");
			txtMatamvang.setText("");
			txtNgaydi.setText("");
			txtNgayve.setText("");
			txtNoiden.setText("");
		}
		if(e.getSource() == btnAdd)
		{
			Vector record = new Vector();
			record.add(txtManhankhau.getText());
			record.add(txtMatamvang.getText());
			record.add(txtNgaydi.getText());
			record.add(txtNgayve.getText());
			record.add(txtLydo.getText());
			record.add(txtNoiden.getText());
			tableRecords.add(record);
			tableList.setModel(new DefaultTableModel(tableRecords,tableTitle));
			JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
		}
		if(e.getSource() == btnDel)
		{
			int iDongDaChon = tableList.getSelectedRow();
            if (iDongDaChon == -1) {
                JOptionPane.showMessageDialog(rootPane, "Chọn hàng cần xóa","Chọn hàng",JOptionPane.WARNING_MESSAGE);
            } else {
                Vector vDongDaChon = (Vector) tableRecords.get(iDongDaChon);
                String idCuaDongDaChon = vDongDaChon.get(0).toString();
                if (JOptionPane.showConfirmDialog(rootPane, "Chắc chắn xóa ?","Xóa", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    tableRecords.remove(iDongDaChon);
                    tableList.setModel(new DefaultTableModel(tableRecords, tableTitle));
                }
            }
		}
		if (e.getSource() == btnEdit) {
            int iDongDaChon = tableList.getSelectedRow();
            if (iDongDaChon == -1) {
                JOptionPane.showMessageDialog(rootPane, "Xin vui lòng chọn dòng cần sửa");
            } else {
                Vector record = new Vector();
                record.add(txtManhankhau.getText());
                record.add(txtMatamvang.getText());
                record.add(txtNgaydi.getText());
                record.add(txtNgayve.getText());
                record.add(txtLydo.getText());
                record.add(txtNoiden.getText());
                tableRecords.set(iDongDaChon, record);
                tableList.setModel(new DefaultTableModel(tableRecords, tableTitle));
                JOptionPane.showMessageDialog(rootPane, "Cập nhật xong");
            }
        }
		if(e.getSource() == btnExit) {
			System.exit(0);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource() == txtMatamvang)
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				txtManhankhau.requestFocus();
			}
		if(e.getSource() == txtManhankhau)
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				txtNgaydi.requestFocus();
			}
		if(e.getSource() == txtNgaydi)
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				txtNgayve.requestFocus();
			}
		if(e.getSource() == txtNgayve)
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				txtNoiden.requestFocus();
			}
		if(e.getSource() == txtNoiden)
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				txtLydo.requestFocus();
			}
		if(e.getSource() == txtLydo)
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				btnAdd.requestFocus();
			}
		if(e.getSource() == btnAdd)
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				Vector record = new Vector();
				record.add(txtManhankhau.getText());
				record.add(txtMatamvang.getText());
				record.add(txtNgaydi.getText());
				record.add(txtNgayve.getText());
				record.add(txtLydo.getText());
				record.add(txtNoiden.getText());
				tableRecords.add(record);
				tableList.setModel(new DefaultTableModel(tableRecords,tableTitle));
				JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
			}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
