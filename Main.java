package WPM;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Scanner scan = new Scanner(System.in);
		int dif=0;
		boolean invalid = false;
		do{
		System.out.println("Select Difficulty: "); //Difficulty level menu
		System.out.println("1. Easy \n"	
						  +"2. Medium \n"
					   	  +"3. Hard \n"
						  +"4. Custom");
		System.out.println();
		dif=scan.nextInt(); 
		switch (dif) {				//use of switch case to execute test in desired level
		case 1:
			Challenge.chal(8); 		
			break;
		case 2:
			Challenge.chal(11);
			break;
		case 3:
			Challenge.chal(15);		//8, 11 and 15 are the predefined number of words in the particular level
			break;
		case 4:
			System.out.println("Enter no. of words: ");
			int w=scan.nextInt();
			Challenge.chal(w);
		default:System.out.println("Enter Valid No.");
				invalid=true;
		}
	}while(invalid);
		scan.close();
	}

}