package gui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mainCode.App;
import mainCode.Contact;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class first {

	private JFrame frmMailService;
	private JTextField upName;
	private JTextField upEmail;
	private JPasswordField Uppassword;
	private JButton btnNewButton;
	private JLabel lblmsg;
	private JPasswordField inpassword;
	private JTextField inEmail;
	private JButton btnSignUp;
	private final JLabel lblNewLabel_6 = new JLabel("ddd");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					first window = new first();
					window.frmMailService.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public first() {
		initialize();
	    events();
	}

	private void events() {
		/////////////////////////////////////////
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App a=new App();
				String myPass=String.valueOf(inpassword.getPassword());
				if(a.signin(inEmail.getText(), myPass)) {
					mainFrame m =new mainFrame(inEmail.getText(),a.c,myPass);
				    //m.user="sssssss";
				    //inEmail.getText();

					frmMailService.dispose();
				m.setVisible(true);
				}
				else {
					lblmsg.setText("wrong password or Email");
				}
				
				
			}
		});
		
		///////////////////////////////////////////////////
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App a=new App();
				String myPass=String.valueOf(Uppassword.getPassword());
				Contact c =new Contact();
				c.email=upEmail.getText();
				c.password=myPass;
				c.name=upName.getText();
				if(a.signup(c)) {
					mainFrame m =new mainFrame(upEmail.getText(),a.c,myPass);
					frmMailService.dispose();
					JOptionPane.showMessageDialog(null, "done!!");
				
					m.setVisible(true);
			   
				}
			   else {
					lblmsg.setText("the user already exists");

			   }
			
			}
		});
	/////////////////////////////////	
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMailService = new JFrame();
		frmMailService.setTitle("mail Service \r\n");
		frmMailService.setIconImage(Toolkit.getDefaultToolkit().getImage(first.class.getResource("/resources/icons8-important-mail-64.png")));
		frmMailService.setBounds(50, 50, 1456, 723);
		frmMailService.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMailService.getContentPane().setLayout(null);
		lblNewLabel_6.setIcon(new ImageIcon(first.class.getResource("/resources/stock-photo-login-grey-screen-laptop-computer-vintage-effects-digital-business-and-technology-concept-491986153.jpg")));
		lblNewLabel_6.setBounds(786, 0, 656, 686);
		frmMailService.getContentPane().add(lblNewLabel_6);
		
		lblmsg = new JLabel("");
		lblmsg.setForeground(Color.RED);
		lblmsg.setBackground(Color.RED);
		lblmsg.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		lblmsg.setBounds(178, 507, 337, 59);
		frmMailService.getContentPane().add(lblmsg);
		
		JLabel lblNewLabel_5 = new JLabel("Name");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 48));
		lblNewLabel_5.setEnabled(false);
		lblNewLabel_5.setBounds(414, 84, 187, 68);
		frmMailService.getContentPane().add(lblNewLabel_5);
		
		JLabel label_1 = new JLabel("Password\r\n\r\n");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 48));
		label_1.setEnabled(false);
		label_1.setBounds(414, 336, 216, 92);
		frmMailService.getContentPane().add(label_1);
		
		JLabel label = new JLabel("Email\r\n");
		label.setFont(new Font("Dialog", Font.PLAIN, 48));
		label.setEnabled(false);
		label.setBounds(414, 221, 127, 59);
		frmMailService.getContentPane().add(label);
		
		JLabel lblNewLabel_4 = new JLabel("Password\r\n\r\n");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 48));
		lblNewLabel_4.setEnabled(false);
		lblNewLabel_4.setBounds(19, 204, 216, 92);
		frmMailService.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Email\r\n");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 48));
		lblNewLabel_3.setEnabled(false);
		lblNewLabel_3.setBounds(19, 89, 127, 59);
		frmMailService.getContentPane().add(lblNewLabel_3);
		
		Uppassword = new JPasswordField();
		Uppassword.setFont(new Font("Monospaced", Font.PLAIN, 23));
		Uppassword.setBounds(414, 423, 325, 36);
		frmMailService.getContentPane().add(Uppassword);
		
		inpassword = new JPasswordField();
		inpassword.setFont(new Font("Monospaced", Font.PLAIN, 23));
		inpassword.setBounds(19, 288, 307, 36);
		frmMailService.getContentPane().add(inpassword);
		
		JLabel lblNewLabel_2 = new JLabel("Sign up\r\n");
		lblNewLabel_2.setEnabled(false);
		lblNewLabel_2.setBackground(Color.RED);
		lblNewLabel_2.setFont(new Font("Pristina", Font.BOLD | Font.ITALIC, 60));
		lblNewLabel_2.setBounds(390, -24, 373, 115);
		frmMailService.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Sign in");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setFont(new Font("Pristina", Font.BOLD | Font.ITALIC, 60));
		lblNewLabel_1.setBackground(Color.RED);
		lblNewLabel_1.setBounds(0, 0, 298, 66);
		frmMailService.getContentPane().add(lblNewLabel_1);
		
		btnSignUp = new JButton("Sign up\r\n");
		
		btnSignUp.setFont(new Font("Dialog", Font.PLAIN, 23));
		btnSignUp.setBounds(414, 593, 273, 66);
		frmMailService.getContentPane().add(btnSignUp);
		
		btnNewButton = new JButton("Sign in\r\n\r\n\r\n");
		
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\OWNER\\Downloads\\icons8-important-mail-50.png"));
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 23));
		btnNewButton.setBounds(19, 600, 273, 66);
		frmMailService.getContentPane().add(btnNewButton);
		
		upEmail = new JTextField();
		upEmail.setFont(new Font("SansSerif", Font.PLAIN, 23));
		upEmail.setColumns(10);
		upEmail.setBounds(414, 290, 325, 32);
		frmMailService.getContentPane().add(upEmail);
		
		upName = new JTextField();
		upName.setFont(new Font("SansSerif", Font.PLAIN, 23));
		upName.setColumns(10);
		upName.setBounds(414, 158, 325, 36);
		frmMailService.getContentPane().add(upName);
		
		inEmail = new JTextField();
		inEmail.setFont(new Font("SansSerif", Font.PLAIN, 23));
		inEmail.setBounds(19, 158, 298, 36);
		frmMailService.getContentPane().add(inEmail);
		inEmail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setIcon(new ImageIcon(first.class.getResource("/resources/3137472.jpg")));
		lblNewLabel.setBounds(0, 0, 3049, 2000);
		frmMailService.getContentPane().add(lblNewLabel);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
