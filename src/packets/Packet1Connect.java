package packets;

public class Packet1Connect extends Packet{
	public String name = "-1";
	public String password = "-1";
	protected boolean logout = false;
	
	public  String getUsername() {
		return name;
	}
	public void setUsername(String name){
		this.name = name;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void logout(boolean logout) {
		this.logout = logout;
	}
	public boolean logout(){
		return logout;
	}
}
