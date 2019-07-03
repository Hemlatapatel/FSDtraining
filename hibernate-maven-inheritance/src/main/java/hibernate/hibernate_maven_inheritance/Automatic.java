package hibernate.hibernate_maven_inheritance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Automatic Car")

public class Automatic extends Car implements Serializable {

	@Column(name="is_automatic", nullable=true)
	private String isAutomatic;

	public Automatic() {
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
