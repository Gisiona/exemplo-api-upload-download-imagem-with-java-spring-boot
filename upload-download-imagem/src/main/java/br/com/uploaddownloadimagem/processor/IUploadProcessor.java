package br.com.uploaddownloadimagem.processor;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import br.com.uploaddownloadimagem.dto.response.UploadResponseDto;

public interface IUploadProcessor {
	UploadResponseDto uploadDocumento(MultipartFile file) throws IOException, Exception;
	UploadResponseDto downloadDocumento(Long id) throws IOException, Exception;
}
