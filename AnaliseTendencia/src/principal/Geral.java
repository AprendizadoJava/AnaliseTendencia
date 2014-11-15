package principal;

/**
 * @author sergio
 *
 */
public class Geral {
	private Apartamento ape = new Apartamento();
	private Casa casa = new Casa();
	private Lote lote = new Lote();
	
	public static void main(String[] args) {

		
		PdfParser pdfAnuncio = new PdfParser();
		pdfAnuncio
				.setEnderecoRecurso("E:\\Importante_note\\EclipseW\\AnaliseTendencia\\Resources\\001a.pdf");
		String textoAnuncio = pdfAnuncio.getConteudo();
		//System.out.println(textoAnuncio);

		Jornal jornal = new Jornal(textoAnuncio);

/*		do {
			Anuncio anuncio = Jornal.getProximoAnuncio();
		} while (anuncio. != null);
*/	}

}
