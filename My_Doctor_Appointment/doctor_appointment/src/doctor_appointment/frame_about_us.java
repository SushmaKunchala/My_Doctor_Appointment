package doctor_appointment;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import javax.swing.*;

public class frame_about_us implements MouseListener {
	
	JFrame f;
	JPanel p_top,p_center1,p_center_main,p_matter,p_images;
	JLabel l1,l_matter,l_home,l_head,l_image1,l_image2;
	ImageIcon i1,i2;
	frame_about_us()
	{
		f=new JFrame();
		p_top=new JPanel();
		p_center1=new JPanel();
		p_center_main=new JPanel();
		p_matter=new JPanel();
		p_images=new JPanel();
		i1=new ImageIcon("aboutus.png");
		i2=new ImageIcon("Chairman.jpg");
		
		l1=new JLabel();
		l_home=new JLabel();
		l_head=new JLabel();
		l_image1=new JLabel();
		l_image2=new JLabel();
		
		Image image1 = i1.getImage();
		Image new_img1=image1.getScaledInstance(300, 200,Image.SCALE_SMOOTH);
		i1 = new ImageIcon(new_img1); 
		
		Image image2 = i2.getImage();
		Image new_img2=image2.getScaledInstance(300, 200,Image.SCALE_SMOOTH);
		i2= new ImageIcon(new_img2); 
		
		l1.setText("OMNI HOSPITALS");
		l1.setFont(new Font("Arial",Font.BOLD,50));
		
		
		l_home.setText("Home");
		l_home.setForeground(Color.gray);
		l_home.setFont(new Font("Arial",Font.BOLD,20));
		l_home.setBounds(100, 20, 100, 20);
		l_home.setHorizontalAlignment(JLabel.CENTER);
		l_home.addMouseListener(this);
		
		l_head.setText("ABOUT US");
		l_head.setFont(new Font("Arial",Font.BOLD,30));
		l_head.setBounds(200,0,300,40);
		
		l_matter=new JLabel("<html>OMNI Hospitals was established with an intention of being a comprehensive & cost-effective chain of hospitals "
				+ "that provides super-specialty services with warmth and care. OMNI Hospitals is owned by the healthcare "
				+ "division of INCOR Group."
				+"<br/>"
				+"<br/>"
				+ "OMNI Hospitals started in 2010 with a 150 bedded super-specialty hospital in Kothapet, Hyderabad. Since its "
				+ "inception, the hospital has set up over 30 specialities including Cardiology, CT Surgery, Orthopaedics, Ortho "
				+ "Oncology, Paediatric and Neonatal Care, General Medicine and General Surgery, Urology and Nephrology, "
				+ "Gynaecology and Obstetrics, Neurology and Neurosurgery, Laparoscopic Surgery, and many more high-end "
				+ "specialties.\r\n"
				+"<br/>"
				+"<br/>"
				+ "\r\n"
				+ "Functional for over 9 years, the hospital has been successful in creating a unique identity of its own as a"
				+ " professional medical care provider with a strong adherence to ethics and a clear focus on bettering the health"
				+ " and lifestyle of the community that it operates in.</html>",SwingConstants.CENTER);
		
		l_matter.setBounds(0, 60, 900, 500);
		l_matter.setForeground(Color.GRAY);
		l_matter.setFont(new Font("Arial",Font.PLAIN,25));
		
		p_top.setBackground(new Color(169, 241, 223));
		p_top.setBounds(0,0,1600, 100);
		p_top.add(l1);
		
		p_center1.add(l_home);
		p_center1.setBackground(Color.WHITE);
		p_center1.setBounds(0,110,1600,50);
		p_center1.setLayout(null);
		
		l_image1.setIcon(i1);
		l_image2.setIcon(i2);
		
		p_images.add(l_image1);
		p_images.add(l_image2);
		p_images.setBackground(Color.WHITE);
		p_images.setBounds(50,0,450,500);
		p_images.setLayout(new GridLayout(2,1,0,0));
		
		p_matter.setLayout(null);
		p_matter.setBounds(500,0,1000,600);
		p_matter.setBackground(Color.WHITE);
		p_matter.add(l_head);
		p_matter.add(l_matter);
		
		p_center_main.add(p_images);
		p_center_main.add(p_matter);
		p_center_main.setBounds(0,180,1600,600);
		p_center_main.setBackground(Color.WHITE);
		p_center_main.setLayout(null);
		
		f.add(p_top);
		f.add(p_center1);
		f.add(p_center_main);
		f.setTitle("About us");
		f.getContentPane().setBackground(Color.white);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setLayout(new BorderLayout());
		f.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Frame_1 f1=new Frame_1();
		
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
