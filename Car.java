package agh.cs.lab2;

import java.util.HashSet;
import java.util.Set;

public class Car  {

	private final IWorldMap map;

	private Position position;
	private Set<IPositionChangeObserver> obserwator =new HashSet<IPositionChangeObserver>();

	public Car(IWorldMap map, int x, int y) {
		this.map = map;
		this.position = new Position(x, y);
	}

	public Car(IWorldMap map) {

		this.map = map;
		this.position = new Position(2, 2);
	}

	private MapDirection kierunek = MapDirection.North;

	private Position naprzod = new Position(0, 1);
	private Position tyl = new Position(0, -1);
	private Position prawo = new Position(1, 0);
	private Position lewo = new Position(-1, 0);

	public String toString() {

		if (kierunek == MapDirection.North)
			return "N";
		if (kierunek == MapDirection.South)
			return "S";
		if (kierunek == MapDirection.West)
			return "W";
		if (kierunek == MapDirection.East)
			return "E";
		return " ";

	}
	public Position getPosition(){
		return position;
	}
	
	public void addListener(IPositionChangeObserver observer){ obserwator.add(observer);	}
	
	public void removeListener(IPositionChangeObserver observer){ obserwator.remove(obserwator);	}
	
	public void positionChanged(Position old, Position _new){
		obserwator.forEach((e)-> e.positionChanged(old, _new)); 
	}
	
	
	
	public void move(MoveDirection direction) {

		switch (direction) {

		case Right:

			kierunek = kierunek.Next();

			break;

		case Left:

			kierunek = kierunek.Previous();

			break;

		case Forward:

			if (kierunek == MapDirection.North
					&& map.canMoveTo(position.add(naprzod)))
				position = position.add(naprzod);
			if (kierunek == MapDirection.South
					&& map.canMoveTo(position.add(tyl)))
				position = position.add(tyl);
			if (kierunek == MapDirection.West
					&& map.canMoveTo(position.add(lewo)))
				position = position.add(lewo);
			if (kierunek == MapDirection.East
					&& map.canMoveTo(position.add(prawo)))
				position = position.add(prawo);
			break;

		case Backward:

			if (kierunek == MapDirection.North
					&& map.canMoveTo(position.add(tyl)))
				position = position.add(tyl);
			if (kierunek == MapDirection.South
					&& map.canMoveTo(position.add(naprzod)))
				position = position.add(naprzod);
			if (kierunek == MapDirection.West
					&& map.canMoveTo(position.add(prawo)))
				position = position.add(prawo);
			if (kierunek == MapDirection.East
					&& map.canMoveTo(position.add(lewo)))
				position = position.add(lewo);
			break;
		}

	}

	
	

}
