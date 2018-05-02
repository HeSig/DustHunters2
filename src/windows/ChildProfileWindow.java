package windows;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import profiles.Account;

/**
 * GUI for children's profile
 * 
 * @author Maida
 * 
 *         25/4: Reinstalled and retry. --- 27/4: Reinstalled, once again. Took
 *         >5h. --- 2/5: Reinstalled. AGAIN.
 *
 */

public class ChildProfileWindow extends JPanel {
	private Account account;
	private String name;

	private JLabel lblTitleHome; // Title, in middle of top panel
	private ImageIcon dustBallImage; // Profilepic, in the middle of middle panel
	private JButton btnProfileSymbol; // Symbol, profilepic will be inside this button

	private JLabel lblNumberOrder; //Number of tasks
	private JLabel lblLocation;
	private JLabel lblChore;
	private JLabel lblPointsForChore;

	/*
	 * Three setters and three getters for the components inside of a task (L + C +
	 * R)
	 */

	// Constructor
	public ChildProfileWindow() {
		// this.name = name;
		start();

	}

}
