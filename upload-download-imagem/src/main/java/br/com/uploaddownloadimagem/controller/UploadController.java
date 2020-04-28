package br.com.uploaddownloadimagem.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.uploaddownloadimagem.dto.response.UploadResponseDto;
import br.com.uploaddownloadimagem.entity.Upload;
import br.com.uploaddownloadimagem.entity.UploadBinder;
import br.com.uploaddownloadimagem.processor.IUploadProcessor;

@RestController
@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RequestMapping("/demo")
public class UploadController {
	
	@Autowired
	private IUploadProcessor uploadProcessor;
	
	@PostMapping("/upload")
	public ResponseEntity<UploadResponseDto> uploadDocumento(@RequestParam("file") MultipartFile file) throws Exception {
			
		UploadResponseDto response = uploadProcessor.uploadDocumento(file);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(new URI("/download/" + response.getId()));
		
		return new ResponseEntity<>(response, headers, HttpStatus.CREATED) ;	
	}

	
	@GetMapping("/download/{id}")
	public ResponseEntity<UploadResponseDto> downloadDocumento(@PathVariable Long id) throws Exception {
			
		UploadResponseDto response = uploadProcessor.downloadDocumento(id);
		HttpHeaders headers = new HttpHeaders();
		
		return new ResponseEntity<>(response, headers, HttpStatus.OK) ;	
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Upload.class, new UploadBinder());
	}
}
