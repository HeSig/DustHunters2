package windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import profiles.Account;
import profiles.ParentProfile;
import tasks.Task;

/**
 * A GUI class that shows the panel where the Parent Profile can see the tasks they have assigned the children.
 * From this class you can reach parent home, profile, editTask and AddTask GUI through actionListeners.
 * 
 * @author Angelina Fransson
 *
 *
 *Note to team: we need to change sizes on the jlabels since they're too small compared to the yellow background. 
 */
@SuppressWarnings("serial")
public class ParentTaskWindow extends JPanel implements ActionListener {
	private Account account; 
	private ParentProfile parentProfile;
	private JLabel lblChildTask;

	private ClientController clientController;

	private JButton btnHome;
	private JButton btnAddTask;
	private JButton btnEditTask;
	private JButton btnProfile;
	private ImageIcon dustBallImage;
	private LinkedList<JPanel> taskPanelList = new LinkedList(); //delete?
	private JPanel pnlMiddle;

/**
 * Setters and getters for Account and ParentProfile
 * 
 */
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

	public ParentTaskWindow (ClientController clientController) {
		this.clientController = clientController;
		start();

	}
	/**
	 * Makes the GUI visible and sets bounds for the main panel. 
	 */

	private void start() {
		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);
		InitializeGUI();
		this.setVisible(true);

	}
	/**
	 * The GUI. 
	 */
	private void InitializeGUI() {

		this.setBounds(6,6, 381, 500);
		this.setLayout(null);
		this.setBackground(Color.YELLOW);


		JPanel pnlTop = new JPanel();
		pnlTop.setBounds(12, 17, 358, 80);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.YELLOW);


		lblChildTask = new JLabel("Barnens sysslor");
		lblChildTask.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblChildTask.setBounds(105, 30, 285, 20);
		pnlTop.add(lblChildTask);

		btnHome = new JButton();
		btnHome.setIcon(new ImageIcon("images/House.jpg"));
		btnHome.setBounds(5, 5, 75, 70);
		btnHome.addActionListener(this);
		pnlTop.add(btnHome);

		btnProfile = new JButton ();
		btnProfile.addActionListener(this);
		dustBallImage = new ImageIcon ("images/20x20Dammtuss.jpg");
		btnProfile.setBounds(275, 16, 75, 70);
		btnProfile.setIcon(dustBallImage);

		pnlTop.add(btnProfile);

		pnlMiddle = new JPanel();
		pnlMiddle.setBackground(Color.WHITE);
		pnlMiddle.setBounds(12, 130, 358, 140);
		GridBagConstraints c = new GridBagConstraints();

		Border border3 = BorderFactory.createEtchedBorder();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;


		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;


		c.gridx = 0;

		updateTasks();


		JPanel pnlBottom = new JPanel();
		pnlBottom.setBounds(12, 300, 358, 180);
		pnlBottom.setLayout(null);
		pnlBottom.setBackground(Color.YELLOW);


		btnAddTask = new JButton(" Lägg till en syssla ");
		btnAddTask.addActionListener(this);
		btnAddTask.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnAddTask.setBackground(Color.GREEN);
		btnAddTask.setForeground(Color.BLACK);
		btnAddTask.setBounds(10, 16, 300, 50);
		pnlBottom.add(btnAddTask);


		btnEditTask = new JButton(" Redigera/Ta bort syssla ");
		btnEditTask.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnEditTask.setBackground(Color.RED);
		btnEditTask.setForeground(Color.BLACK);
		btnEditTask.setBounds(10, 100, 300, 50);
		pnlBottom.add(btnEditTask);

		this.add(pnlTop);
		this.add(pnlMiddle);
		this.add(pnlBottom);		
	}

	@Override
/**
 * Actions performed when clicking on the home, addTask and profile button.
 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnHome) {
			clientController.setViewParentHomeWindow();
		}
		if(e.getSource() == btnAddTask) {
			clientController.setViewParentEditTaskWindow();
		}
		if(e.getSource() == btnProfile) {
			clientController.setViewParentProfileWindow();
		}

	}
	/**
	 * author: Henrik Sigeman
	 */

	public void updateTasks() {
		pnlMiddle.removeAll();
		GridBagConstraints c = new GridBagConstraints();

		c.gridy = 0;

		for(int i = 0; i < clientController.getAccount().getTaskList().size(); i++) {
			Task task = clientController.getAccount().getTaskList().get(i);
			pnlMiddle.add(new TaskPanel(task), c);
			c.gridy++;
		}
		pnlMiddle.revalidate();
		pnlMiddle.repaint();
	}
	/** 
	 * 
	 * @author Henrik Sigeman
	 * 
	 */
	private class TaskPanel extends JPanel{
		private String locationName = "";
		private String choreName = "";
		private int choreValue = 0;
		private JLabel location;
		private JLabel chore;
		private JLabel value;
		private JLabel done;
		private JButton completedButton;
		private ActionListener listener;

		public TaskPanel(Task task) {
			this.locationName = task.getLocationName();
			this.choreName = task.getChoreName();
			this.choreValue = task.getTaskValue();
			location = new JLabel(locationName);
			chore = new JLabel(choreName);
			value = new JLabel(""+choreValue);
			completedButton = new JButton("Godkänn");
			completedButton.setEnabled(task.getCompleted());
			listener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == completedButton) {
						try {
							clientController.getAccount().setTaskList(clientController.completeTask(task, task.getChildProfile()));
							updateTasks();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			};
			completedButton.addActionListener(listener);


			String str = "Inte färdig";
			if(task.getCompleted()) {
				str = "Färdig";
			}
			done = new JLabel(str);

			//setBounds(12, 130, 358, 140);
			setLayout(new GridBagLayout());
			location.setOpaque(true);
			chore.setOpaque(true);
			value.setOpaque(true);
			done.setOpaque(true);
			//			setBackground(Color.YELLOW);

			GridBagConstraints c = new GridBagConstraints();

			Border border = BorderFactory.createEtchedBorder();
			location.setFont(new Font("SansSerif", Font.BOLD, 12));
			location.setBackground(Color.YELLOW);
			location.setBorder(border);
			chore.setFont(new Font("SansSerif", Font.BOLD, 12));
			chore.setBackground(Color.YELLOW);
			chore.setBorder(border);
			value.setFont(new Font("SansSerif", Font.BOLD, 12));
			value.setBackground(Color.YELLOW);
			value.setBorder(border);
			done.setFont(new Font("SansSerif", Font.BOLD, 12));
			done.setBackground(Color.YELLOW);
			done.setBorder(border);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.anchor = GridBagConstraints.NORTHWEST;
			c.weightx = 1;
			c.weighty = 1;


			add(location, c);
			add(chore, c);
			add(value, c);
			add(done, c);
			add(completedButton, c);
		}


	}
}
