package br.com.uploaddownloadimagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.uploaddownloadimagem.entity.Upload;

public interface UploadRepository extends JpaRepository<Upload, Long>{

}
