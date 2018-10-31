package factory;

public class factoryTest {

	public static void main(String[] args) {
		JuiceFactory getjuice = new JuiceFactory();
		Juice juice = getjuice.getJuice("Coffee");
		juice.drink();

	}

}
