
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


public class QLTT extends JFrame implements ActionListener,KeyListener{
	private JLabel lbTitle,lbMathuongtru,lbManhankhau,lbNgaychuyenden,lbNoiotruoc,lbQuanhechuho,lbSohokhau;
	private JTextField txtMathuongtru,txtManhankhau,txtNgaychuyenden,txtNoiotruoc,txtQuanhechuho,txtSohokhau;
	private JButton btnNew,btnEdit,btnAdd,btnDel,btnExit;
	
	JTable table,tableList;
	JScrollPane scrollPane = new JScrollPane();
	Vector tableTitle = new Vector();
	Vector tableRecords = new Vector();
	//Thiet lap cho Jframe
	public QLTT() {
		super("Quản Lý Thường Trú");
		super.setSize(800, 700);
		super.setLocationRelativeTo(null);
		super.setResizable(false);
		super.setLocation(400, 100);
		//new cac doi tuong
		lbTitle = new JLabel("QUẢN LÝ THƯỜNG TRÚ");
		lbMathuongtru = new JLabel("Mã Thường Trú");
		lbManhankhau = new JLabel("Mã Nhân Khẩu");
		lbNgaychuyenden = new JLabel("Ngày Chuyển Đến");
		lbNoiotruoc = new JLabel("Nơi Ở Trước");
		lbQuanhechuho = new JLabel("Quan Hệ Chủ Hộ");
		lbSohokhau= new JLabel("Số Hộ Khẩu");
		
		txtMathuongtru = new JTextField();
		txtNgaychuyenden = new JTextField();
		txtManhankhau = new JTextField();
		txtNoiotruoc = new JTextField();
		txtQuanhechuho = new JTextField();
		txtSohokhau = new JTextField();
		
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
		
		lbMathuongtru.setBounds(new Rectangle(40,75,150,30));
		lbMathuongtru.setFont(new Font("Tahoma",Font.PLAIN,14));
		lbMathuongtru.setForeground(Color.PINK);
		txtMathuongtru.setBounds(new Rectangle(150,80,110,25));
		this.getContentPane().add(txtMathuongtru);
		this.getContentPane().add(lbMathuongtru);
		
		lbQuanhechuho.setBounds(new Rectangle(40,120,150,30));
		lbQuanhechuho.setFont(new Font("Tahoma",Font.PLAIN,14));
		lbQuanhechuho.setForeground(Color.PINK);
		txtQuanhechuho.setBounds(new Rectangle(150,125,110,25));
		this.getContentPane().add(txtQuanhechuho);
		this.getContentPane().add(lbQuanhechuho);
		
		lbSohokhau.setBounds(new Rectangle(280,75,150,30));
		lbSohokhau.setFont(new Font("Tahoma",Font.PLAIN,14));
		lbSohokhau.setForeground(Color.PINK);
		txtSohokhau.setBounds(new Rectangle(380,80,110,25));
		this.getContentPane().add(txtSohokhau);
		this.getContentPane().add(lbSohokhau);
		
		lbManhankhau.setBounds(new Rectangle(280,120,150,30));
		lbManhankhau.setFont(new Font("Tahoma",Font.PLAIN,14));
		lbManhankhau.setForeground(Color.PINK);
		txtManhankhau.setBounds(new Rectangle(380,125,110,25));
		this.getContentPane().add(txtManhankhau);
		this.getContentPane().add(lbManhankhau);
		
		lbNgaychuyenden.setBounds(new Rectangle(510,75,150,30));
		lbNgaychuyenden.setFont(new Font("Tahoma",Font.PLAIN,14));
		lbNgaychuyenden.setForeground(Color.PINK);
		txtNgaychuyenden.setBounds(new Rectangle(640,80,110,25));
		this.getContentPane().add(txtNgaychuyenden);
		this.getContentPane().add(lbNgaychuyenden);
		
		lbNoiotruoc.setBounds(new Rectangle(510,120,150,30));
		lbNoiotruoc.setFont(new Font("Tahoma",Font.PLAIN,14));
		lbNoiotruoc.setForeground(Color.PINK);
		txtNoiotruoc.setBounds(new Rectangle(640,125,110,25));
		this.getContentPane().add(txtNoiotruoc);
		this.getContentPane().add(lbNoiotruoc);
		
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
				tableTitle.add("Mã Thường Trú");
		        tableTitle.add("Mã Nhân Khẩu");
		        tableTitle.add("Số Hộ Khẩu");
		        tableTitle.add("Quan hệ Chủ Hộ");
		        tableTitle.add("Nơi Ở Trước");
		        tableTitle.add("Ngày Chuyển Đến");
		        tableList.setModel(new DefaultTableModel(tableRecords, tableTitle));
		        this.getContentPane().add(scrollPane);
		//Dang ky su kien
				btnNew.addActionListener(this);
				btnAdd.addActionListener(this);
				btnDel.addActionListener(this);
				btnExit.addActionListener(this);
				btnEdit.addActionListener(this);
				
				txtMathuongtru.addKeyListener(this);
				txtQuanhechuho.addKeyListener(this);
				txtManhankhau.addKeyListener(this);
				txtSohokhau.addKeyListener(this);
				txtNgaychuyenden.addKeyListener(this);
				txtNoiotruoc.addKeyListener(this);
				btnAdd.addKeyListener(this);
		setVisible(true);
	
	}

	public static void main(String[] args) {
		QLTT qltt = new QLTT();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNew) {
			txtMathuongtru.setText("");
			txtNgaychuyenden.setText("");
			txtManhankhau.setText("");
			txtSohokhau.setText("");
			txtQuanhechuho.setText("");
			txtNoiotruoc.setText("");
		}
		if(e.getSource() == btnAdd)
		{
			Vector record = new Vector();
			record.add(txtManhankhau.getText());
			record.add(txtMathuongtru.getText());
			record.add(txtNgaychuyenden.getText());
			record.add(txtSohokhau.getText());
			record.add(txtNoiotruoc.getText());
			record.add(txtQuanhechuho.getText());
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
                record.add(txtMathuongtru.getText());
                record.add(txtNgaychuyenden.getText());
                record.add(txtSohokhau.getText());
                record.add(txtNoiotruoc.getText());
                record.add(txtQuanhechuho.getText());
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
		if(e.getSource() == txtMathuongtru)
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				txtQuanhechuho.requestFocus();
			}
		if(e.getSource() == txtQuanhechuho)
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				txtSohokhau.requestFocus();
			}
		if(e.getSource() == txtSohokhau)
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				txtManhankhau.requestFocus();
			}
		if(e.getSource() == txtManhankhau)
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				txtNgaychuyenden.requestFocus();
			}
		if(e.getSource() == txtNgaychuyenden)
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				txtNoiotruoc.requestFocus();
			}
		if(e.getSource() == txtNoiotruoc)
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				btnAdd.requestFocus();
			}
		if(e.getSource() == btnAdd)
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				Vector record = new Vector();
				record.add(txtManhankhau.getText());
				record.add(txtNoiotruoc.getText());
				record.add(txtNgaychuyenden.getText());
				record.add(txtSohokhau.getText());
				record.add(txtQuanhechuho.getText());
				record.add(txtMathuongtru.getText());
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
