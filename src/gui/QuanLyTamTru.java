package gui;

import event.writeQuanLyTamTru;
import console.PersonTamTru;


import javax.swing.filechooser.FileSystemView;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
public class QuanLyTamTru extends JFrame implements ActionListener,KeyListener,MouseListener{
	JButton btnAdd,btnEdit,btnDelete,btnSave,btnOpen,btnClear;
	private JFileChooser fc = new JFileChooser();
	JLabel lbMaNhanKhau,lbCmnd,lbQueQuan,lbHoVaTen,lbDanToc,lbNgheNghiep,lbNgaySinh
			,lbTrinhDo,lbPhone,lbQuocTich,lbSoDienThoai,lbGioiTinh,lbTieuDe;
	JTextField txtMaNhanKhau,txtCmnd,txtQueQuan,txtHoVaTen,txtDanToc,txtNgheNghiep,txtNgaySinh
	,txtTrinhDo,txtPhone,txtQuocTich,txtSoDienThoai,txtGioiTinh;
	JLabel lbTitle,lbMaThuongTru,lbNgayChuyenden,lbNoiOTruoc,lbQuanHeChuHo,lbSoHoKhau;
	JTextField txtMaThuongTru,txtNgayChuyenDen,txtNoiOTruoc,txtQuanHeChuHo,txtSoHoKhau;
	String[] nation = new String[] {"","An Giang","Ba Ria - Vung Tau","Bac Giang","Bac Kan","Bac Ninh",
			"Ben Tre","Binh Dinh","Binh Duong","Binh Phuoc","Binh Thuan","Ca Mau","Cao Bang","Dak Lak",
			"Dak Nong" , "Dien Bien","Dong Nai","Dong Thap","Gia Lai","Ha Giang","Ha Nam","Ha Tinh",
			"Hai Duong","Hau Giang","Hoa Binh","Hung Yen","Khanh Hoa","Kien Giang","Kon Tum",
			"Lai Chau","Lam Dong","Lang Son","Lao Cai","Long An","Nam Dinh","Nghe An","Ninh Binh","Ninh Thuan",
			"Phu Tho","Quang Binh","Quang Nam","Quang Ngai","Quang Ninh","Quang Tri","Soc Trang","Son La",
			"Tay Ninh","Thai Binh","Thai Nguyen","Thanh Hoa","TT-Hue","Tien Giang","Tra Vinh","Tuyen Quang","Vinh Long",
			"Vinh Phuc","Yen Bai","Phu Yen","Can Tho","Da Nang","Hai Phong","Ha Noi","Ho Chi Minh"};
	JComboBox<String> cityList; 
	JRadioButton nam,nu;
	ButtonGroup btnGioiTinh;
	
	JTable table,tableList;
	JScrollPane scrollPane = new JScrollPane();
	Vector tableTitle = new Vector();
	Vector tableRecords = new Vector();
	ImageIcon del = new ImageIcon("images/delete.png");
	ImageIcon add = new ImageIcon("images/add.png");
	ImageIcon sav = new ImageIcon("images/sav.png");
	PersonTamTru[] list = new PersonTamTru[1000];
	
	static int n=0;
	public QuanLyTamTru()
	{
		//1. Initialization
		super("Human Management");
		setSize(new Dimension(1400,500));
		setLayout(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lbTieuDe = new JLabel("Quản Lý Tạm Trú Đà Nẵng");
		lbTieuDe.setFont(new Font("Arial",3,16));
		lbTieuDe.setBounds(new Rectangle(50,10,250,50));
		add(lbTieuDe);
		
		//tao bang
		tableList = new JTable();
		scrollPane.setViewportView(tableList);
		scrollPane.setBounds(new Rectangle(10,100,1350,150));
		tableTitle.add("ID"); // ma nhan khau
        tableTitle.add("Full Name"); // tên
        tableTitle.add("ID Nation"); // cmnd
        tableTitle.add("Hometown"); // quê 
        tableTitle.add("Ethnic"); // Dân Tộc
        tableTitle.add("Job");
        tableTitle.add("Day Of Birth"); //Sinh Nhật
        tableTitle.add("Gender");
        tableTitle.add("Phone Number");//phone number
        tableTitle.add("Resident ID"); // Mã Thường Trú
        tableTitle.add("Household ID"); // Số Hộ Khẩu
        tableTitle.add("Relation"); // Quan Hệ Với Chủ Hộ
        tableTitle.add("Previous Place");
        tableTitle.add("Date of Arrival");
        tableList.setModel(new DefaultTableModel(tableRecords, tableTitle));
		add(scrollPane);
		
		//Mã Nhân Khẩu , Họ Và Tên ,Nghề Nghiệp , Mã Thường Trú, Quan Hệ Chủ Hộ
		lbMaNhanKhau = new JLabel("Mã Nhân Khẩu");
		lbMaNhanKhau.setBounds(new Rectangle(30,300,85,20));
		add(lbMaNhanKhau);
		txtMaNhanKhau = new JTextField();
		txtMaNhanKhau.setBounds(new Rectangle(115,300,100,20));
		add(txtMaNhanKhau);
		
		lbHoVaTen = new JLabel("Họ và Tên");
		lbHoVaTen.setBounds(new Rectangle(30,330,85,20));
		add(lbHoVaTen);
		txtHoVaTen = new JTextField();
		txtHoVaTen.setBounds(new Rectangle(115,330,100,20));
		add(txtHoVaTen);
		
		lbNgheNghiep = new JLabel("Nghề Nghiệp");
		lbNgheNghiep.setBounds(new Rectangle(30,360,85,20));
		add(lbNgheNghiep);
		txtNgheNghiep = new JTextField();
		txtNgheNghiep.setBounds(new Rectangle(115,360,100,20));
		add(txtNgheNghiep);
		
		lbMaThuongTru = new JLabel("Mã Thường Trú");
		lbMaThuongTru.setBounds(new Rectangle(30,390,100,20));
		add(lbMaThuongTru);
		txtMaThuongTru = new JTextField();
		txtMaThuongTru.setBounds(new Rectangle(130,390,85,20));
		add(txtMaThuongTru);
		
		lbQuanHeChuHo = new JLabel("Quan Hệ Chủ Hộ");
		lbQuanHeChuHo.setBounds(new Rectangle(30,420,100,20));
		add(lbQuanHeChuHo);
		txtQuanHeChuHo = new JTextField();
		txtQuanHeChuHo.setBounds(new Rectangle(130,420,85,20));
		add(txtQuanHeChuHo);
		
		
		//Cmnd,Sđt,Ngày Sinh,Số Hộ Khẩu,Ngày Chuyển đến
		lbCmnd = new JLabel("Số CMND");
		lbCmnd.setBounds(new Rectangle(235,300,70,20));
		add(lbCmnd);
		txtCmnd = new JTextField();
		txtCmnd.setBounds(new Rectangle(315,300,100,20));
		add(txtCmnd);
		
		lbSoDienThoai = new JLabel("Số Điện Thoại ");
		lbSoDienThoai.setBounds(new Rectangle(235,330,100,20));
		add(lbSoDienThoai);
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBounds(new Rectangle(315,330,100,20));
		add(txtSoDienThoai);
		
		lbNgaySinh = new JLabel("Ngày Sinh");
		lbNgaySinh.setBounds(new Rectangle(235,360,100,20));
		add(lbNgaySinh);
		txtNgaySinh = new JTextField();
		txtNgaySinh.setBounds(new Rectangle(315,360,100,20));
		add(txtNgaySinh);
		
		lbSoHoKhau = new JLabel("Số Hộ Khẩu");
		lbSoHoKhau.setBounds(new Rectangle(235,390,100,20));
		add(lbSoHoKhau);
		txtSoHoKhau = new JTextField();
		txtSoHoKhau.setBounds(new Rectangle(315,390,100,20));
		add(txtSoHoKhau);
		
		lbNgayChuyenden = new JLabel("Ngày Chuyển Đến ");
		lbNgayChuyenden.setBounds(new Rectangle(235,420,120,20));
		add(lbNgayChuyenden);
		txtNgayChuyenDen = new JTextField();
		txtNgayChuyenDen.setBounds(new Rectangle(345,420,70,20));
		add(txtNgayChuyenDen);
		
		//Quê Quán,Dân Tộc,Giới Tính, Nơi Ở Cũ
		lbQueQuan = new JLabel("Quê Quán");
		lbQueQuan.setBounds(new Rectangle(430,300,70,20));
		add(lbQueQuan);
		cityList = new JComboBox<>(nation);
		cityList.setBounds(new Rectangle(500,300,100,20));
		add(cityList);
		
		lbDanToc = new JLabel("Dân Tộc");
		lbDanToc.setBounds(new Rectangle(430,330,70,20));
		add(lbDanToc);
		txtDanToc = new JTextField();
		txtDanToc.setBounds(new Rectangle(500,330,100,20));
		add(txtDanToc);
		
		lbGioiTinh = new JLabel("Giới Tính");
		lbGioiTinh.setBounds(new Rectangle(430,360,70,20));
		add(lbGioiTinh);
		nam = new JRadioButton("Nam");
		nam.setBounds(new Rectangle(500,360,55,20));
		nu = new JRadioButton("Nữ");
		nu.setBounds(new Rectangle(555,360,50,20));
		add(nam);
		add(nu);
		btnGioiTinh = new ButtonGroup();
		btnGioiTinh.add(nam);
		btnGioiTinh.add(nu);
		
		lbNoiOTruoc = new JLabel("Nơi Ở Cũ");
		lbNoiOTruoc.setBounds(new Rectangle(430,390,70,20));
		add(lbNoiOTruoc);
		txtNoiOTruoc = new JTextField();
		txtNoiOTruoc.setBounds(new Rectangle(500,390,100,20));
		add(txtNoiOTruoc);
		
		btnAdd = new JButton("Add");
		btnAdd.setIcon(add);
		btnAdd.setBounds(new Rectangle(630,300,80,50));
		btnAdd.addActionListener(this);
		add(btnAdd);
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(new Rectangle(725,300,80,50));
		btnEdit.addActionListener(this);
		add(btnEdit);
		btnDelete = new JButton("Delete");
		btnDelete.setIcon(del);
		btnDelete.setBounds(new Rectangle(820,300,80,50));
		btnDelete.addActionListener(this);
		add(btnDelete);
		btnSave = new JButton("Save");
		btnSave.setBounds(new Rectangle(630,370,80,50));
		btnSave.addActionListener(this);
		add(btnSave);
		btnOpen = new JButton("Open");
		btnOpen.setBounds(new Rectangle(725,370,80,50));
		btnOpen.addActionListener(this);
		add(btnOpen);
		btnClear = new JButton("Clear");
		btnClear.setBounds(new Rectangle(820,370,80,50));
		btnClear.addActionListener(this);
		add(btnClear);
		
		tableList.addMouseListener(this);
		
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[] args) {
		QuanLyTamTru huy = new QuanLyTamTru();
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd)
		{
			Vector record = new Vector();
			record.add(txtMaNhanKhau.getText());
			record.add(txtHoVaTen.getText());
			record.add(txtCmnd.getText());
			record.add(cityList.getSelectedItem().toString());
			//list[n].setQueQuan(cityList.getSelectedItem().toString());
			record.add(txtDanToc.getText());
			record.add(txtNgheNghiep.getText());
			record.add(txtNgaySinh.getText());
			String gd ="";
			if(nam.isSelected())
				gd = "Nam";
			else if(nu.isSelected())
				gd ="Nữ";
			record.add(gd);
			record.add(txtSoDienThoai.getText());
			record.add(txtMaThuongTru.getText());
			record.add(txtSoHoKhau.getText());
			record.add(txtQuanHeChuHo.getText());
			record.add(txtNoiOTruoc.getText());
			record.add(txtNgayChuyenDen.getText());
			//list[n].setSdt(txtSoDienThoai.getText());
//			list[n] = new PersonTamTru(txtMaNhanKhau.getText(),txtHoVaTen.getText(),txtCmnd.getText(),
//					cityList.getSelectedItem().toString(),txtNoiSinh.getText(),txtDanToc.getText(),
//					txtNgheNghiep.getText(),txtNgaySinh.getText(),gd,txtSoDienThoai.getText());
			
			n++;
			tableRecords.add(record);
			tableList.setModel(new DefaultTableModel(tableRecords,tableTitle));
			JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
			//đặt các ô về mặc định
			btnGioiTinh.clearSelection();
			txtMaNhanKhau.setText("");
			txtHoVaTen.setText("");
			txtCmnd.setText("");
			//txtQueQuan.setText("");
			txtDanToc.setText("");
			txtNgheNghiep.setText("");
			txtNgaySinh.setText("");
			txtSoDienThoai.setText("");
			txtMaNhanKhau.requestFocus();
			txtMaThuongTru.setText("");
			txtSoHoKhau.setText("");
			txtQuanHeChuHo.setText("");
			txtNoiOTruoc.setText("");
			txtNgayChuyenDen.setText("");
		}
		//Xóa 1 dòng
		if(e.getSource() == btnDelete)
		{
			int iDongDaChon = tableList.getSelectedRow();
            if (iDongDaChon == -1) {
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn record cần xóa");
            } else {
                Vector vDongDaChon = (Vector) tableRecords.get(iDongDaChon);
                String idCuaDongDaChon = vDongDaChon.get(0).toString();
                if (JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa dòng đã chọn có id: " + idCuaDongDaChon, "Lua chon", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    tableRecords.remove(iDongDaChon);
                    tableList.setModel(new DefaultTableModel(tableRecords, tableTitle));
                }
            }
		}
		if(e.getSource() == btnEdit)
		{
			int iDongDaChon = tableList.getSelectedRow();
            if (iDongDaChon == -1) {
                JOptionPane.showMessageDialog(rootPane, "Xin vui lòng chọn dòng cần sửa");
            } else {
                Vector record = new Vector();
                record.add(txtMaNhanKhau.getText());
                record.add(txtHoVaTen.getText());
                record.add(txtCmnd.getText());
                //record.add(txtQueQuan.getText());
                record.add("");
                record.add(txtDanToc.getText());
                record.add(txtNgheNghiep.getText());
                record.add(txtNgaySinh.getText());
                String gd ="";
    			if(nam.isSelected())
    				gd = "Nam";
    			else if(nu.isSelected())
    				gd ="Nữ";
    			record.add(gd);
                record.add(txtSoDienThoai.getText());
                record.add(txtMaThuongTru.getText());
                record.add(txtSoHoKhau.getText());
                record.add(txtQuanHeChuHo.getText());
                record.add(txtNoiOTruoc.getText());
                record.add(txtNgayChuyenDen.getText());
                tableRecords.set(iDongDaChon, record);
                tableList.setModel(new DefaultTableModel(tableRecords, tableTitle));
            JOptionPane.showMessageDialog(rootPane, "Cập nhật xong");
            }
		}
		if(e.getSource()==btnSave) {
			JFileChooser c = new JFileChooser();
			int rVal = c.showSaveDialog(null);
			if (rVal == JFileChooser.APPROVE_OPTION) {
			     String filename = c.getSelectedFile().getName();
			     String dir = c.getCurrentDirectory().toString();
			     String excelFilePath = dir+"\\"+filename+".xlsx";
			     writeQuanLyTamTru huy = new writeQuanLyTamTru();
			     List<PersonTamTru> persons = huy.getPersons(list,n);
			     
					try {
						huy.writeExcel(persons, excelFilePath);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				
			 }
		}
		if(e.getSource()==btnOpen) {
			JFileChooser c = new JFileChooser();
			int rVal = c.showOpenDialog(null);
			if (rVal == JFileChooser.APPROVE_OPTION) {
			     String filename = c.getSelectedFile().getName();
			     String dir = c.getCurrentDirectory().toString();
			     String excelFilePath = dir+"\\"+filename+".xlsx";
//			     readQuanLyNhanKhau huy = new readQuanLyNhanKhau();
//			     try {
//					 List<Person> persons = huy.readExcel(excelFilePath) ;
//					 for(Person person : persons)
//				     {
//						 Vector record = new Vector();
//				    	 record.add(person.getMaNhanKhau());
//				    	 record.add(person.getHoVaTen());
//				    	 record.add(person.getCmnd());
//				    	 record.add(person.getQueQuan());
//				    	 record.add(person.getNoiSinh());
//				    	 record.add(person.getDanToc());
//				    	 record.add(person.getNgheNghiep());
//				    	 record.add(person.getNgaySinh());
//				    	 record.add(person.getGioiTinh());
//				    	 record.add(person.getSdt());
//				    	 System.out.println(person.getMaNhanKhau()+" "+person.getHoVaTen());
//				    	 tableRecords.add(record);
//				    	 tableList.setModel(new DefaultTableModel(tableRecords,tableTitle));
//				     }
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}
			     
			}
		}
//		if(e.getSource() == btnClear)
//		{
//			for(int i = 0 ; i < tableRecords.size() ; i++)
//			{
//				 Vector vDongDaChon = (Vector) tableRecords.get(i);
//	                String idCuaDongDaChon = vDongDaChon.get(0).toString();
//				tableRecords.remove(i);
//                tableList.setModel(new DefaultTableModel(tableRecords, tableTitle));
//			}
//				
//		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tableList) {
            int iDongDaChon = tableList.getSelectedRow();
            if (iDongDaChon != -1) {
                Vector vDongDaChon = (Vector) tableRecords.get(iDongDaChon);
                
                txtMaNhanKhau.setText(vDongDaChon.get(0).toString());
                txtHoVaTen.setText(vDongDaChon.get(1).toString());
                txtCmnd.setText(vDongDaChon.get(2).toString());
                //txtQueQuan.setText(vDongDaChon.get(3).toString()); 
                //Chưa đổi lại quê quan được
                txtDanToc.setText(vDongDaChon.get(4).toString());
                txtNgheNghiep.setText(vDongDaChon.get(5).toString());
                txtNgaySinh.setText(vDongDaChon.get(6).toString());
                //txtGioiTinh.setText(vDongDaChon.get(7).toString());
                
                txtSoDienThoai.setText(vDongDaChon.get(8).toString());
                txtMaThuongTru.setText(vDongDaChon.get(9).toString());
                txtSoHoKhau.setText(vDongDaChon.get(10).toString());
                txtQuanHeChuHo.setText(vDongDaChon.get(11).toString());
                txtNoiOTruoc.setText(vDongDaChon.get(12).toString());
                txtNgayChuyenDen.setText(vDongDaChon.get(13).toString());
            }
        }
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}

}