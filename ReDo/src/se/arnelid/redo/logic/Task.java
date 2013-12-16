package se.arnelid.redo.logic;

import java.io.Serializable;

public class Task implements Serializable {
	private String name;
	private static final long serialVersionUID = 1L;

	public Task(String inputString) {
		name = inputString;
	}

	public boolean equals(Object other) {
		if(other instanceof Task) {
			Task otherTask = (Task) other;
			if (name.equals(otherTask.getName())) {
				return true;
			}
		}
		return false;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return getName();
	}
}
