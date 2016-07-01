
public class MemcachedJavaEjemplo {
	public static void main(String[] args) {
		try {
			//architectural pattern MVC
			Data d = new Data(); //Model (MVC)
			Controller c = new Controller(d); //Controller (MVC)
			PrincipalView vista = new PrincipalView(c);  //View (MVC)
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}