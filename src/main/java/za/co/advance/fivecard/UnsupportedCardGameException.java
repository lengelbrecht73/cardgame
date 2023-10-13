package za.co.advance.fivecard;

public class UnsupportedCardGameException extends Exception {
    
    public UnsupportedCardGameException(){
        super("You tried to play an unsopperted card game!");
    }

    public UnsupportedCardGameException(String message){
        super(message);
    }
}
