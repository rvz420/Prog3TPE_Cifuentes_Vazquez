package programacionIII.TPE.arreglo;

public class Quicksort {

	private String[] array;
	
	public Quicksort( String[] a){
		array = a;
		sort(0, array.length -1);
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
	      String aux;
	      String pivot = array[(izquierdo + derecho) / 2];
	     
	      while (i <= j) {
	            while (array[i].compareTo(pivot) < 0)
	                  i++;
	            while (array[j].compareTo(pivot) > 0)
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
