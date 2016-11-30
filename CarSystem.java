package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class CarSystem {

	public static void main(String[] args) {
			try{
		MoveDirection[] directions = new MoveDirection[args.length];
		OptionsParser pa = new OptionsParser();
		directions = pa.parse(args);

		List<HayStack> siano = new ArrayList<>();

		HayStack s1 = new HayStack(new Position(1, 1));
		HayStack s2 = new HayStack(new Position(0, 0));
		HayStack s3 = new HayStack(new Position(5, 5));
		HayStack s4 = new HayStack(new Position(2, 2));
		siano.add(s1);
		siano.add(s2);
		siano.add(s3);
		siano.add(s4);
		IWorldMap mapa = new UnboundedMap(siano);
		
		Car a1 = new Car(mapa, -4, -5);
		Car a2 = new Car(mapa, 7, 7);
		Car a3 = new Car(mapa, 0, 1);
		Car a4 = new Car(mapa, 2, 0);
		
		
		mapa.add(a1);
		mapa.add(a2);
		mapa.add(a3);
		mapa.add(a4);
		
		
		
		
		mapa.run(directions);
		System.out.println(mapa);
	} catch(IllegalArgumentException ex){
		System.out.println(ex.getMessage());
	
		
	}

	}
	
}
