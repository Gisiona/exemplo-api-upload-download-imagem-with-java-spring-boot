package br.com.uploaddownloadimagem.convert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class UploadConvertBinario {

public static void lerImageAndConvertBinary(String pathInFile, String pathOutFile) throws IOException {
		
		File file = new File(pathInFile);
		
		// faz a leitura de uma imagem
		FileInputStream imageInFile = new FileInputStream(file);	
		
		byte bytes[] = new byte[(int) file.length()];		
		imageInFile.read(bytes);
		
		// converte bytes de uma image em base64
		String encodingImageString = encodeImage(bytes);
				
		// converte Base64 em bytes de array
		byte[] byteArray = decodeImage(encodingImageString);
		
		// salva o arquivo da imagem em diretorio;
		FileOutputStream imageOutFile = new FileOutputStream(pathOutFile);
		
		imageOutFile.write(byteArray);
		
		imageOutFile.close();
		imageInFile.close();
		System.out.print("arquivo salvo com sucesso");		
	}
	
	public static void baixarImage(String imageBase64, String pathOutFile) throws IOException {
		
		byte[] imageByteArray = decodeImage(imageBase64);
		
		FileOutputStream fileOutImage = new FileOutputStream(pathOutFile);
		
		fileOutImage.write(imageByteArray);
		
		fileOutImage.close();
		
		System.out.print("Arquivo salvo com sucesso");
	}
	
	public static String encodeImage(byte[] byteArray) {
		return Base64.getEncoder().encodeToString(byteArray);
	}
	
	public static byte[] decodeImage(String imageString) {
		return Base64.getDecoder().decode(imageString);
	}

}
