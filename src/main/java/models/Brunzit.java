package models;
import java.sql.Timestamp;

public class Brunzit implements java.io.Serializable {

	 private static final long serialVersionUID = 1L;

	 private int id = 0;
	 private int uid;
	 private String userName;
	 private Timestamp postDateTime;
	 private String content;
	 private Integer likes = 0;
	 private Integer parentId = null;
	 private Boolean isFlash = false;
	 private Boolean isLiked = false;
	 
	 public Brunzit() {
	 }

	 public Integer getId() {
		 return this.id;
	 }
	 
	 public void setId(Integer id) {
		 this.id = id;
	 }
	 
	 public Integer getLikes() {
		 return this.likes;
	 }
	 
	 public void setLikes(Integer likes) {
		 this.likes = likes;
	 }

	 public int getUid() {
		 return this.uid;
	 }
	 
	 public void setUid(int uid) {
		 this.uid = uid;
	 }
	 
	 public String getUserName() {
		 return this.userName;
	 }
	 
	 public void setUserName(String uname) {
		 this.userName = uname;
	 }
	 
	 public Timestamp getPostDateTime() {
		 return this.postDateTime;
	 }
	 public void setPostDateTime(Timestamp postDateTime) {
		 this.postDateTime = postDateTime;
	 }
	 
	 public String getContent() {
		 return this.content;
	 }
	 public void setContent(String content) {
		 this.content = content;
	 }
	 public Integer getParentId() {
		 return this.parentId;
	 }
	 public void setParentId(Integer pid) {
		 this.parentId = pid;
	 }
	 
	 public Boolean getIsFlash() {
		 return this.isFlash;
	 }
	 public void setIsFlash(Boolean isFlash) {
		 this.isFlash = isFlash;
	 }
	 
	 public Boolean getIsLiked() {
		 return this.isLiked;
	 }
	 public void setIsLiked(Boolean isLiked) {
		 this.isLiked = isLiked;
	 }

}