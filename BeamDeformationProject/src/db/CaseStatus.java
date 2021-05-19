package db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "case_status")
public class CaseStatus {

	@Id
	private int id;
	private int status;
	
	public CaseStatus() {
		
	}
	
	public CaseStatus(int id, int status) {
		this.id = id;
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
