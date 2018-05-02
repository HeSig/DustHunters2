package windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import profiles.Account;
import profiles.ParentProfile;
/** 
 * KLAR FÖR HENRIK ATT PILLA I! 
 * Hit kommer man om man trycker på profilknappen.
 * 
 * Trycker man på de olika dammtussarna ska man komma till deras inställningar. 
 * @author Angelina Fransson
 *
 */

public class ParentProfileWindow extends JPanel implements ActionListener {
	private Account account; 
	private ParentProfile parentProfile;
	private JLabel lblProfile; 
	
	private JButton btnHome; 
	private JButton btnAddChild;
	private JButton btnDeleteChild;
	private JButton btnChildProfile; 
	private JButton btnParentProfile;
	private ImageIcon dammtussParentProfile;
	private ImageIcon dammtussMaja; 

	public ParentProfileWindow () {
		start ();
	}
	
	public Account getAccount () {
		return account;
	}
	public ParentProfile getParentProfile () {
		return parentProfile; 
	}

	public void setAccount (Account account) {
		this.account = account;
	}
	public void setParentProfile (ParentProfile parentProfile) {
		this.parentProfile = parentProfile;
	}

	
	private void start() {
		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);
		InitializeGUI();
		this.setVisible(true);
		
		
	}
	private void InitializeGUI() {
		
		this.setBounds(6,6, 381, 500);
		this.setLayout(null);
		this.setBackground(Color.YELLOW);
		
		
		JPanel pnlTop = new JPanel();
		pnlTop.setBounds(12, 17, 358, 80);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.YELLOW);


		lblProfile = new JLabel("Mitt Crew");
		lblProfile.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblProfile.setBounds(105, 30, 285, 20);
		pnlTop.add(lblProfile);

		btnHome = new JButton(" Home ");
		btnHome.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnHome.setBounds(10, 16, 90, 50);
		pnlTop.add(btnHome);
		
		
		JPanel pnlMiddle = new JPanel();
		pnlMiddle.setBounds(12, 130, 358, 140);
		pnlMiddle.setLayout(new GridBagLayout());
		pnlMiddle.setBackground(Color.YELLOW);
		GridBagConstraints c = new GridBagConstraints();

		
		btnParentProfile = new JButton ();
		dammtussParentProfile = new ImageIcon ("images/dammtussParentProfile.png");
		btnParentProfile.setBounds(10, 16, 90, 50);
		btnParentProfile.setIcon(dammtussParentProfile);
		
		pnlMiddle.add(btnParentProfile);
		
		btnChildProfile = new JButton (); 
		dammtussMaja = new ImageIcon ("images/dammtussMaja.png");
		btnChildProfile.setBounds(350, 100, 90, 100);
		btnChildProfile.setIcon(dammtussMaja);
		pnlMiddle.add(btnChildProfile);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 20; 
		c.gridy = 100; 
		pnlMiddle.add(btnParentProfile, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 100; 
		c.gridy = 100;
		
		pnlMiddle.add(btnChildProfile, c);


		JPanel pnlBottom = new JPanel();
		pnlBottom.setBounds(12, 400, 358, 180);
		pnlBottom.setLayout(null);
		pnlBottom.setBackground(Color.YELLOW);
		
		
		btnAddChild = new JButton(" Lägg till ett barn ");
		btnAddChild.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnAddChild.setBackground(Color.GREEN);
		btnAddChild.setForeground(Color.BLACK);
		btnAddChild.setBounds(10, 16, 300, 50);
		pnlBottom.add(btnAddChild);
		
		
		btnDeleteChild = new JButton(" Redigera/Ta bort ett barn ");
		btnDeleteChild.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnDeleteChild.setBackground(Color.RED);
		btnDeleteChild.setForeground(Color.BLACK);
		btnDeleteChild.setBounds(10, 100, 300, 50);
		pnlBottom.add(btnDeleteChild);
	
		
		this.add(pnlTop);
		this.add(pnlMiddle);
		this.add(pnlBottom);
	}

	public static void main (String [] args) {
		JFrame frame = new JFrame ();
		ParentProfileWindow ppw = new ParentProfileWindow ();
		frame.add(ppw);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension (400,600));
	}
	@Override

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
 }
