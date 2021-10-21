package jp.id;

import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
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
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;

public class Item extends JFrame implements ActionListener{
	
	JFrame myframes = new JFrame();
	
	String [] productname = {"Lelegion Y540", "Lelegion Y740"};
	int [] productprice = {17999999, 20999999};
	int productongkir = 20000;
	public int xx = 0 ;
	
	JPanel centerpanel, northpanel,headpanel,vouche, back_img;
	JLabel fill1,fill2,fill3,label_title;
	JButton btn_item, btn_voucher, btn_back, backk;
	JLabel label_name, label_price, label_ongkir;

	
	public void content () {
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

		



	
		JLabel label_pic = new JLabel();
		label_pic.setIcon(new ImageIcon(new ImageIcon("Assets/y540.jpg").getImage().getScaledInstance(500, 260, Image.SCALE_SMOOTH )));
		
		JButton picbutton1 = new JButton();
		picbutton1.setIcon(new ImageIcon(new ImageIcon("Assets/y540.jpg").getImage().getScaledInstance(340, 180, Image.SCALE_SMOOTH )));
		
		JButton picbutton2 = new JButton();
		picbutton2.setIcon(new ImageIcon(new ImageIcon("Assets/y740.jpg").getImage().getScaledInstance(340, 180, Image.SCALE_SMOOTH )));

		headpanel = new JPanel (new GridLayout(1,2));
		northpanel = new JPanel(new FlowLayout());
		centerpanel = new JPanel(new GridLayout(5,2,100,5));

		myframes.add(northpanel, BorderLayout.NORTH);
		back_img.add(centerpanel, BorderLayout.CENTER);
		back_img.add(headpanel, BorderLayout.SOUTH);
		
		
		
		picbutton1.setBackground(Color.black);
		picbutton2.setBackground(Color.black);
		
		
		
		
		northpanel.setBackground(new Color(183,36,105));
		
		
		backk = new JButton("Back");
		backk.addActionListener(this);
		northpanel.add(backk);
		
		
		label_title = new JLabel("JP.ID Promo Event Item");
		label_title.setFont(new Font("Calibri", Font.PLAIN, 18));
		label_title.setForeground(Color.white);
		label_title.setBackground(new Color(183,36,105));
		
		northpanel.add(label_title);

		back_img.add(northpanel, BorderLayout.NORTH);


//		btn_back.setPreferredSize(new Dimension(10, 20));
		btn_item = new JButton("Product Showcase");

		btn_voucher = new JButton(" Use Voucher");
		btn_voucher.addActionListener(this);

		label_pic.setBorder(BorderFactory.createEmptyBorder(10,50,0 , 0));
		picbutton1.setBorder(BorderFactory.createEmptyBorder(0,20, 10, 0));
		picbutton2.setBorder(BorderFactory.createEmptyBorder(0,10, 10, 0));
		


		
		
		
		label_name = new JLabel("Name : "  + productname[xx]);
		label_name.setForeground(Color.white);
		
		label_price = new JLabel("Price : Rp." + productprice[xx]);
		label_price.setForeground(Color.white);
		
		label_ongkir = new JLabel("Ongkir : Rp." + productongkir);
		label_ongkir.setForeground(Color.white);
		
		fill1 = new JLabel("");	fill2 = new JLabel("");fill3 = new JLabel("");
		

		
		btn_back = new JButton("Backa");
		btn_back.setFont(new Font("Calibri",Font.BOLD, 20));
		
		northpanel.add(label_pic);
		
		centerpanel.add(label_name);
		centerpanel.add(fill1);
		centerpanel.add(label_price);
		centerpanel.add(fill2);
		centerpanel.add(label_ongkir);
		centerpanel.add(btn_item);
		centerpanel.add(btn_voucher);
		centerpanel.add(fill3);
		
		
		headpanel.add(picbutton1);
		headpanel.add(picbutton2);
		

		
		
		btn_item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			new Itemview();
				
			}
		});
		
		
		btn_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

			myframes.dispose();
			new Main(true);
				
			}
		});
		
		
		
		

		
		
		picbutton1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			label_pic.setIcon(new ImageIcon(new ImageIcon("Assets/y540.jpg").getImage().getScaledInstance(500, 260, Image.SCALE_SMOOTH )));
			xx=0;
			//System.out.println(xx);
			label_name.setText("Name : "  + productname[xx]);
			label_price.setText("Price : Rp." + productprice[xx]);
			validate();
			repaint();

			
			
			
		}
	});
		
		picbutton2.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent e) {
			xx=1;
			label_pic.setIcon(new ImageIcon(new ImageIcon("Assets/y740.jpg").getImage().getScaledInstance(500, 260, Image.SCALE_SMOOTH )));
			//System.out.println(xx);
			label_name.setText("Name : "  + productname[xx]);
			label_price.setText("Price : Rp." + productprice[xx]);
			validate();
			repaint();
			
			
		}
	});
		
		
		back_img.setBorder(BorderFactory.createEmptyBorder(30, 300, 30, 300));
		centerpanel.setBackground(Color.black);


		
		headpanel.setBackground(Color.black);
		northpanel.setBackground(Color.black);
		centerpanel.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 70));

		
		add (back_img);
	}
	

	
	public Item() {
		// TODO Auto-generated constructor stub
		
		content ();
	
		
		this.setTitle("JP.ID");
		this.setSize(1200, 700);
		this.setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new Item ();
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == btn_back) {
			this.dispose();
			new Main(true);
		}else if(e.getSource() == backk) {
			this.dispose();
			new Main(true);
			
		}else if(e.getSource() == btn_voucher) {
			this.dispose();
			new Vidpage();
		}
		
	}

}
