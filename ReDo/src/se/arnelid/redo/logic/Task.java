package se.arnelid.redo.logic;

import java.io.Serializable;

public class Task implements Serializable {
	private String name;
	private static final long serialVersionUID = 1L;

	public Task(String inputString) {
		name = inputString;
	}

	public boolean equals(Object other) {
		return true;
	}
}
