package jp.id;

import java.util.ArrayList;
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
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;

public class VoucherPage extends JFrame implements ActionListener{
	
	JFrame myframes = new JFrame();

	public int xx = 0 ;
	
	JPanel centerpanel, northpanel,headpanel,voucher, back_img;
	JLabel fill1,fill2,fill3,label_title;
	JButton btn_back2, backk;
	
	ArrayList<VoucherData> VData = new ArrayList<>();
	
	public void content () {
		
		VData.add(new VoucherData() );VData.add(new VoucherData() );VData.add(new VoucherData() );VData.add(new VoucherData() );
		VData.add(new VoucherData() );VData.add(new VoucherData() );VData.add(new VoucherData() );VData.add(new VoucherData() );
		
//		for (int i = 0; i < VData.size(); i++) {
//			System.out.println(VData.get(i).getQty());
//		}
		
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
		picbutton1.setIcon(new ImageIcon(new ImageIcon("Assets/ongkir 10.jpg").getImage().getScaledInstance(130, 190, Image.SCALE_SMOOTH )));
		
		JButton picbutton2 = new JButton();
		picbutton2.setIcon(new ImageIcon(new ImageIcon("Assets/ongkir 20.jpg").getImage().getScaledInstance(130, 190, Image.SCALE_SMOOTH )));
		
		JButton picbutton3 = new JButton();
		picbutton3.setIcon(new ImageIcon(new ImageIcon("Assets/ongkir 30.jpg").getImage().getScaledInstance(130, 190, Image.SCALE_SMOOTH )));

		JButton picbutton4 = new JButton();
		picbutton4.setIcon(new ImageIcon(new ImageIcon("Assets/ongkir 40.jpg").getImage().getScaledInstance(130, 190, Image.SCALE_SMOOTH )));
		
		JButton picbutton5 = new JButton();
		picbutton5.setIcon(new ImageIcon(new ImageIcon("Assets/cashback 10.jpg").getImage().getScaledInstance(130, 190, Image.SCALE_SMOOTH )));
		
		JButton picbutton6 = new JButton();
		picbutton6.setIcon(new ImageIcon(new ImageIcon("Assets/cashback 20.jpg").getImage().getScaledInstance(130, 190, Image.SCALE_SMOOTH )));
		
		JButton picbutton7 = new JButton();
		picbutton7.setIcon(new ImageIcon(new ImageIcon("Assets/cashback 30.jpg").getImage().getScaledInstance(130, 190, Image.SCALE_SMOOTH )));
		
		JButton picbutton8 = new JButton();
		picbutton8.setIcon(new ImageIcon(new ImageIcon("Assets/cashback 40.jpg").getImage().getScaledInstance(130, 190, Image.SCALE_SMOOTH )));
		
		headpanel = new JPanel (new FlowLayout());
		northpanel = new JPanel(new FlowLayout());
		centerpanel = new JPanel(new GridLayout(2,4,60,60));
		centerpanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		myframes.add(northpanel, BorderLayout.NORTH);
		back_img.add(centerpanel, BorderLayout.CENTER);
		back_img.add(headpanel, BorderLayout.SOUTH);
		
		
		
		picbutton1.setBackground(new Color(0,0,0,44));
		picbutton2.setBackground(new Color(0,0,0,44));
		picbutton3.setBackground(new Color(0,0,0,44));
		picbutton4.setBackground(new Color(0,0,0,44));
		picbutton5.setBackground(new Color(0,0,0,44));
		picbutton6.setBackground(new Color(0,0,0,44));
		picbutton7.setBackground(new Color(0,0,0,44));
		picbutton8.setBackground(new Color(0,0,0,44));
		
		northpanel.setBackground(new Color(0,0,0,44));

		
		
		btn_back2 = initJButton("Back");
		northpanel.add(btn_back2);
		btn_back2.setLocation(0,0);
		
		label_title = initJLabel("Vouchers",50);
		northpanel.add(label_title);

		back_img.add(northpanel, BorderLayout.NORTH);

		picbutton1.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		picbutton2.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		picbutton3.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		picbutton4.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		picbutton5.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		picbutton6.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		picbutton7.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		picbutton8.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

		centerpanel.add(picbutton1);
		centerpanel.add(picbutton2);
		centerpanel.add(picbutton3);
		centerpanel.add(picbutton4);
		centerpanel.add(picbutton5);
		centerpanel.add(picbutton6);
		centerpanel.add(picbutton7);
		centerpanel.add(picbutton8);
		
		
		picbutton1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
//			picbutton1.setIcon(new ImageIcon(new ImageIcon("Assets/ongkir 10.jpg").getImage().getScaledInstance(140, 200, Image.SCALE_SMOOTH )));
//			xx=0;
//			validate();
//			repaint();
			if(e.getSource() == picbutton1) {
				String picture = "picture1";
				new VoucherPromo(picture, VData.get(0) );
			}
			
			
		}
	});
		
		picbutton2.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent e) {
			xx=1;
			picbutton2.setIcon(new ImageIcon(new ImageIcon("Assets/ongkir 20.jpg").getImage().getScaledInstance(140, 200, Image.SCALE_SMOOTH )));
			validate();
			repaint();
			
			if(e.getSource() == picbutton2) {
				String picture = "picture2";
				new VoucherPromo(picture, VData.get(1));
			}
		}
	});
		
		picbutton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xx=1;
				picbutton3.setIcon(new ImageIcon(new ImageIcon("Assets/ongkir 30.jpg").getImage().getScaledInstance(140, 200, Image.SCALE_SMOOTH )));
				
				if(e.getSource() == picbutton3) {
					String picture = "picture3";
					new VoucherPromo(picture, VData.get(2));
				}
				
			}
		});
			
		
		picbutton4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xx=1;
				picbutton4.setIcon(new ImageIcon(new ImageIcon("Assets/ongkir 40.jpg").getImage().getScaledInstance(140, 200, Image.SCALE_SMOOTH )));
				validate();
				repaint();
				
				if(e.getSource() == picbutton4) {
					String picture = "picture4";
					new VoucherPromo(picture, VData.get(3));
				}
			}
		});
		
		picbutton5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				picbutton5.setIcon(new ImageIcon(new ImageIcon("Assets/cashback 10.jpg").getImage().getScaledInstance(140, 200, Image.SCALE_SMOOTH )));
				xx=0;
				validate();
				repaint();

				
				if(e.getSource() == picbutton5) {
					String picture = "picture5";
					new VoucherPromo(picture, VData.get(4));
				}
				
			}
		});
		
		picbutton6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				picbutton6.setIcon(new ImageIcon(new ImageIcon("Assets/cashback 20.jpg").getImage().getScaledInstance(140, 200, Image.SCALE_SMOOTH )));
				xx=0;
				validate();
				repaint();

				if(e.getSource() == picbutton6) {
					String picture = "picture6";
					new VoucherPromo(picture, VData.get(5));
				}
				
				
			}
		});
		
		picbutton7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				picbutton7.setIcon(new ImageIcon(new ImageIcon("Assets/cashback 30.jpg").getImage().getScaledInstance(140, 200, Image.SCALE_SMOOTH )));
				xx=0;
				validate();
				repaint();

				
				if(e.getSource() == picbutton7) {
					String picture = "picture7";
					new VoucherPromo(picture, VData.get(6));
				}
				
			}
		});
		
		picbutton8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				picbutton8.setIcon(new ImageIcon(new ImageIcon("Assets/cashback 40.jpg").getImage().getScaledInstance(140, 200, Image.SCALE_SMOOTH )));
				xx=0;
				validate();
				repaint();

				if(e.getSource() == picbutton8) {
					String picture = "picture8";
					new VoucherPromo(picture, VData.get(7));
				}
				
				
			}
		});
			
		
		
		back_img.setBorder(BorderFactory.createEmptyBorder(70, 100, 30, 100));
		centerpanel.setBackground(new Color(0,0,0,44));


		
		headpanel.setBackground(new Color(0,0,0,44));
		northpanel.setBackground(new Color(0,0,0,44));
		centerpanel.setBorder(BorderFactory.createEmptyBorder(1, 100, 1, 100));
		centerpanel.setBackground(new Color(0,0,0,44));
		
		add (back_img);
	}
	

	
	public VoucherPage() {
		// TODO Auto-generated constructor stub
		
		content ();
	
		
		this.setTitle("JP.ID");
		this.setSize(1200, 700);
		this.setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == btn_back2) {
			new Main(true);
			this.dispose();
		}
		
	}
	
	private JLabel initJLabel(String str, Integer size) {
		JLabel lbl = new JLabel(str);
		lbl.setForeground(Color.white);
		lbl.setFont(new Font("Segoe Print", Font.BOLD, size));
		return lbl;
	}
	
	private JButton initJButton(String str) {
		JButton but = new JButton(str);
		but.setBackground(Color.pink);
		but.setForeground(Color.red);
		but.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		but.setPreferredSize(new Dimension(65,30));
		but.addActionListener(this);
		return but;
	}
	
}
