package etapa_3;

public class Simulador {

	public static void main(String[] args) {
		
		Grafo grafo = new Grafo();
		grafo.agregarUsuario("u1");
		grafo.agregarUsuario("u2");
		grafo.agregarUsuario("u3");
		grafo.agregarGusto("g1");
		grafo.agregarGusto("g2");
		grafo.agregarGusto("g3");
		
		System.out.println(grafo.toString());
	
		grafo.addGustoUser("g1", "u1");
		grafo.addGustoUser("g2", "u1");
		grafo.addGustoUser("g3", "u1");
		
		grafo.addGustoUser("g1", "u2");
		grafo.addGustoUser("g2", "u2");
		
		grafo.addGustoUser("g2", "u3");
		grafo.addGustoUser("g3", "u3");
		
		System.out.println("Gustos similares");
		System.out.println(grafo.gustosSimilares("u1"));
		
		System.out.println("Gusto mas gustado");
		System.out.println(grafo.masGustado());
		
		
		
	}

}
