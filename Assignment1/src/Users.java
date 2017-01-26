import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Users {

	private static AtomicInteger nextId = new AtomicInteger();
	private int id;
	private String username;
	private String password;
	private static ArrayList<Users> list = new ArrayList<Users>();
	
	Users(String username, String password) {
		this.id = nextId.incrementAndGet();
		this.username = username;
		this.password = password;
		list.add(this);
	}

	String getUsername() {
		return username;
	}

	void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static boolean userExist(String username, String password){
		for(Users user: list){
			if (user.getUsername().equals(username) && user.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean usernameTaken(String username){
		for(Users user: list){
			if(user.getUsername().equals(username)){
				return true;
			}
		}
		return false;
	}
	
}
