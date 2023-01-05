package dominio;

import java.util.Objects;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCamisa() {
        return camisa;
    }

    public void setCamisa(Integer camisa) {
        this.camisa = camisa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return Objects.equals(id, jogador.id) && Objects.equals(nome, jogador.nome) && Objects.equals(camisa, jogador.camisa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, camisa);
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", camisa=" + camisa +
                '}';
    }
}
