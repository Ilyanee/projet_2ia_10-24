package calculatrice;

public interface CalculatorModelInterface {
	//Interface for common operations

	void add() throws Exception;
	
	void substract() throws Exception;
	
	void multiply() throws Exception;
	
	void divide() throws Exception;
	
	void opposite() throws Exception;
	
	void push(double n);
	
	double pop();
	
	void drop();
	
	void swap();
	
	void clear();
}
