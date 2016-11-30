package agh.cs.lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver   {

	protected List<Car> cars = new ArrayList<>();

	Map<Position, Car> hashMapa = new HashMap<>();
	

	@Override
	public boolean canMoveTo(Position position) {
		if (isOccupied(position) == false)
			return true;
		else
			return false;
	}

	@Override
	public boolean add(Car car) {
		Position pozycja;
		pozycja = car.getPosition();

		if (canMoveTo(pozycja))
			cars.add(car);
		else
			throw new IllegalArgumentException("Pozycja zajeta");

		return canMoveTo(pozycja);
	}

	@Override
	public boolean isOccupied(Position position) {
		if (objectAt(position) != null)
			return true;

		else
			return false;
	}

	@Override
	public Object objectAt(Position position) {

		return hashMapa.get(position);
	}

	
	public void positionChanged(Position old, Position _new){
		Car auto=hashMapa.get(old.hashCode());
		hashMapa.remove(old.hashCode());
		hashMapa.put(_new, auto);
		
	}
	
	
	
	
	
	
	public void run(MoveDirection[] directions) {
		int n=cars.size();
		Position poz;
		for (int i = 0; i < directions.length; i++) {
			poz=cars.get(i%n).getPosition();
			cars.get(i % n).move(directions[i]);
			if(cars.get(i%n).getPosition().equals(poz)) continue;
			else {
				hashMapa.remove(poz);
				hashMapa.put(cars.get(i%n).getPosition(), cars.get(i%n));
			}
		}
	}

}