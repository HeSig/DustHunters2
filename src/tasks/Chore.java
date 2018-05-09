package tasks;

import java.io.Serializable;

/**
 * 
 * @author Henrik Sigeman
 *
 */
public class Chore implements Serializable{
	private String choreName;
	
	public Chore(String choreName) {
		this.choreName = choreName;
	}
	
	public void setChoreName(String choreName) {
		this.choreName = choreName;
	}
	
	public String getChoreName() {
		return choreName;
	}
}