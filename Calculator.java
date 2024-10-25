package calculatrice;

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
		//Adds last element of the pile to the accumulator
		
		if (pile.isEmpty()) {
			throw new Exception("Pile vide, rentrer un nombre pour procéder à l'opération");
		}
		
		else {
			double x = pile.pop();
			accu += x;
			pile.push(accu);
		}
	}

	@Override
	public void substract() throws Exception {
		// TODO Auto-generated method stub

		if (pile.isEmpty()) {
			throw new Exception("Pile vide, rentrer un nombre pour procéder à l'opération");
		}
	}

	@Override
	public void multiply() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void divide() throws Exception {
		// TODO Auto-generated method stub

		if (pile.isEmpty()) {
			throw new Exception("Pile vide, rentrer un nombre pour procéder à l'opération");
		}
	}

	@Override
	public void opposite() throws Exception {
		// TODO Auto-generated method stub

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
	}

}
