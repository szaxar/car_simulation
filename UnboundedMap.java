package agh.cs.lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnboundedMap extends AbstractWorldMap {

	List<HayStack> siano = new ArrayList<>();
	Map<Position, HayStack> sianoH = new HashMap<>();

	public UnboundedMap(List<HayStack> x) {
		for (HayStack s : x) {
			sianoH.put(s.getPosition(), s);
			}
		
	}

	@Override
	public Object objectAt(Position position) {
		
		if(sianoH.get(position)!=null) return sianoH.get(position);
		
		Object object = super.objectAt(position);
		
		return object;
		
		
		
	}

	public int smallx() {
		int minx = 100;
		for (HayStack s : sianoH.values()) {
			if (minx > s.getPosition().getX())
				minx = s.getPosition().getX();
		}
		for (Car car : hashMapa.values()) {
			if (minx > car.getPosition().getX())
				minx = car.getPosition().getX();
		}
		return minx;
	}

	public int smally() {
		int miny = 100;
		for (HayStack s : sianoH.values()) {
			if (miny > s.getPosition().getY())
				miny = s.getPosition().getX();
		}
		for (Car car : hashMapa.values()) {
			if (miny > car.getPosition().getY())
				miny = car.getPosition().getY();
		}
		return miny;
	}

	public int largx() {
		int minx = -100;
		for (HayStack s : sianoH.values()) {
			if (minx < s.getPosition().getX())
				minx = s.getPosition().getX();
		}
		for (Car car : hashMapa.values()) {
			if (minx < car.getPosition().getX())
				minx = car.getPosition().getX();
		}
		return minx;
	}

	public int largy() {
		int miny = -100;
		for (HayStack s : sianoH.values()) {
			if (miny < s.getPosition().getY())
				miny = s.getPosition().getX();
		}
		for (Car car : hashMapa.values()) {
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
