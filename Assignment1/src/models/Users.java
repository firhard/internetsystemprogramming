package models;

public class Users {
	
	private int Id;
	private String FirstName;
	private String LastName;
	private String Address;
	private String City;
	private String State;
	private String PostalCode;
	private String EmailAddress;
	private String PhoneNumber;
	private String Birthday;
	private Byte Type;
	private Byte Status;
	private int NumOfVisits;
	private String userName;
	private String password;
	
	public Users() {
		super();
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	public Byte getType() {
		return Type;
	}
	public void setType(Byte type) {
		Type = type;
	}
	public Byte getStatus() {
		return Status;
	}
	public void setStatus(Byte status) {
		Status = status;
	}
	public int getNumOfVisits() {
		return NumOfVisits;
	}
	public void setNumOfVisits(int numOfVisits) {
		NumOfVisits = numOfVisits;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFullName(){
		return FirstName + " " + LastName;
	}
	
	
	public static boolean validateUser(String username, String password) {
   	    DBAccessClass db = new DBAccessClass();
   	    db.connectMeIn();
   	    Users return_user = db.DBgetUserbyUsernameandPassword(username, password);
   	    db.closeConnection();
   	    return (return_user.getId() != 0);
    }
	
	public static boolean existingUserName(String username){
   	    DBAccessClass db = new DBAccessClass();
   	    db.connectMeIn();
   	    boolean taken_username = db.DBUsernameTaken(username);
   	    db.closeConnection();
   	    return (taken_username);
	}
	
	public void registerUser() {
   	    DBAccessClass db = new DBAccessClass();
   	    db.connectMeIn();
   	    String user = this.getUserName();
   	    String pass = this.getPassword();
   	    db.DBsetUser(user, pass);
   	    db.closeConnection();
	}
	
	public static Users findUserbyId(int id) {   
	   	DBAccessClass db = new DBAccessClass();
	   	db.connectMeIn();
	   	Users user = db.DBgetUserbyId(id);
	   	db.closeConnection();
	   	return user;
    }

	
	
}
