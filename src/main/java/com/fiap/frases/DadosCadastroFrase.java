

package com.fiap.frases;


import jakarta.validation.constraints.NotBlank;

public record DadosCadastroFrase(
		@NotBlank
		String frases
		) {

}
