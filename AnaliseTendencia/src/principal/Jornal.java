package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Jornal {

	public static final String ASA_NORTE = "ASA NORTE";

	private String textoJornal;

	public Jornal() {

		tratarAnunciosporTipo(ASA_NORTE, FactoryAnuncio.TRES_QUARTOS);
		tratarAnunciosporTipo(ASA_NORTE, FactoryAnuncio.QUATRO_QUARTOS);

	}

	private void tratarAnunciosporTipo(String nomeBairro, String variacao) {
		String textoAnuncios;

		textoAnuncios = retornaTextoBairro(nomeBairro, variacao);
		Pattern pattern = Pattern.compile("\r\n[1-3][01][0-6]\\s{1}");
		Matcher matcher = pattern.matcher(textoAnuncios);

		ArrayList<Anuncio> anuncios = retornaAnunciosImovel(textoAnuncios,
				matcher, variacao);
		for (int i = 0; i < anuncios.size(); i++) {
			((Apartamento) anuncios.get(i)).destrincharAnuncio();
		}
	}

	public ArrayList<Anuncio> retornaAnunciosImovel(String textoAnuncios,
			Matcher matcher, String variacao) {
		FactoryAnuncio factory;
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
				factory = new FactoryAnuncio();
				anuncio = factory.getAnuncio(variacao);
				textoAnuncioAtual = textoAnuncios.substring(posAnterior,
						posNova);
				((Anuncio)anuncio).setTextoAnuncio(textoAnuncioAtual);
				anuncios.add(anuncio);
				posAnterior = posNova;
			}
		}

		return anuncios;
	}

	public String retornaTextoBairro(String nomeBairro, String variacao) {
		String nomeArquivo = "E:\\Importante_note\\Desenvolvimento\\Java\\AnaliseTendencia\\AnaliseTendencia\\Resources\\"
				+ nomeBairro.toLowerCase() + "_" + variacao + ".txt";
		String textoBairro = retornaTextoArquivo(nomeArquivo);
		return textoBairro;
	}

	private String retornaTextoArquivo(String nomeArquivo) {
		String textoArquivo = "";
		try {
			FileReader arq = new FileReader(nomeArquivo);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			// lê a primeira linha
			// a variável "linha" recebe o valor "null" quando o processo
			// de repetição atingir o final do arquivo texto
			while (linha != null) {
				textoArquivo = textoArquivo + linha + "\r\n";
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}
		return textoArquivo;
	}

	// private boolean proximoAnuncio(String linhaAtual, String tipoImovelFim) {
	//
	// return false;
	// }

	// public ArrayList<Anuncio> retornaAnunciosImovel() {
	// i = buscarInicioSecao(tipoImovelInicio, i);
	//
	// do {
	// // linhaAtual = new String(textoJornal[i]);
	// if (proximoAnuncio(linhaAtual, tipoImovelFim)
	// && !fimSecao(tipoImovelFim, i)) {
	// anuncio = factory.getAnuncio(tipoImovelInicio);
	// anuncio.setTextoAnuncio(textoAnuncioAtual);
	// anuncios.add(anuncio);
	//
	// textoAnuncioAtual = new String("");
	// } else {
	// if (!fimSecao(tipoImovelFim, i))
	// i++;
	// }
	// // textoAnuncioAtual.concat("\r\n" + textoJornal[i]);
	// } while (!fimSecao(tipoImovelFim, i)
	// && !proximoAnuncio(linhaAtual, tipoImovelFim));
	//
	// }

	// private boolean fimSecao(String tipoImovelFim, int i) {
	// return (i < textoJornal.length - 1)
	// && (tipoImovelFim.equals(textoJornal[i]));
	// }

	// private int buscarInicioSecao(String tipoImovelInicio, int i) {
	// do {
	// i++;
	// } while (fimSecao(tipoImovelInicio, i));
	// return i;
	// }

	// imprime conteúdo de string
	// for (int i=0; i < textoJornal.length; i++) {
	// System.out.println(textoJornal[i]);
	// System.out.println(" ================== ");
	// }

}
