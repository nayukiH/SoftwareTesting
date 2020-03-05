package scs.st;

public class Pocket implements Comparable{
	private int value;
	private int count;
		
	Pocket(int value, int count){
		this.value = value;
		this.count = count;
	}
		
	int getValue() {
		return value;
	}
	
	int getCount() {
		return count;
	}
	
	public int compareTo(Object o) {
		Pocket pocket = (Pocket)o;
		if(this.value < pocket.getValue()) {
			return -1;
		}
		else if(this.value == pocket.getValue()) {
			return 0;
		}
		else {
			return 1;
		}
	}
}

