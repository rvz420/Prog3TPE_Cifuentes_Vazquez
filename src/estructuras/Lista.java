package estructuras;


public interface Lista {

	public String getFirst();
	
	public void setFirst(Nodo first);
	
	public boolean isEmpty();
	
	public boolean contiene(String id);
	
	public void add(Nodo n);
	
	public void delete();
	
}
