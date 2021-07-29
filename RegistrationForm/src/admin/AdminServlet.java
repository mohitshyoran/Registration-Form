package admin;

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

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public AdminServlet() {
        super();
    }
    private AdminDao adminDao;

    public void init() {
        adminDao = new AdminDao();
    }
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/adminDetails.jsp");
		dispatcher.forward(request, response);
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
   
    	int adminID 	= Integer.parseInt(request.getParameter("adminID"));
    	String name = request.getParameter("name");
    	String email 	= request.getParameter("email");
        String password 	= request.getParameter("password");
              
//      System.out.println(adminID);
//      System.out.println(name);
//      System.out.println(email);
//      System.out.println(password);

        Admin admin = new Admin();
        admin.setAdminID(adminID);
        admin.setName(name);
        admin.setEmail(email);
        admin.setPassword(password);
      
        

        try {
        	adminDao.registerAdmin(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/adminExit.jsp");
		dispatcher.forward(request, response);
    }
}