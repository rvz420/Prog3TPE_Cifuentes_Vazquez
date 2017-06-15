package estructuras;


public class ListaVinculadaAlFinal implements Lista{
	private Nodo first = null;
	private int cantElem = 0;
	
	public String getFirst() {

		return first.getUsuario().getDni();
	}

	public void setFirst(Nodo first) {
		this.first = first;
	}

	public boolean isEmpty(){
		return first == null;
	}
	
	public boolean contiene(String id){
		Nodo nodoAux = first;
		for (int i = 0; i < cantElem; i++) {
			if((nodoAux.getUsuario().getDni()).equals(id)){
				return true;
			}else{
				nodoAux = nodoAux.getSig();
			}
		}
		return false;
	}
	
	
	public void add(Nodo n){
		//agrega al final
		if(first == null){
			first = n;
		}else{
			Nodo nodoActual = first;
			while(nodoActual.getSig() != null){
				nodoActual = nodoActual.getSig();
			}
			nodoActual.setSig(n);
		}
		this.cantElem++;
}
	
	
	public void delete(){
		first=first.getSig();
		cantElem--;
	}
}
