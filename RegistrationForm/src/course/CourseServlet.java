package course;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.UserDao;
import user.User;

@WebServlet("/course")
public class CourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public CourseServlet() {
        super();
    }
    private CourseDao courseDao;

    public void init() {
    	courseDao = new CourseDao();
    }
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/courseDetails.jsp");
		dispatcher.forward(request, response);
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
   
    	int courseID 	= Integer.parseInt(request.getParameter("courseID"));
    	String name 	= request.getParameter("name");
        String desp 	= request.getParameter("desp");
        String fees 	= request.getParameter("fees");
        String resource 	= request.getParameter("resource");
       
//        System.out.println(courseID);
//        System.out.println(name);
//        System.out.println(desp);
//        System.out.println(fees);
//        System.out.println(resource);

        Course course = new Course();
        course.setCourseID(courseID);
        course.setName(name);
        course.setDesp(desp);
        course.setFees(fees);
        course.setResource(resource);
 
        try {
        	courseDao.registerCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/courseExit.jsp");
		dispatcher.forward(request, response);
    }
}