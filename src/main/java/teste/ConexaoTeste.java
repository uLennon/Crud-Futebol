package teste;

import dominio.Time;
import repositorio.TimeRepositorio;

public class ConexaoTeste {
    public static void main(String[] args) {
        Time time = Time.TimeBuilder.builder().name("Teste1").build();
        TimeRepositorio.save(time);
    }
}
