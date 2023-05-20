
package com.fiap.frases;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;


@Table
@Entity
public class Frase {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Lob
	private String frases;
	private Boolean ativo;


	public Frase() {

	}

	public Frase(DadosCadastroFrase dados) {
		super();
		this.ativo = true;
		this.frases = dados.frases();
		
	}

	public void atualizaInformacoes(DadosAtualizacaoFrase dados) {
		if (dados.frases() != null) {
			this.frases = dados.frases();
		}
}
	public String getFrases() {
		return frases;
	}

	public void setFrases(String frases) {
		this.frases = frases;
	}
	
	public void excluir() {
		this.ativo = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}



}
