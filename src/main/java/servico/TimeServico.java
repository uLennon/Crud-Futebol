package servico;

import dominio.Time;
import repositorio.TimeRepositorio;

import java.util.Scanner;

public class TimeServico {
    private static final Scanner SCANNER = new Scanner(System.in);

    private void salvar(){
        System.out.println("Digite o nome do time");
        String nome = SCANNER.nextLine();
        Time time = Time.TimeBuilder.builder().name(nome).build();
        TimeRepositorio.save(time);
    }
    private static void deletar(){
        System.out.println("Escolha o id do time para deletar");
        int id = Integer.parseInt(SCANNER.nextLine());
        TimeRepositorio.deletar(id);
    }
}
