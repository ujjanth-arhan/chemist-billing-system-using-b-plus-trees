import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;

public class Inventory extends JFrame {

	private JPanel contentPane;
	static String[] records;

	/**
	 * Launch the application.
	 */
	static BPlusTrees obj = new BPlusTrees();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventory frame = new Inventory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public Inventory() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 434, 491);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		obj.show();//needed!
		records = new String[obj.records.length];
		for(int i = 0;i < obj.records.length;i++) {
			records[i] = obj.records[i];
			System.out.println(records[i]);
		}
		
		int numberoffields = 5;
		String words[] = new String[numberoffields];
		String[] columnNames = {"ID","Medicine Name","Stock","Date","Company"};
		Object[][] data = new String[records.length][numberoffields];
		for(int k = 0; k < records.length;k++) {
			words = records[k].split("\\|");
			for(int j = 0; j < numberoffields; j++) {
				data[k][j] = new String(words[j]);
				System.out.println(data[k][j]+"\t");
			}
		}
		JTable myTable = new JTable(data,columnNames);
		myTable.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(myTable);
		scrollPane.setBounds(10, 11, 398, 430);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane);
		
	}
}