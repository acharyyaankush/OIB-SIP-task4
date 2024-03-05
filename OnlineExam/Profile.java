import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ntxt;
	private JTextField idtxt;
	private JTextField ptxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Profile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PROFILE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(310, 0, 109, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(205, 54, 152, 29);
		contentPane.add(lblNewLabel_1);
		
		ntxt = new JTextField();
		ntxt.setBounds(401, 54, 198, 29);
		contentPane.add(ntxt);
		ntxt.setColumns(10);
		ntxt.setText(MyData.names.get(MyData.loggedInIndex));
		
		JLabel lblNewLabel_2 = new JLabel("Your Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(204, 134, 180, 34);
		contentPane.add(lblNewLabel_2);
		
		idtxt = new JTextField();
		idtxt.setBounds(401, 97, 198, 29);
		contentPane.add(idtxt);
		idtxt.setColumns(10);
		idtxt.setText(MyData.ids.get(MyData.loggedInIndex));
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id= idtxt.getText().toString();
				String n= ntxt.getText().toString();
				String p= ptxt.getText().toString();
				
				if(id.equals("") || n.equals("") || p.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please fill all the feilds");
					
				}
				else
				{
					MyData.ids.set(MyData.loggedInIndex, id);
					MyData.names.set(MyData.loggedInIndex, n);
					MyData.passwords.set(MyData.loggedInIndex, p);
					
					
					JOptionPane.showMessageDialog(null, "Your Profile is updated...!!!");
					Dashboard obj = new Dashboard();
					obj.setVisible(true);
					
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					obj.setLocation(dim.width/2-obj.getSize().width/2, dim.height/2-obj.getSize().height/2);
					
					setVisible(false);
				}
				
				
			}
		});
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setForeground(SystemColor.textHighlightText);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(302, 201, 164, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("User id:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(205, 95, 190, 29);
		contentPane.add(lblNewLabel_3);
		
		ptxt = new JTextField();
		ptxt.setBounds(401, 137, 198, 34);
		contentPane.add(ptxt);
		ptxt.setColumns(10);
		ptxt.setText(MyData.passwords.get(MyData.loggedInIndex));
	}
}