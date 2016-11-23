package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
	
	protected List<Car> cars = new ArrayList<>();
	
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
		for (Car car : cars)
			if (car.getPosition().equals(position))
				return car;
		return null;
	}

	@Override
	public void run(MoveDirection[] directions) {
		int n = cars.size();
		for (int i = 0; i < directions.length; i++) {
	
			cars.get(i % n).move(directions[i]);
		}
	}

	
		  
		  
		  
		  
		  
		  
	}