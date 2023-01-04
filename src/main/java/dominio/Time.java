package dominio;

import java.util.Objects;

public class Time {
   private Integer id;
   private String nome;


    public static final class TimeBuilder {
        private Integer id;
        private String nome;

        private TimeBuilder() {
        }

        public static TimeBuilder builder() {
            return new TimeBuilder();
        }

        public TimeBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public TimeBuilder name(String nome) {
            this.nome = nome;
            return this;
        }

        public Time build() {
            Time time = new Time();
            time.id = this.id;
            time.nome = this.nome;
            return time;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return Objects.equals(id, time.id) && Objects.equals(nome, time.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
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
}
