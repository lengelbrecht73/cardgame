package za.co.advance.cardgame.exception;

public class UnsupportedCardGameException extends Exception {
    
    public UnsupportedCardGameException(){
        super("You tried to play an unsupported card game!");
    }

    public UnsupportedCardGameException(String message){
        super(message);
    }
}

