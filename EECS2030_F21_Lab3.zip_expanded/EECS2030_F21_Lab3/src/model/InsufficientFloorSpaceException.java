package model;

@SuppressWarnings("serial")
public class InsufficientFloorSpaceException extends Exception{
	InsufficientFloorSpaceException(String s) {
		super(s);
	}
}
