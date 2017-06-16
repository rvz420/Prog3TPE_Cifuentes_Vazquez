package etapa_3;

import java.util.HashMap;

public class Grafo {
	int tamanio;
	HashMap<Integer,Vertice> vertices;
	
	public Grafo(){
		vertices=new HashMap<Integer, Vertice>();
		tamanio = 0;
	}
	
	private void addVertice(Vertice v){
		vertices.put(tamanio,v);
	}
	
	public int cantVertices(){
		return vertices.size();
	}
	
	public Vertice buscarVertice(String dniOgusto){
		for (int i = 0; i < vertices.size(); i++) {
			if (dniOgusto.equals(vertices.get(i).getDato())){
				return vertices.get(i);
			} 
		}
		return null;
	}
	
	public void addGustoUser(String g, String u){
		if((buscarVertice(u) != null) && (buscarVertice(g) != null)){
			Vertice vertUAux = buscarVertice(u);
			vertUAux.addAdyacente(new Nodo(g));
			Vertice vertGAux = buscarVertice(g);
			vertGAux.addAdyacente(new Nodo(u));
		}
		
	}
	
	public Arreglo gustosSimilares(String u){
		Arreglo devolver = new Arreglo(5);
		Vertice usuario = buscarVertice(u);
		if (usuario != null) {
			for (int i = 0; i < vertices.size(); i++) {
				Vertice vertice = vertices.get(i);
				if (vertice.getTipo().equals(TipoDato.dni)){ //comprobamos que sea un Usuario y no un gusto
					if (!(usuario.equals(vertice))){ //comprobamos que no sea el mismo usuario
						int cantGustos = 0;
						for (int j = 0; j < usuario.cantAdyacentes(); j++) {
							if(vertice.contiene(usuario.getAdyacentes().getAt(j).getElemento())){
								cantGustos++;
							}	
						}
						if (cantGustos > 1){
							devolver.agregar(vertice.getDato());
						}	
					}
				}
			}
		}
		return devolver;
	}
	
	public String masGustado(){
		String masGustado = "";
		int mayorActual = 0;
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).getTipo().equals(TipoDato.gusto)){ //comprobamos que sea un Gusto y no un Usuario
				if(vertices.get(i).getAdyacentes().size() > mayorActual){
					mayorActual = vertices.get(i).getAdyacentes().size();
					masGustado = vertices.get(i).getDato();
				}
			}
		}
		return masGustado;
	}
	
//	public boolean dfs_visit(Vertice Vertice, Hashtable<Integer, EstadoVisita> Vertices){
//		//System.out.print(Vertice.getValor());
//		
//		if (Vertices.get(Vertice.getValor()) == EstadoVisita.VISITANDO){
//			return true;
//		}
//			
//		Vertices.put(Vertice.getValor(), EstadoVisita.VISITANDO);
//		
//		for (Adyacente adyacente : Vertice.getAdyacentes()){
//			if( dfs_visit(adyacente.getDestino(), Vertices)){
//				return true;
//			}
//		}
//		
//		Vertices.put(Vertice.getValor(), EstadoVisita.VISITADO);
//		return false;
//	}
//	
	public void agregarUsuario(String dni){
		addVertice(new Vertice (dni,TipoDato.dni));
		tamanio++;
	}
	
	public void agregarGusto(String gusto){
		if (!vertices.containsValue(gusto)){
			addVertice(new Vertice (gusto,TipoDato.gusto));
			tamanio++;
		}
	}

	@Override
	public String toString() {
		return "Grafo [" + vertices + "]";
	}
	
}
