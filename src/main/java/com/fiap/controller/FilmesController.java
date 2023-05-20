

package com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.frases.DadosAtualizacaoFrase;
import com.fiap.frases.DadosCadastroFrase;
import com.fiap.frases.DadosListagemFrase;
import com.fiap.frases.Frase;
import com.fiap.frases.FrasesRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/frases")
public class FilmesController {
	@Autowired
	private FrasesRepository repository;
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroFrase dados) {
		repository.save(new Frase(dados));
	}
	@GetMapping
	public Page<DadosListagemFrase> listar(@PageableDefault(size=5,sort= {"id"}) Pageable paginacao){
		return repository.findAllByAtivoTrue(paginacao).map(DadosListagemFrase::new);
	}
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoFrase dados) {
		Frase frases = new Frase();
		frases = repository.getReferenceById(dados.id());
		frases.atualizaInformacoes(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		Frase frases = new Frase();
		frases = repository.getReferenceById(id);
		frases.excluir();
		
	}
}
