import java.util.Scanner;
import java.util.Random;

public class Game {
    public void playGame() {
        Exhunt exhunt = new Exhunt();
        Player player = new Player();
        Enemy enemy = new Enemy();

        History history = new History();
        history.HistoryOne();
        history.MenuOne();

        Scanner input = new Scanner(System.in);
        Random generator = new Random();

        while (true) {
            try {
                int numberChoice = input.nextInt();

                if (numberChoice == 1) {
                    Fight fight = new Fight();
                    fight.fight(player, enemy);
                } else if (numberChoice == 2) {
                    int x = generator.nextInt();

                    String string = null;
                    switch (x % 3) {
                        case 0:
                            string = "A";
                            break;
                        case 1:
                            string = "B";
                            break;
                        case 2:
                            string = "C";
                            break;
                    }
                    System.out.println(string);
                    break;
                } else {
                    System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (Exception e) {
                input.nextLine(); // Limpa o buffer do Scanner
                System.out.println("Caractere inválido! Voltando ao Menu...");
            }
        }
    }
}

// TODO
//  Adicionar menu inicial do jogo (criar personagem, iniciar jogo, carregar jogo salvo)
//  Classe de armas, moedas
//  Adicionar nome e objetos em ascii art *
//  Implementar os dados para a opcao 2 (fugir)
//  Adicionar uma mecanica de XP
//  Adicionar uma mecanica de mana/life recover
//  Implementar o GAME OVER com a opcao de voltar ao menu ou sair do jogo
