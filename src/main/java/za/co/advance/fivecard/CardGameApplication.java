package za.co.advance.fivecard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardGameApplication {

	
	static FiveCardApplication fiveCardGame = new FiveCardApplication();

	public static void main(String[] args){
	
		SpringApplication.run(CardGameApplication.class, args);
		fiveCardGame.fiveCardGame(args[0]);

	}

}

