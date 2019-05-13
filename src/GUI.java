import java.util.*;
import javax.swing.*;
import java.awt.*;
public class GUI extends JFrame{
	JLabel lbName,lbPhone,lbCity,lbGender;
	JTextField txtName,txtPhone;
	String[] nation = new String[] {"", "Ho Chi Minh","Da Nang","Ha Noi"};
	JComboBox<String> cityList; 
	String[] gender = new String[] {"Male","Female"};
	JComboBox<String> genderList;
	public GUI()
	{
		//1. Initialization
		super("Human Management");
		setLocation(500, 300);
		setSize(new Dimension(500,500));
		setLayout(null);
		
		lbName = new JLabel("Name");
		lbName.setBounds(50,100,50,20);
		add(lbName);
		
		txtName = new JTextField();
		txtName.setBounds(100,100,250,20);
		add(txtName);
		
		lbCity = new JLabel("City");
		lbCity.setBounds(50,140,50,20);
		add(lbCity);
		
		cityList = new JComboBox<>(nation);
		cityList.setBounds(100,140,100,20);
		add(cityList);
		
		lbGender = new JLabel("Gender");
		lbGender.setBounds(220,140,50,20);
		add(lbGender);
		
		genderList = new JComboBox<>(gender);
		genderList.setBounds(270,140,80,20);
		add(genderList);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		GUI huy = new GUI();
	}

}
