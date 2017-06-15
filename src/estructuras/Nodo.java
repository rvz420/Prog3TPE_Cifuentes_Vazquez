package estructuras;

public class Nodo {
	private Usuario usuario;
	private Nodo sig;

	public Nodo(Usuario u){
		this.usuario = u;
		this.sig = null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setElem(Usuario u) {
		this.usuario = u;
	}

	public Nodo getSig() {
		return sig;
	}

	public void setSig(Nodo sig) {
		this.sig = sig;
	}

	@Override
	public String toString() {
		return "Nodo [usuario=" + usuario + ", sig=" + sig + "]";
	}

}