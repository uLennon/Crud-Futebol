package dominio;

public class Time {
   private Integer id;
   private String name;


    public static final class TimeBuilder {
        private Integer id;
        private String name;

        private TimeBuilder() {
        }

        public static TimeBuilder builder() {
            return new TimeBuilder();
        }

        public TimeBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public TimeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Time build() {
            Time time = new Time();
            time.id = this.id;
            time.name = this.name;
            return time;
        }
    }
}
