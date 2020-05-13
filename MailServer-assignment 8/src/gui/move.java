package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import dataStructure.DLinkedList;
import dataStructure.singleLinkedList;
import mainCode.App;
import mainCode.Contact;
import mainCode.Folder;
import mainCode.IMail;
import mainCode.email;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.Toolkit;
public class move extends JFrame {
	
	move(IMail[] m,int p,String dir2,String x,Contact c){
		this.mail=(email[]) m;

	this.dir=dir2;
	this.page=p;
	this.x=x;
	this.c=c;
	intialize();

}
	  DefaultListModel m=new DefaultListModel();
	  private String folder;
	private singleLinkedList f;
		private String dir;
	  private String x;
		private JPanel contentPane;
	private JCheckBox c10;
	private JCheckBox c9;
	private JCheckBox c8;
	private JCheckBox c7;
	private JCheckBox c6;
	private JCheckBox c5;
	private JCheckBox c1;
	private JCheckBox c2;
	private JCheckBox c3;
	private JCheckBox c4;
    public boolean o1=false;
    public boolean o2=false;
    public boolean o3=false;
    public boolean o4=false;
    public boolean o5=false;
    public boolean o6=false;
    public boolean o7=false;
    public boolean o8=false;
    public boolean o9=false;
    public boolean o10=false;
    public boolean delete=false;
    public email mail[];
private Contact c;
    public int page=1 ;
	public DLinkedList l=new DLinkedList();
	private JList list;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					move frame = new move();
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
	public move() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(move.class.getResource("/resources/icons8-important-mail-64.png")));
	
	intialize();
	}

	private void setText(int page2) {
      c1.setText(String.valueOf(10*(page-1)+1));		
      c2.setText(String.valueOf(10*(page-1)+2));		
      c3.setText(String.valueOf(10*(page-1)+3));		
      c4.setText(String.valueOf(10*(page-1)+4));		
      c5.setText(String.valueOf(10*(page-1)+5));		
      c6.setText(String.valueOf(10*(page-1)+6));		
      c7.setText(String.valueOf(10*(page-1)+7));		
      c8.setText(String.valueOf(10*(page-1)+8));		
      c9.setText(String.valueOf(10*(page-1)+9));		
      c10.setText(String.valueOf(10*(page-1)+10));		
	}

	private void intialize() {
	

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 346, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		c1 = new JCheckBox("1");
		c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(c1.isSelected()) {
				o1=true;
			}
			else {
				o1=false;
			}
			}
		});
		c1.setFont(new Font("Elephant", Font.BOLD, 17));
		c1.setBounds(19, 66, 99, 39);
		contentPane.add(c1);
		
		c2 = new JCheckBox("2\r\n");
		c2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(c2.isSelected()) {
				o2=true;
			}
			else {
				o2=false;
			}
			}
		});
		c2.setFont(new Font("Elephant", Font.BOLD, 17));
		c2.setBounds(19, 110, 99, 39);
		c2.setText("ddd");
		contentPane.add(c2);
		
		c3 = new JCheckBox("3");
		c3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(c3.isSelected()) {
				o3=true;
			}
			else {
				o3=false;
			}
			}
		});
		c3.setFont(new Font("Elephant", Font.BOLD, 17));
		c3.setBounds(19, 151, 99, 39);
		contentPane.add(c3);
		
		c4 = new JCheckBox("4");
		c4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(c4.isSelected()) {
				o4=true;
			}
			else {
				o4=false;
			}
			}
		});
		c4.setFont(new Font("Elephant", Font.BOLD, 17));
		c4.setBounds(19, 192, 99, 39);
		contentPane.add(c4);
		
		c5 = new JCheckBox("5");
		c5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(c5.isSelected()) {
				o5=true;
			}
			else {
				o5=false;
			}
			}
		});
		c5.setFont(new Font("Elephant", Font.BOLD, 17));
		c5.setBounds(120, 66, 99, 39);
		contentPane.add(c5);
		
		c6 = new JCheckBox("6");
		c6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(c6.isSelected()) {
				o6=true;
			}
			else {
				o6=false;
			}
			}
		});
		c6.setFont(new Font("Elephant", Font.BOLD, 17));
		c6.setBounds(120, 110, 99, 39);
		contentPane.add(c6);
		
		c7 = new JCheckBox("7");
		c7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(c7.isSelected()) {
				o7=true;
			}
			else {
				o7=false;
			}
			}
		});
		c7.setFont(new Font("Elephant", Font.BOLD, 17));
		c7.setBounds(120, 151, 99, 39);
		contentPane.add(c7);
		
		c8 = new JCheckBox("8");
		c8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(c8.isSelected()) {
				o8=true;
			}
			else {
				o8=false;
			}
			}
		});
		c8.setFont(new Font("Elephant", Font.BOLD, 17));
		c8.setBounds(120, 192, 91, 31);
		contentPane.add(c8);
		
		c9 = new JCheckBox("9");
		c9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(c9.isSelected()) {
				o9=true;
			}
			else {
				o9=false;
			}
			}
		});
		c9.setFont(new Font("Elephant", Font.BOLD, 17));
		c9.setBounds(219, 66, 99, 39);
		contentPane.add(c9);
		 //setText(page);

		JLabel lblNewLabel = new JLabel("check the number of email you want to move:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 10, 256, 55);
		contentPane.add(lblNewLabel);
		
		c10 = new JCheckBox("10\r\n");
		c10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(c10.isSelected()) {
				o10=true;
			}
			else {
				o10=false;
			}
			}
		});
		c10.setFont(new Font("Elephant", Font.BOLD, 17));
		c10.setBounds(219, 110, 99, 39);
		contentPane.add(c10);
		
		JLabel lblNewLabel_1 = new JLabel("select the folder to move emails to:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(10, 231, 256, 31);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 272, 256, 129);
		contentPane.add(scrollPane);
		
		list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		 list.setModel(m); 
		 m.add(0, "inbox");
		 m.add(1, "sent");
		 m.add(2, "drafts");
		 m.add(3, "trash");
		 for(int i=0; i<c.folders.size(); i++) {
			 m.add(i+4, c.folders.get(i));
		 }

		JButton btnNewButton = new JButton("move");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				singleLinkedList l=new singleLinkedList();
				if(o1 && mail[0]!=null){
					System.out.println(x+"22222");
				//	System.out.println(o1);
                    if(mail[0]!=null) {
					mail[0].dir=dir;}
				     if(x.equalsIgnoreCase("sent")) {mail[0].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[0].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[0].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[0].inbox=true;}
				     else {System.out.println(x);
				    	 mail[0].folder=x;}
				     l.add(mail[0]);
//				     System.out.println(mail[0].folder);

				}
				if(o2&& mail[1]!=null) {
					 if(mail!=null) {
							mail[1].dir=dir;}			
					 if(x.equalsIgnoreCase("sent")) {mail[1].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[1].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[1].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[1].inbox=true;}
				     else {mail[1].folder=x;}

				     l.add(mail[1]);
					
				}
				if(o3&& mail[2]!=null) {
					 if(mail!=null) {
							mail[2].dir=dir;}
				    if(x.equalsIgnoreCase("sent")) {mail[2].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[2].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[2].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[2].inbox=true;}
				     else {mail[2].folder=x;}

				    l.add(mail[2]);
					
				}
				if(o4&& mail[3]!=null) {
					 if(mail!=null) {
							mail[3].dir=dir;}
				    if(x.equalsIgnoreCase("sent")) {mail[3].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[3].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[3].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[3].inbox=true;}
				     else {mail[3].folder=x;}

				    l.add(mail[3]);
					
				}
				if(o5&& mail[4]!=null) {
					 if(mail!=null) {
							mail[4].dir=dir;}
				    if(x.equalsIgnoreCase("sent")) {mail[4].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[4].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[4].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[4].inbox=true;}
				     else {mail[4].folder=x;}

				    l.add(mail[4]);
					
				}
				if(o6&& mail[5]!=null) {
					 if(mail!=null) {
							mail[5].dir=dir;}
				    if(x.equalsIgnoreCase("sent")) {mail[5].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[5].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[5].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[5].inbox=true;}
				     else {mail[5].folder=x;}

				    l.add(mail[5]);
					
				}
				if(o7&& mail[6]!=null) {
					 if(mail!=null) {
							mail[6].dir=dir;}
				    if(x.equalsIgnoreCase("sent")) {mail[6].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[6].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[6].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[6].inbox=true;}
				     else {mail[6].folder=x;}

				    l.add(mail[6]);
					
				}
				if(o8&& mail[7]!=null) {
					 if(mail!=null) {
							mail[7].dir=dir;}
				    if(x.equalsIgnoreCase("sent")) {mail[7].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[7].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[7].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[7].inbox=true;}
				     else {mail[7].folder=x;}

				    l.add(mail[7]);
					
				}
				if(o9&& mail[8]!=null) {
					 if(mail!=null) {
							mail[8].dir=dir;}
				    if(x.equalsIgnoreCase("sent")) {mail[8].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[8].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[8].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[8].inbox=true;}
				     else {mail[8].folder=x;}

				    l.add(mail[8]);
					
				}
				if(o10&& mail[9]!=null) {
					 if(mail!=null) {
							mail[9].dir=dir;}
				    if(x.equalsIgnoreCase("sent")) {mail[9].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[9].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[9].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[9].inbox=true;}
				     else {mail[9].folder=x;}
                      
				    l.add(mail[9]);
					
				}
				
 if(!l.isEmpty() || list.getSelectedIndex()!=-1) {
			   App a2 =new App();
				Folder f= new Folder();
				f.des=dir+list.getSelectedValue().toString();
			a2.moveEmails(l, f);
			
			}}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(183, 419, 121, 31);
		contentPane.add(btnNewButton);
	
      //	c1.get
 	
		 setText(page);
	}
}
