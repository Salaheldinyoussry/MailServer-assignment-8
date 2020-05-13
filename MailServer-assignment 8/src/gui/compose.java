package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dataStructure.LQueue;
import dataStructure.singleLinkedList;
import mainCode.App;
import mainCode.email;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JScrollBar;
import javax.swing.JSplitPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class compose extends JFrame {

	compose(String user){
		this.user=user;
		intialize();
		
	}
	
	
	private JPanel contentPane;
	private JTextField txtTry;
	private JTextField btnrec;
	private JTextArea textArea;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblReceivers;
	private JButton btnNewButton_3;
    private singleLinkedList l1 =new singleLinkedList();
    private singleLinkedList l2 =new singleLinkedList();
    private LQueue q =new LQueue();
    public String user;
    private JList list;
    private int atachNo=0;
    private int priority=4;
   
	  DefaultListModel m=new DefaultListModel();
	  private JLabel lblNewLabel;
	  private JScrollPane scrollPane_2;

    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					compose frame = new compose();
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
	public compose() {
		
	
	intialize();
	}

	private void intialize() {
		// TODO Auto-generated method stub
		setIconImage(Toolkit.getDefaultToolkit().getImage(compose.class.getResource("/resources/icons8-important-mail-64.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 50, 808, 741);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 492, -173, 192);
		contentPane.add(scrollPane);

		txtTry = new JTextField();
		txtTry.setFont(new Font("SansSerif", Font.PLAIN, 18));
		txtTry.setBounds(114, 24, 573, 32);
		contentPane.add(txtTry);
		txtTry.setColumns(10);
		
		btnrec = new JTextField();
		btnrec.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnrec.setColumns(10);
		btnrec.setBounds(114, 83, 573, 32);
		contentPane.add(btnrec);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(67, 195, 651, 213);
		contentPane.add(scrollPane_1);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		scrollPane_1.setViewportView(textArea);
		
		btnNewButton = new JButton("+");
		btnNewButton.setFont(new Font("Elephant", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String x=btnrec.getText();
			q.enqueue(x);
			btnrec.setText("");
			}
		});
		btnNewButton.setBounds(715, 83, 53, 32);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("save draft\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				email mail=new email();
				mail.body=textArea.getText();
		       mail.attachmentsPath=l1;
		       mail.attachments=l2;
		       q.enqueue(btnrec.getText());
		    	mail.subject=txtTry.getText();
		       mail.receivers=q;
		       mail.sender=user;
		       mail.priority=priority;
		     //  Date d=new Date(atachNo, atachNo, atachNo);
				 SimpleDateFormat ft = new SimpleDateFormat("dd,MM,yyyy HH,mm,ss");  
		         Date d=new Date();
		         mail.date=ft.format(d).toString();
		         
		       // mail.subject=
			App a=new App();
			a.makeDraft(mail);
	//	frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Elephant", Font.PLAIN, 12));
		btnNewButton_1.setBounds(438, 657, 162, 41);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("send");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			email mail=new email();
		mail.body=textArea.getText();
       mail.attachmentsPath=l1;
       mail.attachments=l2;
       q.enqueue(btnrec.getText());
    	mail.subject=txtTry.getText();
       mail.receivers=q;
       mail.sender=user;
       mail.priority=priority;
     //  Date d=new Date(atachNo, atachNo, atachNo);
		 SimpleDateFormat ft = new SimpleDateFormat("dd,MM,yyyy HH,mm,ss");  
         Date d=new Date();
         mail.date=ft.format(d).toString();
         
       // mail.subject=
	App a=new App();
	if(!a.compose(mail)){
		  JOptionPane.showMessageDialog(null, "reciever doesn't exist");
	for(int i=0; i<q.size(); i++) {
		q.dequeue();
	}
	}else {
	  JOptionPane.showMessageDialog(null, "email sent");
      //System.exit(0);
	  for(int i=0; i<q.size(); i++) {
			q.dequeue();
		}
	}
			
			}
		});
		btnNewButton_2.setFont(new Font("Elephant", Font.PLAIN, 12));
		btnNewButton_2.setBounds(637, 657, 131, 41);
		contentPane.add(btnNewButton_2);
		
		lblReceivers = new JLabel("Receivers:\r\n");
		lblReceivers.setFont(new Font("Elephant", Font.PLAIN, 21));
		lblReceivers.setBounds(6, 82, 177, 28);
		contentPane.add(lblReceivers);
		////////////////////
		btnNewButton_3 = new JButton("add atachment !");
		btnNewButton_3.addActionListener(new ActionListener() {
		 					

			public void actionPerformed(ActionEvent e) {
				
				
				JFileChooser f = new JFileChooser();
				int r=f.showOpenDialog(null);
	            File fi = f.getSelectedFile();

				if (fi != null && r == JFileChooser.APPROVE_OPTION) {
					 String path=fi.getPath();
					 String name=fi.getName();
					  //JOptionPane.showMessageDialog(null, path);
					  l1.add(path);
					  l2.add(name);
				
				        list.setModel(m); 
				        m.add(atachNo, name);
				        atachNo++;
					  
				
				 }
			}
		});
	
		
		btnNewButton_3.setBounds(264, 492, 185, 41);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("atachments list:");
		lblNewLabel_1.setFont(new Font("Elephant", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(65, 453, 187, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("select the attatchment from the list to delete:");
		lblNewLabel_2.setFont(new Font("Elephant", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(264, 548, 362, 39);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_4 = new JButton("delete");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel model = (DefaultListModel) list.getModel();
				int selectedIndex = list.getSelectedIndex();
				if (selectedIndex != -1) {
				    model.remove(selectedIndex);
				    atachNo--;
				}
			}
		});
		btnNewButton_4.setForeground(Color.RED);
		btnNewButton_4.setFont(new Font("Elephant", Font.PLAIN, 13));
		btnNewButton_4.setBounds(264, 590, 106, 28);
		contentPane.add(btnNewButton_4);
		
		JLabel label = new JLabel("subject:");
		label.setFont(new Font("Elephant", Font.PLAIN, 21));
		label.setBounds(6, 24, 177, 28);
		contentPane.add(label);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(52, 490, 177, 174);
		contentPane.add(scrollPane_2);
		
		list = new JList();
		scrollPane_2.setViewportView(list);
		
		JLabel lblMessage = new JLabel("message:");
		lblMessage.setFont(new Font("Elephant", Font.PLAIN, 21));
		lblMessage.setBounds(6, 155, 177, 28);
		contentPane.add(lblMessage);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getSource()==comboBox) {
				if(comboBox.getSelectedIndex()==0) {
				priority=1;	
				}
				else if(comboBox.getSelectedIndex()==1) {
					priority=2;	
					}
				else if(comboBox.getSelectedIndex()==2) {
					priority=3;	
					}
				
				else if(comboBox.getSelectedIndex()==3) {
					priority=4;	
					}
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox.setSelectedIndex(3);
		comboBox.setBounds(725, 499, 46, 26);
		contentPane.add(comboBox);
		
		JLabel lblPriority = new JLabel("priority:");
		lblPriority.setFont(new Font("Elephant", Font.PLAIN, 21));
		lblPriority.setBounds(623, 496, 115, 26);
		contentPane.add(lblPriority);
		
		lblNewLabel = new JLabel("to add more than one receiver press + after each one:");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(448, 105, 340, 58);
		contentPane.add(lblNewLabel);
	///////////////////////////////////////////////
	}
}
