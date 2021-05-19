package db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "le")
public class EqualAngleL {
	
	@Id
	private String type;
	private Double sec_in_moment;
	
	public EqualAngleL() {
		
	}
	
	public EqualAngleL (String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getInertia() {
		return sec_in_moment;
	}

	public void setInertia(Double value) {
		this.sec_in_moment = value;
	}
	
	
}
