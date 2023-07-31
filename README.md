# BeeHive - Social Network

BeeHive is a Twitter-like social network with a bee-themed twist, developed using HTML, Java, JavaScript, CSS, Bootstrap, MySQL, and Tomcat 9.

## Requirements
To run the BeeHive application, ensure you have the following installed on your computer:

1. JDK (Java Development Kit) 17 or later. You can download it from: [Oracle JDK Downloads](https://www.oracle.com/java/technologies/downloads/#jdk17-windows)
2. Eclipse IDE for Enterprise Java and Web Developers (Version: 2023-03). Download from: [Eclipse IDE](https://eclipseide.org/)
3. Apache Tomcat 9.0. You can get it from: [Apache Tomcat Downloads](https://tomcat.apache.org/download-90.cgi)
4. MySQL Database. Download from: [MySQL Downloads](https://dev.mysql.com/downloads/mysql/)

## Instructions
### Installing the Software
1. Install JDK 17.
2. Install Eclipse IDE for Enterprise Java and Web Developers.
3. Download and set up Apache Tomcat 9.0.
4. Install MySQL Database.

### Configurations
1. Create a user to connect to the database:
   ```
   CREATE USER 'mysql'@'localhost' IDENTIFIED BY 'prac';
   GRANT ALL PRIVILEGES ON *.* TO 'mysql'@'localhost';
   ```

2. Download the `BeeHive.war` file and import it into the Eclipse IDE.
3. Run `ManagerAdmin.java` on the Tomcat Servlet.

## Functionalities
The BeeHive social network provides the following features:

### Register page:
- Register users.
- Admin Users (need to be manually created in the database).

### Log In page:
- View without registration.
- Log in users.
- Implemented cookies for user login.

### Main Timeline:
- Feed.
- Post (called "Brunzits").
- Temporal post (Flash brunzit, lasts for 24h).
- Like/Dislike.
- Comment (logic implemented in the database and button, but not functional in Servlet).
- Top melós (Top users with more likes).
- Profile suggestions (Follow, Visit profile).

### Profile timeline:
- Profile feed.
- Post/Delete post (if it's the user's own profile).
- Temporal post/Delete temporal post (if it's the user's own profile).
- Edit Profile (if it's the user's own profile).
- Info on profile photo.
- Follow/Unfollow (if it's not the user's own profile).
- Delete Account (if it's the user's own profile).
- Users following (if it's the user's own profile).
- Profile suggestions (if it's not the user's own profile).

## Authors
BeeHive - Social Network is developed by Anna Buch, Arnau Adroher, and Maria Gómez.
