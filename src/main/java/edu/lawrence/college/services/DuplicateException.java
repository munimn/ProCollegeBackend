package edu.lawrence.college.services;

public class DuplicateException extends Exception {
	public DuplicateException() {
		super("Attempt to insert duplicate element.");
	}
}
