package principal;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Jornal {

	private Pattern pattern;
	private Matcher matcher;
	
	private String textoJornal;
	private Integer posAtual;

	public Jornal(String texto) {

		textoJornal = texto;

		pattern = Pattern.compile("\r\n[1-3][01][0-6]\\s{1}");
		matcher = pattern.matcher(textoJornal);
	
//		for (int i=0; i < textoJornal.length; i++) {
//			System.out.println(textoJornal[i]);
//			System.out.println(" ================== ");
//		}
		
	}

	public ArrayList<Anuncio> retornaAnunciosImovel(String tipoImovelInicio,
			String tipoImovelFim) {
		FactoryAnuncio factory = new FactoryAnuncio();
		ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();
		int i = 0;
		String textoAnuncioAtual = new String("");
		Anuncio anuncio;
		String linhaAtual;
		int posNova = 0;
		int posAnterior = 0;
		
		boolean haOutroAnuncio = false;
		while (haOutroAnuncio = matcher.find()) {
			if (haOutroAnuncio) {
				posNova = matcher.start();
				System.out.println(textoJornal.substring(posAnterior, posNova));
				System.out.println("========================");
				posAnterior = posNova;
			}
		}
		
		
//		i = buscarInicioSecao(tipoImovelInicio, i);
//
//		do {
////			linhaAtual = new String(textoJornal[i]);
//			if (proximoAnuncio(linhaAtual, tipoImovelFim)
//					&& !fimSecao(tipoImovelFim, i)) {
//				anuncio = factory.getAnuncio(tipoImovelInicio);
//				anuncio.setTextoAnuncio(textoAnuncioAtual);
//				anuncios.add(anuncio);
//
//				textoAnuncioAtual = new String("");
//			} else {
//				if (!fimSecao(tipoImovelFim, i))
//					i++;
//			}
////			textoAnuncioAtual.concat("\r\n" + textoJornal[i]);
//		} while (!fimSecao(tipoImovelFim, i)
//				&& !proximoAnuncio(linhaAtual, tipoImovelFim));
//
		return anuncios;
	}

	private boolean proximoAnuncio(String linhaAtual, String tipoImovelFim) {
		// TODO Auto-generated method stub
		return false;
	}

//	private boolean fimSecao(String tipoImovelFim, int i) {
//		return (i < textoJornal.length - 1)
//				&& (tipoImovelFim.equals(textoJornal[i]));
//	}

//	private int buscarInicioSecao(String tipoImovelInicio, int i) {
//		do {
//			i++;
//		} while (fimSecao(tipoImovelInicio, i));
//		return i;
//	}
}
