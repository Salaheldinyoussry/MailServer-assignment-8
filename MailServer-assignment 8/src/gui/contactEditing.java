package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dataStructure.singleLinkedList;
import mainCode.Contact;
import mainCode.contactManipulation;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class contactEditing extends JFrame {
	public contactEditing(String[] emails,String user,String hh) {
		this.emails=emails;
		h=hh;
		this.user=user;
		intialize();
		}
  private  Contact c=new Contact();
    private String user;
	private JPanel contentPane;
	private JTextField txt;
	private JTextField txt1;
private String [] emails;
private String h;
private JList list;
DefaultListModel m=new DefaultListModel();

/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					contactEditing frame = new contactEditing();
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

	
	
	public contactEditing() {
		intialize();
	}
	private void intialize() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt = new JTextField();
		txt.setBounds(85, 24, 282, 29);
		contentPane.add(txt);
		txt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("name:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 22, 75, 29);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 140, 417, 102);
		contentPane.add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnNewButton = new JButton("delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel model = (DefaultListModel) list.getModel();
				int selectedIndex = list.getSelectedIndex();
				String sel =(String) list.getSelectedValue();
				if (selectedIndex != -1) {
				    model.remove(selectedIndex);
				}
				Contact old =c;
				int i;
				/*for(i =0 ; i<c.emails.size(); i++) {
					if(c.emails.get(i)==sel) {
						break;
					}
				}*/
				//c.emails.remove(i);
				Contact v =new Contact();
				for(i =0 ; i<c.emails.size(); i++) {
					if(c.emails.get(i)!=sel) {
						v.emails.add(c.emails.get(i));
					}}
					v.name=txt.getText();
				
				contactManipulation mc=new contactManipulation();
				try {
					mc.contactEdit(old, v, user);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(10, 311, 85, 29);
		contentPane.add(btnNewButton);
		
		txt1 = new JTextField();
		txt1.setColumns(10);
		txt1.setBounds(10, 408, 282, 29);
		contentPane.add(txt1);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(txt1.getText()!="") {
				int selectedIndex = list.getSelectedIndex();
				String sel =(String) list.getSelectedValue();
				list.setModel(m);
				int size=m.getSize();
				    m.add(size-1, txt1.getText());
				
				Contact old =c;
				Contact v =new Contact();
				for(int i =0 ; i<c.emails.size(); i++) {
						v.emails.add(c.emails.get(i));
					}
				v.emails.add(txt1.getText());
				v.name=txt.getText();
				contactManipulation mc=new contactManipulation();
				try {
					mc.contactEdit(old, v, user);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			txt1.setText("");
			}
			}
		});
		btnAdd.setForeground(Color.RED);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBounds(320, 408, 85, 29);
		contentPane.add(btnAdd);
		
		JLabel lblNewLabel_1 = new JLabel("emails list:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 110, 267, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("select email to delete:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(10, 258, 320, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblTypeTheEmail = new JLabel("type the email and press add to add it to the contact:");
		lblTypeTheEmail.setForeground(Color.RED);
		lblTypeTheEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTypeTheEmail.setBounds(10, 362, 320, 22);
		contentPane.add(lblTypeTheEmail);
	
		txt.setText(h);
      singleLinkedList ll =new singleLinkedList();
      int j=0;

      while(emails[j]!=null) {
    	   list.setModel(m);
    	   m.add(j, emails[j]);
    	  ll.add(emails[j]); 
   	   j++;

      }
       c.name=h;
       c.emails=ll;
       
	}
}
