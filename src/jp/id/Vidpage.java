package jp.id;



import java.awt.BorderLayout;
import java.awt.Canvas;
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

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class Vidpage  {
	
	
	JFrame myframe = new JFrame();
	
	JPanel headpanel, centerpanel;
	JButton button_back;
	JLabel title;
	EmbeddedMediaPlayer player;
	Canvas canvas;
	
	
	
	
	
	

	public void Framee() {
		// TODO Auto-generated constructor stub
		
		myframe.setLayout(new BorderLayout());
		
		
		headpanel = new JPanel ();
		headpanel.setBackground(Color.black);
		
		
		title = new JLabel("JP.ID Promo Event Item");
		title.setForeground(Color.white);
		
		
		button_back = new JButton("Back");
		button_back.setForeground(new Color(183,36,105));
		button_back.setBackground(Color.pink);
		
		
		
		headpanel.add(button_back);
		headpanel.add(title);
		
		myframe.add(headpanel, BorderLayout.NORTH );
		
		
		
		centerpanel = new JPanel (new FlowLayout());
		canvas = new Canvas();
		canvas.setSize(1200,600);
		centerpanel.add(canvas);
		myframe.add(centerpanel, BorderLayout.CENTER );
		
		  
		  button_back.addActionListener(new ActionListener() {
			   
		      public void actionPerformed(ActionEvent e)
		      {
		    	 player.stop();
		         new Main(true);
		         myframe.dispose();
		      }
		  });
		
		
		
		  
		
		  
		  
		
	}
	
	
	
	private void startplay() {
		NativeLibrary.addSearchPath("libvlc", "C:\\Program Files\\VideoLAN\\VLC");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		
		MediaPlayerFactory play = new MediaPlayerFactory();
		
		  player = play.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(myframe));
		  player.setVideoSurface(play.newVideoSurface(canvas));
		  player.playMedia("/Assets/legion.mp4");
		  player.play();
		  player.setRepeat(true);
	}

	
	public Vidpage() {
			Framee();
		  myframe.setSize(new Dimension(1200,700));
		  myframe.setResizable(false);
		  myframe.setLocationRelativeTo(null);
		  myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  myframe.setVisible(true);
		    startplay();

	}
	
//	public static void main(String[] args) {
//		
//		
//		
//		
//		new Vidpage();
//		
//
//	}

}
