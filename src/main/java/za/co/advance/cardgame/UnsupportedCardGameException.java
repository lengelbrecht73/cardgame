package za.co.advance.cardgame;

public class UnsupportedCardGameException extends Exception {
    
    public UnsupportedCardGameException(){
        super("You tried to play an unsupperted card game!");
    }

    public UnsupportedCardGameException(String message){
        super(message);
    }
}

