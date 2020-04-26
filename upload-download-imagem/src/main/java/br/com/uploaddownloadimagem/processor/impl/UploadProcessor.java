package br.com.uploaddownloadimagem.processor.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import br.com.uploaddownloadimagem.dto.response.UploadResponseDto;
import br.com.uploaddownloadimagem.entity.Upload;
import br.com.uploaddownloadimagem.processor.IUploadProcessor;
import br.com.uploaddownloadimagem.repository.UploadRepository;

@Component
public class UploadProcessor implements IUploadProcessor{

	@Autowired
	private UploadRepository uploadRepository;
	
	@Override
	public UploadResponseDto uploadDocumento(MultipartFile file) throws Exception {
		try {
			Upload up = new Upload();
			up.setBytes(file.getBytes());
			up.setContentType(file.getContentType());
			up.setDataCadastro(LocalDateTime.now());
			up.setNome(file.getOriginalFilename());
			up.setSize(file.getSize());
			
			Upload upload = uploadRepository.save(up);
			
			String image = Base64.getEncoder().encodeToString(upload.getBytes());
			
			UploadResponseDto response = new UploadResponseDto();
			response.setContentType(upload.getContentType());
			response.setDataCadastro(upload.getDataCadastro());
			response.setId(upload.getId());
			response.setNome(upload.getNome());
			response.setBytes(image);			
			response.setSize(String.valueOf(file.getSize()));
			return response;
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro ao salvar imagem. Erro: " + e.getMessage());
		}		
	}

	@Override
	public UploadResponseDto downloadDocumento(Long id) throws IOException, Exception {
		try {
			Optional<Upload> upload = uploadRepository.findById(id);
			
			UploadResponseDto response = new UploadResponseDto();
			
			if(upload.isPresent()) {
				String image = Base64.getEncoder().encodeToString(upload.get().getBytes());			
				response.setContentType(upload.get().getContentType());
				response.setDataCadastro(upload.get().getDataCadastro());
				response.setId(upload.get().getId());
				response.setNome(upload.get().getNome());
				response.setBytes(image);
				response.setSize(String.valueOf(upload.get().getSize()));
			}			
			return response;
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro ao salvar imagem. Erro: " + e.getMessage());
		}
	}

}
