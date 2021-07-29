package contact;

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

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public ContactServlet() {
        super();
    }
    private ContactDao contactDao;

    public void init() {
        contactDao = new ContactDao();
    }
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/contactDetails.jsp");
		dispatcher.forward(request, response);
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
   
    	int userID 	= Integer.parseInt(request.getParameter("userID"));
    	String name = request.getParameter("name");
    	String email 	= request.getParameter("email");
        long phoneNo 	= Long.parseLong(request.getParameter("phoneNo"));
        String message 	= request.getParameter("message");
        int contactID 	= Integer.parseInt(request.getParameter("contactID"));
        
//      System.out.println(userID);
//      System.out.println(name);
//      System.out.println(email);
//      System.out.println(phoneNo);
//      System.out.println(message);
//      System.out.println(contactID);

        Contact contact = new Contact();
        contact.setUserID(userID);
        contact.setName(name);
        contact.setEmail(email);
        contact.setPhoneNo(phoneNo);
        contact.setMessage(message);
        contact.setContactID(contactID);
        

        try {
        	contactDao.registerContact(contact);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/contactExit.jsp");
		dispatcher.forward(request, response);
    }
}