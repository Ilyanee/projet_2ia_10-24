package calculatrice;

public class Main {

	public static void main(String[] args) {
		//Test
		
		Calculator calculatrice = new Calculator();
		
		try {
			calculatrice.push(1);
			calculatrice.opposite();
			System.out.println("Pile :" + calculatrice.getPile());
			
			calculatrice.push(10);		
			calculatrice.add();
			System.out.println("Pile :" + calculatrice.getPile());
			
			calculatrice.clear();
			System.out.println("Pile vidée :" + calculatrice.getPile());
		}
		
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}

}
