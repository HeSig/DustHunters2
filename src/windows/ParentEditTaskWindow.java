package windows;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import locations.Location;
import profiles.Account;
import profiles.ChildProfile;
import tasks.Chore;
import tasks.Task;

/**
 * A GUI class that shows the edit task panel for the Parent Profile. In this
 * class you can choose child/children + chore + location and save, which
 * creates a task that will be shown in ParentTaskWindow, and childTaskWindow.
 * From this class you can reach parent profile and home GUI through
 * actionListeners.
 *
 * @author Angelina Fransson
 *
 */
@SuppressWarnings("serial")
public class ParentEditTaskWindow extends JPanel implements ActionListener {

	private Account account;
	private JButton btnHome = new JButton();
	private JLabel lblTitle;
	private JLabel lblChildName;
	private JLabel lblChore;
	private JLabel lblLocation;

	@SuppressWarnings("rawtypes")
	private JComboBox comboChooseChild;
	@SuppressWarnings("rawtypes")
	private JComboBox comboChooseChore;
	@SuppressWarnings("rawtypes")
	private JComboBox comboChooseLocation;

	private JButton btnSave = new JButton();
	private JButton btnCancel = new JButton();
	private JButton btnProfile = new JButton();

	private ChildProfile childProfile;
	private String[] childNames = { "MAIDA", "HENRIK", "ANGIE", "SARA", "KASPER", "ALLA" };
	private String[] preSelectedChores = { "Dammsuga", "Damma", "Diska", "Bädda", "Gå ut med hunden" };
	private String[] preSelectedLocations = { "Hallen", "Sovrummet", "Toaletten", "Vardagsrummet", "utomhus" };

	private ClientController controller;

	/**
	 * Constuctor. Constructs the GUI.
	 * 
	 * @param clientController
	 */
	public ParentEditTaskWindow(ClientController clientController) {
		this.controller = clientController;
		try {
			start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Account getAccount() {
		return account;
	}

	public ChildProfile getChildProfile() {
		return childProfile;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * Makes the GUI visible and sets bounds for the main panel.
	 * 
	 * @throws IOException
	 */
	public void start() throws IOException {

		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);
		InitializeGUI();
		this.setVisible(true);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	/**
	 * The GUI.
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

		lblTitle = new JLabel("Redigera syssla");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setBounds(100, 30, 285, 20);
		btnHome.setIcon(new ImageIcon("images/house.jpg"));
		btnHome.setBounds(5, 5, 85, 70);
		btnProfile.setIcon(
				new ImageIcon(controller.getPictures().getImage(controller.getParentProfile().getImageString())));
		btnProfile.setBounds(275, 16, 75, 70);

		pnlTop.add(btnHome);
		pnlTop.add(lblTitle);
		pnlTop.add(btnProfile);

		// Middle-Top Panel
		JPanel pnlMiddle1 = new JPanel();
		pnlMiddle1.setBounds(12, 100, 358, 130);
		pnlMiddle1.setLayout(new FlowLayout());
		pnlMiddle1.setBackground(Color.YELLOW);
		Border border3 = BorderFactory.createEtchedBorder();

		// Middle-Bottom Panel
		JPanel pnlMiddle2 = new JPanel();
		pnlMiddle2.setBounds(12, 240, 358, 180);
		pnlMiddle2.setLayout(new GridLayout(3, 2));
		pnlMiddle2.setBackground(Color.YELLOW);

		lblChildName = new JLabel("Namn: ");
		lblChildName.setFont(new Font("SansSerif", Font.BOLD, 12));

		lblChore = new JLabel("Välj syssla: ");
		lblChore.setFont(new Font("SansSerif", Font.BOLD, 12));

		lblLocation = new JLabel("Välj plats: ");
		lblLocation.setFont(new Font("SansSerif", Font.BOLD, 12));

		comboChooseChild = new JComboBox(childNames);
		comboChooseChild.setSelectedIndex(1);
		comboChooseChild.setBorder(border3);

		comboChooseChore = new JComboBox(preSelectedChores);
		comboChooseChore.setSelectedIndex(1);
		comboChooseChore.setSelectedItem(border3);

		comboChooseLocation = new JComboBox(preSelectedLocations);
		comboChooseLocation.setSelectedIndex(1);
		comboChooseLocation.setSelectedItem(border3);

		pnlMiddle2.add(lblChildName);
		pnlMiddle2.add(comboChooseChild);
		pnlMiddle2.add(lblChore);
		pnlMiddle2.add(comboChooseChore);
		pnlMiddle2.add(lblLocation);
		pnlMiddle2.add(comboChooseLocation);

		// Bottom Panel

		JPanel pnlBottom = new JPanel();
		pnlBottom.setBounds(12, 430, 358, 100);
		pnlBottom.setLayout(new FlowLayout());
		pnlBottom.setBackground(Color.YELLOW);

		btnSave = new JButton("Spara");
		btnSave.addActionListener(this);
		btnSave.setBounds(10, 10, 10, 10);
		btnSave.setForeground(Color.BLACK);
		btnSave.setBackground(Color.GREEN);

		btnCancel = new JButton("Avsluta");
		btnCancel.setBounds(100, 200, 250, 200);
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.RED);

		pnlBottom.add(btnSave);
		pnlBottom.add(btnCancel);

		this.add(pnlTop);
		this.add(pnlMiddle1);
		this.add(pnlMiddle2);
		this.add(pnlBottom);

		btnHome.addActionListener(this);
		btnProfile.addActionListener(this);
		btnCancel.addActionListener(this);
	}

	/**
	 * Actions performed when clicking on home, profile, cancel and save button.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnHome) {
			controller.setViewParentHomeWindow();
		}
		if (e.getSource() == btnCancel) {
			controller.setViewParentTaskWindow();
		}
		if (e.getSource() == btnSave) {
			Location location = new Location(comboChooseLocation.getSelectedItem().toString());
			Task task = new Task(location, new Chore(comboChooseChore.getSelectedItem().toString()), 10);
			Boolean taskOK = true;

			for (Task t : controller.getAccount().getTaskList()) {
				if (t.compareTask(task)) {
					taskOK = false;
				}
			}
			if (taskOK) {
				// Server add new task to the account.
				try {

					controller.addTaskToAccount(task);
					// Fullösning
					Thread.sleep(500);
					// Fullösning
					controller.getAccount().setTaskList(controller.getTasksFromAccount());
					Thread.sleep(500);
					controller.updateTaskLists();

				} catch (IOException e1) {
					System.out.println("Cannot add new task.");
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				controller.setViewParentTaskWindow();
			} else {
				System.out.println("Identisk syssla redan funnen");
			}
		}
		if (e.getSource() == btnProfile) {
			controller.setViewParentProfileWindow();
		}
	}
}
