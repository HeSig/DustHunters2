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
 * It will give a brief description of how to navigate through the application
 * as well as a short explanation of the idea behind the product. 
 * @author dalvig, Maida 
 *
 */

/*
 * A way to import a bigger textfile to give more detailed explation and recommendations? 
 * Scroll-function because of too much text to fit the screen? -M
 */
	
public class HelpWindow extends JPanel implements ActionListener {
	

	private JLabel lblTitle;
	private String text = new String("1. Första sidan \n Tryck på huset i vänstra hörnet för att komma \n till första sidan. \n 2. Din profil \n Tryck på Dammtussen i högra hörnet för att \n komma till din profil. \n 3. Sysslor \n Är nyttigt för barnen. \n 4. Belöningar \n Är nyttigt för själen. ");
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
		
		JTextArea textArea = new JTextArea(text);
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		
		pnlMiddle.add(scrollPane);
        
		this.add(pnlTop);
		this.add(pnlMiddle);
	
	}
	
		
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnHome ) {
			clientController.setViewParentHomeWindow();
		}
		else if (e.getSource() == btnProfile ) {
			clientController.setViewParentProfileWindow();
		}
		
		
	}
	
	//Main should be removed? -M
//	public static void main(String[] args) throws IOException {
//		JFrame frame = new JFrame();
//		HelpWindow helpWindow = new HelpWindow(null);
//		frame.add(helpWindow);
//		frame.pack();
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setMinimumSize(new Dimension(400, 600));
//	}

}
