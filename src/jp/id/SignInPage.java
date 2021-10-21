package jp.id;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SignInPage extends JFrame implements ActionListener, MouseListener {

	JPanel mainPanel, cPanel, signInPanel, cHeadPanel, cCPanel, cFootPanel, emptyPanel, backPanel, loginTitlePanel, 
	wPanel, ePanel, emailTitlePanel, passTitlePanel, accMsgPanel, signUpBlueMsgPanel, noAccPanel, sPanel;
	JButton backBtn, signInBtn;
	JLabel loginTitleLbl, passwordLbl, emailLbl, accTxtLbl, signUpBlueMsg;
	JTextField emailFld;
	JPasswordField passFld;
	boolean login= false;
	
	Vector<String> emailList = new Vector<>();
	Vector<String> passList = new Vector<>();
	
	
	public SignInPage(Vector<String> emailList, Vector<String> passList) {
		// TODO Auto-generated constructor stub
		
		this.emailList = emailList;
		this.passList = passList;
		
		mainPanel = new JPanel(new BorderLayout() );
		
		// Center Center Panel (Sign in Panel)
		cCPanel = new JPanel(new GridLayout(6,1));
		cCPanel.setBackground(new Color(255,249,244));
		
			// Add to Center Center Panel (Sign in Panel)
			emailTitlePanel = new JPanel();
			emailTitlePanel.setBorder(new EmptyBorder(0, 0, 0, 165));
			emailTitlePanel.setBackground(new Color(255,249,244));
			emailLbl = new JLabel("Email");
			emailFld = new JTextField();
			
			passTitlePanel = new JPanel();
			passTitlePanel.setBorder(new EmptyBorder(0, 0, 0, 140));
			passTitlePanel.setBackground(new Color(255,249,244));
			passwordLbl = new JLabel("Password");
			passFld = new JPasswordField();
			
			signUpBlueMsgPanel = new JPanel();
			signUpBlueMsgPanel.setBackground(new Color(255,249,244));
			signUpBlueMsg = new JLabel("Sign Up");
			signUpBlueMsg.addMouseListener(this);
			signUpBlueMsg.setForeground(Color.BLUE);
			
			noAccPanel = new JPanel();
			noAccPanel.setBackground(new Color(255,249,244));
			accTxtLbl = new JLabel("No account?");
			signInBtn = new JButton("Sign In");
			signInBtn.addActionListener(this);
			accMsgPanel = new JPanel();
			accMsgPanel.setBackground(new Color(255,249,244));
			
			emailTitlePanel.add(emailLbl);
			passTitlePanel.add(passwordLbl);
			cCPanel.add(emailTitlePanel);
			cCPanel.add(emailFld);
			cCPanel.add(passTitlePanel);
			cCPanel.add(passFld);
			cCPanel.add(accMsgPanel);
			noAccPanel.add(accTxtLbl);
			accMsgPanel.add(noAccPanel);
			signUpBlueMsgPanel.add(signUpBlueMsg);
			accMsgPanel.add(signUpBlueMsgPanel);
			cCPanel.add(signInBtn);
		
		
		//Center Head Panel
		cHeadPanel = new JPanel(new GridLayout(1,3) );
		cHeadPanel.setPreferredSize(new Dimension(200,40) );
		
			// Add to C Head Panel
			backBtn = new JButton("Back");
			backBtn.addActionListener(this);
			backPanel = new JPanel();
			backPanel.setBackground(new Color(255,249,244));
			
			backPanel.add(backBtn);
			cHeadPanel.add(backPanel);
			
			loginTitleLbl = new JLabel("Sign in to JP.ID");
			loginTitleLbl.setForeground(Color.black);
			loginTitleLbl.setFont(new Font("Times New Roman", Font.BOLD, 20));
			loginTitlePanel = new JPanel(new FlowLayout() );
			loginTitlePanel.setBorder(new EmptyBorder(5, 0, 0, 0));
			loginTitlePanel.setBackground(new Color(255,249,244));
			loginTitlePanel.add(loginTitleLbl);
			cHeadPanel.add(loginTitlePanel);
			
			emptyPanel = new JPanel();
			emptyPanel.setBackground(new Color(255,249,244));
			cHeadPanel.add(emptyPanel);
		
		// Sign In Panel
		signInPanel = new JPanel(new BorderLayout() );
		wPanel = new JPanel();
		ePanel = new JPanel();
		sPanel = new JPanel();
		
		signInPanel.setBackground(new Color(255,249,244));
		wPanel.setBackground(new Color(255,249,244));
		wPanel.setPreferredSize(new Dimension(90,50) );
		ePanel.setBackground(new Color(255,249,244));
		ePanel.setPreferredSize(new Dimension(90,50) );
		sPanel.setBackground(new Color(255,249,244));
		sPanel.setPreferredSize(new Dimension(90,30) );
		
			//Add to Sign In Panel
			signInPanel.add(cHeadPanel, BorderLayout.NORTH);
			signInPanel.add(cCPanel, BorderLayout.CENTER);
			signInPanel.add(wPanel, BorderLayout.WEST);
			signInPanel.add(sPanel, BorderLayout.SOUTH);
			signInPanel.add(ePanel, BorderLayout.EAST);
		
		// Center Panel (main)
		try {
			cPanel = new JPanel(new BorderLayout() ) {
				Image img = ImageIO.read(new File("Assets/400x300.png"));
				
				@Override
				protected void paintComponent(Graphics g) {
					
					super.paintComponents(g);
					g.drawImage(img, 0, 0, 1200, 700, null);
					
				}
				
			};
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		cPanel.setBorder(new EmptyBorder(200, 400, 200, 400) );
		
			// Add to Center Panel (main)
			cPanel.add(signInPanel, BorderLayout.CENTER);
		
		
		//Add to Main Panel
		mainPanel.add(cPanel, BorderLayout.CENTER);
		
		
		add(mainPanel);
		
		//Init JFrame
		setTitle("JP.ID Sign In");
		setSize(new Dimension(1200,700) );
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public int emailChecker(JTextField emailFld) {
		
		for (int i = 0; i < emailList.size(); i++) {
			if(!emailFld.getText().matches(emailList.get(i))) {
				// ini kalo ga sama
				return 0;
			}else {
				// ini kalo sama
				return 1;
			}
		}
	
		return 0;
	}
	
	public int passChecker(JPasswordField passFld) {
		
		for (int i = 0; i < passList.size(); i++) {
			if(!passFld.getText().matches(passList.get(i))) {
				// ini kalo ga sama
				return 0;
			}else {
				// ini kalo sama
				return 1;
			}
		}
	
		return 0;
	}
	
	// MOUSE LISTENER
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == signUpBlueMsg){
			//direct ke sign up Page
			new SignUpPage();
			this.dispose();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// ACTION LISTENER

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == backBtn) {
			
			new Main(login);
			this.dispose();
			
		}else if(e.getSource() == signInBtn) {
			
			if(emailFld.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Email must be filled!");
				
			}else if(passFld.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Passowrd must be filled!");
				
			}else{
				if(emailChecker(emailFld) == 0) {
					JOptionPane.showMessageDialog(null, "Email not found!");
				}else if(passChecker(passFld) == 0) {
					
					JOptionPane.showMessageDialog(null, "Password is incorrect!");
					
				}else {
					JOptionPane.showMessageDialog(null, "Welcome!");
					login = true;
					new Main(login);
					this.dispose();
					
				}
			}
			
		}
		
	}

}
