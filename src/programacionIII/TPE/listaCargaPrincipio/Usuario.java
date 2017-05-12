package programacionIII.TPE.listaCargaPrincipio;

import programacionIII.TPE.arreglo.ArregloString;

public class Usuario {
	String dni;
	ArregloString gustos;
	Usuario sig;
	
	public Usuario(String[] datos){
		this.dni = datos[0];
		this.gustos = generarGustos(datos);
		this.sig = null;
	}
	
	public ArregloString generarGustos(String[] datos){
		ArregloString retorno = new ArregloString(5);
		int pos = 1; //comienza en 1 para saltear el documento
		
		while (pos < datos.length){
			if((datos[pos] != "") && (!retorno.contiene(datos[pos]))) {
				retorno.agregar(datos[pos]);
			}
			pos++;
		}
		
		return retorno;
	}
	
	public Usuario getSig(){
		return sig;
	}
	
	public void setSig(Usuario usuario){
		sig = usuario;
	}
	
	public ArregloString getGustos(){
		return gustos;
	}
	
	public String getDni(){
		return this.dni;
	}

	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", gustos=" + gustos + "]";
	}
	
}
