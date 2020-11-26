package logical;

import java.io.Serializable;

public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4707481105323476353L;
	private String username;
	private String password;
	private String type;
	
	//Constructor
	public Usuario(String username, String password, String type) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
	}
	//Getters and Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
