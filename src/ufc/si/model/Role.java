package ufc.si.model;

public class Role {
	private int id;
	private String role;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}
	public Role(int id, String role){
		this.id = id;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public String getRole() {
		return role;
	}
	public void setId(int login) {
		this.id = login;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
