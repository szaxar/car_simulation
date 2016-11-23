package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap  extends AbstractWorldMap {

	private Position gora, dol;
	List<Car> cars = new ArrayList<>();

	public RectangularMap(int width, int height) {

		gora = new Position(width - 1, height - 1);
		dol = new Position(0, 0);
	}

	@Override
	public boolean canMoveTo(Position position) {
		boolean fraga= super.canMoveTo(position);
		if (fraga == false && position.larger(gora)
				&& position.smaller(dol))
			return true;

		else
			return false;
	}



	
	public String toString() {
		return new MapVisualizer().dump(this, dol, gora);
	}

}
