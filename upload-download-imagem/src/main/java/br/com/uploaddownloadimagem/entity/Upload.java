package br.com.uploaddownloadimagem.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name = "binario_documento") 
@Getter @Setter
public class Upload {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;	
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "content_type")
	private String contentType;		
	
	@Column(name = "data_cadastro")
	private LocalDateTime dataCadastro;
	
	@Column(name = "tamanho")
	private Long size;
	

	@Column(name="bytes", columnDefinition = "LONGBLOB")
	private byte[] bytes;
	
	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
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

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

		
}
