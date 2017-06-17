package etapa_3;

import java.util.Vector;

public class Grafo {
	int tamanio;
	Vector<Vertice> vertices;

	public Grafo(){
		vertices=new Vector<Vertice>();
		tamanio = 0;
	}

	private void addVertice(Vertice v){
		vertices.addElement(v);
	}

	public int cantVertices(){
		return vertices.size();
	}
	
	public boolean existe(String dniOgusto){
		for (int i = 0; i < vertices.size(); i++) {
			if (dniOgusto.equals(vertices.elementAt(i).getDato())){
				return true;
			}
		}
		return false;
	}

	public Vertice buscarVertice(String dniOgusto){
		for (int i = 0; i < vertices.size(); i++) {
			if (dniOgusto.equals(vertices.elementAt(i).getDato())){
				return vertices.elementAt(i);
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
				Vertice vertice = vertices.elementAt(i);
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
			if (vertices.elementAt(i).getTipo().equals(TipoDato.gusto)){ //comprobamos que sea un Gusto y no un Usuario
				if(vertices.elementAt(i).getAdyacentes().size() > mayorActual){
					mayorActual = vertices.elementAt(i).getAdyacentes().size();
					masGustado = vertices.elementAt(i).getDato();
				}
			}
		}
		return masGustado;
	}

	private int getClave(String dato) {
		int c = 0;
		if(existe(dato)) {
			c = buscarVertice(dato).getId();
		}
		
		return c;
	}
	
	private String extraerMinimo(ListaVinculada cola, int[] dist) {
		String menor;
		int menorCant;
		Nodo cursor = cola.getFirst();
		menor = cursor.getElemento();
		int c = getClave(menor);
		menorCant = dist[c];
		while(cursor != null) {
			int clav = getClave(cursor.getElemento());
			if(menorCant > dist[clav]) {
				menorCant = dist[clav];
				menor = cursor.getElemento();
			}
			cursor = cursor.getSig();
		}
		return menor;
	}
	
	public String idConGustosMasLejanos(String id) {
		int[] distancias = Dijkstra(id);
		int mayor = distancias[0];
		int pos = 0;
		for (int i = 0; i < distancias.length; i++) {
			if(distancias[i]%2 == 0) {            //SON PARES LAS DISTANCIAS ENTRE USUARIOS
				if(mayor < distancias[i]) {
					mayor = distancias[i];
					pos = i;
				}
			}	
		}
		return vertices.elementAt(pos).getDato();
	}
	
	private int[] Dijkstra(String origen){
		ListaVinculada cola = new ListaVinculada();
		int[] dist = new int[tamanio+1];
		int clave=0;
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}            
		if(existe(origen)) {
			clave = getClave(origen);
		}
		dist[clave] = 0;                    //DISTANCIA DEL ORIGEN
		while(!cola.isEmpty()){
		    String min = extraerMinimo(cola,dist);      
			cola.eliminar(min);
			int claveMin = 0;
			ListaVinculada ady = new ListaVinculada();
			if(existe(min)) {
				claveMin = getClave(min);
				ady = buscarVertice(min).getAdyacentes();
			}
			
			Nodo cursor = ady.getFirst();
			while(cursor != null) {
				String dato = cursor.getElemento();
				int c = getClave(dato);
				int distancia = dist[claveMin] + 1; //SE TOMA 1 POR TOMAR EL COSTO DEL GRAFO
				if(distancia < dist[c])
					dist[c] = distancia;
			}
		}
		return dist;
	}
	
	public void agregarUsuario(String dni){
		addVertice(new Vertice (dni,TipoDato.dni,tamanio));
		tamanio++;
	}

	public void agregarGusto(String gusto){
		if (buscarVertice(gusto) == null ){
			addVertice(new Vertice (gusto,TipoDato.gusto,tamanio));
			tamanio++;
		}
	}

	@Override
	public String toString() {
		return "Grafo [" + vertices + "]";
	}

}
