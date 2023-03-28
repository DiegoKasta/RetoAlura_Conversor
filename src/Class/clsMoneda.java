package Class;


public class clsMoneda {
	
	private double moneda, monedaCambio;
	private static double peso=1, dolar=4750.23, euro=5121.94, libraEsterlina=5808.11, yenJapones=36.33, wonCoreano=3.67; //KRW
	private double e;
	private String p;
		
	/**
	 * String.format("%.3f", (this.moneda/er))
	 * @param moneda
	 */
	public clsMoneda(double moneda) {
		this.moneda = Math.abs(moneda);
	}
	
	public void pesoColombiano() {
		this.monedaCambio=this.moneda*e;
	}
	
	public String otraMoneda() {
		return String.format("%.2f", (this.monedaCambio/e));
	}
	
	public void validacion(int a) {
		switch (a) {
		case 0:
			e=peso;
			p="COP";
			break;
		case 1:
			e=dolar;
			p="USD";
			break;
		case 2:
			e=euro;
			p="EUR";
			break;
		case 3:
			e=libraEsterlina;
			p="GBP";
			break;
		case 4:
			e=yenJapones;
			p="JPY";
			break;
		case 5:
			e=wonCoreano;
			p="KRW";
			break;
		}
	}
	
	/*Getter and Setters*/
	public void setMoneda(double moneda) {
		this.moneda = moneda;
	}
//	public double getMoneda() {
//		return this.moneda;
//	}
	public double getMonedaCambio() {
		return monedaCambio;
	}
	public String getMensaje() {
		return p;
	}
	
}
