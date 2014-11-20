package principal;

public class Casa extends Lote {

	private int numeroQuartos;
	private boolean temPiscina;
	private boolean temChurrasqueira;
	
	public int getNumeroQuartos() {
		return numeroQuartos;
	}

	public void setNumeroQuartos(int numeroQuartos) {
		this.numeroQuartos = numeroQuartos;
	}

	public boolean isTemPiscina() {
		return temPiscina;
	}

	public void setPiscina(boolean temPiscina) {
		this.temPiscina = temPiscina;
	}

	public boolean isTemChurrasqueira() {
		return temChurrasqueira;
	}

	public void setTemChurrasqueira(boolean temChurrasqueira) {
		this.temChurrasqueira = temChurrasqueira;
	}

	public void destrincharAnuncio() {
		
	}
	
}
