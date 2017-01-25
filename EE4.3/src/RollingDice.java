// Importing modules that we will need
import java.io.IOException;
import java.lang.Math;


public class RollingDice {
	//Constructor without parameters
	public RollingDice(){} 
	
	public int roll(int n) throws IOException{ 
		/**
		 * Description : Method that simulates the Rolling of Dice and calculate the final result until obtaining a specific result which is the parameter
		 * @param compteur : Number of throws to get the final score - scoreFinal : Final score after each throw
		 * @return compteur : Number of throws to get the final score 
		 */
		
		//Exception that checks if n is between 2 and 12
		IllegalArgumentException e = new IllegalArgumentException(); 
		if (n < 2 || n > 12){
			throw e; 
		}
		
		//Variables to count the final score and the number of throws to get it
		int compteur = 0; 
		int scoreFinal; 
		
		//we roll the dices until we get the number given in parameter 
		do{
		int Score1 = (int)(1 + (Math.random() * (6))); // Generate random number between 1 and 6 for the first Dice
		int Score2 = (int)(1 + (Math.random() * (6))); // Generate random number between 1 and 6 for the second Dice
		scoreFinal = Score1 + Score2; // Calculate the final score witch is the addition of the 2 dices
		compteur++;// we increments the number of throws 
		}while (scoreFinal != n);
		
		// We return the number of throws
		return compteur;
	}
	
	public static void main(String[] args) throws IOException{
		// Create a new object of type RollingDice
		RollingDice partie = new RollingDice();
		// We want to get 2 as final result (SnakeEyes), so we give 2 in parameter
		int resultat = partie.roll(2);
		// Print the result
		System.out.println("Nombre de lancés pour avoir 2 :"+resultat);
	}
}

