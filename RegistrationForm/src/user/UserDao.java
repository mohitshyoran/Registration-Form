package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.javaguides.registration.model.Employee;

public class UserDao {

	public int registerUser(User user) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO user1" +
        							"  (user_id, name, phone_no, email, address, reg_date, password, photo) VALUES " +
        							" (?, ?, ?, ?, ?,?,?,?);";

        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try {
        		Connection connection = DriverManager
        								.getConnection("jdbc:mysql://localhost:3306/e_learning?useSSL=false", "root", "Mohit@mysql1");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL); 
	            preparedStatement.setInt(1, user.getUserID());
	            preparedStatement.setString(2, user.getName());
	            preparedStatement.setLong(3, user.getPhoneNo());
	            preparedStatement.setString(4, user.getEmail());
	            preparedStatement.setString(5, user.getAddress());
	            preparedStatement.setDate(6, user.getDate());
	            preparedStatement.setString(7, user.getPassword());
	            preparedStatement.setString(8, user.getPhoto());
	
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();
        } 
        catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) 
        {
            if (e instanceof SQLException) 
            {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
               }
           }
       }
    }
}