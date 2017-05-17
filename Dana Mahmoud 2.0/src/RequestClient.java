import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by mahmoudsafar on 5/16/17.
 */
public class RequestClient {

    ArrayList<Request> requests;
    int fence; //use this as an itterator for the RequestClient class

    public void sendRequest(int teacherID, int studentID, String courseName, String requestText)
    {
        Request r = new Request(teacherID, studentID, courseName, requestText, requests.size() + 1 );
        requests.add(r);
    }

    public void start()
    {
        fence = 0;
    }

    public Request getNextRequest(user User)
    {
        return getNextRequest(User.getId());
    }

    public Request getNextRequest(int id)
    {

        for (; fence<requests.size(); fence++)
        {

            if(requests.get(fence).getTeacherID() == id)
            {

                Request found =  requests.get(fence);
                fence++; //we finished evaluating this result, need to move on to the next to avoid infinite loops

                return found;
            }
        }

        return null; //not found
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
        fence = 0;
    }



}
