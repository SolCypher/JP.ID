package jp.id;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Itemview extends JFrame{
 JPanel southPanel,northpanel,westpanel,eastpanel,centerpanel;
 JButton button_right, button_zoomin, button_zoomout, button_left, changeimg, closeBtn;
 

 
 BufferedImage image = null;
 
 int x = 1000/4;
 int y = 400/4;
 int width = 700;
 int height = 400;
 int rotate = 0;
 int changepic = 0;
 
 public Itemview() {
  
  try {
   image = ImageIO.read(new File("assets/y740.jpg"));
   repaint();
  } catch (IOException e1) {
   // TODO Auto-generated catch block
   e1.printStackTrace();
  }
 
  southPanel = new JPanel(new FlowLayout());
  westpanel = new JPanel(new FlowLayout());
  eastpanel = new JPanel(new FlowLayout());
  northpanel = new JPanel(new FlowLayout());
  centerpanel = new JPanel(new FlowLayout());
  
  
  
  button_left = new JButton("Rotate Left");
  button_right = new JButton("Rotate Right");
  button_zoomin = new JButton("zoom in");
  button_zoomout = new JButton("zoom out");
  changeimg = new JButton("view other model");
  

  closeBtn = new JButton("close");
  
 
  button_right.addActionListener(new ActionListener() {
   
   @Override
   public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
   
    rotate += 90;
    rotate %= 360;
    repaint();
   }
  });
  
  button_zoomin.addActionListener(new ActionListener() {
   
   @Override
   public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
	   x*=1.1;
	   y*=0.9;
    width += 70;
    height += 40;
    
    repaint();
   }
  });
  
  button_zoomout.addActionListener(new ActionListener() {
   
   @Override
   public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
   x*=0.9;
   y*=1.1;
   
    width -= 70;
    height -= 40;
    repaint();


   }
  });
  
  button_left.addActionListener(new ActionListener() {
   
   @Override
   public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    
    rotate += -90;
    rotate %= 360;
    repaint();
   }
  });
  
  
  changeimg.addActionListener(new ActionListener() {
	   
	   @Override
	   public void actionPerformed(ActionEvent e) {
	    // TODO Auto-generated method stub
	    
		   try {
			   image = ImageIO.read(new File("assets/y540.jpg"));
			   repaint();
			  } catch (IOException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
	  
	    
	    if (changepic%2 == 0) {
			   try {
				   image = ImageIO.read(new File("assets/y540.jpg"));
				   repaint();
				  } catch (IOException e1) {
				   // TODO Auto-generated catch block
				   e1.printStackTrace();
				  }  repaint();
			changepic += 1;
		}
	    
	    else if (changepic%2 == 1) {
			   try {
				   image = ImageIO.read(new File("assets/y740.jpg"));
				   repaint();
				  } catch (IOException e1) {
				   // TODO Auto-generated catch block
				   e1.printStackTrace();
				  }  repaint();
			changepic +=1 ;
		}
	    
	   }
	  });


  
  
  closeBtn.addActionListener(new ActionListener() {
   
      public void actionPerformed(ActionEvent e)
      {
         dispose();
      }
  });
  
 
  southPanel.add(button_left);
  southPanel.add(button_right);
  southPanel.add(button_zoomin);
  southPanel.add(button_zoomout);
  southPanel.add(changeimg);
  southPanel.add(closeBtn);
  this.add(southPanel, BorderLayout.SOUTH);
  southPanel.setBackground(Color.black);
  
  
  
  westpanel.setBackground(Color.black);
  this.add(westpanel, BorderLayout.WEST);
  
  eastpanel.setBackground(Color.black);
  this.add(eastpanel, BorderLayout.EAST);
  
  northpanel.setBackground(Color.black);
  this.add(northpanel, BorderLayout.NORTH);
  
  centerpanel.setBackground(Color.black);
  this.add(centerpanel, BorderLayout.CENTER);
  
 
  

  
  
  
  this.setSize(new Dimension(1200,700));
  this.setResizable(false);
  this.setLocationRelativeTo(null);
  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  this.setVisible(true);
 }
 
 @Override
 public void paint(Graphics g) {
  // TODO Auto-generated method stub
  super.paint(g);
  
  Graphics2D g2d = (Graphics2D) g;
  g2d.rotate(Math.toRadians(rotate),x + width/2, y + height/2);
  g2d.drawImage(image, x, y, width, height, null);
  
 }

 public static void main(String[] args) {
  // TODO Auto-generated method stub
  new Itemview();
 }

}