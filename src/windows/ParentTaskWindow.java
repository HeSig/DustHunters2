package windows;

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
public class ParentTaskWindow extends AbstractWindowUI {
	private Account account; 
	private ParentProfile parentProfile;
	
	private JPanel nameTask;
	private JButton home;
	private JButton profile;
	private JButton addTask;
	private JButton deleteTask;
	private JLabel createdTask;
	private JLabel childDoingTask; //Ifylld när ett barn har blivit assigned/valt en syssla. 
	private JCheckBox checkCompleteTask; //
	//SwitchPanel (panel t.ex. RewardPanel) { this.panel = panel }
	//Note to self: enable/disable JCheckBox beroende på om barnet gjort den eller inte
	//lägg till setters och getters
	public ParentTaskWindow () {
		
	}
	
//	public void chooseTask () {
//		
//	}
//	public void removeTask () {
//		
//	}
	public void confirmDoneTask () {
		
	}
	public void denyDoneTask () {
		
	}
	public void setTaskTimeLimit () {
		
	}
	public void createNewTask () {
		
	}
	public 
	
 }
