package feedback;

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

@WebServlet("/feedback")
public class FeedbackSevlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public FeedbackSevlet() {
        super();
    }
    private FeedbackDao feedbackDao;

    public void init() {
        feedbackDao = new FeedbackDao();
    }
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/feedbackDetails.jsp");
		dispatcher.forward(request, response);
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
   
    	int userID 	= Integer.parseInt(request.getParameter("userID"));
    	String name = request.getParameter("name");
    	String email 	= request.getParameter("email");
        int feedbackID 	= Integer.parseInt(request.getParameter("feedbackID"));
        String feedback 	= request.getParameter("feedback");
        
//      System.out.println(userID);
//      System.out.println(name);
//      System.out.println(email);
//      System.out.println(feedbackID);
//      System.out.println(feedback);

        Feedback feedbackObj = new Feedback();
        feedbackObj.setUserID(userID);
        feedbackObj.setName(name);
        feedbackObj.setEmail(email);
        feedbackObj.setFeedbackID(feedbackID);
        feedbackObj.setFeedback(feedback);
        

        try {
        	feedbackDao.registerFeedback(feedbackObj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/feedbackExit.jsp");
		dispatcher.forward(request, response);
    }
}