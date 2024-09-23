package edu.lawrence.college.services;

public class CollegeNotListedException extends Exception {
	public CollegeNotListedException() {
		super("Please Select your college first");
	}
}
