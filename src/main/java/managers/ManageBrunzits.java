package managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import models.Brunzit;
import utils.DB;


public class ManageBrunzits {
	
	private DB db = null ;
	
	public ManageBrunzits() {
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
	
	/* Add a brunzit */
	public void addBrunzit(Brunzit brunzit) {
		String query = "INSERT INTO brunzit (userID, content, publicationDate, isFlash) VALUES (?,?,?,?)";
		PreparedStatement statement = null;
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,brunzit.getUid());
			statement.setString(2,brunzit.getContent());
			statement.setTimestamp(3,brunzit.getPostDateTime());
			statement.setBoolean(4, brunzit.getIsFlash());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* Add a like */
	public void addLike(Integer uid, Integer bid) {
		String query = "INSERT INTO likes (userID, brunzitID) VALUES (?,?)";
		PreparedStatement statement = null;
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,uid);
			statement.setInt(2,bid);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*see if a user liked a brunzit*/
	public boolean isLiked(Integer uid, Integer bid) {
		String query = "SELECT userID FROM likes WHERE userID = ? and brunzitID = ?";
		PreparedStatement statement;
		ResultSet rs;
		boolean opt = false;
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,uid);
			statement.setInt(2,bid);
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
	/* Delete like, dislike */
	public void dislike(Integer uid, Integer bid) {
		String query = "DELETE FROM likes WHERE userID = ? and brunzitID = ?";
		PreparedStatement statement = null;
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,uid);
			statement.setInt(2,bid);			
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/* Delete existing brunzit */
	public void deleteBrunzit(Integer id) {
		String query = "DELETE FROM brunzit WHERE brunzitID = ? ";
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
	
	
	
	/* Get brunzits from a user given start and end*/
	public List<Brunzit> getUserBrunzits(Integer uid) {
		 String query = "SELECT brunzit.brunzitID,brunzit.userID,brunzit.publicationDate,brunzit.content,brunzit.isFlash, users.usrName FROM brunzit INNER JOIN users ON brunzit.userID = users.userID WHERE brunzit.userID = ? ORDER BY brunzit.publicationDate DESC LIMIT 10;";
		 PreparedStatement statement = null;
		 List<Brunzit> l = new ArrayList<Brunzit>();
		 try {
			 statement = db.prepareStatement(query);
			 statement.setInt(1,uid);
			 
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 Brunzit brunzit = new Brunzit();
       		     brunzit.setId(rs.getInt("brunzitID"));
				 brunzit.setUid(rs.getInt("userID"));
				 brunzit.setPostDateTime(rs.getTimestamp("publicationDate"));
				 brunzit.setContent(rs.getString("content"));
				 brunzit.setUserName(rs.getString("usrName"));
				 brunzit.setIsFlash(rs.getBoolean("isFlash"));
				 brunzit.setLikes(getBrunzitLikes(brunzit.getId()));
				 
				 l.add(brunzit);					 

			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  l;
	}
	public Integer getBrunzitLikes(Integer bID){
		String query = "SELECT COUNT(*) as likes FROM likes where likes.brunzitID = ?;";
		PreparedStatement statement = null;
		Integer likes = 0;
		try {
			 statement = db.prepareStatement(query);
			 statement.setInt(1,bID);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				likes = rs.getInt("likes");
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return likes;	
	} 
	
	public Integer getTopUser(Integer uID){
		String query = "SELECT COUNT(*) AS likes FROM likes, brunzits where brunzits.brunzitID = likes.brunzitID and brunzit.userID = ?;";
		PreparedStatement statement = null;
		Integer uLikes = 0;
		try {
			 statement = db.prepareStatement(query);
			 statement.setInt(1,uID);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 uLikes = rs.getInt("likes");
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return uLikes;	
	} 
	
	
	/* Get brunzits from following users given start and end*/
	public List<Brunzit> getTimeline(Integer uid) {
		String query = "SELECT brunzit.brunzitID, brunzit.publicationDate, brunzit.content, brunzit.isFlash, users.usrName, users.userID FROM brunzit JOIN users ON brunzit.userID = users.userID WHERE (brunzit.parentID IS NULL AND brunzit.userID IN (SELECT followingID FROM followers WHERE userID = ?)) OR (brunzit.parentID IS NULL AND brunzit.userID = ?) ORDER BY brunzit.publicationDate DESC LIMIT 50;";
		PreparedStatement statement = null;
		List<Brunzit> l = new ArrayList<Brunzit>();
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,uid);
			statement.setInt(2,uid);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Brunzit brunzit = new Brunzit();
				brunzit.setId(rs.getInt("brunzitID"));
				brunzit.setUid(rs.getInt("userID"));
				brunzit.setPostDateTime(rs.getTimestamp("publicationDate"));
				brunzit.setContent(rs.getString("content"));
				brunzit.setUserName(rs.getString("usrName"));
				brunzit.setIsFlash(rs.getBoolean("isFlash"));
				brunzit.setLikes(getBrunzitLikes(brunzit.getId()));
				if(brunzit.getIsFlash()) {
					 Timestamp currentTime = new Timestamp(System.currentTimeMillis());
					 Timestamp publicationDate = brunzit.getPostDateTime();
					 long millisecondsDifference = Math.abs(currentTime.getTime() - publicationDate.getTime());
				     long hoursDifference = millisecondsDifference / (60 * 60 * 1000);
				     if (hoursDifference < 24) {
				       	 l.add(brunzit);
				     }
				 }else {
					 l.add(brunzit);					 
				 }
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  l;
	}
	/* Get brunzits for anonimous users*/
	public List<Brunzit> getAnonimousTimeline() {
		String query = "SELECT brunzit.brunzitID, brunzit.publicationDate, brunzit.content, brunzit.isFlash, users.usrName, users.userID FROM brunzit JOIN users ON brunzit.userID = users.userID WHERE brunzit.parentID IS NULL ORDER BY brunzit.publicationDate DESC LIMIT 50;";
		PreparedStatement statement = null;
		List<Brunzit> l = new ArrayList<Brunzit>();
		try {
			statement = db.prepareStatement(query);
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Brunzit brunzit = new Brunzit();
				brunzit.setId(rs.getInt("brunzitID"));
				brunzit.setUid(rs.getInt("userID"));
				brunzit.setPostDateTime(rs.getTimestamp("publicationDate"));
				brunzit.setContent(rs.getString("content"));
				brunzit.setUserName(rs.getString("usrName"));
				brunzit.setIsFlash(rs.getBoolean("isFlash"));
				brunzit.setLikes(this.getBrunzitLikes(brunzit.getId()));
				if(brunzit.getIsFlash()) {
					 Timestamp currentTime = new Timestamp(System.currentTimeMillis());
					 Timestamp publicationDate = brunzit.getPostDateTime();
					 long millisecondsDifference = Math.abs(currentTime.getTime() - publicationDate.getTime());
				     long hoursDifference = millisecondsDifference / (60 * 60 * 1000);
				     if (hoursDifference < 24) {
				       	 l.add(brunzit);
				     }
				 }else {
					 l.add(brunzit);					 
				 }
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  l;
	}
	
	
}