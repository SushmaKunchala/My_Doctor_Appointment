package doctor_appointment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Frame_3 implements ActionListener {
	JFrame f;
	JPanel p_top,p_center1,p_center2,p_center_date,p_center_slot,p_info,p_last,p_slot,p_center_choose;
	JLabel l_main,l_head,l_date,l_slot,l_image,l_info1,l_info2,l_info3,l_empty_info1,l_empty_info2;
	JLabel l_empty_date1;
	JRadioButton rb1,rb2;
	JRadioButton[] ar=new JRadioButton[4];
	JButton b;
	String specality,doctor_name,sql_q_slot,sql_q_doc,date="empty",slot="empty",current_time;
	ButtonGroup group_date,group_slot;
	Connection con;
	Statement stmt;
	ImageIcon image;
	PreparedStatement stmt1,stmt2,stmt3;
	ResultSet rs1,rs2,rs3,rs4;
	JOptionPane op;
	int count;
	int i=0;
	Frame_3(String specality,String doctor_name)
	{
		this.specality=specality;
		this.doctor_name=doctor_name;
		Connection_class db=new Connection_class();
		f=new JFrame();
		p_top=new JPanel();
		p_center1=new JPanel();
		p_center2=new JPanel();
		p_center_date=new JPanel();
		p_center_slot=new JPanel();
		p_info=new JPanel();
		p_last=new JPanel();
		p_slot=new JPanel();
		p_center_choose=new JPanel();
		
		l_main=new JLabel();
		l_head=new JLabel();
		l_date=new JLabel();
		l_slot=new JLabel();
		l_image=new JLabel();
		l_info1=new JLabel();
		l_info2=new JLabel();
		l_info3=new JLabel();
		l_empty_info1=new JLabel();
		l_empty_info2=new JLabel();
		l_empty_date1=new JLabel();
		
		
		b=new JButton();
		
		try {
		con=db.ConnectDB();
		stmt=con.createStatement();
		String sql_q="select TO_CHAR(current_date, 'dd-mm-yyyy'),to_char(current_timestamp,'HH24') from dual";
		rs1=stmt.executeQuery(sql_q);
		rs1.next();
		rb1=new JRadioButton(rs1.getString(1));
		current_time=rs1.getString(2);
		rb1.addActionListener(this);
		String sql_q2="select TO_CHAR(current_date+1, 'dd-mm-yyyy') from dual";
		rs2=stmt.executeQuery(sql_q2);
		rs2.next();
		rb2=new JRadioButton(rs2.getString(1));
		rb2.addActionListener(this);
		group_slot=new ButtonGroup();
		stmt.close();
		}
		
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		
		try {
			if(this.specality.equals("Pediatrician"))
			{
				sql_q_slot="select * from children_doctor_slot where name=?";
				display_data(sql_q_slot);
			}
			else if(this.specality.equals("Cardiologist"))
			{
				sql_q_slot="select * from cardiologist_slot where name=?";
				display_data(sql_q_slot);
			}
			else if(this.specality.equals("Gynecologist"))
			{
				sql_q_doc="select * from gynecologist_slot where name=?";
				display_data(sql_q_doc);
			}
			else if(this.specality.equals("Dentist"))
			{
				sql_q_doc="select * from dentist_slot where name=?";
				display_data(sql_q_doc);
			}
			else if(this.specality.equals("ENT"))
			{
				sql_q_doc="select * from ent_slot where name=?";
				display_data(sql_q_doc);
			}
			else if(this.specality.equals("Dermatologist"))
			{
				sql_q_doc="select * from skin_doctor_slot where name=?";
				display_data(sql_q_doc);
			}
			else if(this.specality.equals("Neurologist"))
			{
				sql_q_doc="select * from neurologist_slot where name=?";
				display_data(sql_q_doc);
			}
			else if(this.specality.equals("Orthopedist"))
			{
				sql_q_doc="select * from orthopedist_slot where name=?";
				display_data(sql_q_doc);
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		rb1.setFocusable(false);
		rb1.setFont(new Font("Arail",Font.BOLD,20));
		rb1.setBackground(Color.WHITE);
		
		rb2.setFocusable(false);
		rb2.setFont(new Font("Arail",Font.BOLD,20));
		rb2.setBackground(Color.WHITE);
		group_date=new ButtonGroup();
		group_date.add(rb1);
		group_date.add(rb2);
		
		l_main.setText("OMNI HOSPITALS");
		l_main.setFont(new Font("Arial",Font.BOLD,50));
		
		l_head.setText("CHOOSE YOUR SLOT");
		l_head.setFont(new Font("Arial",Font.BOLD,28));
		
		l_date.setText("Select  Date :-  ");
		l_date.setFont(new Font("Arial",Font.BOLD,20));
		
		l_slot.setFont(new Font("Arial",Font.BOLD,20));
		l_slot.setText("Select Slot :- ");
		
		try {
			if(this.specality.equals("Pediatrician"))
			{
				sql_q_doc="select * from children_doctor where name=?";
				setdata(sql_q_doc);
			}
			else if(this.specality.equals("Cardiologist"))
			{
				sql_q_doc="select * from cardiologist where name=?";
				setdata(sql_q_doc);
			}
			else if(this.specality.equals("Gynecologist"))
			{
				sql_q_doc="select * from gynecologist where name=?";
				setdata(sql_q_doc);
			}
			else if(this.specality.equals("Dentist"))
			{
				sql_q_doc="select * from dentist where name=?";
				setdata(sql_q_doc);
			}
			else if(this.specality.equals("ENT"))
			{
				sql_q_doc="select * from ent where name=?";
				setdata(sql_q_doc);
			}
			else if(this.specality.equals("Dermatologist"))
			{
				sql_q_doc="select * from skin_doctor where name=?";
				setdata(sql_q_doc);
			}
			else if(this.specality.equals("Neurologist"))
			{
				sql_q_doc="select * from neurologist where name=?";
				setdata(sql_q_doc);
			}
			else if(this.specality.equals("Orthopedist"))
			{
				sql_q_doc="select * from orthopedist where name=?";
				setdata(sql_q_doc);
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		while(i<4)
		{
			ar[i].addActionListener(this);
			i=i+1;
		}
		
		b.setText("BOOK");
		b.setBackground(Color.GREEN);
		b.setFocusable(false);
		b.setSize(20, 30);
		b.setFont(new Font("Arial",Font.BOLD,20));
		b.setActionCommand("BOOK");
		b.addActionListener(this);
		
		p_top.setBounds(0,0,1600,80);
		p_top.setBackground(new Color(169, 241, 223));
		p_top.add(l_main);
	
		p_center1.setBackground(Color.WHITE);
		p_center1.setBounds(200,200,350,400);
		p_center1.setLayout(new GridLayout(2,1,0,0));
		
		p_center_choose.add(l_head);
		p_center_choose.setBackground(Color.WHITE);
		p_center_choose.setBounds(5,0,320,35);
		
		p_center_date.add(l_date);
		p_center_date.setBackground(Color.WHITE);
		p_center_date.add(rb1);
		p_center_date.add(l_empty_date1);
		p_center_date.add(rb2);
		p_center_date.setBounds(0,80,400,100);
		p_center_date.setLayout(new GridLayout(2,2,0,0));
		
		p_center_slot.add(l_slot);
		p_center_slot.add(p_slot);
		p_center_slot.setBackground(Color.WHITE);
		p_center_slot.setBounds(0,200,430,200);
		p_center_slot.setLayout(new GridLayout(1,2,0,0));
		
		p_slot.setBackground(Color.WHITE);
		p_slot.setLayout(new GridLayout(4,1,0,0));
		
		p_center2.add(p_center_choose);
		p_center2.add(p_center_date);
		p_center2.add(p_center_slot);
		p_center2.add(p_last);
		
		p_center2.setBackground(Color.WHITE);
		p_center2.setBounds(750,150,600,600);
		p_center2.setLayout(null);
		
		p_last.setBounds(100,420,110,50);
		p_last.setBackground(Color.WHITE);
		p_last.add(b);
		
		f.add(p_top,BorderLayout.NORTH);
		f.add(p_center1);
		f.add(p_center2);
		
		f.setTitle("Slots");
		f.getContentPane().setBackground(Color.white);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		f.setLayout(new BorderLayout());
		f.setVisible(true);
		
	}

	void display_data(String s)
	{
		int j=0;
		try {
			
			stmt1=con.prepareStatement(s);
			stmt1.setString(1,this.doctor_name);
			rs3=stmt1.executeQuery();
		while(rs3.next())
		{
			ar[j]=new JRadioButton(rs3.getString(3));
			ar[j].setFocusable(false);
			ar[j].setFont(new Font("Arail",Font.BOLD,20));
			ar[j].setBackground(Color.WHITE);
			group_slot.add(ar[j]);
			p_slot.add(ar[j]);
			j=j+1;
		}
		}
	catch(Exception ex)
	{
		System.out.println(ex);
	}
}
	
	void setdata(String s)
	{
		try {
		stmt2=con.prepareStatement(s);
		stmt2.setString(1,this.doctor_name);
		ResultSet rs4=stmt2.executeQuery();
		rs4.next();
		image=new ImageIcon(rs4.getString(2));
		Image image1 = image.getImage();
		Image new_img=image1.getScaledInstance(200, 200,Image.SCALE_SMOOTH);
		image = new ImageIcon(new_img);
		l_image.setIcon(image);
		p_center1.add(l_image);
		l_info1.setText("NAME       : "+rs4.getString(1));
		l_info1.setFont(new Font("Arial",Font.PLAIN,20));
		l_info2.setText("SPECALITY : "+rs4.getString(3));
		l_info2.setFont(new Font("Arial",Font.PLAIN,20));
		l_info3.setText("EXPERIENCE : "+rs4.getString(4));
		l_info3.setFont(new Font("Arial",Font.PLAIN,20));
		p_info.add(l_empty_info1);
		p_info.add(l_info1);
		p_info.add(l_info2);
		p_info.add(l_info3);
		p_info.add(l_empty_info2);
		p_info.setBackground(null);
		p_info.setLayout(new GridLayout(5,1,0,0));
		p_center1.add(p_info);
		
	}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
		if(e.getSource()==b)
		{
			try {
			JButton button=(JButton)e.getSource();
			if(date.equals("empty"))
			{
				op.showMessageDialog(null,"Please select a date","error",JOptionPane.ERROR_MESSAGE);
			}
			else if(slot.equals("empty"))
			{
				op.showMessageDialog(null,"Please select a slot","error",JOptionPane.ERROR_MESSAGE);
				
			}
			else {
				stmt3=con.prepareStatement("select count(*) from booked_data where book_date=? and time_slot=? and doctor_name=?");
				stmt3.setString(1,date);
				stmt3.setString(2,slot);
				stmt3.setString(3,doctor_name);
				rs4=stmt3.executeQuery();
				if(rs4.next()!=false)
				{
				if(rs4.getInt(1)<6)
				{
					count=rs4.getInt(1);
					Frame_last f=new Frame_last(date,slot,specality,doctor_name);
				}
				else {
					op.showMessageDialog(null,"Slots are filled Please select another slot .","error",JOptionPane.ERROR_MESSAGE);
				}
				}
				else {
					Frame_last f=new Frame_last(date,slot,specality,doctor_name);
				}
				rs4.close();
				
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		}
		else {
		if(e.getSource()==rb1)
		{
			date=rb1.getText();
			group_slot.clearSelection();
			slot="empty";
		}
		else if(e.getSource()==rb2)
		{
			date=rb2.getText();
			group_slot.clearSelection();
			slot="empty";
		}
		else
		{
			JRadioButton rb=(JRadioButton)e.getSource();
			if(date!="empty")
		{
			int x=Integer.parseInt(rb.getText().substring(0,rb.getText().indexOf(":")));
			
				if(rb.getText().substring(5,7).equals("PM") && x!=12)
				{
					x=x+12;
				}
			
			if(rb==ar[0])
			{
				if(date==rb1.getText() && Integer.parseInt(current_time)<=x)
				{
				slot=rb.getText();
				}
				else if(date==rb1.getText() && Integer.parseInt(current_time)>x)
				{
					op.showMessageDialog(null,"Slot not available","error",JOptionPane.ERROR_MESSAGE);
					group_slot.clearSelection();
					slot="empty";
				}
				else
				{
					slot=rb.getText();	
				}
			}
			else if(rb==ar[1])
			{
				if(date==rb1.getText() && Integer.parseInt(current_time)<=x)
				{
				slot=rb.getText();
				}
				else if(date==rb1.getText() && Integer.parseInt(current_time)>x)
				{
					op.showMessageDialog(null,"Slot not available","error",JOptionPane.ERROR_MESSAGE);
					group_slot.clearSelection();
					slot="empty";
				}
				else
				{
					slot=rb.getText();	
				}
			}
			else if(rb==ar[2])
			{
				
				if(date==rb1.getText() && Integer.parseInt(current_time)<=x)
				{
				slot=rb.getText();
				}
				else if(date==rb1.getText() && Integer.parseInt(current_time)>x)
				{
					op.showMessageDialog(null,"Slot not available","error",JOptionPane.ERROR_MESSAGE);
					group_slot.clearSelection();
					slot="empty";
				}
				else
				{
					slot=rb.getText();	
				}
				
			}
			else if(rb==ar[3])
			{
				
				if(date==rb1.getText() && Integer.parseInt(current_time)<=x)
				{
				slot=rb.getText();
				}
				else if(date==rb1.getText() && Integer.parseInt(current_time)>x)
				{
					op.showMessageDialog(null,"Slot not available","error",JOptionPane.ERROR_MESSAGE);
					group_slot.clearSelection();
					slot="empty";
				}
				else
				{
					slot=rb.getText();	
				}
			}
			else if(rb==ar[4])
			{
				
				if(date==rb1.getText() && Integer.parseInt(current_time)<=x)
				{
				slot=rb.getText();
				}
				else if(date==rb1.getText() && Integer.parseInt(current_time)>x)
				{
					op.showMessageDialog(null,"Slot not available","error",JOptionPane.ERROR_MESSAGE);
					group_slot.clearSelection();
					slot="empty";
				}
				else
				{
					slot=rb.getText();	
				}
			}
			else if(rb==ar[5])
			{
				
				if(date==rb1.getText() && Integer.parseInt(current_time)<=x)
				{
				slot=rb.getText();
				}
				else if(date==rb1.getText() && Integer.parseInt(current_time)>x)
				{
					op.showMessageDialog(null,"Slot not available","error",JOptionPane.ERROR_MESSAGE);
					group_slot.clearSelection();
					slot="empty";
				}
				else
				{
					slot=rb.getText();	
				}
			}
			else if(rb==ar[6])
			{
				
				if(date==rb1.getText() && Integer.parseInt(current_time)<=x)
				{
				slot=rb.getText();
				}
				else if(date==rb1.getText() && Integer.parseInt(current_time)>x)
				{
					op.showMessageDialog(null,"Slot not available","error",JOptionPane.ERROR_MESSAGE);
					group_slot.clearSelection();
					slot="empty";
				}
				else
				{
					slot=rb.getText();	
				}
			}
			else if(rb==ar[7])
			{
				
				if(date==rb1.getText() && Integer.parseInt(current_time)<=x)
				{
				slot=rb.getText();
				}
				else if(date==rb1.getText() && Integer.parseInt(current_time)>x)
				{
					op.showMessageDialog(null,"Slot not available","error",JOptionPane.ERROR_MESSAGE);
					group_slot.clearSelection();
					slot="empty";
				}
				else
				{
					slot=rb.getText();	
				}
			}
			else if(rb==ar[8])
			{
				
				if(date==rb1.getText() && Integer.parseInt(current_time)<=x)
				{
				slot=rb.getText();
				}
				else if(date==rb1.getText() && Integer.parseInt(current_time)>x)
				{
					op.showMessageDialog(null,"Slot not available","error",JOptionPane.ERROR_MESSAGE);
					group_slot.clearSelection();
					slot="empty";
				}
				else
				{
					slot=rb.getText();	
				}
			}
			else if(rb==ar[9])
			{
				
				if(date==rb1.getText() && Integer.parseInt(current_time)<=x)
				{
				slot=rb.getText();
				}
				else if(date==rb1.getText() && Integer.parseInt(current_time)>x)
				{
					op.showMessageDialog(null,"Slot not available","error",JOptionPane.ERROR_MESSAGE);
					group_slot.clearSelection();
					slot="empty";
				}
				else
				{
					slot=rb.getText();	
				}
			}
			else if(rb==ar[10])
			{
				
				if(date==rb1.getText() && Integer.parseInt(current_time)<=x)
				{
				slot=rb.getText();
				}
				else if(date==rb1.getText() && Integer.parseInt(current_time)>x)
				{
					op.showMessageDialog(null,"Slot not available","error",JOptionPane.ERROR_MESSAGE);
					group_slot.clearSelection();
					slot="empty";
				}
				else
				{
					slot=rb.getText();	
				}
			}
			else if(rb==ar[11])
			{
				
				if(date==rb1.getText() && Integer.parseInt(current_time)<=x)
				{
				slot=rb.getText();
				}
				else if(date==rb1.getText() && Integer.parseInt(current_time)>x)
				{
					op.showMessageDialog(null,"Slot not available","error",JOptionPane.ERROR_MESSAGE);
					group_slot.clearSelection();
					slot="empty";
				}
				else
				{
					slot=rb.getText();	
				}
			}
		}
		else
		{
			op.showMessageDialog(null,"Please select a date ","error",JOptionPane.ERROR_MESSAGE);
			group_slot.clearSelection();
		}
		}
		
	}
	}
}
