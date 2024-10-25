package calculatrice;
import java.util.Stack;

public class Pile {
	//Pile 
	
	public Stack<Double> pile;
	
	public Pile() {
		//Constructor
		
		pile = new Stack<>();
	}
	
	public void push(double n) {
		//Pushes an element n on top of the pile
		
		pile.push(n);
	}
	
	public double pop() {
		//Returns the element on top of the pile
		
		return pile.peek();
	}
	
	public void drop() {
		//Deletes the element on top of the pile
		
		pile.pop();
	}
	
	public void swap() {
		//Swithes places for last two elements of the pile
		
		double copyElmt = pile.remove(pile.capacity()-1);
		pile.push(copyElmt);
	}
	
	public void clear() {
		//Deletes all elements from the pile
		
		pile.clear();
	}
}
