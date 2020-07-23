package k.wakir;

public interface UserDao {
	
	public int insertUser(Users user);
	public Users getUsers(String email, String password);
	public Users getForgotPasswordUser(String email, String mobileNumber);
	public void updateUsers(String email, String phoneNumber, String password);
}
