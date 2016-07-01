

public class Controller {

	private Data d;
	public Controller(Data d2) {
		// TODO Auto-generated constructor stub
		d = d2;
	}
	public void IntroducirDatos() throws InterruptedException {
		// TODO Auto-generated method stub
		d.IntroducirDatos();
	}
	public String getDatos() {
		// TODO Auto-generated method stub
		return this.d.getDatos();
	}
	public void CerrarConex() {
		// TODO Auto-generated method stub
		d.CerrarCon();
	}
	
	//Add Observer MVC
	public void anadirVista(Observador vista) {
		// TODO Auto-generated method stub
		d.AnadirVista(vista);
	}
}
