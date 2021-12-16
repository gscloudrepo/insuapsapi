package in.gosoftware.apimis.misapimaven.controller;


import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang.CharEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.icu.impl.duration.impl.DataRecord.EMilliSupport;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import in.gosoftware.apimis.misapimaven.EmailUtil;
import in.gosoftware.apimis.misapimaven.SmtpAuthenticator;
import in.gosoftware.apimis.misapimaven.model.Customer;
import in.gosoftware.apimis.misapimaven.model.Mail;



@RestController
@CrossOrigin(origins = "*")
public class EmailController {
	
//	private String username;
//	
//	private String password;
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	  @Autowired
	    private Configuration freemarkerConfig;
	@GetMapping(value="api/send/{email}/{cid}/{subject}/{fullname}")
	
	public void sendEmail(@PathVariable("email") String email,@PathVariable("cid") String cid,@PathVariable("subject") String subject,@PathVariable("fullname") String fullname)    {
		
		Mail mail = new Mail();
		 mail.setFullname(fullname);
		 mail.setCid(cid);
		 mail.setMailTo(email);
		 mail.setMailSubject(subject);
	    //    MimeMessageHelper helper = new MimeMessageHelper(message);
		Map model = new HashMap();
       model.put("name", fullname);
       model.put("cid", cid);
       model.put("signature", "https://insuaps.com");
       mail.setModel(model);
		sendmail(mail);
		//return "Email sent successfully";
	}
	
	
	private void sendmail(Mail mail ) {
		 MimeMessage message = javaMailSender.createMimeMessage();
		 
		 
        
       
		
	        try {
	            MimeMessageHelper helper = new MimeMessageHelper(message, true, CharEncoding.UTF_8);
	            Template t = freemarkerConfig.getTemplate("email-template.ftl");
	            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getModel());
	    		// SimpleMailMessage msg = new SimpleMailMessage();
	    		 helper.setTo(mail.getMailTo());

	    		 helper.setSubject(mail.getMailSubject());
	    		 helper.setText(html, true);

	    	        javaMailSender.send(message);
	        } catch (Exception e) {
	        	System.out.println(e.getMessage());
	           // log.warn("E-mail could not be sent to user '{}', exception is: {}", to, e.getMessage());
	        }
       
		
		
	}
  
}
