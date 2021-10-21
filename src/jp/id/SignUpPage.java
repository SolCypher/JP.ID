package jp.id;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.toedter.calendar.JDateChooser;

//import com.toedter.calendar.JCalendar;
//import com.toedter.calendar.JDateChooser;

public class SignUpPage extends JFrame implements ActionListener{

	JPanel mainPanel, bgPanel, signUpPanel, signUpHeaderPanel, signUpCenterPanel, signUpFooterPanel, emptyFooterPanel, backPanel,
	regTitlePanel, usernamePanel, genderPanel, genderRadioPanel, emailPanel, passwordPanel, confPassPanel, addressPanel, dobPanel;
	JLabel regTitleLbl, usernameLbl, genderLbl, passwordLbl, emailLbl, confirmPassLbl, addressLbl, dobLbl;
	JButton signUpBtn, backBtn;
	JRadioButton maleRBtn, femaleRBtn;
	ButtonGroup genderGroup;
	JTextField usernameFld, emailFld, addressFld;
	JPasswordField passFld, confirmPassFld;
	JDateChooser calendar;
	
	Vector<String> emailList = new Vector<>();
	Vector<String> passList = new Vector<>();
	
	public SignUpPage() {
		// TODO Auto-generated constructor stub
		
		mainPanel = new JPanel(new BorderLayout() );
		
		//Sign Up Footer Panel
		signUpFooterPanel = new JPanel();
		signUpFooterPanel.setBackground(new Color(169, 68, 86));
		signUpBtn = new JButton("Sign Up");
		signUpBtn.addActionListener(this);
		
			// Add to Sign Up Footer Panel
		signUpFooterPanel.add(signUpBtn);
		
		// Sign Up Center Panel
		signUpCenterPanel = new JPanel(new GridLayout(8,2) );
		signUpCenterPanel.setBackground(new Color(169, 68, 86));
		
		usernamePanel = new JPanel();
		usernamePanel.setBackground(new Color(169, 68, 86));
		usernameLbl = new JLabel("UserName");
		usernameLbl.setForeground(Color.white);
		usernamePanel.add(usernameLbl);
		usernameFld = new JTextField();
		usernameFld.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				warnUsername();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				warnUsername();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
//				warnUsername();
			}
			
			public void warnUsername() {
				if(usernameFld.getText().length() < 5 || usernameFld.getText().length() > 50) {
					//JOptionPane.showMessageDialog(null, "Username must be 5-50 characters!");
					usernameFld.setBorder(BorderFactory.createLineBorder(Color.red) );
					
				}else if(!usernameFld.getText().contains(" ")) {
					//JOptionPane.showMessageDialog(null, "Username must consist of 2 words!");
					usernameFld.setBorder(BorderFactory.createLineBorder(Color.red) );
					
				}else {
					usernameFld.setBorder(BorderFactory.createLineBorder(Color.gray) );
				}
			}
			
		});
		
		genderPanel = new JPanel();
		genderPanel.setBackground(new Color(169, 68, 86));
		genderLbl = new JLabel("Gender");
		genderLbl.setForeground(Color.white);
		genderPanel.add(genderLbl);
		genderRadioPanel = new JPanel();
		genderRadioPanel.setBackground(new Color(169, 68, 86));
		maleRBtn = new JRadioButton("Male");
		maleRBtn.setBackground(new Color(169, 68, 86));
		maleRBtn.setForeground(Color.white);
		femaleRBtn = new JRadioButton("Female");
		femaleRBtn.setBackground(new Color(169, 68, 86));
		femaleRBtn.setForeground(Color.white);
		genderGroup = new ButtonGroup();
		genderGroup.add(maleRBtn);
		genderGroup.add(femaleRBtn);
		
		emailPanel = new JPanel();
		emailPanel.setBackground(new Color(169, 68, 86));
		emailLbl = new JLabel("Email");
		emailLbl.setForeground(Color.white);
		emailPanel.add(emailLbl);
		emailFld = new JTextField();
		emailFld.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				warnEmail();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				warnEmail();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				warnEmail();
			}
			
			public void warnEmail() {
				if(!emailFld.getText().matches("^(.+)@(.+)$")) {
					//JOptionPane.showMessageDialog(null, "Email must be in correct format! (_@_)");
					emailFld.setBorder(BorderFactory.createLineBorder(Color.red));
				
				}else {
					emailFld.setBorder(BorderFactory.createLineBorder(Color.gray));
					
				}
			}
			
		});
		
		passwordPanel = new JPanel();
		passwordPanel.setBackground(new Color(169, 68, 86));
		passwordLbl = new JLabel("Password");
		passwordLbl.setForeground(Color.white);
		passwordPanel.add(passwordLbl);
		passFld = new JPasswordField();
		passFld.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				warnPass();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				warnPass();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				warnPass();
			}
			
			public void warnPass() {
				if(passFld.getPassword().length < 8 || passFld.getPassword().length > 50 ) {
					//JOptionPane.showMessageDialog(null, "Password must be 8-50 characters!");
					passFld.setBorder(BorderFactory.createLineBorder(Color.red));
					
				}else if(!passFld.getText().matches("[A-Za-z0-9]+") ) {
					//JOptionPane.showMessageDialog(null, "Password must be alphanumeric!");
					passFld.setBorder(BorderFactory.createLineBorder(Color.red));
					
				}else {
					passFld.setBorder(BorderFactory.createLineBorder(Color.gray));
					
				}
			}
			
		});
		
		confPassPanel = new JPanel();
		confPassPanel.setBackground(new Color(169, 68, 86));
		confirmPassLbl = new JLabel("Confirm Password");
		confirmPassLbl.setForeground(Color.white);
		confPassPanel.add(confirmPassLbl);
		confirmPassFld = new JPasswordField();
		confirmPassFld.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				warnConfPass();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				warnConfPass();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				warnConfPass();
			}
			
			public void warnConfPass() {
				if(!confirmPassFld.getText().equals(passFld.getText())) {
					//JOptionPane.showMessageDialog(null, "Password must be the same with confirm Password!");
					confirmPassFld.setBorder(BorderFactory.createLineBorder(Color.red));
					
				}else {
					confirmPassFld.setBorder(BorderFactory.createLineBorder(Color.gray));
				}
			}
		});
		
		addressPanel = new JPanel();
		addressPanel.setBackground(new Color(169, 68, 86));
		addressLbl = new JLabel("Address");
		addressLbl.setForeground(Color.white);
		addressPanel.add(addressLbl);
		addressFld = new JTextField();
		addressFld.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				warnAddress();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				warnAddress();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				warnAddress();
			}
			
			public void warnAddress() {
				if(addressFld.getText().length() < 8 || addressFld.getText().length() > 50 ) {
					//JOptionPane.showMessageDialog(null, "Address must be 8-50 characters!");
					addressFld.setBorder(BorderFactory.createLineBorder(Color.red));
					
				}else {
					addressFld.setBorder(BorderFactory.createLineBorder(Color.gray));
					
				}
			}
			
		});
		
		dobPanel = new JPanel();
		dobPanel.setBackground(new Color(169, 68, 86));
		dobLbl = new JLabel("DOB");
		dobLbl.setForeground(Color.white);
		dobPanel.add(dobLbl);
		calendar = new JDateChooser();
		
			// Add to Sign Up Center Panel
			signUpCenterPanel.add(usernamePanel);
			signUpCenterPanel.add(usernameFld);
			
			signUpCenterPanel.add(genderPanel);
			genderRadioPanel.add(femaleRBtn);
			genderRadioPanel.add(maleRBtn);
			signUpCenterPanel.add(genderRadioPanel);
			
			signUpCenterPanel.add(emailPanel);
			signUpCenterPanel.add(emailFld);
			
			signUpCenterPanel.add(passwordPanel);
			signUpCenterPanel.add(passFld);
			
			signUpCenterPanel.add(confPassPanel);
			signUpCenterPanel.add(confirmPassFld);
			
			signUpCenterPanel.add(addressPanel);
			signUpCenterPanel.add(addressFld);
			
			signUpCenterPanel.add(dobPanel);
			signUpCenterPanel.add(calendar);
		
		// Sign Up Header Panel
		signUpHeaderPanel = new JPanel(new GridLayout(1,3));
		
		signUpHeaderPanel.setBackground(new Color(169, 68, 86));
		
			//Add to Sign Up Header Panel
			backPanel = new JPanel();
			backPanel.setBorder(new EmptyBorder(0, 0, 0, 80));
			backPanel.setBackground(new Color(169, 68, 86));
			backBtn = new JButton("Back");
			backBtn.addActionListener(this);
			backPanel.add(backBtn);
			signUpHeaderPanel.add(backPanel);
			
			regTitlePanel = new JPanel();
			regTitleLbl = new JLabel("Sign up to JP.ID");
			regTitleLbl.setFont(new Font("Times New Roman", Font.BOLD, 20));
			regTitleLbl.setForeground(Color.WHITE);
			regTitlePanel.setBackground(new Color(169, 68, 86));
			regTitlePanel.add(regTitleLbl);
			signUpHeaderPanel.add(regTitlePanel);
			
			emptyFooterPanel = new JPanel();
			emptyFooterPanel.setBackground(new Color(169, 68, 86));
			signUpHeaderPanel.add(emptyFooterPanel);
		
		// SignUp BG Panel (main)
		signUpPanel = new JPanel(new BorderLayout() );
		
		signUpPanel.setBackground(new Color(169, 68, 86));
		
			// Add to Sign Up BG Panel (Main)
		signUpPanel.add(signUpHeaderPanel, BorderLayout.NORTH);
		signUpPanel.add(signUpCenterPanel, BorderLayout.CENTER);
		signUpPanel.add(signUpFooterPanel, BorderLayout.SOUTH);
		
		// Bg Panel
		try {
			bgPanel = new JPanel(new BorderLayout()) {
				Image img = ImageIO.read(new File("Assets/600x400.png"));
				
			@Override
			protected void paintComponent(Graphics g) {
				
				super.paintComponents(g);
				g.drawImage(img, 0, 0, 1200, 700, null);
			}
				
			};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			bgPanel.setBorder(new EmptyBorder(150, 0, 150, 600));
		
			// Add to BG Panel
			bgPanel.add(signUpPanel, BorderLayout.CENTER);
		
		
		// Add to Main Panel
		mainPanel.add(bgPanel);
		
		
		add(mainPanel);
		
		setTitle("JP.ID Sign Up");
		setSize(new Dimension(1200,700) );
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public LocalDate convertToLocalDateViaInstant(java.util.Date date) {
        return date.toInstant()
          .atZone(ZoneId.systemDefault())
          .toLocalDate();
    }
	
	// ACTION LISTENER
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == backBtn) {
			new SignInPage(emailList,passList);
			this.dispose();
			
		}else if(e.getSource() == signUpBtn) {
			
			if(usernameFld.getText().length() < 5 || usernameFld.getText().length() > 50) {
				JOptionPane.showMessageDialog(null, "Username must be 5-50 characters!");
				
			}else if(!usernameFld.getText().contains(" ")) {
				JOptionPane.showMessageDialog(null, "Username must consist of 2 words!");
				
			}else if(passFld.getPassword().length < 8 || passFld.getPassword().length > 50 ) {
				JOptionPane.showMessageDialog(null, "Password must be 8-50 characters!");
				
			}else if(!passFld.getText().matches("[A-Za-z0-9]+") ) {
				JOptionPane.showMessageDialog(null, "Password must be alphanumeric!");
				
			}else if(!confirmPassFld.getText().equals(passFld.getText())) {
				JOptionPane.showMessageDialog(null, "Password must be the same with confirm Password!");
				
			}else if(!emailFld.getText().matches("^(.+)@(.+)$")) {
				JOptionPane.showMessageDialog(null, "Email must be in correct format! (_@_)");
				
			}else if(java.time.LocalDate.now().isBefore(convertToLocalDateViaInstant(calendar.getDate())) || 
					java.time.LocalDate.now().isEqual(convertToLocalDateViaInstant(calendar.getDate()))) {
				
				JOptionPane.showMessageDialog(null, "DOB must be at least yesterday!");
				
			}else if(addressFld.getText().length() < 8 || addressFld.getText().length() > 50 ) {
				JOptionPane.showMessageDialog(null, "Address must be 8-50 characters!");
				
			}else {
				// Vector userList buat nyimpen user yg udh registered
				emailList.add(emailFld.getText());
				passList.add(passFld.getText());
				
//				JOptionPane.showMessageDialog(null, emailList.get(0) + " " + passList);
				new SignInPage(emailList,passList);
				this.dispose();
			}
		}
		
	}

}
