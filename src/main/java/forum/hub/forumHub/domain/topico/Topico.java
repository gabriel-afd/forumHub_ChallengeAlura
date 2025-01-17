package forum.hub.forumHub.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topico")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    private String nomeCurso;
    private String titulo;

    private Boolean ativo;


    public Topico(TopicoDTO dadosTopico) {
        this.mensagem = dadosTopico.mensagem();
        this.nomeCurso = dadosTopico.nomeCurso();
        this.titulo = dadosTopico.titulo();
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void atualizarTopico(@Valid DadosAtualizarTopico dadosAtualizarTopico) {
        if(dadosAtualizarTopico.mensagem() != null){
            this.mensagem = dadosAtualizarTopico.mensagem();
        }

        if(dadosAtualizarTopico.nomeCurso() != null){
            this.nomeCurso = dadosAtualizarTopico.nomeCurso();
        }

        if(dadosAtualizarTopico.titulo() != null){
            this.titulo = dadosAtualizarTopico.titulo();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
