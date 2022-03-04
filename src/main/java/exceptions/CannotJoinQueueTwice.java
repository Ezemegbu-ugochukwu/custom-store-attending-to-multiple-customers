package exceptions;

public class CannotJoinQueueTwice extends Exception{
    public CannotJoinQueueTwice (String message){
        super(message);
    }
}
