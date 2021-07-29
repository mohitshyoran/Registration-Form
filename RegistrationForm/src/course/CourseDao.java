package course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.javaguides.registration.model.Employee;

public class CourseDao {

	public int registerCourse(Course course) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO course" +
        							"  (course_id, c_name, c_desp, c_fees, c_resource) VALUES " +
        							" (?, ?, ?, ?, ?);";

        int result = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try {
        		Connection connection = DriverManager
        								.getConnection("jdbc:mysql://localhost:3306/e_learning?useSSL=false", "root", "Mohit@mysql1");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL); 
	            preparedStatement.setInt(1, course.getCourseID());
	            preparedStatement.setString(2, course.getName());
	            preparedStatement.setString(3, course.getDesp());
	            preparedStatement.setString(4, course.getFees());
	            preparedStatement.setString(5, course.getResource());

	
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