package windows;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;

import profiles.Account;
import profiles.ChildProfile;

public class ChildTaskWindow extends AbstractWindowUI {

	private Account account;
	private ChildProfile childProfile;
	private JButton btnHome = new JButton("Home");
	private JLabel lblAssigned;
	private JLabel childName;
	private JLabel check;
	
	
	
	
	public ChildTaskWindow(String title) {
		super(title);
		setupTaskWindow();
	}
	
	public void setupTaskWindow() {		// Problem: can't seem to add components (such as
										// buttons, labels, etc) to the window created by 
		btnHome = new JButton(" Tilbaka ");
		btnHome.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnHome.setBounds(10, 10, 10, 10);
		topPanel.setLayout(null);
		
		topPanel.add(btnHome);						// the abstract class.
		
		
		
//		lblAssigned = new JLabel("Tilldelning: ");
//		lblAssigned.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
//		Border border3 = BorderFactory.createEtchedBorder();
//		lblAssigned.setBorder(border3);
		
//		middlePanel.add(lblAssigned);
		
		
		
//		frame.add(topPanel);
		
	}
		
	
	
	public static void main(String[] args) {
		ChildTaskWindow taskWindow = new ChildTaskWindow("Syssla: 1");
	}
	
	

}
