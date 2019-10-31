package com.candidjava.spring.Enum;

public enum Gender {

	MALE("male"), FEMALE("female"), OTHER("other");

	private final String text;

	private Gender(String text) {
		this.text = text;
	}

	//@Enumerated(EnumType.STRING)
	public String getText() {
		return this.text;
	}

	/*
	 * public static Optional<Gender> fromText(String text) { return
	 * Arrays.stream(values()) .filter(bl -> bl.text.equalsIgnoreCase(text))
	 * .findFirst(); }
	 */

	// MALE,
	// FEMALE,
	// OTHER;

}
