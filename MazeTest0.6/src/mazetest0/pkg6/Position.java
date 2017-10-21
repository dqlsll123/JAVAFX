
package mazetest0.pkg6;
public class Position{
	public int x, y;
        public String identity;
	public Position(int x, int y,String identity){
		this.x = x;
		this.y = y;
                this.identity=identity;
	}

	public boolean equals(Object o){
		if(o == null){
			return false;
		}
		if(!(o instanceof Position)){
			return false;
		}
		Position p =(Position) o;
		return this.x == p.x && this.y == p.y;
	}
}
