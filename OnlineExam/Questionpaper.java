Questionpaper.java


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Questionpaper extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JButton btnNewButton;
	JLabel lblNewLabel;
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnNewRadioButton_1;
	JRadioButton rdbtnNewRadioButton_2;
	JRadioButton rdbtnNewRadioButton_3;
	JButton btnNewButton_1;
	ButtonGroup bg;
	
	//Timer
	JButton  showTimer;
	private Timer timer;
    private int countdownSeconds;
	
	int index=0;
	
	String arr[][] = {
			{"1. Which component is used to compile, debug and execute the java programs?", "a) JRE" ,"b) JIT", "c) JDK", "d) JVM","c"},
			{"2. Select the valid statement.", "char ch[]=new char(5)" ,"char ch[]=new char[5]", "char ch[]=new char()", "char ch[]=new char[]","b"},
			{"3. Number of primitive data types in Java are?", "6" ,"7", "8", "9","c"},
			{"4. What makes the Java platform independent?", "a) Advanced programming language" ,"b) It uses bytecode for execution", "c) Class compilation", "d) All of these","b"},
			{"5. Which environment variable is used to set the java path?", "a) MAVEN_Path" ,"b) JavaPATH", "c) JAVA", "d) JAVA_HOME","d"},
	};

	private JLabel lblNewLabel_1;
	private JButton btnNewButton_2;
	
	String userAnswer[] = {"", "", "", "", ""};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int examDurationSeconds = 1 * 30; // 1 hour exam duration
					Questionpaper frame = new Questionpaper(examDurationSeconds);
					frame.setVisible(true);
					
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void displayQue(){
		
		bg.clearSelection();
		
		if(userAnswer[index]!="")
		{
			if(arr[index][1].equals(userAnswer[index]))
			{
				rdbtnNewRadioButton.setSelected(true);
			}
			if(arr[index][2].equals(userAnswer[index]))
			{
				rdbtnNewRadioButton_1.setSelected(true);
			}
			if(arr[index][3].equals(userAnswer[index]))
			{
				rdbtnNewRadioButton_2.setSelected(true);
			}
			if(arr[index][4].equals(userAnswer[index]))
			{
				rdbtnNewRadioButton_3.setSelected(true);
			}
		}
		
	
		lblNewLabel.setText(arr[index][0]);
		rdbtnNewRadioButton.setText(arr[index][1]);
		rdbtnNewRadioButton_1.setText(arr[index][2]);
		rdbtnNewRadioButton_2.setText(arr[index][3]);
		rdbtnNewRadioButton_3.setText(arr[index][4]);
		if(index == 0) 
		{
			btnNewButton.setVisible(false);	
			btnNewButton_1.setBounds(311, 205, 102, 33);
		}
		else
		{
			btnNewButton.setVisible(true);
			btnNewButton_1.setBounds(534, 205, 102, 33);
		}
		
		
		if(arr.length-1 == index)
		{
			btnNewButton_1.setVisible(false);
			btnNewButton_2.setVisible(true);
			
		}
		else
		{
			btnNewButton_1.setVisible(true);
			btnNewButton_2.setVisible(false);
				
		}
		
		
	}
	
	public void checkAnswer()
	{
		String uans = "";
		if(rdbtnNewRadioButton.isSelected())
		{
			uans = "a";
		}
		else if(rdbtnNewRadioButton_1.isSelected())
		{
			uans = "b";
		}
		else if(rdbtnNewRadioButton_2.isSelected())
		{
			uans =	"c";
		}
		else if(rdbtnNewRadioButton_3.isSelected())
		{
			uans = "d";
		}
		userAnswer[index] = uans;
	}
	
	 private void updateCountdownLabel() {
	        
	        int minutes = (countdownSeconds % 3600) / 60;
	        int seconds = countdownSeconds % 60;
	        String timeString = String.format("%02d:%02d Left",minutes, seconds);
	        showTimer.setText(timeString);
	    }
	
	/**
	 * Create the frame.
	 */
	public Questionpaper(int seconds) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 316);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Previous");
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setForeground(SystemColor.window);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAnswer();
				index--;
				displayQue();
			}
		});
		btnNewButton.setBounds(38, 205, 112, 33);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Next");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAnswer();
				index++;
				displayQue();			
				}
		});
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setForeground(SystemColor.window);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(534, 205, 102, 33);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(48, 10, 661, 36);
		contentPane.add(lblNewLabel);
		
		showTimer = new JButton("Time Left: 10:00");
		showTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		showTimer.setFont(new Font("Tahoma", Font.BOLD, 14));
		showTimer.setEnabled(false);
		showTimer.setBounds(559, 69, 150, 36);
		contentPane.add(showTimer);
		
		//Timer
		countdownSeconds = seconds;
		updateCountdownLabel();
		
		timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countdownSeconds--;
                if (countdownSeconds >= 0) {
                    updateCountdownLabel();
                } else {
                    timer.stop();
                    JOptionPane.showMessageDialog(Questionpaper.this, "Time's up!");
                    
                    checkAnswer();
    				
    				int marks = 0;
    				
    				for(int i=0; i<userAnswer.length; i++)
    				{
    					
    					if(userAnswer[i].trim().equals((arr[i][5]).trim()))
    					{
//    					System.out.println(userAnswer[i]+" : "+arr[i][5]);
    						marks++;
    					}
    				}
    				
    				
    				
    				JOptionPane.showMessageDialog(null, "Total Marks: "+marks);
    				
    				//REDIRECT TO THE DASHBOARD
    				Dashboard obj = new Dashboard();
    				obj.setVisible(true);
    				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    				obj.setLocation(dim.width/2-obj.getSize().width/2, dim.height/2-obj.getSize().height/2);
    				
					
    				
                }
            }
        });
        timer.start();
		
		rdbtnNewRadioButton = new JRadioButton(" 6");
		rdbtnNewRadioButton.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnNewRadioButton.setBounds(30, 52, 517, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton(" 7");
		rdbtnNewRadioButton_1.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnNewRadioButton_1.setBounds(30, 84, 523, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton(" 8");
		rdbtnNewRadioButton_2.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnNewRadioButton_2.setBounds(30, 122, 517, 21);
		contentPane.add(rdbtnNewRadioButton_2);
		
	    rdbtnNewRadioButton_3 = new JRadioButton(" 9");
	    rdbtnNewRadioButton_3.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnNewRadioButton_3.setBounds(30, 160, 517, 21);
		contentPane.add(rdbtnNewRadioButton_3);
		
		bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);
		bg.add(rdbtnNewRadioButton_3);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 10, 45, 36);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAnswer();
				
				int marks = 0;
				
				for(int i=0; i<userAnswer.length; i++)
				{
					
					if(userAnswer[i].trim().equals((arr[i][5]).trim()))
					{
						marks++;
					}
				}
				
				
				
				JOptionPane.showMessageDialog(null, "Total Marks: "+marks);
				
				//REDIRECT TO THE DASHBOARD
				Dashboard obj = new Dashboard();
				obj.setVisible(true);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				obj.setLocation(dim.width/2-obj.getSize().width/2, dim.height/2-obj.getSize().height/2);
				
				
			}
		});
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(534, 207, 128, 29);
		contentPane.add(btnNewButton_2);
		
		displayQue();
	}

	
}