package factory;

public class JuiceFactory {
	public Juice getJuice(String juiceName) {
		Orange orange = new Orange();
		Coffee coffee = new Coffee();
		switch(juiceName) {
		case "Orange":
			System.out.println("get orange");
			System.out.println("stack orange");
			System.out.println("get orange juice");
			return orange;
		case "Coffee":
			System.out.println("get coffee");
			System.out.println("grind coffee");
			System.out.println("put water into cup");
			System.out.println("put coffer into cup");
			System.out.println("get coffee juice");
			return coffee;
		default:
			return null;		
		}
	}
	
}
