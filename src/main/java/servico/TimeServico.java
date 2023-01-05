package servico;

import dominio.Time;
import repositorio.TimeRepositorio;

import java.util.Optional;
import java.util.Scanner;

public class TimeServico {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void salva(){
        System.out.println("Digite o nome do time.");
        String nome = SCANNER.nextLine();
        Time time = Time.TimeBuilder.builder().name(nome).build();
        TimeRepositorio.salvar(time);
    }
    public static void deletar(){
        System.out.println("Escolha o id do time para deletar.");
        int id = Integer.parseInt(SCANNER.nextLine());
        TimeRepositorio.deletar(id);
    }

    public static void atualizar(){
        System.out.println("Digite o id do time para atualizar");
        Optional<Time> timeOptional = TimeRepositorio.buscaID(Integer.parseInt(SCANNER.nextLine()));
        if(timeOptional.isEmpty()){
            System.out.println("Time nao encontrado!");
            return;
        }
        Time timeDb = timeOptional.get();
        System.out.println("Digite o novo nome do time.");
        String nome = SCANNER.nextLine();
        nome = nome.isEmpty() ? timeDb.getNome() : nome;
        Time timeAtualizado = Time.TimeBuilder
                .builder()
                .id(timeDb.getId())
                .name(nome)
                .build();
        TimeRepositorio.atualizar(timeAtualizado);
    }
}
