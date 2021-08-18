package doctor_appointment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class Frame_doctor extends Connection_class implements ActionListener{

	JFrame f;
	JLabel l1,l_name,l_specality,l_experience,l_book;
	JPanel p_top,p_center,p_bottom;
	Connection con;
	PreparedStatement stmt;
	JLabel[] ar=new JLabel[27];
	JPanel[] arp=new JPanel[9];
	JButton[] b=new JButton[3];
	ImageIcon image;
	String doctor,sql_q;
	ResultSet rs,rs1;
	int button_index=0;
	Frame_doctor(String Doctor)
	{
		this.doctor=Doctor;
		Connection_class db=new Connection_class();
		f=new JFrame();
		l1=new JLabel();
		l_name=new JLabel();
		l_specality=new JLabel();
		l_experience=new JLabel();
		l_book=new JLabel();
		p_top=new JPanel();
		p_center=new JPanel();
		p_bottom=new JPanel();
	
			try {
				con=db.ConnectDB();
				if(this.doctor.equals("PEDIATRICIAN"))
				{
					this.doctor="Pediatrician";
					sql_q="select * from children_doctor where specality=?";
					setdata(sql_q);
				}
				else if(this.doctor.equals("CARDIOLOGIST"))
				{
					this.doctor="Cardiologist";
					sql_q="select * from cardiologist where specality=?";
					setdata(sql_q);
				}
				else if(this.doctor.equals("GYNECOLOGIST"))
				{
					this.doctor="Gynecologist";
					sql_q="select * from gynecologist where specality=?";
					setdata(sql_q);
				}
				else if(this.doctor.equals("DENTIST"))
				{
					this.doctor="Dentist";
					sql_q="select * from dentist where specality=?";
					setdata(sql_q);
				}
				else if(this.doctor.equals("ENT"))
				{
					this.doctor="ENT";
					sql_q="select * from ent where specality=?";
					setdata(sql_q);
				}
				else if(this.doctor.equals("DERMATOLOGIST"))
				{
					this.doctor="Dermatologist";
					sql_q="select * from skin_doctor where specality=?";
					setdata(sql_q);
				}
				else if(this.doctor.equals("NEUROLOGIST"))
				{
					this.doctor="Neurologist";
					sql_q="select * from neurologist where specality=?";
					setdata(sql_q);
				}
				else if(this.doctor.equals("ORTHOPEDIST"))
				{
					this.doctor="Orthopedist";
					sql_q="select * from orthopedist where specality=?";
					setdata(sql_q);
				}
				
				stmt.close();
				
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		
		
		l1.setText("OMNI HOSPITALS");
		l1.setFont(new Font("Arial",Font.BOLD,50));
		
		p_top.setBackground(new Color(169, 241, 223));
		p_top.setBounds(0,0,1600, 100);
		p_top.add(l1);
		
		p_center.setBounds(300,120,1550,650);
		p_center.setLayout(new GridLayout(3,5,80,10));
		p_center.setBackground(Color.WHITE);
		
		p_bottom.setBounds(0,750,1650,50);
		p_bottom.setBackground(Color.WHITE);
		
		f.add(p_top,BorderLayout.NORTH);
		f.add(p_bottom,BorderLayout.SOUTH);
		f.add(p_center,BorderLayout.CENTER);
		f.setTitle("Doctors");
		f.getContentPane().setBackground(Color.white);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		f.setLayout(new BorderLayout());
		f.setVisible(true);
	}
void setdata(String sql_q1)
{
	
	int i=0;
	int j=0;
	int k=0;
	try 
	{
		stmt=con.prepareStatement(sql_q1,ResultSet.TYPE_SCROLL_INSENSITIVE);
		stmt.setString(1,this.doctor);
	rs=stmt.executeQuery();
	while(rs.next())
	{	
		
		image=new ImageIcon(rs.getString(2));
		Image image1 = image.getImage();
		Image new_img=image1.getScaledInstance(200, 200,Image.SCALE_SMOOTH);
		image = new ImageIcon(new_img);
		ar[i]=new JLabel();
		arp[j]=new JPanel();
		ar[i].setIcon(image);
		p_center.add(ar[i]);
		i=i+1;
		ar[i]=new JLabel();
		arp[j].add(ar[i]);
		i=i+1;
		
		ar[i]=new JLabel();
		ar[i].setText("NAME       : "+rs.getString(1));
		ar[i].setFont(new Font("Arial",Font.PLAIN,20));
		arp[j].add(ar[i]);
		i=i+1;
		
		ar[i]=new JLabel();
		ar[i].setText("SPECALITY  : "+rs.getString(3));
		ar[i].setFont(new Font("Arial",Font.PLAIN,20));
		arp[j].add(ar[i]);
		i=i+1;
		
		ar[i]=new JLabel();
		ar[i].setText("EXPERIENCE : "+rs.getString(4));
		ar[i].setFont(new Font("Arial",Font.PLAIN,20));
		arp[j].add(ar[i]);
		i=i+1;
		
		ar[i]=new JLabel();
		arp[j].add(ar[i]);
		
		arp[j].setLayout(new GridLayout(5,1,0,0));
		arp[j].setBackground(Color.WHITE);
		p_center.add(arp[j]);
		j=j+1;
		
		arp[j]=new JPanel();
		b[k]=new JButton();
		b[k].setText("Book An Appointment");
		b[k].setFont(new Font("Arial",Font.BOLD,15));
		b[k].setBackground(Color.green);
		b[k].setFocusable(false);
		b[k].setBounds(10,70,200,40);
		arp[j].add(b[k]);
		
		arp[j].setBackground(Color.WHITE);
		arp[j].setLayout(null);
		
		k=k+1;
		p_center.add(arp[j]);

		i=i+1;
		j=j+1;
		
		ar[i]=new JLabel();
		p_center.add(ar[i]);
		i=i+1;
		
	}
	rs.close();
	stmt.close();
	}
	catch(Exception ex)
	{
		System.out.println(ex);
	}
	while(button_index<3)
	{
		b[button_index].addActionListener(this);
		button_index=button_index+1;
	}
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	JButton button=(JButton)e.getSource();
	try {
	stmt=con.prepareStatement(sql_q,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	stmt.setString(1,this.doctor);
	rs1=stmt.executeQuery();
	if(button==b[0])
	{
		rs1.absolute(1);
		Frame_3 f=new Frame_3(this.doctor,rs1.getString(1));	
	}
	else if(button==b[1])
	{
		rs1.absolute(2);
		Frame_3 f=new Frame_3(this.doctor,rs1.getString(1));
	}
	else if(button==b[2])
	{
		rs1.absolute(3);
		Frame_3 f=new Frame_3(this.doctor,rs1.getString(1));
	}
	rs1.close();
	stmt.close();
	}
	catch(Exception ex)
	{
		System.out.println(ex);
	}
}

}

