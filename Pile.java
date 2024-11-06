package application;
import java.util.Stack;

public class Pile implements CalculatorModelInterface {
	//Pile 
	
	public Stack<Double> pile;
	
	public Pile() {
		//Constructor
		
		pile = new Stack<>();
	}
	
	public Stack<Double> getPile(){
		//Getter Pile
		
		return pile;
	}
	
	public Boolean isEmpty() {
		//BOolean test is pile empty
		
		return pile.isEmpty();
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

	@Override
	public void add() {
		//Pile doesnt add
		
		throw new UnsupportedOperationException("Pile ne réalise pas d'opérations")		;
	}

	@Override
	public void substract() {
		//Pile doesnt substract
		
		throw new UnsupportedOperationException("Pile ne réalise pas d'opérations")		;
	}

	@Override
	public void multiply() {
		//Pile doesnt multiply
		
		throw new UnsupportedOperationException("Pile ne réalise pas d'opérations")		;
	}

	@Override
	public void divide() {
		//Pile doesnt divide
		
		throw new UnsupportedOperationException("Pile ne réalise pas d'opérations")		;
	}

	@Override
	public void opposite() {
		//Pile doesnt oppose
		throw new UnsupportedOperationException("Pile ne réalise pas d'opérations")		;
	}
}
