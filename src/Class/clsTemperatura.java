package Class;

public class clsTemperatura {
	private double valorTemp,valorTempCambio;
	private double salida;
	private String dato;
	/**
	 * @param valorTemp
	 */
	public clsTemperatura(double valorTemp) {
		super();
		this.valorTemp = valorTemp;
	}

	public String getDato() {
		return this.dato;
	}	
	public void validacionA(int a) {
		switch (a) {
		case 0:
			this.valorTempCambio=this.valorTemp;
			break;
		case 1:
			this.valorTempCambio=gradosFaC(this.valorTemp);
			break;
		default:
			this.valorTempCambio=gradosKaC(this.valorTemp);
			break;
		}
		//return salida;
	}
	public double validacionB(int a) {
		switch (a) {
		case 0:
			salida=this.valorTempCambio;
			this.dato="°C";
			break;
		case 1:
			salida=gradosCaF(this.valorTempCambio);
			this.dato="°F";
			break;
		default:
			salida=gradosCaK(this.valorTempCambio);
			this.dato="°K";
			break;
		}
		return salida;
	}
	
	private double gradosFaC(double c) {
		return (c-32)*5/9;//retorna C
	}
	private double gradosCaF(double c) {
		return (c*9/5) + 32;//retorna F
	}
	private double gradosKaC(double c) {
		return c-273.15;//retorna C
	}
	private double gradosCaK(double c) {
		return c+273.15;//retorna K
	}
}
