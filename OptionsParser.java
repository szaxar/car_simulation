package agh.cs.lab2;

public class OptionsParser {

	public MoveDirection[] parse(String[] args) {

		MoveDirection[] tablica = new MoveDirection[args.length];
		int i = 0;
		
		
		
		
		for (String argument : args) {
			
				
			switch (argument) {
			case "f":
				tablica[i] = MoveDirection.Forward;
				i++;
				break;

			case "b":
				tablica[i] = MoveDirection.Backward;
				i++;
				break;

			case "r":
				tablica[i] = MoveDirection.Right;
				i++;
				break;
			case "l":
				tablica[i] = MoveDirection.Left;
				i++;
				break;
			
			default:
				throw new IllegalArgumentException("bledne wartosci");
			
			}
			
			

			}
		

		
		
		
		
		
		
		return tablica;
	}
}
