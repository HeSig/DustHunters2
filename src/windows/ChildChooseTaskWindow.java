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
 * GUI for children's profile
 * 
 * @author Maida, Angelina
 * 
 * 
 *         25/4: Reinstalled and retry. --- 27/4: Reinstalled, once again. Took
 *         >5h. --- 2/5: Reinstalled. AGAIN. -- 4/5: It seems like I don't have
 *         all classes like the others. Maybe my Git is bad again?
 *
 */

public class ChildChooseTaskWindow extends JPanel implements ActionListener {
	private Account account;
	private String name; // Delete? - Angie

	private JLabel lblToDo;
	private JLabel lblTitleChores; // Title, in middle of top panel
	private ImageIcon dustBallImage; // Profilepic, in the middle of middle panel
	private JLabel lblProfileSymbol; // Symbol, profilepic will be inside this label
	private JButton btnHome;
	private JButton btnProfile;
	private JLabel lblNumberOrder; // Number of tasks. Delete?
	private JLabel lblLocation;
	private JButton btnChore; // When user clicks task, they will in fact click a button to take them to class
	// ChildTaskWindow
	private JLabel lblRewardPoints;

	private ClientController clientController;
	private DefaultListModel model = new DefaultListModel(); // Testing to see if works
	private JList taskList = new JList(model); // Testing

	// Setters
	public void setLblLocation(JLabel lblLocation) {
		this.lblLocation = lblLocation;
	}

	public void setLblChore(JLabel lblLocation) {
		this.btnChore = btnChore;
	}

	public void setLblRewardPoints(JLabel lblLocation) {
		this.lblRewardPoints = lblRewardPoints;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	// Getters
	public Account getAccount() {
		return account;
	}

	// Constructor
	public ChildChooseTaskWindow(ClientController clientController) throws IOException {
		// this.name = name; Delete?
		this.clientController = clientController;

		start();

	}

	private void start() {
		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);
		InitializeGUI();
		this.setVisible(true);
		lblLocation.setOpaque(true);
		btnChore.setOpaque(true);
		lblRewardPoints.setOpaque(true);

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
		btnProfile.setIcon(new ImageIcon(clientController.getPictures().getImage(clientController.getChildProfile().getImageString())));
		btnProfile.setBounds(275, 16, 75, 70);
		pnlTop.add(btnHome);
		pnlTop.add(btnProfile);

		// Middle panel
		JPanel pnlMiddle = new JPanel();
		pnlMiddle.setBounds(12, 130, 358, 140); // Original 12, 130, 358, 140
		pnlMiddle.setLayout(new GridBagLayout());
		pnlMiddle.setBackground(Color.YELLOW);
		GridBagConstraints c = new GridBagConstraints();

		// Profile picture in the middle of middle panel
		lblProfileSymbol = new JLabel();
	//	dustBallImage = new ImageIcon("images/20x20Dammtuss.jpg");
		lblProfileSymbol.setBounds(300, 16, 90, 50); // Original 250, 16, 90, 50
		lblProfileSymbol.setIcon(new ImageIcon(clientController.getPictures().getImage(clientController.getChildProfile().getImageString())));
		pnlMiddle.add(lblProfileSymbol);

		/*
		 * Components added to the middle panel. Remember; a task A task consists of
		 * location + chore + reward.
		 */
		
		taskList.setCellRenderer(new TaskRenderer());
		JScrollPane taskScroll = new JScrollPane(taskList);
		taskScroll.setBounds(12, 130, 358, 140);
		
		updateTasks();
		
		lblToDo = new JLabel("Sysslor att göra");
		lblToDo.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblToDo.setBounds(1, 10, 90, 50);
		pnlMiddle.add(lblToDo);

		lblLocation = new JLabel("Kök");
		lblLocation.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblLocation.setBounds(1, 16, 90, 50);
		pnlMiddle.add(lblLocation);

		btnChore = new JButton("Dammsuga Vardagsrummet");
		btnChore.addActionListener(this);
		btnChore.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnChore.setBounds(40, 16, 90, 50); // Original 40, 16, 90, 50
		pnlMiddle.add(btnChore);

		lblRewardPoints = new JLabel(" 5p");
		lblRewardPoints.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblRewardPoints.setBounds(80, 16, 90, 50); // Original 80, 16, 90, 50
		pnlMiddle.add(lblRewardPoints);

		// Components of task needs size constraints. In middle panel
		// I didn't have btnProfileSymbol in gridbagcontraints before
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 1;
		c.gridy = 1;
		pnlMiddle.add(lblProfileSymbol, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 1;
		c.gridy = 1;
		pnlMiddle.add(lblToDo, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 2;
		pnlMiddle.add(lblLocation, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 1;
		c.gridy = 2;
		pnlMiddle.add(btnChore, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 2;
		c.gridy = 2;
		pnlMiddle.add(lblRewardPoints, c);

		// Bottom panel. It's empty.
		JPanel pnlBottom = new JPanel();
		pnlBottom.setBounds(12, 300, 358, 180);
		pnlBottom.setLayout(null);
		pnlBottom.setBackground(Color.YELLOW);

		// Add panels
		this.add(pnlTop);
		//this.add(pnlMiddle);
		this.add(taskScroll);
		this.add(pnlBottom);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnChore) {
			clientController.setViewChildPerformTaskWindow();
		} else if (e.getSource() == btnHome) {
			clientController.setViewChildHomeWindow();
		}
		else if (e.getSource() == btnProfile) {
			clientController.setViewChildProfileWindow();
		}

	}
	
	public void updateTasks() {
		model.clear();

		for (int i = 0; i < clientController.getAccount().getTaskList().size(); i++) {
			Task task = clientController.getAccount().getTaskList().get(i);
			model.addElement(task);
		}
	}

	private class TaskRenderer implements ListCellRenderer {
		private ActionListener listener;
		private JButton completedButton;

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			listener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

				}
			};
			// TODO Auto-generated method stub
			completedButton = new JButton("Godkänn");
			completedButton.addActionListener(listener);
			JPanel panel = new JPanel(new GridLayout(2, 4));
			Task task = (Task) value;
			panel.add(new JLabel(task.getLocationName()));
			panel.add(new JLabel(task.getChoreName()));
			panel.add(new JLabel("" + task.getTaskValue()));

			if (task.getCompleted()) {
				panel.add(new JLabel("Färdig"));
				completedButton.setEnabled(true);
			} else {
				panel.add(new JLabel("Ej färdig"));
				completedButton.setEnabled(false);
			}
			panel.add(completedButton);

			return panel;
		}

	}

	// Just playing around to see if it works
//	public void updateSomething() {
//		model.clear();
//
//		for (int i = 0; i < clientController.getAccount().getTaskList().size(); i++) {
//			Task task = clientController.getAccount().getTaskList().get(i);
//			model.addElement(task);
//
//		}

	}


