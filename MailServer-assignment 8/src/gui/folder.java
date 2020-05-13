package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mainCode.Contact;
import mainCode.Folder;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class folder extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField1;
	private Contact c; 
	DefaultListModel m=new DefaultListModel();
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					folder frame = new folder();
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
	 folder(Contact c) {
		this.c=c;
		intialize();
	}
	 folder() {
		intialize();
		
	}

	private void intialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 566, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 74, 466, 183);
		contentPane.add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		textField = new JTextField();
		textField.setBounds(183, 282, 185, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("rename");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String x=(String) list.getSelectedValue();
			int i=list.getSelectedIndex(); 
			String y=textField.getText();
			 if(y!="") {
				 Folder f=new Folder();
				 f.renameDir(c, x, y);
			 }
			 list.setModel(m);
			 m.remove(i);
			 m.add(i, y);
			}
		});
		btnNewButton.setBounds(378, 282, 112, 24);
		contentPane.add(btnNewButton);
		
		textField1 = new JTextField();
		textField1.setColumns(10);
		textField1.setBounds(183, 349, 185, 26);
		contentPane.add(textField1);
		
		JLabel lblNewLabel = new JLabel("select the folder to rename:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(10, 282, 174, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblAddNewFolder = new JLabel("add new folder:");
		lblAddNewFolder.setForeground(Color.RED);
		lblAddNewFolder.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddNewFolder.setBounds(85, 347, 174, 26);
		contentPane.add(lblAddNewFolder);
		
		JButton btnAdd = new JButton("add\r\n");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Folder ff=new Folder();
		    String x=textField1.getText();
		    ff.createDir(x, c);
		    list.setModel(m);
		    int size=m.getSize();
		    m.add(size-1, x);
			}
		});
		btnAdd.setBounds(378, 351, 112, 24);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("delete\r\n");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel model = (DefaultListModel) list.getModel();
				int selectedIndex = list.getSelectedIndex();
				String x=(String) list.getSelectedValue();
				if (selectedIndex != -1) {
				    model.remove(selectedIndex);
				}
				Folder ff=new Folder();
				ff.deleteFile(x, c);
			}
		});
		
		
		
		btnDelete.setBounds(183, 410, 112, 24);
		contentPane.add(btnDelete);
		
		JLabel lblDeleteSelectedFolder = new JLabel("delete selected folder:");
		lblDeleteSelectedFolder.setForeground(Color.RED);
		lblDeleteSelectedFolder.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDeleteSelectedFolder.setBounds(33, 408, 174, 26);
		contentPane.add(lblDeleteSelectedFolder);
		
		JLabel lblNewLabel_1 = new JLabel("to delete or rename folder you must selected first from folder list:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(10, 10, 507, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Folder List:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2.setBounds(20, 42, 141, 26);
		contentPane.add(lblNewLabel_2);

		updateList();
//System.out.println(c.folders.get(0));
	}

	private void updateList() {
	    if(c.folders!=null) {
      int i=0;
	 while(c.folders.get(i)!=null) {
		list.setModel(m);
		m.add(i, c.folders.get(i));
	 i++;
	 }
	    
	    }		
	}
	
	
}
