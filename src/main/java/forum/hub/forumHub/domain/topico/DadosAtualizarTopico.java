package forum.hub.forumHub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTopico(
        @NotNull
        Long id,
        String mensagem,
        String nomeCurso,
        String titulo
) {

        public DadosAtualizarTopico(Topico topico) {
                this(topico.getId(), topico.getMensagem(), topico.getNomeCurso(), topico.getTitulo());
        }
}
