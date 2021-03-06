package etapa_3;

public class Vertice {
	int id;
	String dato;
	TipoDato tipo;
	ListaVinculada adyacentes;

	public Vertice(String d, TipoDato t, int id) {
		this.id = id;
		dato =d;
		tipo =t;
		adyacentes = new ListaVinculada();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDato() {
		return dato;
	}

	public TipoDato getTipo() {
		return tipo;
	}

	public void setDato(String d) {
		dato = d;
	}

	public ListaVinculada getAdyacentes() {
		return adyacentes;
	}

	public void addAdyacente(Nodo adyacente) {
		if (!adyacentes.contiene(adyacente.getElemento())) {
			adyacentes.add(adyacente);
		}
	}

	public boolean contiene(String s){
		return adyacentes.contiene(s);
	}

	public boolean contiene(String s, ListaVinculada ady){
		return ady.contiene(s);
	}

	public int cantAdyacentes(){
		return adyacentes.size();
	}

	@Override
	public String toString() {
		return "[" + dato + "]";
	}

}
