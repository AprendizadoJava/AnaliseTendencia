package principal;

public abstract class Anuncio {
	private String textoAnuncio;
	private int areaTotal;
	private int areaUtil;
	private String quadra;
	private String posicaoSol;
	private boolean Churrasqueira;
	private boolean Piscina; 

	public boolean temChurrasqueira() {
		return Churrasqueira;
	}

	public void setTemChurrasqueira(boolean temChurrasqueira) {
		this.Churrasqueira = temChurrasqueira;
	}

	public boolean temPiscina() {
		return Piscina;
	}

	public void setPiscina(boolean temPiscina) {
		this.Piscina = temPiscina;
	}

	public int getAreaTotal() {
		return areaTotal;
	}

	public void setAreaTotal(int areaTotal) {
		this.areaTotal = areaTotal;
	}

	public int getAreaUtil() {
		return areaUtil;
	}

	public void setAreaUtil(int areaUtil) {
		this.areaUtil = areaUtil;
	}

	public String getQuadra() {
		return quadra;
	}

	public void setQuadra(String quadra) {
		this.quadra = quadra;
	}

	public String getPosicaoSol() {
		return posicaoSol;
	}

	public void setPosicaoSol(String posicaoSol) {
		this.posicaoSol = posicaoSol;
	}

	public String getTextoAnuncio() {
		return textoAnuncio;
	}
	
	public void destrincharAnuncio() {
		
	}

	public void setTextoAnuncio(String textoAnuncioAtual) {
		textoAnuncio = textoAnuncioAtual;		
	}
}
