package estructuras;


public class ArregloUsuario {

	Usuario[] arreglo;
	boolean ordenado = false;
	int cantElem = 0;

	public ArregloUsuario(){
		arreglo = new Usuario[10000];
	}

	public ArregloUsuario(int tamanio){
		arreglo = new Usuario[tamanio];
	}

	public void agregar(Usuario elem){

		if (this.cantElem == arreglo.length){ //Si el arreglo esta lleno le duplicamos el tamaño
			Usuario[] arregloNuevo = new Usuario[this.arreglo.length*2];
			for (int i = 0; i < arreglo.length; i++) {
				arregloNuevo[i] = this.arreglo[i];
			}
			this.arreglo = arregloNuevo;
		}
		arreglo[cantElem] = elem;
		cantElem++;
		ordenado = false;
	}
	
	public boolean contiene(String aux){
	    //Este es el metodo de busqueda utilizado en la etapa 1 (poco eficiente)
	    for (int i = 0; i < cantElem; i++) {
	      if(aux.equals(arreglo[i].getDni())){
	        return true;
	      }
	    }
	    return false;
	  }
	
	public void eliminarAt(int pos){
		
		for (int i = pos; i < arreglo.length-1; i++) {
			arreglo[i] = arreglo[i+1];
		}
		this.cantElem--;
		arreglo[cantElem] = null;
	}

	public void insertarAt(int pos, Usuario elem){
		for (int i = this.arreglo.length-1; i > pos; i--) {
			this.arreglo[i] = this.arreglo[i-1];
		}
		this.arreglo[pos] = elem;
	}
	
	public void replace (int i, int j){
		arreglo[i] = arreglo[j];
	}
	
	public void intercambiar(int i, int j){
		Usuario aux;
		aux = arreglo[i];
		arreglo[i] = arreglo[j];
		arreglo[j] = aux;
	}
	
	public int getCantElem(){
		return this.cantElem;
	}

	public Usuario elemAt(int pos){
		return arreglo[pos];
	}
	
	public String toString(){
		String retorno="";
		for (int i = 0; i < cantElem; i++) {
			retorno += "["+this.arreglo[i]+"]";
		}
		return retorno;
	}
	
	public void ordenarArregloQuickSort(){
		//Ordenamiento mediante QuickSort 
		Ordenamientos.quickSort(arreglo, cantElem);
		
	}
	
	public boolean existe(String dni){
		//Metodo de búsqueda Binaria utilizado en la etapa 2 (Más eficiente)
	    int centro, inf = 0, sup = cantElem;
	    
	    if(!ordenado){
	    	ordenarArregloQuickSort();
	    	ordenado = true;
	    }
	    
	     while(inf<=sup){
	       centro = (sup+inf)/2;
	       String aux = arreglo[centro].getDni();
	       if(aux.equals(dni)) {         
	         return true;
	       }
	       else if(Integer.parseInt(dni) < Integer.parseInt(arreglo[centro].getDni())){
	         sup=centro-1;
	       }
	       else {
	         inf=centro+1;
	       }
	     }
	     return false;
	  }
}
	


