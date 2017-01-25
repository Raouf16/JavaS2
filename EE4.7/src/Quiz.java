// Importing modules that we will need
import java.lang.Math;
import java.util.Scanner;

public class Quiz {
	/**
	 * Description : Class Quiz which contains the subroutines and which will administers a basic addition quiz to the user
	 * @param int[] nombreGauche : Array which contains the left number of the addition - int[] nombreDroite : Array which contains the right number of the addition - int[] reponseUtilis : Array which contains the result given by the user
	 */
	// Global variables
	int[] nombreGauche = new int[10]; // Array which contains the left number of the addition
	int[] nombreDroite = new int[10]; // Array which contains the right number of the addition
	int[] reponseUtilis = new int[10]; // Array which contains the result given by the user
	
	//Constructor without parameters
	public Quiz(){}
	
	// Method that initialize
	public void createQuiz(){
		/**
		 * Description : Method that initializes the two arrays : nombreGauche & nombreDroite 
		 * @param no parameters
		 * @return void
		 */
		
		for(int i = 0 ; i < 10 ; i++){
			nombreGauche[i] = (int)(1 + (Math.random() * (100)));
			nombreDroite[i] = (int)(1 + (Math.random() * (100)));
		}
	}
	
	public void administerQuiz(){
		/**
		 * Description : Method that read the results given by the user and put them on the array reposeUtilis 
		 * @param Scanner sc : to read the user results
		 * @return void
		 */
		
		System.out.println("Bonjour, Préparez vous au Quizz !");
		Scanner sc = new Scanner(System.in);
		
		// We have to ask the user the result of an addition, 10 times
		for(int i = 0 ; i < 10 ; i++){
			System.out.println("Veuillez saisir le résultat de l'addition :");
			System.out.println(nombreGauche[i]+" + "+nombreDroite[i]+" = ");
			int nbEntree = sc.nextInt();
			reponseUtilis[i] = nbEntree;
		}
		
	}
	
	public int gradeQuizz(){
		/**
		 * Description : Method that check the results and give points or not to the user
		 * @param score : which will be incremented if the user give a right answer
		 * @return score : the score of the user
		 */
		
		int score = 0;
		System.out.println("\n Vos résultats : ");
		for(int i = 0 ; i < 10 ; i++){
			// if the user has given the right answer
			if((nombreGauche[i] + nombreDroite[i]) == reponseUtilis[i]){
				System.out.println("\n"+nombreGauche[i]+" + "+nombreDroite[i]+" = "+reponseUtilis[i]+" Bonne réponse ! ");
				score += 10;
			}
			// if the user has given a false answer
			else{
				System.out.println("\n"+nombreGauche[i]+" + "+nombreDroite[i]+" = "+reponseUtilis[i]+" Mauvaise réponse ..");
				// We also give the right answer to the user 
				System.out.println("La bonne réponse est : "+nombreGauche[i]+" + "+nombreDroite[i]+" = "+(nombreGauche[i]+nombreDroite[i]));
			}
		}
		return score;
	}
	
	public static void main(String[]args){
		// Create a new object of type Quiz
		Quiz quiz1 = new Quiz();
		quiz1.createQuiz();
		quiz1.administerQuiz();
		int resultat = quiz1.gradeQuizz();
		System.out.println("Votre score est de : "+resultat);
	}
}
