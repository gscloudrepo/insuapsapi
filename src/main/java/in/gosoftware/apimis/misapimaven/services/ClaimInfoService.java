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
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

import in.gosoftware.apimis.misapimaven.model.ClaimInfo;
import in.gosoftware.apimis.misapimaven.model.UploadClaimInfoFile;
import in.gosoftware.apimis.misapimaven.repository.ClaimInfoRepo;
import in.gosoftware.apimis.misapimaven.repository.ClaimReportRepo;
import in.gosoftware.apimis.misapimaven.repository.QuotationReportRepo;
import in.gosoftware.apimis.misapimaven.repository.UploadClaimInfoFileRepo;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClaimInfoService implements IClaimInfoService {

	@Autowired
	private ClaimInfoRepo claiminforepo;
	@Autowired
	private UploadClaimInfoFileRepo uploadclaiminforepo;
	@Autowired
	private ClaimReportRepo claimReportRepo;
	public static String reportPath = "/var/www/insuaps/html/claiminti/";
	public static String jasperreportPath = "/var/www/insuaps/html/reports/";
	public static String photofilePath = "/var/www/insuaps/html/claiminti/";
	public static String fileName_second,fileName_first,fileName_final;

	// public static String reportPath = System.getProperty("user.dir") +"/uploads/";
	// public static String jasperreportPath = System.getProperty("user.dir") +"/uploads/";
	// public static String photofilePath = System.getProperty("user.dir") +"/uploads/claiminti/";
	@Override
	public String create(ClaimInfo claimInfo) {
		// TODO Auto-generated method stub
		claiminforepo.save(claimInfo).subscribe();
		return "created";
				
	}

	@Override
	public Mono<ClaimInfo> findById(String id) {
		// TODO Auto-generated method stub
		return claiminforepo.findById(id);
	}

	@Override
	public void createclaimmisfile(UploadClaimInfoFile uploadClaimInfoFile) {
		// TODO Auto-generated method stub
		uploadclaiminforepo.save(uploadClaimInfoFile);
	}

	@Override
	public UploadClaimInfoFile updateclaiminfofile(UploadClaimInfoFile uploadClaimInfoFile) {
		// TODO Auto-generated method stub
		return uploadclaiminforepo.save(uploadClaimInfoFile);
	}

	@Override
	public Flux<ClaimInfo> findAll() {
		// TODO Auto-generated method stub
		return claiminforepo.findAll();
	}

	@Override
	public Mono<ClaimInfo> update(ClaimInfo claimInfo) {
		// TODO Auto-generated method stub
		return claiminforepo.save(claimInfo);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		claiminforepo.deleteById(id).subscribe();
	}

	@Override
	public Flux<ClaimInfo> findByCreatedon(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return claiminforepo.findByCreatedonBetween(sdate, edate);
	}

	@Override
	public void deleteFile(String id) {
		// TODO Auto-generated method stub
		uploadclaiminforepo.deleteById(id);
	}
	
	
	public String getPhotoZip(String id) throws IOException {
		
		
		List<UploadClaimInfoFile> uploadClaimInfoFileList=uploadclaiminforepo.findByClaiminfoidAndFilenametype(id,"Photos");
		
		 List<String> listofFiles = new ArrayList<String>();
		
	     for (UploadClaimInfoFile value : uploadClaimInfoFileList)
		 {
	    	 listofFiles = uploadClaimInfoFileList.stream().map(x -> x.getFilename()).collect(Collectors.toList());

			 //listofFiles.add(photofilePath + uploadClaimInfoFileList.get(2));
			
		 }
	     System.out.println(listofFiles);
//	         // Source pdfs
		return zipFile(listofFiles);
	}

	public String generateReport(String id) {

		// List<Makeproposal> makeproposals = new ArrayList<>();
		// makejasperRepo.findAll().stream().filter(p-> p.getId()==id).forEach(element->
		// makeproposals.add(element));

		// makejasperRepo.findAllById(id);

		// List<Makeproposal> makeproposals = new ArrayList<>();
		// makejasperRepo.findAll().stream().filter(p-> p.getId()==id).forEach(element->
		// makeproposals.add(element));

		// makejasperRepo.findAllById(id);

		try {

			File file = ResourceUtils.getFile(jasperreportPath+"claim_intimation_1.jrxml");

			InputStream input = new FileInputStream(file);

			// Compile the Jasper report from .jrxml to .japser

			JasperReport jasperReport = JasperCompileManager.compileReport(input);

			// Get your data source

			JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(
					(Collection<?>) claimReportRepo.findAllById(id));

			// Add parameters

			Map<String, Object> parameters = new HashMap<>();

			parameters.put("createdBy", "Go Software");

			// Fill the report

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, source);

			// Export the report to a PDF file
			fileName_first = getAlphaNumericString(22);
			//String fileName = new SimpleDateFormat("yyyyMMddHHmmss'.pdf'").format(new Date());

			//JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\" + fileName);
			JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath +  fileName_first+".pdf");

			System.out.println("PDF1 File Generated !!");

			// JasperExportManager.exportReportToXmlFile(jasperPrint, reportPath +
			// "\\Employee.xml", true);
			//
			// System.out.println("XML File Generated !!");
			//
			// JasperExportManager.exportReportToHtmlFile(jasperPrint, reportPath +
			// "\\Employee.html");
			//
			// System.out.println("HTML Generated");
			//
			// xlsx(jasperPrint);
			//
			// csv(jasperPrint);

		//	return fileName;

		} catch (Exception e) {

			return e.getMessage();

		}
		try {

			File file = ResourceUtils.getFile(jasperreportPath+"claim_intimation_2.jrxml");

			InputStream input = new FileInputStream(file);

			// Compile the Jasper report from .jrxml to .japser

			JasperReport jasperReport = JasperCompileManager.compileReport(input);

			// Get your data source

			JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(
					(Collection<?>) claimReportRepo.findAllById(id));
			
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
	         fileName_final = getAlphaNumericString(22);
	        // fileName_final = new SimpleDateFormat("yyyyMMddHHmmss'.pdf'").format(new Date());
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
	
	public String zipFile(List<String> srcFiles) throws IOException {
		// List<String> srcFiles = Arrays.asList("test1.txt", "test2.txt");
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss'.zip'").format(new Date());
	        FileOutputStream fos = new FileOutputStream(photofilePath+fileName);
	        ZipOutputStream zipOut = new ZipOutputStream(fos);
	        for (String srcFile : srcFiles) {
	            File fileToZip = new File(srcFile);
	            FileInputStream fis = new FileInputStream(photofilePath+fileToZip);
	            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
	            zipOut.putNextEntry(zipEntry);
	 
	            byte[] bytes = new byte[1024];
	            int length;
	            while((length = fis.read(bytes)) >= 0) {
	                zipOut.write(bytes, 0, length);
	            }
	            fis.close();
	        }
	        zipOut.close();
	        fos.close();
			return fileName;
	      
	}
	

}
