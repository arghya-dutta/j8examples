package cmn;

public class CDTO implements Comparable<CDTO>{

	private int x;

	@Override
	public int compareTo(CDTO o) {
		// TODO Auto-generated method stub
		return o.getX() - this.x;
	}

	private int getX() {
		// TODO Auto-generated method stub
		return x;
	}
	
	
}
