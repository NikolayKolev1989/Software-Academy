package db;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
//	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int id;
	@Id
	private String username;
	@Column(unique = true)
	private String hashedPassword;
	@Column(unique = true)
	private String unhashedPassword;
	@Column(unique = true)
	private String email;
	
	public User(String username, String hashedPassword,String unhashedPassword, String email){
		this.username = username;
		this.unhashedPassword = unhashedPassword;
		this.hashedPassword = hashedPassword;
		this.email = email;
	}
	
	public User(){
		
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String UnhashedPassword() {
		return unhashedPassword;
	}

	public void setUnhashedPassword(String unhashedPassword) {
		this.unhashedPassword = unhashedPassword;
	}
	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
//		return "User [id=" + id + ", username=" + username + ", hashedPassword=" + hashedPassword + ", email=" + email
//				+ "]";
		return "User [username=" + username + ", hashedPassword=" + hashedPassword + ", email=" + email
				+ "]";
	}
	
}
