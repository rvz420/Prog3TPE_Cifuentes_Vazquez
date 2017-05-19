package programacionIII.TPE.arreglo;

public class Quicksort {

	private Usuario[] array;
	
	public Quicksort( Usuario[] a, int cantElem){
		array = a;
		sort(0, cantElem-1);
	}
	
	public void sort(int izquierdo, int derecho){
		int i = particion(izquierdo,derecho);
		if(izquierdo < (i-1))
			sort(izquierdo,i-1);
		if(i < derecho)
			sort(i, derecho);
		
	}
	
	int particion(int izquierdo, int derecho){
	      int i = izquierdo, j = derecho;
	      Usuario aux;
	      Usuario pivot = array[(izquierdo + derecho) / 2];
	     
	      while (i <= j) {
	            while (array[i].getDni().compareTo(pivot.getDni()) < 0)
	                  i++;
	            while (array[j].getDni().compareTo(pivot.getDni()) > 0)
	                  j--;
	            if (i <= j) {
	                  aux = array[i];
	                  array[i] = array[j];
	                  array[j] = aux;
	                  i++;
	                  j--;
	            }
	      };
	     
	      return i;
	}
	
}
