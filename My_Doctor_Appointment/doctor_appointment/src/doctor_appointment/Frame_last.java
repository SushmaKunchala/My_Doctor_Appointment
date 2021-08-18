package doctor_appointment;
import java.util.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;


public class Frame_last extends Connection_class implements ActionListener {

	String date,time,tag,strdate="",specality,doctor_name;
	JFrame f;
	JTextField tf1,tf2,tf3,tf4;
	JRadioButton rb1,rb2;
	JButton b;
	JPanel p_top,p_top1,p_center,p_info1,p_info2,p_info3,p_info4,p_info5,p_bottom,p_center_main;
	JLabel l1,l_1,l_2,l_3,l_4,l_5,l_empty,l_empty1,l_empty2,l_empty3,l_empty4,l_head,l_empty5,l_empty6;
	ButtonGroup group_gender;
	Connection con;
	Connection_class db;
	PreparedStatement stmt;
	String gender="empty";
	JOptionPane op;
	SqlDateModel model;
	Properties p;
	JDatePanelImpl panel;
	JDatePickerImpl datepicker;
	
	Frame_last(String date,String time,String specality,String doctor_name)
	{
		this.specality=specality;
		this.doctor_name=doctor_name;
		model=new SqlDateModel();
		p=new Properties();
		panel=new JDatePanelImpl(model,p);
		datepicker= new JDatePickerImpl(panel,new AbstractFormatter()
				{
			@Override
			public Object stringToValue(String text) throws ParseException {
				// TODO Auto-generated method stub
				return "";
			}

			@Override
			public String valueToString(Object value) throws ParseException {
				// TODO Auto-generated method stub
				if(value!=null)
				{
				Calendar cal=(Calendar)value;
				SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
				strdate=format.format(cal.getTime());
				return strdate;
				}
				return "";
			}});
		db=new Connection_class();
		this.date=date;
		this.time=time;
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		rb1=new JRadioButton("Male");
		rb2=new JRadioButton("Female");
		
		b=new JButton();
		l1=new JLabel();
		l_1=new JLabel();
		l_2=new JLabel();
		l_3=new JLabel();
		l_4=new JLabel();
		l_5=new JLabel();
		l_empty=new JLabel();
		l_empty1=new JLabel();
		l_empty2=new JLabel();
		l_empty3=new JLabel();
		l_empty4=new JLabel();
		l_empty5=new JLabel();
		l_empty6=new JLabel();
		l_head=new JLabel();
		
		p_top=new JPanel();
		p_top1=new JPanel();
		p_center=new JPanel();
		p_info1=new JPanel();
		p_info2=new JPanel();
		p_info3=new JPanel();
		p_info4=new JPanel();
		p_info5=new JPanel();
		p_bottom=new JPanel();
		p_center_main=new JPanel();
		
		p.put("text.day", "Day");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		
		f=new JFrame();
	
		rb1.setBackground(Color.WHITE);
		rb1.setFocusable(false);
		rb1.addActionListener(this);
		
		rb2.setBackground(Color.WHITE);
		rb2.setFocusable(false);
		rb2.addActionListener(this);
		
		p_center.add(l_empty5);
		p_center.add(l_empty6);
		l_1.setText("FIRST NAME : ");
		l_1.setFont(new Font("Arail",Font.BOLD,20));
		p_center.add(l_1);
		
		tf1.setBounds(0, 20, 200, 30);
		p_info1.add(tf1);
		p_info1.setLayout(null);
		p_info1.setBackground(Color.WHITE);
		p_center.add(p_info1);
		
		l_5.setText("LAST NAME : ");
		l_5.setFont(new Font("Arail",Font.BOLD,20));
		p_center.add(l_5);
		
		tf4.setBounds(0,20,200,30);
		p_info5.add(tf4);
		p_info5.setLayout(null);
		p_info5.setBackground(Color.WHITE);
		p_center.add(p_info5);
		
		l_4.setText("DATE OF BIRTH : ");
		l_4.setFont(new Font("Arail",Font.BOLD,20));
		p_center.add(l_4);
		
		datepicker.setBounds(0, 30, 200, 30);
		datepicker.setBackground(Color.WHITE);
		p_info4.add(datepicker);
		p_info4.setBackground(Color.WHITE);
		p_info4.setLayout(null);
		p_center.add(p_info4);
		
		l_2.setText("GENDER : ");
		l_2.setFont(new Font("Arail",Font.BOLD,20));
		p_center.add(l_2);
		rb1.setFont(new Font("Arail",Font.BOLD,20));
		rb1.setBounds(5,10,100,25);
		rb2.setFont(new Font("Arail",Font.BOLD,20));
		rb2.setBounds(110,10,100,25);
		group_gender=new ButtonGroup();
		group_gender.add(rb1);
		group_gender.add(rb2);
		
		
		p_info2.add(rb1);
		p_info2.add(rb2);
		//p_info2.add(l_empty);
		p_info2.setLayout(null);
		p_info2.setBackground(Color.WHITE);
		p_center.add(p_info2);
	
		l_3.setText("MOBILE NUMBER : ");
		l_3.setFont(new Font("Arail",Font.BOLD,20));
		p_center.add(l_3);
		
		tf2.setBounds(0, 20, 200, 30);
		p_info3.add(tf2);
		p_info3.setLayout(null);
		p_info3.setBackground(Color.WHITE);
		p_center.add(p_info3);
		
		b.setBackground(Color.GREEN);
		b.setText("SUBMIT");
		b.setFont(new Font("Arail",Font.BOLD,20));
		b.setBounds(240, 400, 150, 30);
		b.addActionListener(this);
	
		l1.setText("OMNI HOSPITALS");
		l1.setFont(new Font("Arial",Font.BOLD,50));
		
		l_head.setText("Enter your Details");
		l_head.setFont(new Font("Arial",Font.BOLD,30));
		
		p_top.setBackground(new Color(169, 241, 223));
		p_top.setBounds(0,0,1600, 100);
		p_top.add(l1);
		
		p_top1.setBackground(Color.WHITE);
		p_top1.setBounds(0,150,1600, 100);
		p_top1.add(l_head);
		
		p_center.setBackground(Color.WHITE);
		p_center.setBounds(60, 10, 520, 350);
		p_center.setLayout(new GridLayout(6,2,0,0));
		
		p_center_main.add(p_center);
		p_center_main.add(b);
		p_center_main.setBounds(500,270,620,480);
		p_center_main.setBackground(Color.WHITE);
		p_center_main.setLayout(null);
		p_center_main.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		p_bottom.setLayout(null);
		p_bottom.setBackground(Color.WHITE);
		p_bottom.setBounds(0, 530, 1000, 60);
		
		
		f.add(p_top);
		f.add(p_top1);
		f.add(p_center_main);
		f.add(p_bottom);
		f.setTitle("Details");
		f.getContentPane().setBackground(Color.white);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		f.setLayout(new BorderLayout());
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b)
		{
			if(tf1.getText().isEmpty())
			{
				op.showMessageDialog(null,"Please enter your name ","error",JOptionPane.ERROR_MESSAGE);
			}
			else if(strdate=="")
			{
				op.showMessageDialog(null,"Please give your Date of Birth ","error",JOptionPane.ERROR_MESSAGE);
			}
			else if(gender.equals("empty"))
			{
				op.showMessageDialog(null,"Please select your gender","error",JOptionPane.ERROR_MESSAGE);
			}
			else if(tf2.getText().isEmpty())
				{
				op.showMessageDialog(null,"Please enter your 10 digit mobile number ","error",JOptionPane.ERROR_MESSAGE);
				}
			else if(tf2.getText().length()!=10)
			{
				op.showMessageDialog(null,"Please enter your 10 digit mobile number correctly ","error",JOptionPane.ERROR_MESSAGE);
			}
			else if(tf2.getText().length()==10)
			{
				int c=0;
			for(int i=0;i<tf2.getText().length();i++)
			{
				Boolean flag = Character.isDigit(tf2.getText().charAt(i));
				if(!flag)
				{
					op.showMessageDialog(null,"Please enter your 10 digit mobile number correctly ","error",JOptionPane.ERROR_MESSAGE);
					c=1;
					break;
				}
			}
			if(c==0)
			{
				try {
					if(gender.equals("Male"))
					{
						tag="Mr.";
					}
					else if(gender.equals("Female"))
					{
						tag="Miss. ";
					}
					int res=op.showConfirmDialog(f," Do you want to confirm your booking ? ");
					if(res==op.YES_OPTION)
					{
					con=db.ConnectDB();
					stmt=con.prepareStatement("insert into booked_data values(?,?,?,?,?,?,?,?)");
					stmt.setString(1,tf4.getText()+" "+tf1.getText());
					stmt.setString(2,gender);
					stmt.setString(3, tf2.getText());
					stmt.setString(4,date);
					stmt.setString(5,time);
					stmt.setString(6,strdate);
					stmt.setString(7,specality);
					stmt.setString(8,doctor_name);
					stmt.executeUpdate();
					con.commit();
					op.showMessageDialog(null,tag+" "+tf4.getText()+" your booking is successful ","success",JOptionPane.PLAIN_MESSAGE);
					f.dispose();
					}
					
					
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
			}
			}
		}
		else {
			if(e.getSource()==rb1)
			{
				gender=rb1.getText();
			}
			else if(e.getSource()==rb2)
			{
				gender=rb2.getText();
			}
		}
	}
}
