package in.gosoftware.apimis.misapimaven.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import in.gosoftware.apimis.misapimaven.model.Makeproposal;
import in.gosoftware.apimis.misapimaven.model.Mis;
import in.gosoftware.apimis.misapimaven.model.UploadProposalFile;
import in.gosoftware.apimis.misapimaven.repository.MakeJasperProp;
import in.gosoftware.apimis.misapimaven.repository.MakeProposalRepo;
import in.gosoftware.apimis.misapimaven.repository.UploadPropRepo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MakeProposalService implements IMakeProposalService {

	@Autowired
	MakeProposalRepo makeproposalrepo;
	@Autowired
	UploadPropRepo uploadPropRepo;
	@Autowired
	MakeJasperProp makejasperRepo;
	// public static String reportPath = System.getProperty("user.dir") +"/uploads";
	public static String reportPath = "/var/www/insuaps/html/prop/";
	public static String jasperreportPath = "/var/www/insuaps/html/reports/";

	@Override
	public Mono<Makeproposal> create(Makeproposal makeProposal) {

		return makeproposalrepo.save(makeProposal);

	}

	@Override
	public void createprop(UploadProposalFile uploadProposalFile) {

		uploadPropRepo.save(uploadProposalFile);
	}

	@Override
	public Flux<Makeproposal> findByCreatedon(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return makeproposalrepo.findByCreatedonBetween(sdate, edate);
	}

	@Override
	public Mono<Makeproposal> findById(String id) {
		// TODO Auto-generated method stub
		return makeproposalrepo.findById(id);
	}

	@Override
	public Flux<Makeproposal> findAll() {
		// TODO Auto-generated method stub
		return makeproposalrepo.findAll();
	}

	@Override
	public Mono<Makeproposal> update(Makeproposal makeproposal) {
		// TODO Auto-generated method stub
		return makeproposalrepo.save(makeproposal);
	}

	@Override
	public Mono<Void> delete(String id) {
		// TODO Auto-generated method stub
		return makeproposalrepo.deleteById(id);
	}

	@Override
	public void deleteFile(String id) {

		uploadPropRepo.deleteByPropid(id);
	}

	@Override
	public UploadProposalFile updateprop(UploadProposalFile uploadProposalFile) {

		return uploadPropRepo.save(uploadProposalFile);

	}

	public String generateReport(String id) {

		// List<Makeproposal> makeproposals = new ArrayList<>();
		// makejasperRepo.findAll().stream().filter(p-> p.getId()==id).forEach(element->
		// makeproposals.add(element));

		// makejasperRepo.findAllById(id);

		try {

			File file = ResourceUtils.getFile(jasperreportPath+"proposal_form_1_1.jrxml");

			InputStream input = new FileInputStream(file);

			// Compile the Jasper report from .jrxml to .japser

			JasperReport jasperReport = JasperCompileManager.compileReport(input);

			// Get your data source

			JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(
					(Collection<?>) makejasperRepo.findAllById(id));

			// Add parameters

			Map<String, Object> parameters = new HashMap<>();

			parameters.put("createdBy", "Go Software");

			// Fill the report

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, source);

			// Export the report to a PDF file
			String fileName = new SimpleDateFormat("yyyyMMddHHmmss'.pdf'").format(new Date());

			//JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\" + fileName);
			JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath +  fileName);

			System.out.println("PDF File Generated !!");

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

			return fileName;

		} catch (Exception e) {

			return e.getMessage();

		}

		// return null;
	}
	
	private void xlsx(JasperPrint jasperPrint) throws JRException {
		
		        // Exports a JasperReports document to XLSX format. It has character output type and exports the document to a grid-based layout.
		
		        JRXlsxExporter exporter = new JRXlsxExporter();
	
		        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		     // Export the report to a PDF file
				String fileName = new SimpleDateFormat("yyyyMMddHHmmss'.xlsx'").format(new Date());
				
		
		        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(reportPath + "\\"+fileName));
		
		        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(reportPath + fileName));
		
		        SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
		
		        configuration.setOnePagePerSheet(true);
		
		        configuration.setRemoveEmptySpaceBetweenColumns(true);
		
		        configuration.setDetectCellType(true);
		
		        exporter.setConfiguration(configuration);
		
		
		
		        exporter.exportReport();
		
		    }

}
