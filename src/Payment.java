import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Payment extends JFrame {
	static int q[];

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment(q);
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
	public Payment(int q[]) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 487);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		int m = 1,n=0;
		int arr[] = new int[(int) Math.ceil(q.length/3)];
		int brr[] = new int[(int) Math.ceil(q.length/3)];
		int crr[] = new int[(int) Math.ceil(q.length/3)];
		for(int i = 0;i < q.length;i++) {
			if((i+1)%3==0) {
				System.out.println(q[i]);
			}
				
			else {
				System.out.print(q[i]+"\t");
				
			}
			if(i==m) {
				brr[n] = q[i];
				crr[n++]=q[i+1];
				m+=3;
			}
			
		}
			
		for(int z = 0; z < brr.length;z++)
			arr[z] = brr[z]*crr[z];
		
		Object[] columnNames = {"ID","Quantity","Price","Sub-total"};
		Object[][] data = new Object[(int) Math.ceil(q.length/3)][4];

		
		int row = 0;
		for(int i = 0; i < q.length;i+=3) {
			for(int j = 0; j < 3;j++) {
				if(i  == 0) {
					if(q[1]==0) 						
						break;			
					data[0][j] = q[i+j];
					data[0][3] = arr[0];
					
				}
					
				else {
					if(q[i+1]==0)
						break;
					data[row][j] = q[i+j];
					data[row][3] = arr[row];
				}
					
			}
			row++;
			 			
		}
		
//		row=0;
//		for(int i = 0; i < q.length;i+=3) {
//			int a = Integer.parseInt((String)data[row][1]);
//			int b = Integer.parseInt((String)data[row][2]);
//			data[row][3] = a*b;
//			row++;
//		}
			

		
		DefaultTableModel model = new DefaultTableModel(data,columnNames);
		JTable table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(450,63));
        table.setFillsViewportHeight(true);
        
        for (int i = table.getRowCount() - 1; i >= 0; i--) {
        	if(table.getModel().getValueAt(i, 0)==null)        	
        		model.removeRow(i);
        }
        
        File fmedicines = new File("medicines.txt");

        
//        try {
//        FileReader filer = new FileReader(fmedicines);
//		BufferedReader bufr = new BufferedReader(filer);
//		String lr = bufr.readLine();
//		String cont[] = new String[5];
//		int k = 0;
//		while (lr != null) {
//			cont[k] = lr.split("\\|")[0];
//			
//			lr = bufr.readLine();
//		}
//		System.out.println(q.length);
//		bufr.close();
//		
//			filer.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println("Reading failed");
//		}
        
        
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVisible(true);
		scrollPane.setBounds(10, 11, 381, 357);
		contentPane.add(scrollPane);

		btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(10, 379, 381, 58);
		contentPane.add(btnNewButton);
		

	}
}
