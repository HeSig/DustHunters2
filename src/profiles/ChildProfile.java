package profiles;

import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * 
 * @author Henrik Sigeman
 * 
 * 25/4: Har ominstallerat och testar igen
 *
 */
public class ChildProfile implements Serializable{
	private String name;
	private Account account;
	private ImageIcon icon;
	
	public ChildProfile(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	

}
