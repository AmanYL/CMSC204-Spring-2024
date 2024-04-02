public class CourseDBElement implements Comparable<CourseDBElement> {
    private String courseID;
    private int CRN;
    private int credits;
    private String roomNum;
    private String instructorName;
    //Constructor 
    public CourseDBElement(String courseID, int CRN, int credits, String roomNum, String instructorName) {
        this.courseID = courseID;
        this.CRN = CRN;
        this.credits = credits;
        this.roomNum = roomNum;
        this.instructorName = instructorName;
    }

    @Override
    public int compareTo(CourseDBElement other) {
        return Integer.compare(this.CRN, other.CRN);
    }
    
    public boolean equals(CourseDBElement other) {
    	boolean valid = true;
    	
    	if(Integer.compare(this.CRN, other.CRN) != 0)
    		valid = false;
    	if(Integer.compare(this.credits, other.credits) != 0)
    		valid = false;
    	if(!this.courseID.equals(other.courseID))
    		valid = false;
    	if(!this.roomNum.equals(other.roomNum))
    		valid = false;
    	if(!this.instructorName.equals(other.instructorName))
    		valid = false;
    	
    	return valid;
    }
    
    //Getters
    public String getID() {
    	return courseID;
    }
    public int getCRN() {
    	return CRN;
    }
    public int getCredits() {
    	return credits;
    }
    public String getRoomNum() {
    	return roomNum;
    }
    public String getInstructorName() {
    	return instructorName;
    }
    
    public String toString() {
    	String str = String.format("Course:%s CRN:%d Credits:%d Instructor:%s Room:%s", courseID, CRN, credits, instructorName, roomNum);
    	return str;
    }
}








