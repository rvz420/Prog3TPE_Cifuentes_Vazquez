package programacionIII.TPE.arreglo;

public class Usuario {
	String dni;
	String[] gustos;
	int contGustos = 0;
	
	public Usuario(String[] datos){
		this.dni = datos[0];
		this.gustos = generarGustos(datos);
	}
	
	public String[] generarGustos(String[] datos){
		String[] retorno = new String[5];
		int pos = 1; //comienza en 1 para saltear el documento
		
		while (pos < datos.length){
			if((datos[pos] != "") && (!contieneGusto(datos[pos]))) {
				retorno[contGustos] = datos[pos];
				contGustos++;
			}
			pos++;
		}
		
		return retorno;
	}
	
	public String[] getGustos(){
		return gustos;
	}
	
	public String getDni(){
		return this.dni;
	}

	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", gustos=" + gustos + "]";
	}
	
	public boolean contieneGusto(String aux){
	    
		if(contGustos == 0){
			return true;
		}
		
	    for (int i = 0; i < contGustos; i++) {
	      if(aux.equals(gustos[i])){
	        return true;
	      }
	    }
	    return false;
	  }
	
}
