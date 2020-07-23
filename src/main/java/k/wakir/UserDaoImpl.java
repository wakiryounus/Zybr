package k.wakir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {

	static Connection con;
	static PreparedStatement mPstatment;
	@Override
	public int insertUser(Users user) {
		int status = 0;
		try {
			con = DbConnectionProvider.getConnection();
			mPstatment = con.prepareStatement("INSERT INTO users1 VALUES(?,?,?,?,?,?)");
			mPstatment.setString(1, user.getFirstName());
			mPstatment.setString(2, user.getLastName());
			mPstatment.setString(3, user.getEmail());
			mPstatment.setString(4, user.getCompanyName());
			mPstatment.setString(5, user.getPhonenumber());
			mPstatment.setString(6, user.getPassword());
			status = mPstatment.executeUpdate();
			con.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	@Override
	public Users getUsers(String email, String password) {
		Users users = new Users();
		try {
			con = DbConnectionProvider.getConnection();
			mPstatment = con.prepareStatement("SELECT * FROM users1 WHERE email=? and password=?");
			mPstatment.setString(1, email);
			mPstatment.setString(2, password);
			ResultSet rs = mPstatment.executeQuery();
			while (rs.next()) {
				users.setFirstName(rs.getString(1));
				users.setLastName(rs.getString(2));
				users.setEmail(rs.getString(3));
				users.setCompanyName(rs.getString(4));
				users.setPhonenumber(rs.getString(5));
				users.setPassword(rs.getString(6));
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return users;
	}

	@Override
	public Users getForgotPasswordUser(String email, String mobileNumber) {
		// TODO Auto-generated method stub
		Users users = new Users();
		try {
			con = DbConnectionProvider.getConnection();
			mPstatment = con.prepareStatement("SELECT * FROM users1 WHERE email=? and phone=?");
			mPstatment.setString(1, email);
			mPstatment.setString(2, mobileNumber);
			ResultSet rs = mPstatment.executeQuery();
			while (rs.next()) {
				users.setFirstName(rs.getString(1));
				users.setLastName(rs.getString(2));
				users.setEmail(rs.getString(3));
				users.setCompanyName(rs.getString(4));
				users.setPhonenumber(rs.getString(5));
				users.setPassword(rs.getString(6));
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return users;
	}

	@Override
	public void updateUsers(String email, String phoneNumber, String password) {
		// TODO Auto-generated method stub
		try {
			con = DbConnectionProvider.getConnection();
			mPstatment = con.prepareStatement("UPDATE users1 set password=? where email=? and phone=?");
			mPstatment.setString(1,password);
			mPstatment.setString(2, email);
			mPstatment.setString(3, phoneNumber);
			mPstatment.executeUpdate();
			con.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
