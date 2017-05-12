package programacionIII.TPE.listaCargaFinal;

public class ListaVinculadaAlFinal {
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
		//agrega al final
		if(first == null){
			first = user;
		}else{
			Usuario UsuarioActual = first;
			while(UsuarioActual.getSig() != null){
				UsuarioActual = UsuarioActual.getSig();
			}
			UsuarioActual.setSig(user);
		}
		this.cantElem++;
}
	
	
	public void delete(){
		first=first.getSig();
		cantElem--;
	}
}
