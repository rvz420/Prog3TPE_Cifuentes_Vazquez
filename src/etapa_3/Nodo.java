package etapa_3;

public class Nodo {
	String elemento;
	Nodo sig;
	
	public Nodo(String elemento) {
		this.elemento = elemento;
		this.sig = null;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public Nodo getSig() {
		return sig;
	}

	public void setSig(Nodo sig) {
		this.sig = sig;
	}
	

	
	
	
}
