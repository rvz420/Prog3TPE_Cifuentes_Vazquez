package programacionIII.TPE.arreglo;

public class ArregloString {

	String[] arreglo;
	int cantElem = 0;

	public ArregloString(){
		arreglo = new String[10000];
	}

	public ArregloString(int tamanio){
		arreglo = new String[tamanio];
	}

	public void agregar(String elem){

		if (this.cantElem == arreglo.length){ //Si el arreglo esta lleno le duplicamos el tamaño
			String[] arregloNuevo = new String[this.arreglo.length*2];
			for (int i = 0; i < arreglo.length; i++) {
				arregloNuevo[i] = this.arreglo[i];
			}
			this.arreglo = arregloNuevo;
		}
		arreglo[cantElem] = elem;
		cantElem++;
	}
	
	public boolean contiene(String aux){
	    
	    for (int i = 0; i < cantElem; i++) {
	      if(aux.equals(arreglo[i])){
	        return true;
	      }
	    }
	    return false;
	  }
	
	public void eliminarAt(int pos){
		//recordar excepcion de eliminar un null
		for (int i = pos; i < arreglo.length-1; i++) {
			arreglo[i] = arreglo[i+1];
		}
		this.cantElem--;
		arreglo[cantElem] = null;
	}

	public void insertarAt(int pos, String elem){
		for (int i = this.arreglo.length-1; i > pos; i--) {
			this.arreglo[i] = this.arreglo[i-1];
		}
		this.arreglo[pos] = elem;
	}

	public int getCantElem(){
		return this.cantElem;
	}

	public String elemAt(int pos){
		return arreglo[pos];
	}
	
	public int getSize(){
		return cantElem;
	}
	
	public String toString(){
		String retorno="";
		for (int i = 0; i < cantElem; i++) {
			retorno += "["+this.arreglo[i]+"]";
		}
		return retorno;
	}
}

