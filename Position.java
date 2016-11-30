package agh.cs.lab2;

public class Position {

	@Override
	public int hashCode() {
		  int hash = 13;
		  hash += this.x * 31;
		  hash += this.y * 17;
		  return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public final int x;

	public final int y;

	public Position(int x, int y) {

		this.x = x;

		this.y = y;

	}

	public String toString() {

		return "(" + this.x + "," + this.y + ")";

	}

	public boolean smaller (Position A){
	      if (A.x <= this.x && A.y <= this.y ){
	         return true;
	      }
	      else return false;
	   }
	   
	   public boolean larger (Position A){
	      if (A.x >= this.x && A.y >= this.y ){
	         return true;
	      }
	      else return false;
	   }

	public Position add(Position a)

	{

		Position position3 = new Position(this.x + a.x, this.y + a.y);

		return position3;

	}
	  public int getX() {
	        return x;
	    }

	    public int getY() {
	        return y;
	    }

	
}
