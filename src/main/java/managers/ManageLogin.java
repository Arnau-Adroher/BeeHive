package managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Login;
import utils.DB;
import utils.HashUtils;

public class ManageLogin {
	private DB db = null;

	public ManageLogin() {
		try {
			db = new DB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void finalize() {
		try {
			db.disconnectBD();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public boolean checkCredentials(String userName, String pwd, boolean[] errors) {
		String query = "SELECT usrName,pwd FROM users WHERE usrName = ?";
		PreparedStatement statement;
		ResultSet rs;
		boolean opt = false;
		try {
			statement = db.prepareStatement(query);
			statement.setString(1, userName);
			rs = statement.executeQuery();
			if (rs.isBeforeFirst()) {
				rs.next();
				String dbPwd = rs.getString(2);
				String hashedPwd = HashUtils.hashString(pwd);
				if(hashedPwd.equals(dbPwd)) {
					opt = true;
				}else {
					errors[1] = true; //wrong password
				}
				
			}else {
				errors[0] = true; //wrong username
			}
			statement.close();
			rs.close();
			return opt;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return opt;
	}
	

	/* Check if all the fields are filled correctly */
	public boolean isComplete(Login user) {
	    return(hasValue(user.getUserName())&&
	    		hasValue(user.getPwd()));
	}

	private boolean hasValue(String val) {
		return ((val != null) && (!val.equals("")));
	}
}
