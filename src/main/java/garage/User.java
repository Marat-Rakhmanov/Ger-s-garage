package garage;


public class User {
	
	private static int UserID;
	private String fname;
	private String surname;
	private String password;
	private String licence;
	private static String EmailAddress;
	private String phone;
	private String gender;
	private String birthday;
	
	private static int currentUserIDNumber = 0;
	
	public User() {
		fname = "";
		surname = "";
		password = "";
		licence = "";
		EmailAddress = "";
		phone = "";
		gender = "";
		birthday = "";
	}
	
	public User(String fname, String surname, String password, String licence, String EmailAddress, String phone, String gender,
			String birthday) {
		super();
		User.UserID = generateID();
		this.fname = fname;
		this.surname = surname;
		this.password = password;
		this.licence = licence;
		User.EmailAddress = EmailAddress;
		this.phone = phone;
		this.gender = gender;
		this.birthday = birthday;
	}
	
	
	public int generateID() {

		currentUserIDNumber++;
		return currentUserIDNumber;
	}
	public static int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		User.UserID = userID;
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLicence() {
		return licence;
	}
	public void setLicence(String licence) {
		this.licence = licence;
	}
	public static String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmail(String EmailAddress) {
		User.EmailAddress = EmailAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
