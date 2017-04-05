package ar.com.gruponn.model;

import java.util.Date;

public class Conductor extends Usuario{
	
	private Date licenseExpiration;

	
	
	
	public Boolean isLicenseExipered(){
		Date today = new Date();
		int result = this.licenseExpiration.compareTo(today);
	return result > 1;
	}
	
	public Date getLicenseExpiration() {
		return licenseExpiration;
	}

	public void setLicenseExpiration(Date licenseExpiration) {
		this.licenseExpiration = licenseExpiration;
	}

	
}
