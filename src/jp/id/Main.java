package jp.id;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Main extends JFrame implements ActionListener, MenuListener{

	JMenuBar header;
	JMenu voucher, event, promo;
	JPanel mainPanel, nPanel, cPanel, sPanel,btnPanelSignIn, btnPanelExit, emptyPanel, signInPanel, exitPanel;
	JButton signInBtn, exitBtn;
	Image bgImage = null;
	
	int imgWidth = 1000;
	int imgHeight = 650;
	
	static boolean login;
	
	
	Color Maroon = new Color(169,68,87);
	AudioPlayer audioPlayer = new AudioPlayer();
	
	Vector<String> emailList = new Vector<>();
	Vector<String> passList = new Vector<>();
	
	public Main(boolean login) {
		
		this.login = login;
		
		mainPanel = new JPanel(new BorderLayout() );
	
		audioPlayer.MediaPlayer.play();
		
		// JMenu
		voucher = new JMenu("Voucher");
		event = new JMenu("Event");
		promo = new JMenu("Promo");
		
		voucher.addMenuListener(this);
		promo.addMenuListener(this);
		event.addMenuListener(this);
		
		voucher.setForeground(Color.white);
		event.setForeground(Color.white);
		promo.setForeground(Color.white);
		
		// VALIDASI BUTTON VOUCHER EVENT PROMO BLM
		

		voucher.setPreferredSize(new Dimension(65,50) );
		event.setPreferredSize(new Dimension(50,50) );
		promo.setPreferredSize(new Dimension(50,50) );
		
		// Header JMenuBar
			header = new JMenuBar();
				
			header.setBackground(Maroon);
			header.setBorderPainted(false);
			header.setPreferredSize(new Dimension(1000,40) );
			
			//add to Header
			header.add(voucher);
			header.add(event);
			header.add(promo);
		
		//BgImage
			try {
				bgImage = ImageIO.read(new File("Assets/red.png") );
//				repaint();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//cPanel
		cPanel = new JPanel();
		
//		cPanel.setBackground(Color.gray);
		
			// add to cPanel
//			cPanel.add(paint());
		
		
		//JButtons
		signInBtn = new JButton("Sign-In");
		signInBtn.addActionListener(this);
		exitBtn = new JButton("Exit");
		exitBtn.addActionListener(this);
		
		//VALIDASI SIGN IN BLM
		
		signInBtn.setBackground(Maroon);
		signInBtn.setForeground(Color.white);
//		signInBtn.setPreferredSize(new Dimension(75,50));
		exitBtn.setBackground(Maroon);
		exitBtn.setForeground(Color.white);
		
		//sPanel
		sPanel = new JPanel(new GridLayout(1,3) );
		emptyPanel = new JPanel();
		signInPanel = new JPanel();
		exitPanel = new JPanel();
		
		sPanel.setPreferredSize(new Dimension(1000,50) );
		signInPanel.setBorder(new EmptyBorder(0, 0, 0, 220));
		exitPanel.setBorder(new EmptyBorder(0, 220, 0, 0));
		
		signInPanel.add(signInBtn);
		exitPanel.add(exitBtn);
		
			//add to sPanel
			sPanel.add(signInPanel);
			sPanel.add(emptyPanel);
			sPanel.add(exitPanel);
//			sPanel.add(btnPanelSignIn);
//			sPanel.add(btnPanelExit);
		
		//add to mainPanel
		mainPanel.add(header, BorderLayout.NORTH);
//		mainPanel.add(new BgImage(), BorderLayout.CENTER);
		mainPanel.add(cPanel, BorderLayout.CENTER);
		mainPanel.add(sPanel, BorderLayout.SOUTH);
		
		add(mainPanel);
		
		
		// init JFrame
		setTitle("JP.ID");
		setSize(new Dimension(1200,700) );
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Graphics2D bgImage2D = (Graphics2D) g;
		bgImage2D.drawImage(bgImage, 1200/20, 700/15, imgWidth, imgHeight, null);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main(login);
//		new Item();
//		new VoucherPage();
//		new VoucherPromo();
//		new SignInPage();
//		new SignUpPage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == exitBtn) {
			audioPlayer.MediaPlayer.stop();
			this.dispose();
		}else if(e.getSource() == signInBtn) {
			audioPlayer.MediaPlayer.pause();
			new SignInPage(emailList,passList);
			this.dispose();
		}
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuSelected(MenuEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == voucher) {
			if(login == false) {
				audioPlayer.MediaPlayer.pause();
				new SignInPage(emailList,passList);
				this.dispose();
			}else if(login == true ) {
				audioPlayer.MediaPlayer.pause();
				new VoucherPage();
				this.dispose();}
			
		}else if(e.getSource() == promo) {
			
			if(login == false) {
				audioPlayer.MediaPlayer.pause();
				new SignInPage(emailList,passList);
				this.dispose();
			}else if(login == true) {
				audioPlayer.MediaPlayer.pause();
				new Vidpage();
				this.dispose();}
		}
		
		else if(e.getSource() == event) {
			if(login == false) {
				audioPlayer.MediaPlayer.pause();
				new SignInPage(emailList,passList);
				this.dispose();
			}else if(login == true) {
				audioPlayer.MediaPlayer.pause();
				new Item();
				this.dispose();}
		}
	}

}
