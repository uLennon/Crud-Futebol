package servico;


import dominio.Jogador;
import repositorio.JogadorRepositorio;
import java.util.Optional;
import java.util.Scanner;

public class JogadorServico {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void salva(){
        System.out.println("Digite o nome do jogador.");
        String nome = SCANNER.nextLine();
        System.out.println("Digite o numero da camisa do jogador.");
        Integer camisa = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Digite o numero da time do jogador.");
        Integer time = Integer.parseInt(SCANNER.nextLine());
        Jogador jogador = Jogador.JogadorBuilder.builder().nome(nome).camisa(camisa).timeId(time).build();
        JogadorRepositorio.salvar(jogador);
    }
    public static void deletar(){
        System.out.println("Escolha o id do jogador para deletar.");
        int id = Integer.parseInt(SCANNER.nextLine());
        JogadorRepositorio.deletar(id);
    }

    public static void atualizar(){
        System.out.println("Digite o id do jogador para atualizar");
        Optional<Jogador> jogadorOptional = JogadorRepositorio.buscaID(Integer.parseInt(SCANNER.nextLine()));
        if(jogadorOptional.isEmpty()){
            System.out.println("Jogador nao encontrado!");
            return;
        }
        Jogador jogadorDb = jogadorOptional.get();
        System.out.println("Digite o novo nome do jogador.");
        String nome = SCANNER.nextLine();
        System.out.println("Digite o numero novo da camisa do jogador.");
        Integer camisa = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Digite o numero novo do time do jogador.");
        Integer timeid = Integer.parseInt(SCANNER.nextLine());
        nome = nome.isEmpty() ? jogadorDb.getNome() : nome;
        Jogador jogadorAtualizado = Jogador.JogadorBuilder
                .builder()
                .id(jogadorDb.getId())
                .nome(nome)
                .camisa(camisa)
                .timeId(timeid)
                .build();
        JogadorRepositorio.atualizar(jogadorAtualizado);
    }

    public static void buscaId(){
        System.out.println("Digite o id para buscar.");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println(JogadorRepositorio.buscaID(id));
    }
}
