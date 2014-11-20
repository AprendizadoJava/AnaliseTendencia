package principal;

public class Apartamento extends Anuncio {

	private int numeroQuartos;
	private boolean SalaoFesta;	
	
	public boolean temSalaoFesta() {
		return SalaoFesta;
	}

	public void setSalaoFesta(boolean temSalaoFesta) {
		this.SalaoFesta = temSalaoFesta;
	}

	public int getNumeroQuartos() {
		return numeroQuartos;
	}

	public void setNumeroQuartos(int numeroQuartos) {
		this.numeroQuartos = numeroQuartos;
	}

	public void destrincharAnuncio() {
		
	}

}
