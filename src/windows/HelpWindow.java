package windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
* A window that adult users will see if they click "Hjälp" (Help) in the ParentHomeWindow
 * It will give a brief description of how to navigate through the application. 
 * @author dalvig, Maida 
 *
 */

/*
 * A way to import a bigger textfile to give more detailed explation and recommendations? 
 * Scroll-function because of too much text to fit the screen? -M
 */

/**
 * 
 * @author Maida, dalvig
 *
 */

public class HelpWindow extends JPanel implements ActionListener {

	private JLabel lblTitle;
	// private String text = new String("1. Första sidan \n Tryck på huset i vänstra
	// hörnet för att komma \n till första sidan. \n 2. Din profil \n Tryck på
	// Dammtussen i högra hörnet för att \n komma till din profil. \n 3. Sysslor \n
	// Är nyttigt för barnen. \n 4. Belöningar \n Är nyttigt för själen. ");
	private String text2 = helpText();
	private JButton btnHome = new JButton();
	private JButton btnProfile = new JButton();

	private ClientController clientController;

	public HelpWindow(ClientController clientController) throws IOException {
		this.clientController = clientController;
		start();
	}

	public void start() throws IOException {

		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);
		InitializeGUI();
		this.setVisible(true);
	}

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

		lblTitle = new JLabel("Hjälp");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTitle.setBounds(120, 30, 285, 20);
		btnHome.setIcon(new ImageIcon("images/House.jpg"));
		btnHome.setBounds(5, 5, 80, 65);
		btnProfile.setIcon(new ImageIcon("images/20x20Dammtuss.jpg"));
		btnProfile.setBounds(260, 16, 90, 50);

		btnHome.addActionListener(this);
		btnProfile.addActionListener(this);

		pnlTop.add(btnHome);
		pnlTop.add(lblTitle);
		pnlTop.add(btnProfile);

		// Middle Panel
		JPanel pnlMiddle = new JPanel();

		pnlMiddle.setBounds(12, 130, 358, 280);
		pnlMiddle.setLayout(new FlowLayout());
		pnlMiddle.setBackground(Color.YELLOW);
		Border border3 = BorderFactory.createEtchedBorder();

		// TextArea and scroll-function
		JTextArea textArea = new JTextArea(text2);
		textArea.setSize(400, 550); //Scroll doesn't work when I set size - M
		textArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);

		pnlMiddle.add(scrollPane);

		this.add(pnlTop);
		this.add(pnlMiddle);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnHome) {
			clientController.setViewParentHomeWindow();
		} else if (e.getSource() == btnProfile) {
			clientController.setViewParentProfileWindow();
		}

	}

	// Method for the text. \n
	public String helpText() {
		text2 = "Välkommen till Dammjägarna! "
				+ "\n \n Du som förälder har nu skapat ett konto "
				+ "\n med föräldraprofil. För att optimera "
				+ "\n användandet av applikationen kan ni ta "
				+ "\n del av vår produkbeskrivning och manual."
				+ "\n "
				+ "\n "
				+ "För att komma runt i appen:"
				+ "\n * För att komma igång kan du skapa en"
				+ "\n föräldraprofil för din partner och för"
				+ "\n att skapa barnprofiler gör du"
				+ "\n på samma sätt. För att lägga till" //lägga till = bold
				+ " en profil trycker du på dammtussen" //en profil = bold
				+ " längst upp till höger. Som föräldraprofilen"
				+ " har du alla användarnamn och lösenord. "
				+ "\n "
				+ "\n "
				+ "* För att komma tillbaka till första sidan"
				+ " trycker du på huset längst upp till vänster."
				+ "\n "
				+ "\n "
				+ "* Under inställningar kan du ändra dina"
				+ " egna profilinställningar."
				+ "\n "
				+ "\n "
				+ "* Under sysslor lägger du till sysslor som "
				+ "barnen har i uppdrag att göra."
				+ "\n "
				+ "\n "
				+ "* Under belöningar kan du välja eller skriva"
				+ "in vilka belöningar barnen får när de har "
				+ "uppsnått sina måll"
				+ "\n "
				+ "\n "
				+ "* Under hjälp/manual kommer du till denna sidan."
				+ "\n "
				+ "\n "
				+ "* Som en dammjägarfamilj kan ni välja olika teman"
				+ " för att göra det roligare för barnen att jaga"
				+ " dammtussar. Barnen kan även individuellt välja"
				+ " tema för sin egen dammtuss. Detta kan göras"
				+ " när du lägger till en barnprofil."
				+ "\n "
				+ "\n "
				+ "Behöver du hjälpa barnet omkring i appen?"
				+ "* Barnen får användarnamn och lösenord av"
				+ " ena förälderna och loggar in."
				+ "\n "
				+ "\n "
				+ "* Genom att klicka på dammtussen längst upp"
				+ " till höger så kommer barnet till sin profil" //profil = bold
				+ "\n "
				+ "\n "
				+ "* För att komma tillbaka till första sidan " //första sidan = bold
				+ " trycker barnet på huset längst upp till vänster." 
				+ "\n "
				+ "\n "
				+ "* Under mina sysslor kan barnet se vilka" //mina sysslor = bold
				+ " uppdrag som finns."
				+ "\n "
				+ "\n "
				+ "* Under mina belöningar kan barnet se sina" //mina belöningar = bold
				+ " skatter. Barnet kan klicka på varje skatt för"
				+ " att se mer detaljerad information om detta"
				+ "\n "
				+ "\n "
				+ "Våra rekommendationer"
				+ "\n * Kom överens om poängvärdet för varje syssla."
				+ " Antingen mellan er föräldrar och/eller tillsammans"
				+ " med barnen. Risk finns att föräldrarna ger olika"
				+ " poäng för samma syssla. Att ta med barnen i "
				+ " bestämandet ger de en känsla av samarbete."
				+ "\n "
				+ "\n "
				+ "* Du som förälder kan välja att göra vissa sysslor"
				+ "+ samarbetsbara mellan syskonen. Kom överens om "
				+ " vilka sysslor som kan barnen kan samarbeta med."
				+ "\n "
				+ "\n "
				+ "* Diskutera med barnet på förhand om vilka "
				+ " konsekvenser som finns om hen väljer att aldrig"
				+ " göra en syssla."
				+ "\n "
				+ "\n "
				+ "* Du kan välja att inte godkänna en syssla som barnet"
				+ " gjort. Vi uppmuntrar att du som förälder berättar"
				+ " muntligt för barnet hur städningen kan kompletteras."
				+ "";
		return text2;
	}

}
