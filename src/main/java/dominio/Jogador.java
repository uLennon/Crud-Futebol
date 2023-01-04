package dominio;

public class Jogador {
    private Integer id;
    private String nome;
    private Integer camisa;


    public static final class JogadorBuilder {
        private Integer id;
        private String nome;
        private Integer camisa;

        private JogadorBuilder() {
        }

        public static JogadorBuilder builder() {
            return new JogadorBuilder();
        }

        public JogadorBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public JogadorBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public JogadorBuilder camisa(Integer camisa) {
            this.camisa = camisa;
            return this;
        }

        public Jogador build() {
            Jogador jogador = new Jogador();
            jogador.camisa = this.camisa;
            jogador.id = this.id;
            jogador.nome = this.nome;
            return jogador;
        }
    }
}
