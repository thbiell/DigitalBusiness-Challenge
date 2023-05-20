

package com.fiap.frases;


public record DadosListagemFrase(
		String frases
		) {

	public DadosListagemFrase(Frase frases) {
		this(
				frases.getFrases());
	}
}
