package programacionIII.TPE.listaCargaPrincipio;

public class ListaVinculadaAlPrincipio {
	private Usuario first = null;
	private int cantElem = 0;
	
	public String getFirst() {

		return first.getDni();
	}

	public void setFirst(Usuario first) {
		this.first = first;
	}

	public boolean isEmpty(){
		return first == null;
	}
	
	public boolean contiene(String id){
	   Usuario userAux = first;
	   for (int i = 0; i < cantElem; i++) {
	     if((userAux.getDni()).equals(id)){
	       return true;
	     }else{
	    	 userAux = userAux.getSig();
	     }
	   }
	   return false;
	 }

	public void add(Usuario user){
		if(cantElem == 0){
			first = user;
		}else{
			Usuario tmp = user;
			tmp.setSig(first);
			first = tmp;
		}
		cantElem++;
	}
	
	public void delete(){
		first=first.getSig();
		cantElem--;
	}
}
