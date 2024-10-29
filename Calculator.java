package calculatrice;
import java.util.Stack;
public class Calculator implements CalculatorModelInterface {
	private double accu;
	private Pile pile;
	
	public Calculator() {
		//Constructor
		
		accu = 0.0;
		pile = new Pile();
	}

	@Override
	public void add() throws Exception {
		//Adds last 2 elements of the pile
		
		if (pile.isEmpty()) {
			throw new Exception("Pile vide, rentrer un nombre pour procéder à l'opération");
		}
		
		else {
			double x = pile.pop();
			pile.drop();
			double y = pile.pop();
			pile.drop();
			accu = x + y;
			pile.push(accu);
		}
	}

	@Override
	public void substract() throws Exception {
		//Substracts last 2 elements of the pile

		if (pile.isEmpty()) {
			throw new Exception("Pile vide, rentrer un nombre pour procéder à l'opération");
		}
		
		else {
			double x = pile.pop();
			pile.drop();
			double y = pile.pop();
			pile.drop();
			accu = x - y;
			pile.push(accu);
		}
	}

	@Override
	public void multiply() throws Exception {
		//Multiplies last 2 elements of the pile
		
		if (pile.isEmpty()) {
			throw new Exception("Pile vide, rentrer un nombre pour procéder à l'opération");
		}
		
		else {
			double x = pile.pop();
			pile.drop();
			double y = pile.pop();
			pile.drop();
			accu = x * y;
			pile.push(accu);
		}
	}

	@Override
	public void divide() throws Exception {
		//Divides last 2 elements of the pile

		if (pile.isEmpty()) {
			throw new Exception("Pile vide, rentrer un nombre pour procéder à l'opération");
		}
		
		else {
			double x = pile.pop();
			pile.drop();
			double y = pile.pop();
			pile.drop();
			accu = x / y;
			pile.push(accu);
		}
	}

	@Override
	public void opposite() throws Exception {
		//Returns the opposed value of last element of the pile
		
		if (pile.isEmpty()) {
			throw new Exception("Pile vide, rentrer un nombre pour procéder à l'opération");
		}
		
		else {
			double x = pile.pop();
			pile.drop();
			accu += -1 * x;
			pile.push(accu);
		}
	}

	@Override
	public void push(double n) {
		//Pushes an element n on top of the pile
		
		pile.push(n);
	}

	@Override
	public double pop() {
		//Returns the element on top of the pile
		
		return pile.pop();
	}

	@Override
	public void drop() {
		//Deletes the element on top of the pile

		pile.drop();
	}

	@Override
	public void swap() {
		//Swithes places for last two elements of the pile

		pile.swap();
	}

	@Override
	public void clear() {
		//Deletes all elements from the pile

		pile.clear();
		accu = 0.0;
	}
	
	public Stack<Double> getPile(){
		return pile.getPile();
	}
	
	public double getAccu() {
		//Getter accu
		
		return accu;
	}

}