package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap {

	List<HayStack> siano = new ArrayList<>();
	

	public UnboundedMap(List<HayStack> x) {
		this.siano = x;
	}

	

	@Override
	public Object objectAt(Position position) {
		
		
		for (HayStack s : siano)
			if (s.getPosition().equals(position))
				return s;
	
		Object object = super.objectAt(position);
		return object;
		
		
		
	}

	public int smallx() {
		int minx = 100;
		for (HayStack s : siano) {
			if (minx > s.getPosition().getX())
				minx = s.getPosition().getX();
		}
		for (Car car : cars) {
			if (minx > car.getPosition().getX())
				minx = car.getPosition().getX();
		}
		return minx;
	}

	public int smally() {
		int miny = 100;
		for (HayStack s : siano) {
			if (miny > s.getPosition().getY())
				miny = s.getPosition().getX();
		}
		for (Car car : cars) {
			if (miny > car.getPosition().getY())
				miny = car.getPosition().getY();
		}
		return miny;
	}

	public int largx() {
		int minx = -100;
		for (HayStack s : siano) {
			if (minx < s.getPosition().getX())
				minx = s.getPosition().getX();
		}
		for (Car car : cars) {
			if (minx < car.getPosition().getX())
				minx = car.getPosition().getX();
		}
		return minx;
	}

	public int largy() {
		int miny = -100;
		for (HayStack s : siano) {
			if (miny < s.getPosition().getY())
				miny = s.getPosition().getX();
		}
		for (Car car : cars) {
			if (miny < car.getPosition().getY())
				miny = car.getPosition().getY();
		}
		return miny;
	}

	public String toString() {
		return new MapVisualizer().dump(this, new Position(smallx(), smally()),
				new Position(largx(), largy()));
	}
}
