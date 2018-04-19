package profiles;

import java.io.Serializable;

/**
 * 
 * @author Henrik Sigeman
 *
 */
public class ChildProfile implements Serializable{
	private String name;
	private Account account;
	
	public ChildProfile(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
