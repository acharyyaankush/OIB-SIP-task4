import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textfield;
	private JTextField textfield_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 323);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setForeground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Online Examination Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(237, 22, 232, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter UserId:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(204, 71, 125, 13);
		contentPane.add(lblNewLabel_1);
		
		textfield = new JTextField();
		textfield.setBackground(SystemColor.text);
		textfield.setBounds(339, 70, 125, 19);
		contentPane.add(textfield);
		textfield.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(204, 105, 125, 13);
		contentPane.add(lblNewLabel_2);
		
		textfield_2 = new JTextField();
		textfield_2.setBackground(SystemColor.text);
		textfield_2.setBounds(339, 99, 125, 19);
		contentPane.add(textfield_2);
		textfield_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Log IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String userid = textfield.getText().toString();
				String password = textfield_2.getText().toString();
				int size = MyData.ids.size();
				int f=0;
				for(int i=0;i<size;i++)
				{
					if(MyData.ids.get(i).equals(userid) && MyData.passwords.get(i).equals(password))
					{
						f=1;
						MyData.loggedInIndex = i;
						break;
					}
				}
				
				if(f==1)
				{
					Dashboard obj = new Dashboard();
					obj.setVisible(true);
					
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					obj.setLocation(dim.width/2-obj.getSize().width/2, dim.height/2-obj.getSize().height/2);
				}
				else
				{
					JOptionPane.showMessageDialog(null,  "Sorry Invalid credentials");
					
					textfield.setText("");
					textfield_2.setText("");
				}
				
				
			}
		});
		btnNewButton.setForeground(SystemColor.textHighlightText);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(273, 153, 147, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("New User?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(237, 207, 106, 29);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Click Here");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registration obj = new Registration();
				obj.setVisible(true);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				obj.setLocation(dim.width/2-obj.getSize().width/2, dim.height/2-obj.getSize().height/2);
			}
		});
		btnNewButton_1.setForeground(SystemColor.textHighlightText);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(339, 206, 136, 31);
		contentPane.add(btnNewButton_1);
	}
}