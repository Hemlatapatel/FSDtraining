package hibernate.hibernate_maven_inheritance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Manual Car")

public class Manual extends Car implements Serializable {

	@Column(name="is_automatic", nullable=true)
	private String isAutomatic;

	public Manual() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIsAutomatic() {
		return isAutomatic;
	}

	public void setIsAutomatic(String isAutomatic) {
		this.isAutomatic = isAutomatic;
	}

	
	
	
}

