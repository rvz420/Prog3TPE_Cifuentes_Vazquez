package estructuras;


public class Ordenamientos {

	private static Usuario[] array;
	
	public static void quickSort(Usuario[] array, int cantElem){
		sort(array, 0, cantElem-1);
	}
	
	public static void sort(Usuario[] array, int izquierdo, int derecho){
		int i = particion(izquierdo,derecho);
		if(izquierdo < (i-1))
			sort(array,izquierdo,i-1);
		if(i < derecho)
			sort(array,i, derecho);
		
	}
	
	static int particion(int izquierdo, int derecho){
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
