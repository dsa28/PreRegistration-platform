/**
 * Created by mahmoudsafar on 5/16/17.
 */
public class Request {

    private RequestState state;
    private int requestID;

    private int teacherID;
    private int studentID;
    private String courseName;
    private String requestText;

    Request(int teacherID, int studentID, String courseName, String requestText, int requestID)
    {
        this.teacherID = teacherID;
        this.studentID = studentID;
        this.courseName = courseName;
        this.requestText = requestText;
        state = RequestState.Pending;
        this.requestID = requestID;

    }

    public String toString()
    {
        return getRequestID() + "::[" + getState() + "] From: " + getStudentID() + ", Course: " + getCourseName() +
                ", Request Note: " + getRequestText();
    }

    public int getTeacherID()
    {
        return teacherID;
    }

    public int getStudentID()
    {
        return studentID;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public String getRequestText()
    {
        return requestText;
    }

    public int getRequestID()
    {
        return requestID;
    }

    public String getState()
    {
        return state.getState();
    }

    public void rejectRequest()
    {
        state = RequestState.Rejected;
    }

    public void approveRequest()
    {
        state = RequestState.Approved;
    }





}
