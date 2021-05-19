package main;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "upn")
public class Pipe {
	
	@Id
	private String type;
	private Long sec_in_moment;
	
	public Pipe() {
		
	}
	
	public Pipe (String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getValue() {
		return sec_in_moment;
	}

	public void setValue(Long value) {
		this.sec_in_moment = value;
	}
	
	
}
