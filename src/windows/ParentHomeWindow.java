package windows;

import java.awt.*;
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
/*
 * Författare: Angelina Fransson
 */
public class ParentHomeWindow extends JPanel implements ActionListener {
	private Account account; 
	private ParentProfile parentProfile;

	private JButton btnSettings;
	private JButton btnChores;
	private JButton btnRewards;
	private JButton btnHelpManual;
	private JLabel lblPicture;
	private JButton btnProfileSymbol;
	private ImageIcon dustBallImage;

	public ParentHomeWindow () {

		start();

	}

	private void start() {
		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);
		InitializeGUI();
		this.setVisible(true);

	}
	public Account getAccount () {
		return account;
	}
	public ParentProfile getParentProfile () {
		return parentProfile; 
	}
	private void InitializeGUI() {

		this.setBounds(6,6, 381, 500);
		this.setLayout(null);
		this.setBackground(Color.YELLOW);


		JPanel pnlTop = new JPanel();
		pnlTop.setBounds(12, 17, 358, 80);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.YELLOW);
		
		btnProfileSymbol = new JButton ();
		dustBallImage = new ImageIcon ("images/20x20Dammtuss.jpg");
		btnProfileSymbol.setBounds(125, 16, 90, 90);
		btnProfileSymbol.setIcon(dustBallImage);
		
		pnlTop.add(btnProfileSymbol);
		
		lblPicture = new JLabel ("images/NinjaReducedSize3.png");
		pnlTop.add(lblPicture); //fixa 


		JPanel pnlMiddle = new JPanel();
		pnlMiddle.setBounds(12, 130, 358, 140);
		pnlMiddle.setLayout(new GridBagLayout());
		pnlMiddle.setBackground(Color.YELLOW);
		GridBagConstraints c = new GridBagConstraints();

		btnSettings = new JButton("Inställningar");
		btnSettings.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnSettings.setBounds(1, 16, 90, 50);
		pnlMiddle.add(btnSettings);

		btnChores = new JButton ("Sysslor");
		btnChores.setFont(new Font ("SansSerif", Font.PLAIN, 14));
		btnChores.setBounds(40, 16, 90, 50);
		pnlMiddle.add (btnChores);

		btnRewards = new JButton ("Belöningar");
		btnRewards.setFont(new Font ("SansSerif", Font.PLAIN, 14));
		btnRewards.setBounds(80, 16, 90, 50);
		pnlMiddle.add (btnRewards);

		btnHelpManual = new JButton ("Hjälp/Manual"); 
		btnHelpManual.setFont(new Font ("SansSerif", Font.PLAIN, 14));
		btnHelpManual.setBounds(120, 16, 90, 50);
		pnlMiddle.add(btnHelpManual);

		//Behövs göras om så alla är exakt lika långa
//		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = -4;
		c.weighty = 1;
		pnlMiddle.add(btnSettings, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = -4;
		c.weighty = 1;

		pnlMiddle.add(btnChores, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = -4;
		c.weighty = 1;


		pnlMiddle.add(btnRewards, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = -4;
		c.weighty = 1;
		pnlMiddle.add(btnHelpManual, c);


		JPanel pnlBottom = new JPanel();
		pnlBottom.setBounds(12, 300, 358, 180);
		pnlBottom.setLayout(null);
		pnlBottom.setBackground(Color.YELLOW);



		this.add(pnlTop);
		this.add(pnlMiddle);
		this.add(pnlBottom);
	}



	public static void main (String [] args) {
		JFrame frame = new JFrame ();
		ParentHomeWindow phw = new ParentHomeWindow ();
		frame.add(phw);
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


