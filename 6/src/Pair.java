
public class Pair {
	Double dist;
	Integer c;
	
	public Pair(Double dist, Integer c) {
		this.dist = dist;
		this.c = c;
	}
	
	public Double get() {
		return dist;
	}
	
	public Integer getclass() {
		return c;
	}
	
	public String toString()
	{
		return "" + dist + ":" + c;
	}

}
