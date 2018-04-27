package windows;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import profiles.Account;
import profiles.ParentProfile;

/**
 * 
 * @author Angelina Fransson
 *
 */
public class ParentTaskWindow extends AbstractWindowUI implements ActionListener {
	private Account account; 
	private ParentProfile parentProfile;
	
	private JPanel nameTask;
	private JButton home;
	private JButton profile;
	private JButton addTask;
	private JButton deleteTask;
	private JLabel createdTask;
	private JLabel childDoingTask; //Ifylld när ett barn har blivit assigned/valt en syssla. 
	private JCheckBox checkCompletedTask; //
	//SwitchPanel (panel t.ex. RewardPanel) { this.panel = panel }
	//Note to self: enable/disable JCheckBox beroende på om barnet gjort den eller inte
	//lägg till setters och getters
	
	public Account getAccount () {
		return account;
	}
	public ParentProfile getParentProfile () {
		return parentProfile; 
	}
	public void setNameTask (JPanel nameTask) {
		this.nameTask = nameTask;
	}
	public void setAccount (Account account) {
		this.account = account;
	}
	public void setParentProfile (ParentProfile parentProfile) {
		this.parentProfile = parentProfile;
	}
	public void setHome (JButton home) {
		this.home = home;
	}
	public void setProfile (JButton profile) {
		this.profile = profile;
	}
	public void setAddTask (JButton addTask) {
		this.addTask = addTask;
	} 
	public void setDeleteTask (JButton deleteTask) {
		this.deleteTask = deleteTask;
	}
	public void setCreatedTask (JLabel createdTask){
		this.createdTask = createdTask;
	}
	public void setChildDoingTask (JLabel childDoingTask) {
		this.childDoingTask = childDoingTask;
	}
	public void setCheckCompletedTask (JCheckBox checkCompletedTask) {
		this.checkCompletedTask = checkCompletedTask;
	}
	public ParentTaskWindow (String title) {
		super (title);
		setBackground (Color.YELLOW);
		
		
		
		
	}
	
	public void chooseTask () {
		
	}

	public void confirmDoneTask () {
		
	}
	public void denyDoneTask () {
		
	}
	public void setTaskTimeLimit () {
		
	}
	public void createNewTask () {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void main (String [] args) {
		new ParentTaskWindow ("Parent Task Window");
	}
 }
