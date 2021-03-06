//Toufic Nouwayhed
//The database is made up of 8 tables:
//1. users (UserID, UserPassword)
//2. teachers (UserID, TeacherName)
//3. students (UserID, StudentName)
//4. administrators (UserID, AdministratorName)
//5. rooms (RoomID, Capacity)
//6. course (CourseID, CourseTime, Capacity, UserID(teachers), RoomID(rooms))
//7. courseuser (UserID, CourseID) //used for the schedule
//8. messages (UserID(users), MessageTimestamp, MessageBody)
import javax.swing.*;
import java.sql.*;

public class ddb {


  public String retrieveCourse(String co) {

	try{    
		Class.forName("com.mysql.jdbc.Driver");//Register JDBC driver
		//Open a connection using JDBC driver name and database URL
   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prereg","root","root");
   Statement stmt = con.createStatement();
   
   ResultSet rs = stmt.executeQuery("select CourseID from course where CourseID = '"+ co + "'");
   //TODO: fix the query to get the capacity and the rest of the information.
  //select the required course
   con.close();
   return rs.getString(0);
   
   }
	catch(Exception e)
	{
      //Handle errors for Class.forName
		e.printStackTrace();
		return "Error";
      }
	}
  public void StoreCourse(String co, String timee, int capacityy, int userid, String roomid) {

		try{    
			Class.forName("com.mysql.jdbc.Driver");//Register JDBC driver
			//Open a connection using JDBC driver name and database URL
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prereg","root","root");
	   Statement stmt = con.createStatement();
	   //store the required course
	   stmt.executeUpdate("insert into 'course' (CourseID, CourseTime, Capacity, UserID, RoomID) VALUE ( '"+ co + "','"+ timee + "','" + capacityy + "','" + userid + "','" + roomid + "')");
	   System.out.println("DONE");
	   con.close();
	   
	   }
		catch(Exception e)
		{
	      //Handle errors for Class.forName
			e.printStackTrace();
	      }
		}
 public String[] RetreiveSchedule(int userid) {
	
		try{    
			Class.forName("com.mysql.jdbc.Driver");//Register JDBC driver
			//Open a connection using JDBC driver name and database URL
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prereg","root","root");
	   Statement stmt = con.createStatement();
	   //select all the courses associated with the teacher or student id (UserID)
	   ResultSet rs = stmt.executeQuery("select CourseID from courseuser where UserID = '"+ userid + "'");
	   
	   
	   String result[]=new String[10];
	   int i = 0;
	   while(rs.next())
	   {
		   result[i] = rs.getString(0);	  
		   i++;
	   }//put the results in an array of strings assuming a maximum of 
	   //10 courses a student or teacher can take
	   System.out.println("DONE");
	   con.close();
	   return result;
	   }
		catch(Exception e)
		{
	      //Handle errors for Class.forName
			e.printStackTrace();
			String result[]=new String[10];
			return result;
	      }
		}
 public void StoreCourseForUser(String co, int userid) {
		try{    
			Class.forName("com.mysql.jdbc.Driver");//Register JDBC driver
			//Open a connection using JDBC driver name and database URL
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prereg","root","root");
	   Statement stmt = con.createStatement();
	   //insert a course for a user taking it
	   //to implement an entire schedule insert each course for the user seperately
	   //and then the selects takes them all.
	   stmt.executeUpdate("insert into 'courseuser' (CourseID, UserID) VALUE ( '"+ co + "','" + userid  + "')");
	   System.out.println("DONE");
	   con.close();
	   }
		catch(Exception e)
		{
	      //Handle errors for Class.forName
			e.printStackTrace();
	      }
		}
 public String retrieveMessages(int userid) {

		try{    
			Class.forName("com.mysql.jdbc.Driver");//Register JDBC driver
			//Open a connection using JDBC driver name and database URL
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prereg","root","root");
	   Statement stmt = con.createStatement();
	   //select the Message sent (most recent one for this user)
	   //TODO: if demanded, select a message with a specific timestamp
	   ResultSet rs = stmt.executeQuery("select MessageBody from messages where UserID = '"+ userid + "'");
	  
	   con.close();
	   return rs.getString(0);
	   
	   }
		catch(Exception e)
		{
	      //Handle errors for Class.forName
			e.printStackTrace();
			return "Error";
	      }
		}
 public void StoreMessage(String messa, int userid, String datetimee) {//date time should be of the following format
 								       //yyyy-mm-dd hh:mm:ss.xxxxx

		try{    
			Class.forName("com.mysql.jdbc.Driver");//Register JDBC driver
			//Open a connection using JDBC driver name and database URL
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prereg","root","root");
	   Statement stmt = con.createStatement();
	   //store a message
	   stmt.executeUpdate("insert into 'messages' (UserID, MessageTimestamp, MessageBody) VALUE ( '"+ userid + "','" + datetimee  + "','" + messa + "')");
	   System.out.println("DONE");
	   con.close();
	   }
		catch(Exception e)
		{
	      //Handle errors for Class.forName
			e.printStackTrace();
	      }
		}

	public boolean checkCredentials(int userid, String password) {


      boolean credCorrect = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");//Register JDBC driver
			//Open a connection using JDBC driver name and database URL
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DataStorage","root","root");
			Statement stmt = con.createStatement();
			//check if row exists
			ResultSet rs = stmt.executeQuery("select UserID, UserPassword from users where UserID='"+userid+"' AND UserPassword='"+password+"'");


			if (rs.getFetchSize() != 0)
            {

                 credCorrect = true;
            }



			System.out.println("DONE");
			con.close();
			return credCorrect;
		}
		catch(Exception e)
		{
			//Handle errors for Class.forName
			e.printStackTrace();
			System.out.println("Not working");
		}
		return credCorrect;
	}


   }


