package dominio;

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
}
