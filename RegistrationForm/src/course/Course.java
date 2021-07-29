package course;

import java.io.Serializable;
import java.sql.Date;


public class Course implements Serializable {
 
	private static final long serialVersionUID = 1L;
    private int courseID;
    private String name;
    private String desp;
    private String fees;
    private String resource;
   
    public int getCourseID() {
        return courseID;
    }
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesp() {
        return desp;
    }
    public void setDesp(String desp) {
        this.desp = desp;
    }
    public String getFees() {
        return fees;
    }
    public void setFees(String fees) {
        this.fees = fees;
    }
    public String getResource() {
        return resource;
    }
    public void setResource(String resource) {
        this.resource = resource;
    }
}