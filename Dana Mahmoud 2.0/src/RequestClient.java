import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by mahmoudsafar on 5/16/17.
 */
public class RequestClient {

    ArrayList<Request> requests;

    public void sendRequest(int teacherID, int studentID, String courseName, String requestText)
    {
        Request r = new Request(teacherID, studentID, courseName, requestText, requests.size() + 1 );
        requests.add(r);
    }

    public ArrayList<Request> getRequestsForTeacher (int id)
    {
        ArrayList<Request> studentRequests = new ArrayList<Request>();
        for (Request r: requests) {
            if(r.getTeacherID() == id)
            {
                studentRequests.add(r);
            }
        }

        return studentRequests;
    }


    public void approveCourse(int requestID)
    {

        for (Request r: requests) {


            if(r.getRequestID() == requestID)
            {
                r.approveRequest();
                return; //ID is unique-- there can only be one such request
            }
        }
    }

    public void rejectCourse(int requestID)
    {
        for (Request r: requests) {
            if(r.getRequestID() == requestID)
            {
                r.rejectRequest();
                return; //ID is unique - there can only be one such request
            }
        }
    }


     RequestClient()
    {
        requests = new ArrayList<Request>();
    }



}
