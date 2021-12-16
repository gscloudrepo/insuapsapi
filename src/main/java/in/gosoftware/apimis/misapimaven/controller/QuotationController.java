package in.gosoftware.apimis.misapimaven.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.gosoftware.apimis.misapimaven.model.Quotation;
import in.gosoftware.apimis.misapimaven.services.QuoationService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
// @CrossOrigin(origins = "*")
@RequestMapping("api/quotation")
public class QuotationController {
	
	@Autowired
	QuoationService quoationService;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestBody Quotation quotation) {
		quoationService.create(quotation);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/quote/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Mono<Quotation>> findById(@PathVariable("id") String id) {
		Mono<Quotation> quotation = quoationService.findById(id);
		HttpStatus status = quotation != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<Quotation>>(quotation, status);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/allquote", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Flux<Quotation> findAll() { 	
		Flux<Quotation> quotation = quoationService.findAll();
		return quotation;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/quoteupdate", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Mono<Quotation> update(@RequestBody Quotation quotation) {
		return quoationService.update(quotation);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/quotedelete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") String id) {
		quoationService.delete(id);
		//quoationService.deleteFile(id);
	}

	// @CrossOrigin(origins = "*")
	// @RequestMapping(value = "/allmiswithdate",method = RequestMethod.GET,
	// produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	// @ResponseBody
	// public Flux<Mis> findAllWithDate(@RequestBody DateRange daterange) {
	// Flux<Mis> mis = misService.findByCreatedon(daterange);
	// return mis;
	// }
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/allquotewithdate/{sdate}/{edate}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Flux<Quotation>> findAllWithDate(@PathVariable("sdate") String sadte,
			@PathVariable("edate") String edate) throws ParseException {
		Date sdates = new SimpleDateFormat("yyyy-MM-dd").parse(sadte);
		Date edates = new SimpleDateFormat("yyyy-MM-dd").parse(edate);
		Flux<Quotation> quotation = quoationService.findByCreatedon(sdates, edates);
		HttpStatus status = quotation != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Flux<Quotation>>(quotation, status);
	}
	
	 @GetMapping("/report/{id}")
	 
     public String QuoteReport(@PathVariable("id") String id) {
 
         return quoationService.generateReport(id);
 
     }

}
