package doctor_appointment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import javax.swing.*;

public class Frame_1 implements ActionListener, MouseListener{
	JFrame f;
	JPanel p1,p_center1,p_center2,p_center2_slidebutton1,p_center2_slidebutton2,p_center2_label;
	JPanel p2_bottom;
	JLabel l1,l_home,l_aboutus,l_image;
	JLabel l_contact,l_c1,l_c2,l_c3,l_c4;
	JButton b1,b_image1,b_image2;
	ImageIcon s[];
	int slideshow_count=0;
	Frame_1()
	{
		f=new JFrame();
		p1=new JPanel();
		p_center1=new JPanel();
		p_center2=new JPanel();
		p_center2_slidebutton1=new JPanel();
		p_center2_slidebutton2=new JPanel();
		p_center2_label=new JPanel();
		
		p2_bottom=new JPanel();
		l1=new JLabel();
		l_c1=new JLabel();
		l_c2=new JLabel();
		l_c3=new JLabel();
		l_c4=new JLabel();
		l_home=new JLabel();
		l_aboutus=new JLabel();
		l_image=new JLabel();
		l_contact=new JLabel();
		b1=new JButton();
		b_image1=new JButton();
		b_image2=new JButton();
		
		s=new ImageIcon[8];
		
		s[0]=new ImageIcon("slideshow1.jpg");
		Image image1=s[0].getImage();
		Image new_img1=image1.getScaledInstance(600, 350,Image.SCALE_SMOOTH);
		s[0] = new ImageIcon(new_img1);
		
		s[1]=new ImageIcon("slideshow2.jpg");
		Image image2=s[1].getImage();
		Image new_img2=image2.getScaledInstance(600, 350,Image.SCALE_SMOOTH);
		s[1] = new ImageIcon(new_img2);
		
		s[2]=new ImageIcon("slideshow3.jpg");
		Image image3=s[2].getImage();
		Image new_img3=image3.getScaledInstance(600, 350,Image.SCALE_SMOOTH);
		s[2] = new ImageIcon(new_img3);
		
		s[3]=new ImageIcon("slideshow4.jpg");
		Image image4=s[3].getImage();
		Image new_img4=image4.getScaledInstance(600, 350,Image.SCALE_SMOOTH);
		s[3] = new ImageIcon(new_img4);
		
		s[4]=new ImageIcon("slideshow5.jpg");
		Image image5=s[4].getImage();
		Image new_img5=image5.getScaledInstance(600, 350,Image.SCALE_SMOOTH);
		s[4] = new ImageIcon(new_img5);
		
		s[5]=new ImageIcon("slideshow6.jpg");
		Image image6=s[5].getImage();
		Image new_img6=image6.getScaledInstance(600, 350,Image.SCALE_SMOOTH);
		s[5] = new ImageIcon(new_img6);
		
		s[6]=new ImageIcon("slideshow7.jpg");
		Image image7=s[6].getImage();
		Image new_img7=image7.getScaledInstance(600, 350,Image.SCALE_SMOOTH);
		s[6] = new ImageIcon(new_img7);
		
		s[7]=new ImageIcon("slideshow8.jpg");
		Image image8=s[7].getImage();
		Image new_img8=image8.getScaledInstance(600, 350,Image.SCALE_SMOOTH);
		s[7] = new ImageIcon(new_img8);
		
		l_image.setIcon(s[0]);
		
		
		l1.setText("OMNI HOSPITALS");
		l1.setFont(new Font("Arial",Font.BOLD,50));
		l1.setBounds(200, 25, 500, 60);
		
		l_contact.setText("Contact details : ");
		l_contact.setFont(new Font("Arial",Font.BOLD,20));
		l_contact.setBounds(180,2,500,50);
		
		l_c1.setText("<html>1-8-31/1 Begumpet, Minister Rd, Krishna Nagar Colony<br/>Secunderabad, Telangana 500003 <br/>Telephone numbers : 040 4488 5000, <br/> 040 4488 5001, 040 4488 5002</html>");
		l_c1.setFont(new Font("Arial",Font.PLAIN,20));
		l_c1.setBounds(200,55,500,100);
		
		l_c2.setText("<html>7-3-45/6 Pulipati vari street, Gandhi Nagar<br/>Vijayawada,Andhra Pradesh 520014 <br/>Telephone numbers : 040 4438 5700, <br/> 040 4438 5701, 040 4438 5702</html>");
		l_c2.setFont(new Font("Arial",Font.PLAIN,20));
		l_c2.setBounds(760,55,500,100);
		
		l_home.setText("Home");
		l_home.setForeground(Color.gray);
		l_home.setFont(new Font("Arial",Font.BOLD,20));
		l_home.setBounds(100, 20, 100, 20);
		l_home.setHorizontalAlignment(JLabel.CENTER);
		l_home.addMouseListener(this);
		
		l_aboutus.setText("About us");
		l_aboutus.setForeground(Color.gray);
		l_aboutus.setFont(new Font("Arial",Font.BOLD,20));
		l_aboutus.setBounds(220, 20, 150, 20);
		l_aboutus.setHorizontalAlignment(JLabel.CENTER);
		l_aboutus.addMouseListener(this);
		
		b_image1.setText("<<");
		b_image1.setFocusable(false);
		b_image1.addActionListener(this);
		b_image1.setBounds(120,0,60,50);
		b_image1.setFont(new Font("Arial",Font.BOLD,20));
		
		
		b_image2.setText(">>");
		b_image2.setFocusable(false);
		b_image2.addActionListener(this);
		b_image2.setBounds(20,0, 60, 50);
		b_image2.setFont(new Font("Arial",Font.BOLD,20));
		
		p1.setBackground(new Color(169, 241, 223));
		p1.setBounds(0,0,1600, 100);
		p1.setLayout(null);
		p1.add(l1);
		
		p_center1.setBounds(0,110,1600,50);
		p_center1.setBackground(Color.WHITE);
		p_center1.setLayout(null);
		p_center1.add(l_home);
		p_center1.add(l_aboutus);
		
		p_center2_slidebutton1.setBackground(Color.WHITE);
		p_center2_slidebutton1.add(b_image1);
		p_center2_slidebutton1.setLayout(null);
		p_center2_slidebutton1.setBounds(0,150,200,50);
		
		p_center2_slidebutton2.setBackground(Color.WHITE);
		p_center2_slidebutton2.add(b_image2);
		p_center2_slidebutton2.setLayout(null);
		p_center2_slidebutton2.setBounds(800,150,200,50);
		
		p_center2_label.add(l_image);
		p_center2_label.setBounds(200,0,600,450);
		p_center2_label.setBackground(Color.WHITE);
		
		p_center2.setBackground(Color.WHITE);
		p_center2.setBounds(250,200,1600,450);
		
		p_center2.add(p_center2_slidebutton1,BorderLayout.WEST);
		p_center2.add(p_center2_label);
		p_center2.add(p_center2_slidebutton2,BorderLayout.EAST);
		p_center2.setLayout(new BorderLayout());
	
		
		p2_bottom.setBounds(0,620,1600, 250);
		p2_bottom.add(l_contact);
		p2_bottom.add(l_c1);
		p2_bottom.add(l_c2);
		p2_bottom.add(l_c3);
		
		p2_bottom.setLayout(null);
		
		b1.setBounds(1200, 25, 270, 50);
		b1.setBackground(Color.GREEN);
		b1.setText("Book An Appointment");
		b1.setFocusable(false);
		b1.setFont(new Font("Arial",Font.BOLD,20));
		b1.addActionListener(this);
		p1.add(b1);
	
		
		f.add(p1,BorderLayout.NORTH);
		f.add(p2_bottom,BorderLayout.SOUTH);
		f.add(p_center1);
		f.add(p_center2);
		f.setTitle("Home Page");
		f.getContentPane().setBackground(Color.white);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			Frame_2 f2=new Frame_2();
		}
		else if(e.getSource()==b_image1)
		{
			if(slideshow_count>0)
			{
				slideshow_count=slideshow_count-1;
				l_image.setIcon(s[slideshow_count]);
			}
			
		}
		else if(e.getSource()==b_image2)
		{
			if(slideshow_count<s.length-1)
			{
				slideshow_count=slideshow_count+1;
				l_image.setIcon(s[slideshow_count]);
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel l=(JLabel)e.getSource();
		if(l.getText()=="About us")
		{
			frame_about_us f1=new frame_about_us();
			f.dispose();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel l=(JLabel)e.getSource();
		l.setOpaque(true);
		l.setBackground(new Color(245, 244, 241));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel l=(JLabel)e.getSource();
		l.setOpaque(true);
		l.setBackground(null);
		
	}
}
