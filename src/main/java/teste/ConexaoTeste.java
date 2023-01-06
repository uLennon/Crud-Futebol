package teste;

import servico.JogadorServico;
import servico.TimeServico;
import java.util.Scanner;
import java.util.SortedMap;

public class ConexaoTeste {
    static Scanner scn = new Scanner(System.in);
    static int op;
    public static void main(String[] args) {
        System.out.println("1 - Escolha Menu time");
        System.out.println("2 - Escolha Menu jogadores");
        op = scn.nextInt();
        switch (op){
         case 1:
             timeMenu();
             break;
         case 2:
             jogadorMenu();
             break;
            default:
                System.out.println("Opcao invalida!");
                break;
     }
    }

    public static void timeMenu(){
        System.out.println("Escolha:");
        System.out.println("1 - Cadastrar time");
        System.out.println("2 - Deletar Time");
        System.out.println("3 - Atualizar Time");
        op = scn.nextInt();
        switch (op){
            case 1:
                TimeServico.salva();
                break;
            case 2:
                TimeServico.deletar();
                break;
            case 3:
                TimeServico.atualizar();
                break;
            default:
                System.out.println("Opcao invalida!");
        }
    }

    public static void jogadorMenu(){
        System.out.println("Escolha:");
        System.out.println("1 - Cadastrar jogador");
        System.out.println("2 - Deletar jogador");
        System.out.println("3 - Atualizar jogador");
        op = scn.nextInt();
        switch (op){
            case 1:
                JogadorServico.salva();
                break;
            case 2:
                JogadorServico.deletar();
                break;
            case 3:
                JogadorServico.atualizar();
                break;
            default:
                System.out.println("Opcao invalida!");
        }

    }
}
