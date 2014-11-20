package principal;

public class FactoryAnuncio {

	public static final String TRES_QUARTOS="3 QUARTOS";
	public static final String QUATRO_QUARTOS="4 QUARTOS";
	public static final String LOTE="LOTE";
	public static final String CASA="CASA";

	public Anuncio getAnuncio(String tipoImovel) {
		Anuncio anuncio;
		if (tipoImovel.equalsIgnoreCase(TRES_QUARTOS)){
			anuncio = new Apartamento();
		} else if (tipoImovel.equalsIgnoreCase(QUATRO_QUARTOS)){
			anuncio = new Apartamento();			
		} else if (tipoImovel.equalsIgnoreCase(LOTE)){
			anuncio = new Lote();
		} else if (tipoImovel.equalsIgnoreCase(CASA)){
			anuncio = new Casa();
		} 		
		return null;
	}

}
