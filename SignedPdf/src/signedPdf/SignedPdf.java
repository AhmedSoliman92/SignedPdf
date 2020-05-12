package signedPdf;

import java.io.IOException;
import java.util.Calendar;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;


public class SignedPdf {
	public static String signedPdf(String name,String loc,String reason, String filePath) {
		PDDocument pdDocument = new PDDocument();
		PDPage pdPage = new PDPage();
		pdDocument.addPage(pdPage);
		try {
 
			PDSignature PDfSignature = new PDSignature();
			PDfSignature.setFilter(PDSignature.FILTER_VERISIGN_PPKVS);
			PDfSignature.setSubFilter(PDSignature.SUBFILTER_ADBE_PKCS7_SHA1);
			PDfSignature.setName(name);
			PDfSignature.setLocation(loc);
			PDfSignature.setReason(reason);
			PDfSignature.setSignDate(Calendar.getInstance());
			pdDocument.addSignature(PDfSignature);
			
			pdDocument.save(filePath);
			pdDocument.close();
			return "PDF saved to the location !!!";
		} catch (IOException e) {
			return "Error while saving pdf " + e.getMessage();
		}
	}
	public static void main(String [] args) {
		System.out.println(signedPdf("Ahmed Soliman","WFH", "Sample Signature test","../signature.pdf"));
	}
}
