package tasks;

import java.io.Serializable;

import locations.Location;
import profiles.ChildProfile;

/**
 * 
 * @author Henrik Sigeman
 *
 */
public class Task implements Serializable{
	private Location location;
	private Chore chore;
	private Boolean completed = false;
	private int value;
	private ChildProfile child;

	/**
	 * Creates a new task
	 * 
	 * @param location
	 *            the location
	 * @param chore
	 *            the chore
	 * @param value
	 *            the point value of the task.
	 */
	public Task(Location location, Chore chore, int value) {
		this.location = location;
		this.chore = chore;
		this.setTaskValue(value);
		child = new ChildProfile("", 0);
	}

	public Task(Location location2, Chore chore2, int value2, Boolean bool, ChildProfile child) {
		this.location = location2;
		this.chore = chore2;
		this.setTaskValue(value2);
		this.setCompleted(bool);
		this.child = child;
	}

	/**
	 * Returns the location of the task
	 * 
	 * @return the location.
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Returns the chore of the task.
	 * 
	 * @return the chore.
	 */
	public Chore getChore() {
		return chore;
	}
	
	public void setChildProfile(ChildProfile child) {
		this.child = child;
	}
	public Boolean compareTask(Task task) {
		Boolean bool = true;
		if(!location.getLocationName().equals(task.getLocationName())) {
			bool = false;
		}
		if(!chore.getChoreName().equals(task.getChoreName())) {
			bool = false;
		}
		if(value != task.getTaskValue()) {
			bool = false;
		}
		return bool;
		
	}
	
	public ChildProfile getChildProfile() {
		return child;
	}

	/**
	 * returns wether the task is completed or not.
	 * 
	 * @return true or false, depending on if the task is completed.
	 */
	public Boolean getCompleted() {
		return completed;
	}

	/**
	 * Set the task as completed.
	 * @param bool 
	 */
	public void setCompleted(Boolean bool) {
		completed = bool;
	}

	/**
	 * 
	 */
	public void complete() {
		if (completed == true) {
			// Add points to reward goal and delete this task.
		} else {
			// Inform user that the task cannot be completed.
		}
	}

	/**
	 * returns the point value of the task.
	 * 
	 * @return value of the task.
	 */
	public int getTaskValue() {
		return value;
	}

	/**
	 * set the value of the task.
	 * 
	 * @param value
	 *            the new value of the task.
	 */
	public void setTaskValue(int value) {
		this.value = value;
	}

	/**
	 * Returns the name of the chore.
	 * 
	 * @return the name of the chore.
	 */
	public String getChoreName() {
		return chore.getChoreName();
	}

	/**
	 * Returns the name of the tasks location.
	 * 
	 * @return the name of the location.
	 */
	public String getLocationName() {
		return location.getLocationName();
	}

}
