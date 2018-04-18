package tasks;

import locations.Location;

/**
 * 
 * @author Henrik Sigeman
 *
 */
public class Task {
	private Location location;
	private Chore chore;
	private Boolean completed = false;
	private int value;

	/**
	 * 
	 * @param location
	 * @param chore
	 * @param value
	 */
	public Task(Location location, Chore chore, int value) {
		this.location = location;
		this.chore = chore;
		this.setTaskValue(value);
	}
	/**
	 * 
	 * @return
	 */
	public Location getLocation() {
		return location;
	}
	/**
	 * 
	 * @return
	 */
	public Chore getChore() {
		return chore;
	}
	/**
	 * 
	 * @return
	 */
	public Boolean getCompleted() {
		return completed;
	}
	/**
	 * 
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
		}
	}
	
	public int getTaskValue() {
		return value;
	}
	public void setTaskValue(int value) {
		this.value = value;
	}
	public String getChoreName() {
		return chore.getChoreName();
	}
	public String getLocationName() {
		return location.getLocationName();
	}

}
