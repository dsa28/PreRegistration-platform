/**
 * Created by mahmoudsafar on 4/15/17.
 */
public class Message {


    //private id;
    //private String timestamp;
    private String content;
    private int senderID;
    private int receiverID;
   // private Boolean readStatus = false;

    protected Message( int senderID, int receiverID, String content)
    {
        this.receiverID = receiverID;
        this.senderID = senderID;
        this.content = content;
    }


    int getReceiverID ()
    {
        return  receiverID;
    }

    int getSenderID ()
    {
        return senderID;
    }

    String getContent()
    {
        return content;
    }

//    void setReadStatus()
//    {
//        readStatus = true;
//    }


}
