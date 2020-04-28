package br.com.uploaddownloadimagem.entity;

import java.beans.PropertyEditorSupport;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class UploadBinder extends PropertyEditorSupport {

	public void setAsText(MultipartFile file) throws IOException {
		final Upload upload = Upload.convertMultiPartFile(file);
		super.setValue(upload);
	}
}
