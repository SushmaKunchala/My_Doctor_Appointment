package doctor_appointment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.sql.DriverManager;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class Frame_2 extends Connection_class implements MouseListener{
	JFrame f;
	JLabel l1,l_card;
	JPanel p_top;
	JPanel p_bottom;
	JPanel p_right;
	JPanel p_left;
	JPanel p_center;
	ImageIcon image;

	JLabel[] ar=new JLabel[8];
	Connection con;
	
	int i=0,j=0;
	
	Frame_2()
	{
		f=new JFrame();
		l1=new JLabel();
		p_top=new JPanel();
		p_bottom=new JPanel();
		p_right=new JPanel();
		p_left=new JPanel();
		p_center=new JPanel();
		Connection_class db=new Connection_class();
		
		l1.setText("OMNI HOSPITALS");
		l1.setFont(new Font("Arial",Font.BOLD,50));
		
		try {
			con=db.ConnectDB();
			Statement stmt=con.createStatement();
			String sql_query="select * from specalists";
			ResultSet rs=stmt.executeQuery(sql_query);
			while(rs.next())
			{
			image=new ImageIcon(rs.getString(2));
			Image image1 = image.getImage();
			Image new_img=image1.getScaledInstance(200, 200,Image.SCALE_SMOOTH);
			image = new ImageIcon(new_img); 
			ar[i]=new JLabel();
			ar[i].setText(rs.getString(1));
			ar[i].setFont(new Font("Arial",Font.BOLD,20));
			ar[i].setIcon(image);
			ar[i].setHorizontalTextPosition(JLabel.CENTER);
			ar[i].setVerticalTextPosition(JLabel.BOTTOM);
			ar[i].setHorizontalAlignment(JLabel.CENTER);
			p_center.add(ar[i]);
			i=i+1;
			}
			rs.close();
			stmt.close();
			con.close();
			
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		
		while(j<8)
		{
			ar[j].addMouseListener (this);
			j=j+1;
		}
		
		p_top.setBounds(0,0,1600,100);
		p_top.setBackground(new Color(169, 241, 223));
		p_top.add(l1);
		
		
		p_bottom.setBounds(0,750,1650,50);
		p_bottom.setBackground(Color.WHITE);
		
		p_right.setBounds(1450,0,100,1000);
		p_right.setBackground(Color.white);
		
		p_left.setBounds(0,0,10,1000);
		p_left.setBackground(Color.white);
		
		p_center.setBounds(10,100,1450,700);
		p_center.setLayout(new GridLayout(2,4,0,0));
		p_center.setBackground(Color.WHITE);
		
		f.add(p_top,BorderLayout.NORTH);
		f.add(p_bottom,BorderLayout.SOUTH);
		f.add(p_right,BorderLayout.EAST);
		f.add(p_left,BorderLayout.WEST);
		f.add(p_center,BorderLayout.CENTER);
		
		f.setTitle("Specality");
		f.getContentPane().setBackground(Color.white);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		f.setLayout(new BorderLayout());
		f.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel l=(JLabel)e.getSource();
		Frame_doctor f=new Frame_doctor(l.getText());
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
