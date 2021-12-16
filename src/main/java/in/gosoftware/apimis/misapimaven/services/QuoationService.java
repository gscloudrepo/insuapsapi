package in.gosoftware.apimis.misapimaven.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

import in.gosoftware.apimis.misapimaven.model.Quotation;
import in.gosoftware.apimis.misapimaven.repository.QuotationRepo;
import in.gosoftware.apimis.misapimaven.repository.QuotationReportRepo;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class QuoationService implements IQuotationService {
	
	
	public  String fileName_second,fileName_first,fileName_final;

	// public static String reportPath = System.getProperty("user.dir") +"/uploads/";
	// public static String jasperreportPath = System.getProperty("user.dir") +"/uploads/";
	public static String reportPath = "/var/www/insuaps/html/quote/";
	public static String jasperreportPath = "/var/www/insuaps/html/reports/";
	@Autowired
	private QuotationRepo quotationrepo;
	@Autowired
	private QuotationReportRepo quotationreportrepo;
	@Override
	public String create(Quotation quotation) {
		// TODO Auto-generated method stub
		quotationrepo.save(quotation).subscribe();
		return "created";
				
	}

	@Override
	public Mono<Quotation> findById(String id) {
		// TODO Auto-generated method stub
		return quotationrepo.findById(id);
	}

	@Override
	public Flux<Quotation> findAll() {
		// TODO Auto-generated method stub
		return quotationrepo.findAll();
	}

	@Override
	public Mono<Quotation> update(Quotation quotation) {
		// TODO Auto-generated method stub
		return quotationrepo.save(quotation);
	}

	@Override
	public void delete(String id) {
		quotationrepo.deleteById(id).subscribe();
		// TODO Auto-generated method stub
		
			
	}

	public Flux<Quotation> findByCreatedon(Date sdates, Date edates) {
		// TODO Auto-generated method stub
		return quotationrepo.findByCreatedonBetween(sdates, edates);
	}
	
	
	public String generateReport(String id) {

		// List<Makeproposal> makeproposals = new ArrayList<>();
		// makejasperRepo.findAll().stream().filter(p-> p.getId()==id).forEach(element->
		// makeproposals.add(element));

		// makejasperRepo.findAllById(id);

		try {

			File file = ResourceUtils.getFile(jasperreportPath+"quotation_1.jrxml");

			InputStream input = new FileInputStream(file);

			// Compile the Jasper report from .jrxml to .japser

			JasperReport jasperReport = JasperCompileManager.compileReport(input);

			// Get your data source

			JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(
					(Collection<?>) quotationreportrepo.findAllById(id));

			// Add parameters

			Map<String, Object> parameters = new HashMap<>();

			parameters.put("createdBy", "Go Software");

			// Fill the report

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, source);

			// Export the report to a PDF file
			fileName_first =getAlphaNumericString(22);

			//JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\" + fileName);
			JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath +  fileName_first+".pdf");

			System.out.println("PDF File Generated !!");

		

		//	return fileName;

		} catch (Exception e) {

			return e.getMessage();

		}
		try {

			File file = ResourceUtils.getFile(jasperreportPath+"quotation_2.jrxml");

			InputStream input = new FileInputStream(file);

			// Compile the Jasper report from .jrxml to .japser

			JasperReport jasperReport = JasperCompileManager.compileReport(input);

			// Get your data source

			JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(
					(Collection<?>) quotationreportrepo.findAllById(id));
			
			// Add parameters

			Map<String, Object> parameters = new HashMap<>();

			parameters.put("createdBy", "Go Software");

			// Fill the report

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, source);

			// Export the report to a PDF file
			fileName_second = getAlphaNumericString(22);
			//fileName_second = new SimpleDateFormat("yyyyMMddHHmmss'.pdf'").format(new Date());

		
			JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath +  fileName_second+".pdf");

			System.out.println("PDF2 File Generated !!");

			
			// list.add(new FileInputStream(new File(reportPath +  fileName_second)));
			
			//return fileName;

		} catch (Exception e) {

			return e.getMessage();

		}

		 List<InputStream> list = new ArrayList<InputStream>();
	     try {
//	         // Source pdfs
	         list.add(new FileInputStream(new File(reportPath +  fileName_first+".pdf")));
	         list.add(new FileInputStream(new File(reportPath +  fileName_second+".pdf")));
	        
	//
//	         // Resulting pdf
	         fileName_final = getAlphaNumericString(30);
	      //   fileName_final = new SimpleDateFormat("yyyyMMddHHmmss'.pdf'").format(new Date());
	         OutputStream out = new FileOutputStream(new File(reportPath +  fileName_final+".pdf"));
	 //        System.out.println(list);
	  //       System.out.println(out);
	//
	         doMerge(list, out);
//	        
	//
	     } catch (FileNotFoundException e) {
	         e.printStackTrace();
	     } catch (DocumentException e) {
	         e.printStackTrace();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
		
	     return fileName_final+".pdf";
		// return null;
	}
	
	
	public static void doMerge(List<InputStream> list, OutputStream outputStream)
	        throws DocumentException, IOException {
	    Document document = new Document();
	    PdfWriter writer = PdfWriter.getInstance(document, outputStream);
	    document.open();
	    PdfContentByte cb = writer.getDirectContent();
	    
	    for (InputStream in : list) {
	        PdfReader reader = new PdfReader(in);
	        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
	            document.newPage();
	            //import the page from source pdf
	            PdfImportedPage page = writer.getImportedPage(reader, i);
	            //add the page to the destination pdf
	            cb.addTemplate(page, 0, 0);
	        }
	    }
	    
	    outputStream.flush();
	    document.close();
	    outputStream.close();
	}
	static String getAlphaNumericString(int n) {

		// length is bounded by 256 Character
		byte[] array = new byte[256];
		new Random().nextBytes(array);

		String randomString = new String(array, Charset.forName("UTF-8"));

		// Create a StringBuffer to store the result
		StringBuffer r = new StringBuffer();

		// remove all spacial char
		String AlphaNumericString = randomString.replaceAll("[^A-Za-z0-9]", "");

		// Append first 20 alphanumeric characters
		// from the generated random String into the result
		for (int k = 0; k < AlphaNumericString.length(); k++) {

			if (Character.isLetter(AlphaNumericString.charAt(k)) && (n > 0)
					|| Character.isDigit(AlphaNumericString.charAt(k)) && (n > 0)) {

				r.append(AlphaNumericString.charAt(k));
				n--;
			}
		}

		// return the resultant string
		return r.toString();
	}
}
