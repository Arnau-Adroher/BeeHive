package managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import models.User;
import utils.DB;
import utils.HashUtils;

public class ManageUsers {
	
	private DB db = null ;
	
	public ManageUsers() {
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
	
	/* Get a user given its PK*/
	public User getUser(String userName) {
		String query = "SELECT usrName, userID, name, birthDate, isAdmin FROM users WHERE usrName = ? ;";
		PreparedStatement statement = null;
		ResultSet rs = null;
		User user = null;
		try {
			statement = db.prepareStatement(query);
			statement.setString(1,userName);
			rs = statement.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserName(rs.getString("usrName"));
				user.setId(rs.getInt("userID"));
				user.setName(rs.getString("name"));
				user.setBirthDate(rs.getString("birthDate"));
				user.setIsAdmin(rs.getInt("isAdmin"));
				user.setFollowers(this.getNumberFollowers(user.getId()));
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
		
	// Add new user
	public void addUser(String userName, String name, String pwd, String date) {
		String query = "INSERT INTO users (usrName,name,birthDate,pwd) VALUES (?,?,?,?)";
		PreparedStatement statement = null;	
   
		String hashedPwd = HashUtils.hashString(pwd);
		
		try {
			statement = db.prepareStatement(query);
			statement.setString(1,userName);
			statement.setString(2,name);
			statement.setString(3,date);
			statement.setString(4,hashedPwd);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/* Delete existing user */
	public void deleteUser(Integer id) {
		String query = "DELETE FROM users WHERE userID = ? ";
		PreparedStatement statement = null;
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,id);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* change name */
	public void changeName(String name, Integer id) {
		String query = "update users SET name = ? where userID = ?; ";
		PreparedStatement statement = null;
		try {
			statement = db.prepareStatement(query);
			statement.setString(1,name);
			statement.setInt(2,id);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* change birthdate */
	public void changeBirthDate(String date, Integer id) {
		String query = "update users SET birthDate = ? where userID = ?; ";
		PreparedStatement statement = null;
		try {
			statement = db.prepareStatement(query);
			statement.setString(1,date);
			statement.setInt(2,id);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isUnique(String userName, boolean[] errors) {
		String query = "SELECT usrName FROM users WHERE usrName = ?";
		PreparedStatement statement;
		ResultSet rs;
		boolean opt = true;
		try {
			statement = db.prepareStatement(query);
			statement.setString(1,userName);
			rs = statement.executeQuery();
			if(rs.isBeforeFirst()) {
				opt = false;
				errors[5] = true;
			}
			statement.close();
			rs.close();
			return opt;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return opt;
	}
	
	// Follow a user
		public void followUser(Integer uid, Integer fid) {
			String query = "INSERT INTO followers (userID,followingID) VALUES (?,?)";
			PreparedStatement statement = null;
			try {
				statement = db.prepareStatement(query);
				statement.setInt(1,uid);
				statement.setInt(2,fid);
				statement.executeUpdate();
				statement.close();
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// Unfollow a user
		public void unfollowUser(Integer uid, Integer fid) {
			String query = "DELETE FROM followers WHERE userID = ? AND followingID = ?";
			PreparedStatement statement = null;
			try {
				statement = db.prepareStatement(query);
				statement.setInt(1,uid);
				statement.setInt(2,fid);
				statement.executeUpdate();
				statement.close();
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public List<User> getNotFollowedUsers(Integer id) {
			 String query = "SELECT userID,usrName FROM users WHERE userID NOT IN (SELECT users.userID FROM users,followers WHERE users.userID = followingID AND followers.userID = ?) AND userID <> ? ORDER BY usrName LIMIT 10";
			 PreparedStatement statement = null;
			 List<User> l = new ArrayList<User>();
			 try {
				 statement = db.prepareStatement(query);
				 statement.setInt(1,id);
				 statement.setInt(2, id);
				 
				 ResultSet rs = statement.executeQuery();
				 while (rs.next()) {
					 User user = new User();
					 user.setId(rs.getInt("userID"));
					 user.setUserName(rs.getString("usrName"));
					 user.setFollowers(getNumberFollowers(user.getId()));
					 l.add(user);
				 }
				 rs.close();
				 statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return  l;
		}
		
		public List<User> getFollowedUsers(Integer id) {
			 String query = "SELECT users.userID as ID, users.usrName AS usr FROM users,followers WHERE users.userID = followingID AND followers.userID = ?;";
			 PreparedStatement statement = null;
			 List<User> l = new ArrayList<User>();
			 try {
				 statement = db.prepareStatement(query);
				 statement.setInt(1,id);
				 ResultSet rs = statement.executeQuery();
				 while (rs.next()) {
					 User user = new User();
					 user.setId(rs.getInt("ID"));
					 user.setUserName(rs.getString("usr"));
					 user.setFollowers(getNumberFollowers(user.getId()));
					 l.add(user);
				 }
				 rs.close();
				 statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return  l;
		}
		
		public Integer getNumberFollowers(Integer uid) {
			String query = "select count(*) as followers FROM followers WHERE followingID = ?;";
			PreparedStatement statement = null;
			Integer followers = 0;
			try {
				 statement = db.prepareStatement(query);
				 statement.setInt(1,uid);
				 ResultSet rs = statement.executeQuery();
				 while (rs.next()) {
					followers = rs.getInt("followers");
				 }
				 rs.close();
				 statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return followers;	
		}
		public boolean isFollowed(Integer uid, Integer fid) {
			String query = "SELECT userID FROM followers WHERE userID = ? and followingID = ?";
			PreparedStatement statement;
			ResultSet rs;
			boolean opt = false;
			try {
				statement = db.prepareStatement(query);
				statement.setInt(1,uid);
				statement.setInt(2,fid);
				rs = statement.executeQuery();
				if(rs.isBeforeFirst()) {
					opt = true;
				}
				statement.close();
				rs.close();
				return opt;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return opt;
		}
		
		//Get Top melos
		public List<User> getTopMelos() {
			 String query = "SELECT u.userID, u.usrName, COUNT(*) AS total_likes FROM users u JOIN brunzit b ON u.userID = b.userID JOIN likes l ON b.brunzitID = l.brunzitID GROUP BY u.userID ORDER BY total_likes DESC LIMIT 3;";
			 PreparedStatement statement = null;
			 List<User> list = new ArrayList<User>();
			 try {
				 statement = db.prepareStatement(query);

				 ResultSet rs = statement.executeQuery();
				 while (rs.next()) {
					 User user = new User();
					 user.setId(rs.getInt("u.userID"));
					 user.setUserName(rs.getString("u.usrName"));
					 user.setLikes(rs.getInt("total_likes"));
					 list.add(user);
				 }
				 rs.close();
				 statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return  list;
		}
	
	/*Check if all the fields are filled correctly */
	public boolean isComplete(User user) {
	    return(hasValue(user.getUserName()) &&
	    	   hasValue(user.getName()) &&
	    	   hasValue(user.getPwd1()) &&
	    	   hasValue(user.getBirthDate())&&
	           hasValue(user.getPwd2()) );
	}
	
	private boolean hasValue(String val) {
		return((val != null) && (!val.equals("")));
	}
		
	


}
