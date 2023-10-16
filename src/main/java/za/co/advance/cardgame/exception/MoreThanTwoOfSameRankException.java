package za.co.advance.cardgame.exception;

public class MoreThanTwoOfSameRankException extends Exception {
    
    public MoreThanTwoOfSameRankException(){
        super("You cannot have more than two of the same Rank. I smell a cheater!");
    }

    public MoreThanTwoOfSameRankException(String message){
        super(message);
    }
}

