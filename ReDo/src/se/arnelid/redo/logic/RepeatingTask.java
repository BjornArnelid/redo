package se.arnelid.redo.logic;

public class RepeatingTask {
	private int intervalValue;
	private int intervalType;
	
	public void setInterval(int value, int type) {
		intervalValue = value;
		intervalType = type;
	}

	public int getIntervalValue() {
		return intervalValue;
	}

	public int getIntervalType() {
		return intervalType;
	}

}
