package user;

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

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public UserServlet() {
        super();
    }
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/userDetails.jsp");
		dispatcher.forward(request, response);
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
   
    	int userID 	= Integer.parseInt(request.getParameter("userID"));
    	String name = request.getParameter("name");
        long phoneNo 	= Long.parseLong(request.getParameter("phoneNo"));
        String email 	= request.getParameter("email");
        String address 	= request.getParameter("address");
        String password = request.getParameter("password");
        Date date = Date.valueOf(request.getParameter("date"));
        String photo = request.getParameter("photo");
        
//        System.out.println(userID);
//        System.out.println(name);
//        System.out.println(phoneNo);
//        System.out.println(email);
//        System.out.println(address);
//        System.out.println(password);
//        System.out.println(date);
//       System.out.println(photo);


        User user = new User();
        user.setUserID(userID);
        user.setName(name);
        user.setPhoneNo(phoneNo);
        user.setEmail(email);
        user.setAddress(address);
        user.setPassword(password);
        user.setDate(date);
        user.setPhoto(photo);
        

        try {
        	userDao.registerUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/userExit.jsp");
		dispatcher.forward(request, response);
    }
}