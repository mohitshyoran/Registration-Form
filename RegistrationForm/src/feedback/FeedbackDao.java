package feedback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.javaguides.registration.model.Employee;

public class FeedbackDao {

	public int registerFeedback(Feedback feedback) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO feedback (user_id, name, email, f_id, feedback) VALUES (?, ?, ?, ?, ?);";

        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try {
        		Connection connection = DriverManager
        								.getConnection("jdbc:mysql://localhost:3306/e_learning?useSSL=false", "root", "Mohit@mysql1");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL); 
	            preparedStatement.setInt(1, feedback.getUserID());
	            preparedStatement.setString(2, feedback.getName());
	            preparedStatement.setString(3, feedback.getEmail());
	            preparedStatement.setInt(4, feedback.getFeedbackID());
	            preparedStatement.setString(5, feedback.getFeedback());

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