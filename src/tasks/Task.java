package tasks;

import java.io.Serializable;

import locations.Location;

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
	 */
	public void setCompleted() {
		completed = true;
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
