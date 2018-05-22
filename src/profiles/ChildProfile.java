package profiles;

import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * 
 * @author Henrik Sigeman, Maida Sijaric
 * 
 * 25/4: Har ominstallerat och testar igen
 *
 */
public class ChildProfile implements Serializable{
	private String name;
	private Account account;
	private String imageStr;
	private int points = 0;
	
	public ChildProfile(String name, int points) {
		this.name = name;
		setPoints(points);
	}
	
	public String getName() {
		return name;
	}
	
	private void setPoints(int points) {
		this.points = points;
	}
	
	public int getPoints() {
		return points;
	}
	public void addPoints(int points) {
		this.points += points;
	}
	public void removePoints(int points) {
		this.points -= points;
	}
	public void setImage(String str) {
		imageStr = str;
	}
	
	public String getImageString() {
		return imageStr;
	}
	

}
