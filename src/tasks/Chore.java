package tasks;

/**
 * 
 * @author Henrik Sigeman
 *
 */
public class Chore {
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