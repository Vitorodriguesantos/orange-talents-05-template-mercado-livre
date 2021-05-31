package br.com.zupacademy.vitor.mercadolivre.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ImagensForm {
	
	@NotNull
	private List<String> base64 = new ArrayList<>();
	@Positive
	private Long idProduto;
	public List<String> getBase64() {
		return base64;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	
	public ImagensForm() {
		
	}
	public ImagensForm(@NotBlank List<String> base64, @Positive Long idProduto) {
		super();
		this.base64 = base64;
		this.idProduto = idProduto;
	}

}
