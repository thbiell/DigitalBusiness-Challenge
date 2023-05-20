
package com.fiap.frases;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoFrase(
		@NotNull
		Long id,
		String frases
		) {

}
