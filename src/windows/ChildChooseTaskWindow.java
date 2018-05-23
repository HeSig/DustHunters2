package windows;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

import profiles.Account;
import profiles.ParentProfile;
import tasks.Task;
import windows.ClientController;

/**
 * Window that shows children a list of chores created by the parent profiles. 
 * 
 * @author Maida, Angelina
 * 
 *
 */

public class ChildChooseTaskWindow extends JPanel implements ActionListener {
	private Account account;

	private JLabel lblTitleChores; // Title, in middle of top panel
	private JButton btnHome;
	private JButton btnProfile;
	
	private JButton btnChooseChore;

	private ClientController clientController;
	private DefaultListModel model = new DefaultListModel(); // Testing to see if works
	private JList taskList = new JList(model); // Testing

	// Setters

	public void setAccount(Account account) {
		this.account = account;
	}

	// Getters
	public Account getAccount() {
		return account;
	}

	// Constructor
	public ChildChooseTaskWindow(ClientController clientController) throws IOException {

		this.clientController = clientController;

		start();

	}

	private void start() {
		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);
		InitializeGUI();
		this.setVisible(true);

	}

	/*
	 * Set sizes and add components
	 */
	private void InitializeGUI() {
		// TODO Auto-generated method stub

		// PnlMain
		this.setBounds(6, 6, 381, 500);
		this.setLayout(null);
		this.setBackground(Color.YELLOW);

		// Top panel
		JPanel pnlTop = new JPanel();
		pnlTop.setBounds(12, 17, 358, 80);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.YELLOW);

		// Home-label in middle of pnlTop
		lblTitleChores = new JLabel("Dina Sysslor");
		lblTitleChores.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTitleChores.setBounds(105, 30, 285, 20);
		pnlTop.add(lblTitleChores);

		btnHome = new JButton();
		btnHome.addActionListener(this);
		btnHome.setIcon(new ImageIcon("images/House.jpg"));
		btnHome.setBounds(5, 5, 80, 65);

		btnProfile = new JButton();
		btnProfile.addActionListener(this);
		btnProfile.setIcon(new ImageIcon(
				clientController.getPictures().getImage(clientController.getChildProfile().getImageString())));
		btnProfile.setBounds(275, 16, 75, 70);
		pnlTop.add(btnHome);
		pnlTop.add(btnProfile);

		// Middle panel
		JPanel pnlMiddle = new JPanel();
		pnlMiddle.setBounds(12, 130, 358, 140); // Original 12, 130, 358, 140
		pnlMiddle.setLayout(new GridBagLayout());
		pnlMiddle.setBackground(Color.YELLOW);
		GridBagConstraints c = new GridBagConstraints();

		/*
		 * Components added to the middle panel. Remember; a task A task consists of
		 * location + chore + reward.
		 */

		taskList.setCellRenderer(new TaskRenderer());
		JScrollPane taskScroll = new JScrollPane(taskList);
		taskScroll.setBounds(12, 130, 358, 140);

		updateTasks();

		// Bottom panel. It's empty.
		JPanel pnlBottom = new JPanel();
		pnlBottom.setBounds(12, 300, 358, 180);
		pnlBottom.setLayout(null);
		pnlBottom.setBackground(Color.YELLOW);

		btnChooseChore = new JButton("Välj syssla");
		btnChooseChore.setBounds(10, 16, 300, 50);
		btnChooseChore.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnChooseChore.setBackground(Color.GREEN);
		btnChooseChore.setForeground(Color.BLACK);
		btnChooseChore.addActionListener(this);
		pnlBottom.add(btnChooseChore);

		// Add panels
		this.add(pnlTop);
		this.add(taskScroll);
		this.add(pnlBottom);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnHome) {
			clientController.setViewChildHomeWindow();
		} else if (e.getSource() == btnProfile) {
			clientController.setViewChildProfileWindow();
		} else if (e.getSource() == btnChooseChore) {
			clientController.setViewChildPerformTaskWindow();
		}

	}

	/**
	 * Finds the tasks created by parent profiles and shows them in the child
	 * profile
	 * 
	 * @author dalvig
	 */

	public void updateTasks() {
		model.clear();

		for (int i = 0; i < clientController.getAccount().getTaskList().size(); i++) {
			Task task = clientController.getAccount().getTaskList().get(i);
			model.addElement(task);
		}
	}

	private class TaskRenderer implements ListCellRenderer {
		private ActionListener listener;
		private JButton btnCompleted;

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			listener = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == btnCompleted) {
						clientController.setViewChildPerformTaskWindow();
					}

				}
			};
			// TODO Auto-generated method stub
			btnCompleted = new JButton("Ej gjord");
			btnCompleted.addActionListener(listener);

			JPanel panel = new JPanel(new GridLayout(2, 4));
			Task task = (Task) value;
			panel.add(new JLabel(task.getLocationName()));
			panel.add(new JLabel(task.getChoreName()));
			panel.add(new JLabel("" + task.getTaskValue()));

			if (task.getCompleted()) {
				panel.add(new JLabel("Färdig"));
				btnCompleted.setEnabled(true);
			} else {
				panel.add(new JLabel("Ej färdig"));
				btnCompleted.setEnabled(false);
			}
			panel.add(btnCompleted);

			return panel;
		}

	}

}
