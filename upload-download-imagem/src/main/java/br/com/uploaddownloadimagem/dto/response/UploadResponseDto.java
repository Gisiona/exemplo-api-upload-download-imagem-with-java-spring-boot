package br.com.uploaddownloadimagem.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadResponseDto {
	
	@JsonProperty("codigo")
	private Long id;	

	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("content_type")
	private String contentType;		
	
	@JsonProperty("data_cadastro")
	private LocalDateTime dataCadastro;
	
	@JsonProperty("size")
	private String size;
	
	@JsonProperty("arquivo")
	private String bytes;

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getBytes() {
		return bytes;
	}

	public void setBytes(String bytes) {
		this.bytes = bytes;
	}

}
