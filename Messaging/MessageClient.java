import java.util.Vector;

/**
 * Created by mahmoudsafar on 4/15/17.
 */
public abstract class MessageClient {




    void saveMessageToDB( Message M )
    {
     //Save message content and info into the database

    }

    Vector<Message> getInbox( int receiverID )
    {

        //Gets all messages of the user of ID == receiverID

    }


    String readMessageFromInbox (Message M)
    {
        String content = M.getContent();
        M.setReadStatus();
        updateMessageInDB(M);
        return content;
    }

    void updateMessageInDB(Message M)
    {
        //Updates message reading status
        //Can't this be done via another function?

    }

    void sendMessage ( int senderID, int receiverID, String content)
    {
        Message M = new Message(senderID, receiverID, content);
        saveMessageToDB(M);

    }

    void deleteMessageInDB (Message M)
    {
        //Deletes message in DB
    }

}
