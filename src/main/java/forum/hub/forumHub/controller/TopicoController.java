package forum.hub.forumHub.controller;

import forum.hub.forumHub.domain.topico.DadosAtualizarTopico;
import forum.hub.forumHub.domain.topico.DadosListagemTopico;
import forum.hub.forumHub.domain.topico.Topico;
import forum.hub.forumHub.domain.topico.TopicoDTO;
import forum.hub.forumHub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid TopicoDTO dadosTopico, UriComponentsBuilder uriComponentsBuilder){
        var dados = new Topico(dadosTopico);
        repository.save(dados);

        var uri = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(dados.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(dados));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar(@PageableDefault(size = 20,sort = {"mensagem"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);

    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarTopico dadosAtualizarTopico){
        var topico = repository.getReferenceById(dadosAtualizarTopico.id());
        topico.atualizarTopico(dadosAtualizarTopico);

        return ResponseEntity.ok(new DadosAtualizarTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var topico = repository.getReferenceById(id);
        topico.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var topico = repository.getReferenceById(id);


        return ResponseEntity.ok(new DadosAtualizarTopico(topico));
    }


}
