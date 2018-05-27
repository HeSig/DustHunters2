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
* A window that adult users will see if they click "Hj�lp" (Help) in the ParentHomeWindow
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
	// private String text = new String("1. F�rsta sidan \n Tryck p� huset i v�nstra
	// h�rnet f�r att komma \n till f�rsta sidan. \n 2. Din profil \n Tryck p�
	// Dammtussen i h�gra h�rnet f�r att \n komma till din profil. \n 3. Sysslor \n
	// �r nyttigt f�r barnen. \n 4. Bel�ningar \n �r nyttigt f�r sj�len. ");
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

		lblTitle = new JLabel("Hj�lp");
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
		text2 = "V�lkommen till Dammj�garna! "
				+ "\n \n Du som f�r�lder har nu skapat ett konto "
				+ "\n med f�r�ldraprofil. F�r att optimera "
				+ "\n anv�ndandet av applikationen kan ni ta "
				+ "\n del av v�r produkbeskrivning och manual."
				+ "\n "
				+ "\n "
				+ "F�r att komma runt i appen:"
				+ "\n * F�r att komma ig�ng kan du skapa en"
				+ "\n f�r�ldraprofil f�r din partner och f�r"
				+ "\n att skapa barnprofiler g�r du"
				+ "\n p� samma s�tt. F�r att l�gga till" //l�gga till = bold
				+ " en profil trycker du p� dammtussen" //en profil = bold
				+ " l�ngst upp till h�ger. Som f�r�ldraprofilen"
				+ " har du alla anv�ndarnamn och l�senord. "
				+ "\n "
				+ "\n "
				+ "* F�r att komma tillbaka till f�rsta sidan"
				+ " trycker du p� huset l�ngst upp till v�nster."
				+ "\n "
				+ "\n "
				+ "* Under inst�llningar kan du �ndra dina"
				+ " egna profilinst�llningar."
				+ "\n "
				+ "\n "
				+ "* Under sysslor l�gger du till sysslor som "
				+ "barnen har i uppdrag att g�ra."
				+ "\n "
				+ "\n "
				+ "* Under bel�ningar kan du v�lja eller skriva"
				+ "in vilka bel�ningar barnen f�r n�r de har "
				+ "uppsn�tt sina m�ll"
				+ "\n "
				+ "\n "
				+ "* Under hj�lp/manual kommer du till denna sidan."
				+ "\n "
				+ "\n "
				+ "* Som en dammj�garfamilj kan ni v�lja olika teman"
				+ " f�r att g�ra det roligare f�r barnen att jaga"
				+ " dammtussar. Barnen kan �ven individuellt v�lja"
				+ " tema f�r sin egen dammtuss. Detta kan g�ras"
				+ " n�r du l�gger till en barnprofil."
				+ "\n "
				+ "\n "
				+ "Beh�ver du hj�lpa barnet omkring i appen?"
				+ "* Barnen f�r anv�ndarnamn och l�senord av"
				+ " ena f�r�lderna och loggar in."
				+ "\n "
				+ "\n "
				+ "* Genom att klicka p� dammtussen l�ngst upp"
				+ " till h�ger s� kommer barnet till sin profil" //profil = bold
				+ "\n "
				+ "\n "
				+ "* F�r att komma tillbaka till f�rsta sidan " //f�rsta sidan = bold
				+ " trycker barnet p� huset l�ngst upp till v�nster." 
				+ "\n "
				+ "\n "
				+ "* Under mina sysslor kan barnet se vilka" //mina sysslor = bold
				+ " uppdrag som finns."
				+ "\n "
				+ "\n "
				+ "* Under mina bel�ningar kan barnet se sina" //mina bel�ningar = bold
				+ " skatter. Barnet kan klicka p� varje skatt f�r"
				+ " att se mer detaljerad information om detta"
				+ "\n "
				+ "\n "
				+ "V�ra rekommendationer"
				+ "\n * Kom �verens om po�ngv�rdet f�r varje syssla."
				+ " Antingen mellan er f�r�ldrar och/eller tillsammans"
				+ " med barnen. Risk finns att f�r�ldrarna ger olika"
				+ " po�ng f�r samma syssla. Att ta med barnen i "
				+ " best�mandet ger de en k�nsla av samarbete."
				+ "\n "
				+ "\n "
				+ "* Du som f�r�lder kan v�lja att g�ra vissa sysslor"
				+ "+ samarbetsbara mellan syskonen. Kom �verens om "
				+ " vilka sysslor som kan barnen kan samarbeta med."
				+ "\n "
				+ "\n "
				+ "* Diskutera med barnet p� f�rhand om vilka "
				+ " konsekvenser som finns om hen v�ljer att aldrig"
				+ " g�ra en syssla."
				+ "\n "
				+ "\n "
				+ "* Du kan v�lja att inte godk�nna en syssla som barnet"
				+ " gjort. Vi uppmuntrar att du som f�r�lder ber�ttar"
				+ " muntligt f�r barnet hur st�dningen kan kompletteras."
				+ "";
		return text2;
	}

}
