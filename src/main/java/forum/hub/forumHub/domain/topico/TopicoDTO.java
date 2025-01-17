package forum.hub.forumHub.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record TopicoDTO(

        @NotBlank
        String mensagem,
        @NotBlank
        String nomeCurso,
        @NotBlank
        String titulo
) {
        public TopicoDTO(Topico dados) {
                this(dados.getMensagem(), dados.getNomeCurso(), dados.getTitulo());
        }
}
