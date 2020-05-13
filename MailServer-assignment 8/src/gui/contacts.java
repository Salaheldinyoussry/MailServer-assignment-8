package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.border.MatteBorder;

import dataStructure.singleLinkedList;
import mainCode.Contact;
import mainCode.contactManipulation;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class contacts extends JFrame {
	  DefaultListModel m=new DefaultListModel();
	  DefaultListModel m1=new DefaultListModel();
    private singleLinkedList l =new singleLinkedList();
	private JPanel contentPane;
	private JTextField text;
	private JTextField text1;
	private singleLinkedList c ;
	private String user;
	private JList list;
	private JList list1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					contacts frame = new contacts();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */
	public contacts(String user) {
		this.user=user;
		intialize();
	
	}
	public contacts() {
		intialize();
	
	}
	
	

	private void intialize() {
		
		loadcont();
		
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 393, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);	
		contentPane.setLayout(null);
		
		list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
			String x=(String) list.getSelectedValue();

			m1.clear();
			for(int i=0; i<c.size(); i++) {
				if(((Contact)c.get(i)).name.equalsIgnoreCase(x)) {
					for(int j=0 ; j<((Contact)c.get(i)).emails.size(); j++) {
						
						list1.setModel(m1);
						m1.add(j, ((Contact)c.get(i)).emails.get(j));
					}
				}
			}
			}
		});
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(10, 59, 163, 145);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel("Add contact:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(10, 359, 163, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("name:\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 402, 66, 24);
		contentPane.add(lblNewLabel_1);
		
		text = new JTextField();
		text.setBounds(74, 402, 217, 29);
		contentPane.add(text);
		text.setColumns(10);
		
		JLabel lblEmails = new JLabel("emails :");
		lblEmails.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmails.setBounds(20, 459, 66, 24);
		contentPane.add(lblEmails);
		
		text1 = new JTextField();
		text1.setColumns(10);
		text1.setBounds(74, 459, 217, 29);
		contentPane.add(text1);
		
		JButton btnNewButton = new JButton("+\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			l.add(text1.getText());
			text1.setText("");
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setBounds(301, 457, 43, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel model = (DefaultListModel) list.getModel();
				int selectedIndex = list.getSelectedIndex();
				String name=(String) list.getSelectedValue();
				if (selectedIndex != -1) {
				    model.remove(selectedIndex);
				    contactManipulation cm =new contactManipulation();
				   Contact uc =new Contact();
				   uc.name=name;
				   for(int i=0; i<c.size(); i++) {
					   if(((Contact)c.get(i)).name.equalsIgnoreCase(name)) {
						   for(int j=0; j<((Contact)c.get(i)).emails.size(); j++) {
							   uc.emails.add(((Contact)c.get(i)).emails.get(j));
						   }
					   }
				   }
				    
				    try {
						cm.deleteContact(uc, user);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_1.setBounds(10, 301, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnEdit = new JButton("edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int x=list.getSelectedIndex();
		 String [] ca =new String[50];
			if(x!=-1) {
				String h=(String) list.getSelectedValue();
				for(int i=0; i<c.size(); i++) {
					if(((Contact)c.get(i)).name==h) {
						for(int j=0 ; j<((Contact)c.get(i)).emails.size(); j++) {
							ca[j]=(String) ((Contact)c.get(i)).emails.get(j);
						}
						break;
					}
				}
				System.out.println(h);
				contactEditing ce =new contactEditing(ca,user,h);
		        ce.setVisible(true);
		        m1.clear();
				m.clear();
		        loadcont();
				
				addCont();
				
				
			}
			}
		});
		btnEdit.setForeground(Color.RED);
		btnEdit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnEdit.setBounds(117, 301, 85, 21);
		contentPane.add(btnEdit);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Contact ic =new Contact();
			ic.name=text.getText();
			l.add(text1.getText());
			ic.emails=l;
			 contactManipulation cm =new contactManipulation();
			 cm.addContact(ic, user);
			 m.clear();
			 loadcont();
			 addCont();
			 m1.clear();
			
			}
		});
		btnAdd.setForeground(Color.RED);
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnAdd.setBounds(259, 569, 85, 21);
		contentPane.add(btnAdd);
		
		JLabel lblContactList = new JLabel("contacts list:");
		lblContactList.setForeground(Color.RED);
		lblContactList.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblContactList.setBounds(10, 10, 163, 33);
		contentPane.add(lblContactList);
		
		JLabel lblSelectContactFrom = new JLabel("select contact from the list to edit or delete:");
		lblSelectContactFrom.setForeground(Color.RED);
		lblSelectContactFrom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelectContactFrom.setBounds(10, 258, 264, 33);
		contentPane.add(lblSelectContactFrom);
		
		list1 = new JList();
		list1.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list1.setBounds(204, 59, 163, 145);
		contentPane.add(list1);
		
		JLabel lblContactEmails = new JLabel("contact emails");
		lblContactEmails.setForeground(Color.RED);
		lblContactEmails.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblContactEmails.setBounds(204, 10, 163, 33);
		contentPane.add(lblContactEmails);
		
		JLabel lblSelectContactFrom_1 = new JLabel("select contact from the list to view it's emails");
		lblSelectContactFrom_1.setForeground(Color.RED);
		lblSelectContactFrom_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelectContactFrom_1.setBounds(10, 214, 264, 33);
		contentPane.add(lblSelectContactFrom_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton_2.setBounds(42, 556, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnRefresh = new JButton("refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.clear();
               m1.clear();
				loadcont();
			addCont();
			}
		});
		btnRefresh.setForeground(Color.RED);
		btnRefresh.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnRefresh.setBounds(245, 301, 85, 21);
		contentPane.add(btnRefresh);
	addCont();
	}

	private void addCont() {
    list.setModel(m);
    for(int i=0; i<c.size(); i++) {
    	m.add(i, ((Contact)c.get(i)).name);
    }
    
	}

	private void loadcont() {
   contactManipulation cm =new contactManipulation();
   cm.loadContacts(user);
   this.c=cm.userContacts;
	}
}
