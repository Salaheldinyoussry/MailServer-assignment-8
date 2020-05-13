package gui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dataStructure.LQueue;
import dataStructure.singleLinkedList;
import mainCode.App;
import mainCode.Contact;
import mainCode.Filter;
import mainCode.Folder;
import mainCode.IFolder;
import mainCode.IMail;
import mainCode.Sort;
import mainCode.email;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JDesktopPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.border.TitledBorder;
import javax.swing.JSplitPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Toolkit;

public class mainFrame extends JFrame {

	mainFrame(String x,Contact cn,String pass){
		this.user=x;
		intialize();
		lblNewLabel.setText(x);
		c=cn;

	}
	
	  DefaultListModel m=new DefaultListModel();
	  DefaultListModel m1=new DefaultListModel();
	  DefaultListModel m2=new DefaultListModel();
	   private singleLinkedList folders=new singleLinkedList();

	  public String user;
	public Contact c ;
	private JPanel contentPane;
	private JTable table;
    private int page=1;
	private email mail[]=new email[10];
	private JTextField filter;
	private JTable table_1;
	private String dir="C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+user+"\\inbox";
	private String dir2="C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+user+"\\";
	private String x="inbox";
	
	private singleLinkedList userFolders=new singleLinkedList();
	private JComboBox comboBox_2;
	private JComboBox comboBox_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_4;
	private JLabel lblNewLabel;
	private JList list;
  ///////////////////
	private String edate;
	private String esubject;
	//////////////////////
	private email e =new email() ;
	private JTextArea textArea;
	private JLabel lblNewLabel_5;
	private JList list2;
	private JTextField priority;
	private JComboBox comboBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
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
	public mainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(mainFrame.class.getResource("/resources/icons8-important-mail-64.png")));
	 intialize();
	}

	private void setEmailPage() {
   int j=0;
	if(mail!=null) {
   for(int i=0; i<mail.length; i++) {
		email e= (email) mail[i];
	 if(e!=null) {
		table.setValueAt(e.subject+"___"+e.date, i, 0);
        j++;
	 }}}
    while(j<9) {
		table.setValueAt("", j, 0);
    	j++;
    }
	}


	private void setTableIndex() {
		for(int i=0; i<10; i++) {
			
			table_1.setValueAt((page-1)*10+i+1, i, 0);
			 
		
		}
	
	}
	
	private void events() {
		// TODO Auto-generated method stub
	table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			  int index =table.getSelectedRow();
			  //TableModel model =table.getModel();

			  //String st=model.getValueAt(0, 0).toString();
			 // JOptionPane.showMessageDialog(null, "play");
              
			  setEmailPage();
			  setTableIndex();
			  if(index>-1) {
				if(mail==null || mail[index]==null) {
					textField.setText("");
					textField_2.setText("");
					textField_4.setText("");
					textArea.setText("");
					priority.setText("");
					m.clear();
                      m2.clear();
				}else {
				  m.clear();
					m2.clear();
				  lblNewLabel_5.setText(""); 
				  
				  email em =(email) mail[index];
			if(!em.subject.equalsIgnoreCase("null")) {
				  textField.setText(em.subject);}
			
			textField_2.setText(em.sender);
			textField_4.setText(em.date);
			textArea.setText(em.body);
			priority.setText(Integer.toString(em.priority));
			edate=em.date;
			esubject=em.subject;
			 list.setModel(m); 
			 list2.setModel(m2);
		    for(int i=0; i<em.attachments.size(); i++) {
		          if(!((String) em.attachments.get(i)).equalsIgnoreCase("null")){

		    	m.add(i, em.attachments.get(i));
		          }
		          }
		    LQueue q1 =new LQueue();
		    LQueue q2 =new LQueue();

		    for(int i=0; i<em.receivers.size(); i++) {
		        q1.enqueue(em.receivers.dequeue());
		    }
		    for(int i=0; i<q1.size(); i++) {
          Object o =new Object();
          o=q1.dequeue();
          em.receivers.enqueue(o);
         if(!((String)o).equalsIgnoreCase(null)){
          m2.add(i,(String) o);}
		   }    
			}}
			
			}
		});	
	}

	private void intialize() {
App a0=new App();
a0.signin(user, "salah");
c=a0.c;
	
		dir="C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+user+"\\inbox";
		dir2="C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+user+"\\";
		//	userFolders
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(17, 20, 1516, 767);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			deleteFrame d =new deleteFrame(mail,page,dir2,x);
			
			d.setVisible(true);
		   
			App a=new App();
			Filter filt =new Filter();
			Sort ss =new Sort();
			
		filt.st=filter.getText();
		Folder ff=new Folder ();
		ff.des=dir;
				
			ss.choice=(String) comboBox_1.getSelectedItem();
				
				
					a.setViewingOptions(ff, null, ss);
				
				mail=(email[]) a.listEmails(page);
				   int i=0;
			        while(mail[i]!=null) {
			        	mail[i].dir=dir2;
			        	if(x.equalsIgnoreCase("trash")) {
			        		mail[i].trash=true;
			        	}
			        	else if(x.equalsIgnoreCase("inbox")) {
			        		mail[i].inbox=true;
			        	}else if(x.equalsIgnoreCase("drafts")) {
			        		mail[i].drafts=true;
			        	}else if(x.equalsIgnoreCase("sent")) {
			        		mail[i].sent=true;
			        	}	
			        i++;
			        }
				setTableIndex();

				setEmailPage( );
				setTableIndex();
		
			}
			

		});
		comboBox_2 = new JComboBox();
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			
				Filter filt =new Filter();
				Sort ss =new Sort();
				
				App a =new App();
			filt.st=filter.getText();
			Folder ff=new Folder ();
			ff.des=dir;
			if(e.getSource()==comboBox_1) {
					
				ss.choice=(String) comboBox_1.getSelectedItem();
						a.setViewingOptions(ff, null, ss);
						
					
					mail=(email[]) a.listEmails(page);
					   int i=0;
				        while(mail[i]!=null) {
				        	mail[i].dir=dir2;
				        	if(x.equalsIgnoreCase("trash")) {
				        		mail[i].trash=true;
				        	}
				        	else if(x.equalsIgnoreCase("inbox")) {
				        		mail[i].inbox=true;
				        	}else if(x.equalsIgnoreCase("drafts")) {
				        		mail[i].drafts=true;
				        	}else if(x.equalsIgnoreCase("sent")) {
				        		mail[i].sent=true;
				        	}	
				        i++;
				        }
					setTableIndex();

					setEmailPage( );
					setTableIndex();
				}
			}
		});

JLabel label_6 = new JLabel("New label");
label_6.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) 
	{  			

		App a=new App();
		IMail[] m =new IMail[10];
		
		m=a.listEmails(page+1);
		if(m!=null && m[0]!=null) {
			mail=(email[]) m;
			   int i=0;
		        while(mail[i]!=null) {
		        	mail[i].dir=dir2;
		        	if(x.equalsIgnoreCase("trash")) {
		        		mail[i].trash=true;
		        	}
		        	else if(x.equalsIgnoreCase("inbox")) {
		        		mail[i].inbox=true;
		        	}else if(x.equalsIgnoreCase("drafts")) {
		        		mail[i].drafts=true;
		        	}else if(x.equalsIgnoreCase("sent")) {
		        		mail[i].sent=true;
		        	}	
		        i++;
		        } 
			page++;
			  setTableIndex();

			setEmailPage();
			setTableIndex();
		}
		
	}
});

JButton btnNewButton_2 = new JButton("");
btnNewButton_2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	App a=new App();
	Sort ss =new Sort();
	Filter filt =new Filter();
	Folder ff=new Folder();
	ff.des=dir;
	
	ss.choice=(String) comboBox_1.getSelectedItem();
		a.setViewingOptions(ff, null, ss);
		
	
	
	mail=(email[]) a.listEmails(page);
	   int i=0;
       while(mail[i]!=null) {
       	mail[i].dir=dir2;
       	if(x.equalsIgnoreCase("trash")) {
       		mail[i].trash=true;
       	}
       	else if(x.equalsIgnoreCase("inbox")) {
       		mail[i].inbox=true;
       	}else if(x.equalsIgnoreCase("drafts")) {
       		mail[i].drafts=true;
       	}else if(x.equalsIgnoreCase("sent")) {
       		mail[i].sent=true;
       	}	
       i++;
       } 
	setTableIndex();

	setEmailPage( );
	setTableIndex();	
	}
});

JButton btnFilter = new JButton("filter");
btnFilter.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	Sort s=new Sort();
		s.choice=(String) comboBox_1.getSelectedItem();
if(filter.getText()!="") {
	int j=0;
	while(mail[j]!=null) {
	    if(x.equalsIgnoreCase("sent")) {mail[j].sent=true;}
	     else if(x.equalsIgnoreCase("drafts")) {mail[j].drafts=true;}
	     else if(x.equalsIgnoreCase("trash")) {mail[j].trash=true;}
	     else if(x.equalsIgnoreCase("inbox")) {mail[j].inbox=true;}
	     else {mail[j].folder=x;}
		j++;	
	}
	
	
	Filter f=new Filter();
	f.choice=(String) comboBox_2.getSelectedItem();
  if(f.choice.equalsIgnoreCase("priority")) {
	  f.prio=Integer.parseInt(filter.getText());
  }else {
	f.st=filter.getText();
  }
	App a=new App ();
Folder ff=new Folder();
ff.des=dir;
a.setViewingOptions(ff, f, s);

mail=(email[]) a.listEmails(page);
setEmailPage();
}
	
	}
});

JButton btnContacts = new JButton("contacts");
btnContacts.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	contacts ccc =new contacts(user);
	ccc.setVisible(true);
	}
});
btnContacts.setFont(new Font("SansSerif", Font.PLAIN, 20));
btnContacts.setBounds(189, 530, 159, 43);
contentPane.add(btnContacts);
btnFilter.setFont(new Font("Tahoma", Font.PLAIN, 26));
btnFilter.setBounds(101, 412, 159, 43);
contentPane.add(btnFilter);

priority = new JTextField();
priority.setFont(new Font("Tahoma", Font.PLAIN, 18));
priority.setColumns(10);
priority.setBounds(1228, 63, 52, 30);
contentPane.add(priority);

JLabel lblPriority = new JLabel("priority:");
lblPriority.setForeground(Color.WHITE);
lblPriority.setFont(new Font("Tahoma", Font.BOLD, 19));
lblPriority.setBounds(1134, 62, 99, 30);
contentPane.add(lblPriority);

JLabel lblRecievers = new JLabel("recievers:");
lblRecievers.setForeground(Color.WHITE);
lblRecievers.setFont(new Font("Tahoma", Font.BOLD, 19));
lblRecievers.setBounds(1124, 238, 99, 30);
contentPane.add(lblRecievers);
JScrollPane scrollPane_3 = new JScrollPane();
scrollPane_3.setBounds(1222, 239, 270, 80);
contentPane.add(scrollPane_3);

list2 = new JList();
scrollPane_3.setViewportView(list2);
JButton btnNewButton_3 = new JButton("folders");
btnNewButton_3.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	folder ff=new folder(c);
	ff.setVisible(true);

	App a22 =new App();
	a22.signin(c.email, c.password);
	c=a22.c;
	}
});
btnNewButton_3.setFont(new Font("SansSerif", Font.PLAIN, 20));
btnNewButton_3.setBounds(0, 530, 159, 43);
contentPane.add(btnNewButton_3);

JButton btnMove = new JButton("move");
btnMove.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	
	//	System.out.println(c.folders.get(0));
		//move(IMail[] m,int p,String dir2,String x){
		move mo =new move(mail,page,dir2,x,c);
	System.out.println(x);
		mo.setVisible(true);
	
	 
	App a=new App();
	Filter filt =new Filter();
	Sort ss =new Sort();
	
filt.st=filter.getText();
Folder ff=new Folder ();
ff.des=dir;
		
	ss.choice=(String) comboBox_1.getSelectedItem();
		
			a.setViewingOptions(ff, null, ss);
			
		
		mail=(email[]) a.listEmails(page);
		   int i=0;
	        while(mail[i]!=null) {
	        	mail[i].dir=dir2;
	        	if(x.equalsIgnoreCase("trash")) {
	        		mail[i].trash=true;
	        	}
	        	else if(x.equalsIgnoreCase("inbox")) {
	        		mail[i].inbox=true;
	        	}else if(x.equalsIgnoreCase("drafts")) {
	        		mail[i].drafts=true;
	        	}else if(x.equalsIgnoreCase("sent")) {
	        		mail[i].sent=true;
	        	}	
	        i++;
	        } 
		setTableIndex();

		setEmailPage( );
		setTableIndex();

	
	
	}
});
btnMove.setFont(new Font("Tahoma", Font.PLAIN, 26));
btnMove.setBounds(189, 483, 159, 43);
contentPane.add(btnMove);
btnNewButton_2.setIcon(new ImageIcon(mainFrame.class.getResource("/resources/icons8-refresh-80.png")));
btnNewButton_2.setBounds(230, 127, 132, 80);
contentPane.add(btnNewButton_2);

lblNewLabel_5 = new JLabel("No Email is selected click on the email on the table to view !!");
lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 21));
lblNewLabel_5.setForeground(Color.RED);
lblNewLabel_5.setBounds(860, 20, 586, 59);
contentPane.add(lblNewLabel_5);
label_6.setIcon(new ImageIcon(mainFrame.class.getResource("/resources/icons8-green-arrow-144.png")));
label_6.setBounds(218, 620, 144, 104);
contentPane.add(label_6);

JLabel lblNewLabel_3 = new JLabel("New label");
lblNewLabel_3.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
	if(page>1) {
		App a =new App();
	IMail [] m =new IMail[10];
	mail=(email[]) a.listEmails(page-1);
	   int i=0;
       while(mail[i]!=null) {
       	mail[i].dir=dir2;
       	if(x.equalsIgnoreCase("trash")) {
       		mail[i].trash=true;
       	}
       	else if(x.equalsIgnoreCase("inbox")) {
       		mail[i].inbox=true;
       	}else if(x.equalsIgnoreCase("drafts")) {
       		mail[i].drafts=true;
       	}else if(x.equalsIgnoreCase("sent")) {
       		mail[i].sent=true;
       	}	
       i++;
       }
	page--;
	  setTableIndex();

	setEmailPage();
	setTableIndex();
	
	}
	}
});
lblNewLabel_3.setIcon(new ImageIcon(mainFrame.class.getResource("/resources/w.png")));
lblNewLabel_3.setBounds(15, 626, 144, 104);
contentPane.add(lblNewLabel_3);
JScrollPane scrollPane_2 = new JScrollPane();
scrollPane_2.setBounds(875, 573, 304, 109);
contentPane.add(scrollPane_2);

list = new JList();
list.addListSelectionListener(new ListSelectionListener() {
	public void valueChanged(ListSelectionEvent e) {
		//DefaultListModel model = (DefaultListModel) list.getModel();
		int selectedIndex = list.getSelectedIndex();
		if (selectedIndex != -1) {
		String x=(String)list.getSelectedValue();

		File f=new File(dir+"\\"+esubject+edate+"\\"+x);
		Desktop d =Desktop.getDesktop();
		try {
			d.open(f);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
	}
});
list.setFont(new Font("Tahoma", Font.PLAIN, 24));
list.setModel(new AbstractListModel() {
	String[] values = new String[] {};
	public int getSize() {
		return values.length;
	}
	public Object getElementAt(int index) {
		return values[index];
	}
});
scrollPane_2.setViewportView(list);

JPanel panel = new JPanel();
panel.setBounds(875, 570, 301, 116);
contentPane.add(panel);
panel.setLayout(null);

JList list_1 = new JList();
list_1.setBounds(1002, 589, 173, 102);
//		panel.add(new JScrollPane(list));

		JScrollPane scrollPane_1 = new JScrollPane(list_1);
		contentPane.add(scrollPane_1);

JLabel label_5 = new JLabel("~~~~~~~~~~~~~~~~~\r\n");
label_5.setForeground(Color.RED);
label_5.setFont(new Font("Tahoma", Font.PLAIN, 27));
label_5.setBounds(10, 63, 352, 22);
contentPane.add(label_5);

JLabel lblAttachmentList = new JLabel("attachment list:");
lblAttachmentList.setForeground(Color.WHITE);
lblAttachmentList.setFont(new Font("Tahoma", Font.BOLD, 19));
lblAttachmentList.setBounds(875, 530, 159, 30);
contentPane.add(lblAttachmentList);

JLabel lblMessage = new JLabel("message:");
lblMessage.setForeground(Color.WHITE);
lblMessage.setFont(new Font("Tahoma", Font.BOLD, 19));
lblMessage.setBounds(860, 287, 99, 30);
contentPane.add(lblMessage);

JLabel lblDate = new JLabel("date:");
lblDate.setForeground(Color.WHITE);
lblDate.setFont(new Font("Tahoma", Font.BOLD, 19));
lblDate.setBounds(1124, 196, 99, 30);
contentPane.add(lblDate);

JLabel lblFrom = new JLabel("from:");
lblFrom.setForeground(Color.WHITE);
lblFrom.setFont(new Font("Tahoma", Font.BOLD, 19));
lblFrom.setBounds(1124, 154, 99, 30);
contentPane.add(lblFrom);

JLabel lblNewLabel_1 = new JLabel("Subject:");
lblNewLabel_1.setForeground(Color.WHITE);
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
lblNewLabel_1.setBounds(1114, 99, 99, 30);
contentPane.add(lblNewLabel_1);

JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(875, 329, 617, 173);
contentPane.add(scrollPane);
textArea = new JTextArea();
textArea.setFont(new Font("Gabriola", Font.PLAIN, 24));
scrollPane.setViewportView(textArea);

textField_4 = new JTextField();
textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
textField_4.setColumns(10);
textField_4.setBounds(1225, 197, 269, 30);
contentPane.add(textField_4);

textField_2 = new JTextField();
textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
textField_2.setColumns(10);
textField_2.setBounds(1225, 150, 269, 30);
contentPane.add(textField_2);
textField = new JTextField();
textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
textField.setBounds(1223, 99, 269, 30);
contentPane.add(textField);
textField.setColumns(10);
comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"subject", "sender", "reciever", "body", "atachments", "date", "priority"}));
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setBounds(218, 320, 144, 35);
		contentPane.add(comboBox_2);
		
		JLabel lblFilterBy = new JLabel("filter by :");
		lblFilterBy.setForeground(Color.RED);
		lblFilterBy.setFont(new Font("Lucida Handwriting", Font.BOLD, 34));
		lblFilterBy.setBounds(0, 310, 194, 43);
		contentPane.add(lblFilterBy);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		table_1.setToolTipText("");
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setShowVerticalLines(false);
		table_1.setRowHeight(74);
		table_1.setForeground(Color.RED);
		table_1.setFont(new Font("Elephant", Font.BOLD | Font.ITALIC, 21));
		table_1.setEnabled(false);
		table_1.setBounds(379, 0, 46, 740);
		contentPane.add(table_1);
		
		JLabel label_2 = new JLabel("~~~~~~~~~~~~~~~~~\r\n");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 27));
		label_2.setBounds(10, 451, 352, 22);
		contentPane.add(label_2);
		
		filter = new JTextField();
		filter.setBounds(0, 365, 362, 35);
		contentPane.add(filter);
		filter.setColumns(10);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton_1.setBounds(0, 483, 159, 43);
		contentPane.add(btnNewButton_1);
		
		JLabel label_1 = new JLabel("~~~~~~~~~~~~~~~~~\r\n");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		label_1.setBounds(10, 219, 352, 22);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("~~~~~~~~~~~~~~~~~\r\n");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 27));
		label.setBounds(10, 288, 352, 22);
		contentPane.add(label);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		comboBox_1.addItemListener(new ItemListener() {
			//{"Date", "Priority", "Subject", "Sender", "Receiver"}));
			
					public void itemStateChanged(ItemEvent e) {
				Filter filt =new Filter();
				Sort ss =new Sort();
				
				App a =new App();
			filt.st=filter.getText();
			Folder ff=new Folder ();
			ff.des=dir;
			if(e.getSource()==comboBox_1) {
					
				ss.choice=(String) comboBox_1.getSelectedItem();
						a.setViewingOptions(ff, null, ss);
						
					
					
					mail=(email[]) a.listEmails(page);
					   int i=0;
				        while(mail[i]!=null) {
				        	mail[i].dir=dir2;
				        	if(x.equalsIgnoreCase("trash")) {
				        		mail[i].trash=true;
				        	}
				        	else if(x.equalsIgnoreCase("inbox")) {
				        		mail[i].inbox=true;
				        	}else if(x.equalsIgnoreCase("drafts")) {
				        		mail[i].drafts=true;
				        	}else if(x.equalsIgnoreCase("sent")) {
				        		mail[i].sent=true;
				        	}	
				        i++;
				        }   
					setTableIndex();

					setEmailPage( );
					setTableIndex();
				}

			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Date", "Priority", "Subject", "Sender", "Receiver", "attachments"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(168, 247, 194, 28);
		contentPane.add(comboBox_1);
		if(comboBox_1.getSelectedIndex()==0) {}
		JLabel lblNewLabel_2 = new JLabel("sort by :");
		lblNewLabel_2.setFont(new Font("Lucida Handwriting", Font.BOLD, 34));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(0, 238, 194, 43);
		contentPane.add(lblNewLabel_2);
		System.out.print(user);
		lblNewLabel = new JLabel(user);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Elephant", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(23, 20, 376, 43);
		//lblNewLabel.setText(user);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			if(e.getSource()==comboBox) {
				App a8 =new App();
                Folder f=new Folder();

				if(comboBox.getSelectedIndex()==0) {
                  f.des="C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+user+"\\inbox";
					x="inbox";
                 Sort ss=new Sort();
                 ss.choice="date";
					a8.setViewingOptions(f, null, ss);
			        mail=(email[]) a8.listEmails(page);
					  setTableIndex();

			        setEmailPage( );
			        setTableIndex();

			        dir=f.des;
				}
			
				else if(comboBox.getSelectedIndex()==1) {
				      f.des="C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+user+"\\sent";
						x="sent";
						 Sort ss=new Sort();
		                 ss.choice="date";
							a8.setViewingOptions(f, null, ss);
				        mail=(email[]) a8.listEmails(page);
						  setTableIndex();

				        setEmailPage( );
				        setTableIndex();

				        dir=f.des;

						}
			
				else if(comboBox.getSelectedIndex()==2) {
					 f.des="C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+user+"\\trash";
					 Sort ss=new Sort();
	                 ss.choice="date";
						a8.setViewingOptions(f, null, ss);	
				        mail=(email[]) a8.listEmails(page);
						  setTableIndex();
                         x="trash";
				        setEmailPage( );
				        setTableIndex();
		                   dir=f.des;

				}
				else if(comboBox.getSelectedIndex()==3) {
					 f.des="C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+user+"\\drafts";
					 Sort ss=new Sort();
	                 ss.choice="date";
						a8.setViewingOptions(f, null, ss);	
				        mail=(email[]) a8.listEmails(page);
				      
				        setTableIndex();
                          x="drafts";
				        setEmailPage( );
				        setTableIndex();

				        dir=f.des;

				}
				else {
					String h=(String) comboBox.getSelectedItem();
					 f.des="C:\\eclipseWorkspace\\MailServer-assignment 8\\src\\system\\"+user+"\\"+h;
					 Sort ss=new Sort();
	                 ss.choice="date";
						a8.setViewingOptions(f, null, ss);	
				        mail=(email[]) a8.listEmails(page);
				        x=h;
				        setTableIndex();
				        setEmailPage( );
				        setTableIndex();

				        dir=f.des;
					
				}
				   int i=0;
			        while(mail[i]!=null) {
			        	mail[i].dir=dir2;
			        	if(x.equalsIgnoreCase("trash")) {
			        		mail[i].trash=true;
			        	}
			        	else if(x.equalsIgnoreCase("inbox")) {
			        		mail[i].inbox=true;
			        	}else if(x.equalsIgnoreCase("drafts")) {
			        		mail[i].drafts=true;
			        	}else if(x.equalsIgnoreCase("sent")) {
			        		mail[i].sent=true;
			        	}	
			        i++;
			        }
				  
			}
			}

			
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"inbox", "sent", "trash", "drafts"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(10, 127, 208, 24);
		contentPane.add(comboBox);

		//	System.out.println(c.name);
	
		JButton btnNewButton = new JButton("compose\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			compose c=new compose(user);
			//c.user=user;
			c.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 177, 208, 30);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setForeground(Color.RED);
		table.setFont(new Font("Elephant", Font.BOLD | Font.ITALIC, 21));
		table.setSurrendersFocusOnKeystroke(true);
		table.setToolTipText("");
	//	table.setValueAt(2, 0, 0);
	
		table.setRowHeight(74);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"emails:"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(88);
		table.getColumnModel().getColumn(0).setMinWidth(88);
		table.setBounds(437, 0, 392, 767);
		
		events();

		
		
		contentPane.add(table);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_4.setIcon(new ImageIcon(mainFrame.class.getResource("/resources/cropped-1920-1200-336116.jpg")));
		lblNewLabel_4.setBounds(0, 0, 2002, 1200);
		contentPane.add(lblNewLabel_4);
		
		////////
		App a =new App();
		Folder f=new Folder();
		f.des=dir;
Sort s=new Sort();
s.choice="date";
a.setViewingOptions(f, null, s);
mail=(email[]) a.listEmails(page);
int i=0;
while(mail[i]!=null) {
	mail[i].dir=dir2;
	if(x.equalsIgnoreCase("trash")) {
		mail[i].trash=true;
	}
	else if(x.equalsIgnoreCase("inbox")) {
		mail[i].inbox=true;
	}else if(x.equalsIgnoreCase("drafts")) {
		mail[i].drafts=true;
	}else if(x.equalsIgnoreCase("sent")) {
		mail[i].sent=true;
	}	
i++;
}
setTableIndex();

setEmailPage();
setTableIndex();


////////////////////////

for(int j=0; j<c.folders.size(); j++) {
	comboBox.addItem(c.folders.get(j));
//contentPane.add(comboBox)
	;}
	   
	  			}
	private void setTableNo() {
		// TODO Auto-generated method stub
		
	}

	private void setTable() {
		// TODO Auto-generated method stub
		
	}
}

