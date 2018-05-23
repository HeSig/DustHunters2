package windows;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * This GUI-class presents the "story" of a specific chore to the child. The
 * intention has been to make the completion of the chore more playful and
 * inspiring to the child.
 * 
 * @author Kasper
 *
 */

public class TaskStoryWindow extends JPanel implements ActionListener {

	private JLabel lblTitle;
	private String text = new String("Schh!" + "\nHör du mig, Dammjägare? Vi behöver din hjälp," + "\nDammjägar-ninjan."
			+ "\nDen onda Smutselina har varit i farten igen, "
			+ "\noch vi måste snabbt få bort hennes spår i vardagsrummet   " + "\ninnan hon märker något. "
			+ "\nSmutselina hör lika bra som en fladdermus, " + "\nså du måste vara tyst och försiktig. "
			+ "\nPå med masken, nu kör vi!");
	private JButton btnHome = new JButton();
	private JButton btnProfile = new JButton();
	private ImageIcon dustBallImage;
	private JLabel lblDustSymbol;
	private ClientController controller;

	public TaskStoryWindow(ClientController clientController) throws IOException {
		this.setClientController(clientController);
		start();
	}

	public void start() throws IOException {

		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);
		InitializeGUI();
		this.setVisible(true);
	}

	/**
	 * Method that sets up the various graphical components of the window. Panels:
	 * Main, Top and Middle.
	 * 
	 * @throws IOException
	 */

	public void InitializeGUI() throws IOException {

		// Main Panel
		this.setBounds(6, 6, 381, 500);
		this.setLayout(null);
		this.setBackground(Color.YELLOW);

		// Top Panel
		JPanel pnlTop = new JPanel();

		pnlTop.setBounds(12, 17, 358, 80);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.YELLOW);

		lblTitle = new JLabel("Tjenare!");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblTitle.setBounds(145, 30, 285, 20);
		btnHome.setIcon(new ImageIcon("images/House.jpg"));
		btnHome.setBounds(5, 5, 80, 65);
		btnProfile.setIcon(new ImageIcon("images/20x20Dammtuss.jpg"));
		btnProfile.setBounds(260, 16, 90, 50);

		pnlTop.add(btnHome);
		pnlTop.add(lblTitle);
		pnlTop.add(btnProfile);

		btnHome.addActionListener(this);
		btnProfile.addActionListener(this);

		// Middle Panel
		JPanel pnlMiddle = new JPanel();

		pnlMiddle.setBounds(12, 150, 358, 360);
		pnlMiddle.setLayout(new FlowLayout());
		pnlMiddle.setBackground(Color.YELLOW);

		JTextArea textArea = new JTextArea(text);
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);

		pnlMiddle.add(scrollPane);

		dustBallImage = new ImageIcon("images/NinjaReducedSize3.png");

		lblDustSymbol = new JLabel();
		lblDustSymbol.setBounds(85, 13, 200, 160);
		lblDustSymbol.setIcon(dustBallImage);
		pnlMiddle.add(lblDustSymbol);

		this.add(pnlTop);
		this.add(pnlMiddle);
	}

	/**
	 * Handles the interaction the user does with the buttons, and redirects to
	 * either ChildHomeWindow or ChildProfileWindow.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnHome) {
			controller.setViewChildHomeWindow();
		} else if (e.getSource() == btnProfile) {
			controller.setViewChildProfileWindow();
		}
	}

	public ClientController getClientController() {
		return controller;
	}

	public void setClientController(ClientController clientController) {
		this.controller = clientController;
	}
}