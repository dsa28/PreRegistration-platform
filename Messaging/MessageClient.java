import java.util.Vector;

/**
 * Created by mahmoudsafar on 4/15/17.
 */
public abstract class MessageClient {




    void saveMessageToDB( Message M )
    {
     //Save message content and info into the database
     //The input of the constructor should be declared as global variables, more like a configuration file
     DatabaseConnection db = new DatabaseConnection(username, password, dbName);
     //Save message should take the info of M and store it in the DB in a suitable manner
     db.saveMessage(M);
     //Should we delete db as an object? to avoid memory overflow?

    }

    Message[] getInbox( int receiverID )
    {
        //Should return an array of messages based on the receiver's ID; the source is a database
        //The line below should create an object that allows us to connect to a db (should be provided by the other team)
        
        //The input of the constructor should be declared as global variables, more like a configuration file
        DatabaseConnection db = new DatabaseConnection(username, password, dbName);
        //or they could be hardcoded in the class [NOT ADVISABLE]
        //DatabaseConnection db = new DatabaseConnection();
        
        return db.getMessagesOfUser(receiverID);
        //Should we delete db as an object? to avoid memory overflow?

    }


    String readMessageFromInbox (Message M)
    {
        String content = M.getContent();
        M.setReadStatus();
        DatabaseConnection db = new DatabaseConnection(username, password, dbName);
        db.updateMessage(M);
        //Should we delete db as an object? to avoid memory overflow?
        return content;
    }

    void sendMessage ( int senderID, int receiverID, String content)
    {
        Message M = new Message(senderID, receiverID, content);
        DatabaseConnection db = new DatabaseConnection(username, password, dbName);
        db.saveMessage(M);
        //Should we delete db as an object? to avoid memory overflow?

    }

    void deleteMessageInDB (Message M)
    {
        //Deletes message in DB
        DatabaseConnection db = new DatabaseConnection(username, password, dbName);
        db.deleteMessage(M);
        //Should we delete db as an object? to avoid memory overflow?
    }

}
