import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by mahmoudsafar on 4/15/17.
 */
public class MessageClient {

	Vector<Message> messages = new Vector<>();

//Notice: this is not really needed? Can be substitued by sendMessage()
//    void saveMessageToDB( Message M )
//    {
//     //Save message content and info into the database
//     //The input of the constructor should be declared as global variables, more like a configuration file
//     DatabaseConnection db = new DatabaseConnection(username, password, dbName);
//     //Save message should take the info of M and store it in the DB in a suitable manner
//     db.saveMessage(M);
//     //Should we delete db as an object? to avoid memory overflow?
//
//    }

    Vector<Message> getInbox( int receiverID )
    {
    	Vector<Message> inbox = new Vector<>();

		for (Message m:
			messages ) {

			if(m.getReceiverID() == receiverID)
			{
				inbox.add(m);
			}

		}

		return inbox;
	}



    void sendMessage ( int senderID, int receiverID, String content)
    {
        Message M = new Message(senderID, receiverID, content);
        messages.add(M);

    }

}
