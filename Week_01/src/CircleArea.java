
public class CircleArea {

	double radius;
	CircleArea(int tempArea){
		
		radius = tempArea;
		
	}
	
	double area() {
		
		double tempArea = radius*radius*Math.PI;
		
		return tempArea;
	}
	
}
