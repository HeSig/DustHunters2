package locations;

import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * 
 * @author Henrik Sigeman
 *
 */
public class Location implements Serializable{
	protected String locationName;
	protected ImageIcon locationIcon;
	
	public Location(String locationName) {
		this.locationName = locationName;
	}
	
	public Location() {
		
	}

	public String getLocationName() {
		return locationName;
	}

	public ImageIcon getLocationIcon() {
		return locationIcon;
	}

}
