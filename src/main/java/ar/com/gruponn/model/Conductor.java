package ar.com.gruponn.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Conductor extends Usuario{
	
	private Date licenseExpiration;
	
	public Double average(){
		List<Viaje> endedTravels = this.travels.stream().filter(travel -> travel.getFinshed()).collect(Collectors.toList());
		Double result= 0.0;
		for (Viaje viaje : endedTravels) {
			result = result + viaje.average(); 
		}
		return result/endedTravels.size();
	}
	
	
	public Boolean isLicenseExipered(){
		Date today = new Date();
		int result = this.licenseExpiration.compareTo(today);
	return result > 0;
	}
	
	public Date getLicenseExpiration() {
		return licenseExpiration;
	}

	public void setLicenseExpiration(Date licenseExpiration) {
		this.licenseExpiration = licenseExpiration;
	}

	
}
