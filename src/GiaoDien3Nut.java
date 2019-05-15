import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GiaoDien3Nut extends JFrame implements ActionListener{
	JButton btnQLNK,btnQLTT,btnQLTV;
	JMenu mFile;
	JMenuItem menuIteamOpen,menuIteamSave,menuIteamSaveAs;
	public GiaoDien3Nut()
	{
		super("Giao Diện Chính");
		setLayout(null);
		setSize(new Dimension(300,400));
		
		JMenuBar mb = new JMenuBar();
		mFile = new JMenu("File");
		menuIteamOpen = new JMenuItem("Open..");
		menuIteamSave = new JMenuItem("Save");
		menuIteamSaveAs = new JMenuItem("Save As");
		mFile.add(menuIteamOpen);
		mFile.add(menuIteamSave);
		mFile.add(menuIteamSaveAs);
		mb.add(mFile);
		setJMenuBar(mb);
		
		btnQLNK = new JButton("Quản Lý Nhân Khẩu");
		btnQLNK.setBackground(Color.PINK);
		btnQLNK.setBounds(new Rectangle(50,50,200,20));
		btnQLTT = new JButton("Quản Lý Tạm Trú");
		btnQLTT.setBackground(Color.PINK);
		btnQLTT.setBounds(new Rectangle(50,120,200,20));
		btnQLTV = new JButton("Quản Lý Tạm Vắng");
		btnQLTV.setBackground(Color.PINK);
		btnQLTV.setBounds(new Rectangle(50,190,200,20));
		
		
		
		add(btnQLNK);
		add(btnQLTT);
		add(btnQLTV);
		btnQLNK.addActionListener(this);
		btnQLTT.addActionListener(this);
		btnQLTV.addActionListener(this);
		
		setResizable(false);
		setVisible(true);
	}
	public static void main(String[] args) {
		GiaoDien3Nut huy = new GiaoDien3Nut();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnQLNK)
		{
			QuanLyNhanKhau tmp = new QuanLyNhanKhau();
		}
			
	}
}
