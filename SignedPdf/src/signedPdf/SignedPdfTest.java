package signedPdf;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SignedPdfTest {

	@Test
	void testSignedPdf() {
		
		assertEquals("PDF saved to the location !!!",SignedPdf.signedPdf("Ahmed Soliman", "WFH", "Sample Signature test","../signature.pdf"));
	}
	@Test
	void testSignedPdf_Exception() {
		
		assertEquals("Error while saving pdf \\signature.pdf (Access is denied)",SignedPdf.signedPdf("Ahmed Soliman", "WFH", "Sample Signature test","\\signature.pdf"));
	}
}
