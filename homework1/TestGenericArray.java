package homework1;
public class TestGenericArray {

	public static <E> void main(String[] args)  {
		GenericArray test = new GenericArray ();	
		int selection = 0;
		
		while (selection != 9){
			selection = test.menu();
			test.choice(selection);
		}
	}
}