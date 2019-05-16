import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTable;

public class Table extends JFrame{
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(new Dimension(500,500));
		String col[] = { "Name", "Course", "Grade" };
		String data[][] = { col,{ "vinod", "BCA", "A" }, { "Raju", "MCA", "b" },
                { "Ranjan", "MBA", "c" }, { "Rinku", "BCA", "d" } };

        
        JTable table = new JTable(data, col);
        table.setLocation(25,343);
        frame.add(table, BorderLayout.CENTER);
        frame.setVisible(true);
	}
}
