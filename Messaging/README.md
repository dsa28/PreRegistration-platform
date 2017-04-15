--Here's somewhere to start from!
The idea here is the following:
[Message: holds all information of a message object]
[Message Client: deals with the gui, database]

//Optimization Ideas
[Message Queue: all message clients send their messages to the queue in order to avoid crashes. this is an adapter.]
