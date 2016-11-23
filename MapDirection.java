package agh.cs.lab2;

public enum MapDirection {

	North, South, West, East;

	public String toString() {

		switch (this) {

		case North:

			return "Poludnie";

		case South:

			return "Polnoc";

		case East:

			return "Wschod";

		case West:

			return "Zachod";

		}

		return "";

	}

	public MapDirection Next() {

		switch (this) {

		case North:

			return East;

		case South:

			return West;

		case East:

			return South;

		case West:

			return North;

		default:

			return null;

		}

	}

	public MapDirection Previous() {

		switch (this) {

		case North:

			return West;

		case South:

			return East;

		case East:

			return North;

		case West:

			return South;

		default:

			return null;

		}

	}

}
