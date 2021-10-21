package jp.id;

import java.util.ArrayList;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JTextField;

import org.omg.CORBA.portable.ApplicationException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;

public class VoucherPromo extends JFrame implements ActionListener{
	
	JFrame myframes = new JFrame();

	public int xx = 0 ;
	
	JPanel descPanel,mainPanel, centerpanel, northpanel, emptyPanel,voucher, back_img;
	JLabel fill1,fill2,fill3,label_title;
	JButton claim_button,cancel_button,backk;

	String pictureNum;
//	Vector<Integer> claimStats = new Vector<>(8);
	Integer Quantity;
	VoucherData vList;
	
	public void content (String pictureNum) {
		
//		claimStats.add(0);claimStats.add(0);claimStats.add(0);claimStats.add(0);claimStats.add(0);claimStats.add(0);
//		claimStats.add(0);claimStats.add(0);
		
		back_img = new JPanel(new BorderLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(new File("Assets/voucherpage.png")), 0, 0, 1200, 700, null);
				}catch (IOException e) {
					// TODO Auto-generated method stub
					e.printStackTrace();
				}
				
			}
		};

	
		JButton picbutton1 = new JButton();
		picbutton1.setIcon(new ImageIcon(new ImageIcon("Assets/ongkir 10.jpg").getImage().getScaledInstance(200, 325, Image.SCALE_SMOOTH )));
		
		JButton picbutton2 = new JButton();
		picbutton2.setIcon(new ImageIcon(new ImageIcon("Assets/ongkir 20.jpg").getImage().getScaledInstance(200, 325, Image.SCALE_SMOOTH )));
		
		JButton picbutton3 = new JButton();
		picbutton3.setIcon(new ImageIcon(new ImageIcon("Assets/ongkir 30.jpg").getImage().getScaledInstance(200, 325, Image.SCALE_SMOOTH )));

		JButton picbutton4 = new JButton();
		picbutton4.setIcon(new ImageIcon(new ImageIcon("Assets/ongkir 40.jpg").getImage().getScaledInstance(200, 325, Image.SCALE_SMOOTH )));
		
		JButton picbutton5 = new JButton();
		picbutton5.setIcon(new ImageIcon(new ImageIcon("Assets/cashback 10.jpg").getImage().getScaledInstance(200, 325, Image.SCALE_SMOOTH )));
		
		JButton picbutton6 = new JButton();
		picbutton6.setIcon(new ImageIcon(new ImageIcon("Assets/cashback 20.jpg").getImage().getScaledInstance(200, 325, Image.SCALE_SMOOTH )));
		
		JButton picbutton7 = new JButton();
		picbutton7.setIcon(new ImageIcon(new ImageIcon("Assets/cashback 30.jpg").getImage().getScaledInstance(200, 325, Image.SCALE_SMOOTH )));
		
		JButton picbutton8 = new JButton();
		picbutton8.setIcon(new ImageIcon(new ImageIcon("Assets/cashback 40.jpg").getImage().getScaledInstance(200, 325, Image.SCALE_SMOOTH )));
		
		
		emptyPanel = new JPanel ();
		northpanel = new JPanel(new GridLayout(3,1));
		centerpanel = new JPanel(new BorderLayout());
		mainPanel = new JPanel(new BorderLayout());
		descPanel = new JPanel(new BorderLayout());

//		emptyPanel.setPreferredSize(new Dimension(100,350) );
//		myframes.add(northpanel, BorderLayout.NORTH);
		back_img.add(mainPanel, BorderLayout.CENTER);
		back_img.add(centerpanel, BorderLayout.WEST);
		mainPanel.add(descPanel, BorderLayout.EAST);
		
		
		label_title = initJLabel("Voucher Ongkir",25);
		northpanel.add(label_title);
		
		claim_button = initJButton2("Claim");
		northpanel.add(claim_button);
		claim_button.setLocation(0,0);
		
		cancel_button = initJButton2("Cancel");
		northpanel.add(cancel_button);
		cancel_button.setLocation(0,0);
		
		descPanel.setBackground(new Color(169,68,87));
		descPanel.add(northpanel, BorderLayout.EAST);
		descPanel.add(emptyPanel, BorderLayout.CENTER);
//		emptyPanel.add(northpanel);
		emptyPanel.setBackground(Color.blue);

		if(pictureNum.equals("picture1")) {
			picbutton1.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

			centerpanel.add(picbutton1);
		}else if(pictureNum.equals("picture2")) {
			picbutton2.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

			centerpanel.add(picbutton2);
		}else if(pictureNum.equals("picture3")) {
			picbutton3.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

			centerpanel.add(picbutton3);
		}else if(pictureNum.equals("picture4")) {
			picbutton4.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

			centerpanel.add(picbutton4);
		}else if(pictureNum.equals("picture5")) {
			picbutton5.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

			centerpanel.add(picbutton5);
		}else if(pictureNum.equals("picture6")) {
			picbutton6.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

			centerpanel.add(picbutton6);
		}else if(pictureNum.equals("picture7")) {
			picbutton7.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

			centerpanel.add(picbutton7);
		}else if(pictureNum.equals("picture8")) {
			picbutton8.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

			centerpanel.add(picbutton8);
		}
	
		
//		centerpanel.setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));
		
		back_img.setBorder(BorderFactory.createEmptyBorder(60, 5, 80, 80));
			
//		centerpanel.setBackground(new Color(169,68,87));

//		emptyPanel.setBackground(new Color(169,68,87));
		northpanel.setBackground(new Color(169,68,87));
		centerpanel.setBackground(new Color(169,68,87));
		
		add (back_img);
	}
	

	
	public VoucherPromo(String picture, VoucherData vList) {
		// TODO Auto-generated constructor stub
		
//		this.Quantity = vQty;
		this.vList = vList;
		
		pictureNum = picture;
		
		content (pictureNum);
	
		
		this.setTitle("JP.ID");
		this.setSize(500, 500);
		this.setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == cancel_button) {
//			JOptionPane.showMessageDialog(null, claimStats);
			this.dispose();
		}else if(e.getSource() == claim_button) {
			
//			JOptionPane.showMessageDialog(null, claimStats.get(1) );
			
			if(vList.getQty() == 1) {
				JOptionPane.showMessageDialog(null, "Success!");
				vList.setQty(vList.getQty() - 1);
				System.out.println(vList.getQty());
			}else {
				JOptionPane.showMessageDialog(null, "You already claimed this voucher");
			}
			
//			if(pictureNum.equals("picture1") && claimStats.get(0) == 0 ) {
//				claimStats.set(0, 1);
//				JOptionPane.showMessageDialog(null, "test");
//				this.dispose();
//				
//			}else if(pictureNum.equals("picture2") && claimStats.get(0) == 0 ) {
//				claimStats.set(1, 1);
//				JOptionPane.showMessageDialog(null, "test");
//				this.dispose();
//				
//			}else if(pictureNum.equals("picture3") && claimStats.get(0) == 0 ) {
//				claimStats.set(2, 1);
//				JOptionPane.showMessageDialog(null, "test");
//				this.dispose();
//				
//			}else if(pictureNum.equals("picture4") && claimStats.get(0) == 0 ) {
//				claimStats.set(3, 1);
//				JOptionPane.showMessageDialog(null, "test");
//				this.dispose();
//				
//			}else if(pictureNum.equals("picture5") && claimStats.get(0) == 0 ) {
//				claimStats.set(4, 1);
//				JOptionPane.showMessageDialog(null, "test");
//				this.dispose();
//				
//			}else if(pictureNum.equals("picture6") && claimStats.get(0) == 0 ) {
//				claimStats.set(5, 1);
//				JOptionPane.showMessageDialog(null, "test");
//				this.dispose();
//				
//			}else if(pictureNum.equals("picture7") && claimStats.get(0) == 0 ) {
//				claimStats.set(6, 1);
//				JOptionPane.showMessageDialog(null, "test");
//				this.dispose();
//				
//			}else if(pictureNum.equals("picture8") && claimStats.get(0) == 0 ) {
//				claimStats.set(7, 1);
//				JOptionPane.showMessageDialog(null, "test");
//				this.dispose();
//				
//			}else {
//				JOptionPane.showMessageDialog(null, "You already claimed this voucher");
//			}
//			

			
		}
		
	}
	
	private JLabel initJLabel(String str, Integer size) {
		JLabel lbl = new JLabel(str);
		lbl.setForeground(Color.white);
		lbl.setBackground(new Color(169,68,87));
		lbl.setFont(new Font("Segoe Print", Font.BOLD, size));
		return lbl;
	}
	
	private JButton initJButton(String str) {
		JButton but = new JButton(str);
//		but.setBackground(new Color(169,68,87));
		but.setForeground(Color.red);
		but.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		but.setPreferredSize(new Dimension(65,30));
		but.addActionListener(this);
		return but;
	}
	
	private JButton initJButton2(String str) {
		JButton but = new JButton(str);
//		but.setBackground(new Color(169,68,87));
		but.setForeground(Color.black);
		but.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		but.setPreferredSize(new Dimension(65,30));
		but.addActionListener(this);
		return but;
	}
}
