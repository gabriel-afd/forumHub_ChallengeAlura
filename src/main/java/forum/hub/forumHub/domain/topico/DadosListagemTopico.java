package forum.hub.forumHub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosListagemTopico(
        @NotNull
        Long id,
        @NotBlank
        String mensagem,
        @NotBlank
        String nomeCurso,
        @NotBlank
        String titulo
) {
        public DadosListagemTopico(Topico topico){
                this(topico.getId(), topico.getMensagem(), topico.getNomeCurso(), topico.getTitulo());
        }
}
