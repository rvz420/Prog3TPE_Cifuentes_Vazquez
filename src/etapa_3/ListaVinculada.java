package etapa_3;



public class ListaVinculada {
	private Nodo first = null;
	private int cantElem = 0;

	public Nodo getFirst() {

		return first;
	}

	public void setFirst(Nodo first) {
		this.first = first;
	}

	public boolean isEmpty(){
		return first == null;
	}

	public boolean contiene(String s){
		Nodo nodoAux = first;
		for (int i = 0; i < cantElem; i++) {
			if((nodoAux.getElemento()).equals(s)){
				return true;
			}else{
				nodoAux = nodoAux.getSig();
			}
		}
		return false;
	}

	public void add(Nodo n){	
		if(cantElem == 0){
			first = n;
		}else{
			Nodo tmp = n;
			tmp.setSig(first);
			first = tmp;
		}
		cantElem++;
	}

	public void delete(){
		first=first.getSig();
		cantElem--;
	}
	
	public void eliminar(String dato) {
		Nodo pos = first;
		if(first != null){
			if(dato == first.getElemento()) {
				first = first.getSig();
				cantElem--;
			}
			else { while((pos.getSig() != null)&&(!dato.equals(pos.getSig().getElemento())))
						pos = first.getSig();
				   if(dato == pos.getSig().getElemento()){
					   pos.setSig(pos.getSig().getSig());
					   cantElem--;
				   }
			}
		}
	}

	public int size() {
		return cantElem;
	}

	public void setCantElem(int cantElem) {
		this.cantElem = cantElem;
	}
	
	public Nodo getAt(int pos){
		Nodo retorno = null;
		Nodo nodoActual = first;
		if(pos<this.cantElem){
			for (int i = 0; i < pos; i++) {
				nodoActual = nodoActual.getSig();
			}
			retorno = nodoActual;
		}
		return retorno;
	}
	
}
