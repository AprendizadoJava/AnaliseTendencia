package principal;

import java.util.ArrayList;

public class Jornal {

	
	private String[] textoJornal;
	private Integer posAtual;

	public Jornal(String texto) {
		textoJornal = texto.split("\r\n");
	}

	public ArrayList<Anuncio> retornaAnunciosImovel(String tipoImovelInicio, String tipoImovelFim) {
		FactoryAnuncio factory = new FactoryAnuncio();
		ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();
		int i = 0;
		String anuncioAtual = new String("");
		Anuncio anuncio; 
		
		i = buscarInicioSecao(tipoImovelInicio, i);
				
		do {
			
			
			if (proximoAnuncio(textoJornal[i])) 
				anuncio = factory.getAnuncio(tipoImovelInicio);
				anuncios.add(anuncio);

				anuncioAtual = new String("");
			else i++;
		} while (!fimSecao(tipoImovelFim, i) && !proximoAnuncio(textoJornal[i]));
		
		
		return anuncios;
	}

	private boolean fimSecao(String tipoImovelFim, int i) {
		return (i < textoJornal.length - 1)
				&& (tipoImovelFim.equals(textoJornal[i]));
	}

	private int buscarInicioSecao(String tipoImovelInicio, int i) {
		do {
			i++;
		} while (fimSecao(tipoImovelInicio, i));
		return i;
	}
}
