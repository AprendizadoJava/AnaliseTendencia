package principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PdfParser {

	/***
	 * Extract the content from the given PDF file. As a side effect most other
	 * fields are set too.
	 * 
	 * @see org.zilverline.extractors.AbstractExtractor#getContent(java.io.File)
	 */
	private String enderecoRecurso;

	public void setEnderecoRecurso(String enderecoRecurso) {
		this.enderecoRecurso = enderecoRecurso; // caminho do arquivo
	}

	public String getConteudo() {

		File f = new File(this.enderecoRecurso);
		FileInputStream is = null;
		try {
			is = new FileInputStream(f);
		} catch (IOException e) {
			System.out.println("ERRO: " + e.getMessage());
			return null;
		}

		PDDocument pdfDocument = null;
		try {
			// System.out.println("#1");
			PDFParser parser = new PDFParser(is);
			// System.out.println("#2");
			parser.parse();
			// System.out.println("#3");
			pdfDocument = parser.getPDDocument();
			// System.out.println("#4");
			PDFTextStripper stripper = new PDFTextStripper();
			// System.out.println("#5");
			return stripper.getText(pdfDocument);
			// System.out.println("#6");
		} catch (IOException e) {
			return "ERRO: Can't open stream" + e;
		} catch (Throwable e) {
			// catch this, since we need to close the resources
			return "ERRO: An error occurred while getting contents from PDF"
					+ e;
		} finally {
			if (pdfDocument != null) {
				try {
					pdfDocument.close();
				} catch (IOException e) {
					return "ERRO: Can't close pdf." + e;
				}
			}
		}
	}
}
