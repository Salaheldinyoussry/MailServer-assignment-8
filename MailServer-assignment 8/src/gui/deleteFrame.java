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
import mainCode.IMail;
import mainCode.email;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
public class deleteFrame extends JFrame {
	deleteFrame(IMail[] m,int p,String dir2,String x){
			this.mail=(email[]) m;
	
		this.dir=dir2;
		this.page=p;
		this.x=x;
		intialize();

	}
		
		
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
    public String dir;
    String x;
    public int page=1 ;
	public singleLinkedList l=new singleLinkedList();
	private JButton btnNewButton;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteFrame frame = new deleteFrame();
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
	public deleteFrame() {
	
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
		setBounds(100, 100, 290, 294);
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

		JLabel lblNewLabel = new JLabel("check the number of email you want to delete :");
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
		
		btnNewButton = new JButton("delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				singleLinkedList l=new singleLinkedList();
				
				if(o1) {
					//System.out.println(x);
				//	System.out.println(o1);

					mail[0].dir=dir;
					System.out.println(dir);
				     if(x.equalsIgnoreCase("sent")) {mail[0].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[0].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[0].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[0].inbox=true;}
					 	l.add(mail[0]);

				}
				if(o2) {
				    mail[1].dir=dir;
				     if(x.equalsIgnoreCase("sent")) {mail[1].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[1].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[1].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[1].inbox=true;}
					l.add(mail[1]);
					
				}
				if(o3) {
				    mail[2].dir=dir;
				    if(x.equalsIgnoreCase("sent")) {mail[2].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[2].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[2].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[2].inbox=true;}
					l.add(mail[2]);
					
				}
				if(o4) {
				    mail[3].dir=dir;
				    if(x.equalsIgnoreCase("sent")) {mail[3].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[3].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[3].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[3].inbox=true;}
					l.add(mail[3]);
					
				}
				if(o5) {
				    mail[4].dir=dir;
				    if(x.equalsIgnoreCase("sent")) {mail[4].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[4].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[4].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[4].inbox=true;}
					l.add(mail[4]);
					
				}
				if(o6) {
				    mail[5].dir=dir;
				    if(x.equalsIgnoreCase("sent")) {mail[5].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[5].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[5].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[5].inbox=true;}
					l.add(mail[5]);
					
				}
				if(o7) {
				    mail[6].dir=dir;
				    if(x.equalsIgnoreCase("sent")) {mail[6].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[6].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[6].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[6].inbox=true;}
					l.add(mail[6]);
					
				}
				if(o8) {
				    mail[7].dir=dir;
				    if(x.equalsIgnoreCase("sent")) {mail[7].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[7].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[7].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[7].inbox=true;}
					l.add(mail[7]);
					
				}
				if(o9) {
				    mail[8].dir=dir;
				    if(x.equalsIgnoreCase("sent")) {mail[8].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[8].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[8].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[8].inbox=true;}
					l.add(mail[8]);
					
				}
				if(o10) {
				    mail[9].dir=dir;
				    if(x.equalsIgnoreCase("sent")) {mail[9].sent=true;}
				     else if(x.equalsIgnoreCase("drafts")) {mail[9].drafts=true;}
				     else if(x.equalsIgnoreCase("trash")) {mail[9].trash=true;}
				     else if(x.equalsIgnoreCase("inbox")) {mail[9].inbox=true;}
					l.add(mail[9]);
					
				}
			   App a2 =new App();
			   a2.deleteEmails(l);
					
				}			
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(181, 226, 85, 21);
		contentPane.add(btnNewButton);
	
      //	c1.get
 	
		 setText(page);
	}



}
