package reset.poo.basico;

import java.util.Random;

public class Jogo {
    // Atributos:
    private Personagem jogador1, jogador2;
    private boolean temJogo = false;

    // Métodos públicos:
    public void imprimeDados(Personagem jogador1, Personagem jogador2){
        this.jogador1.imprimirBasicos();
        this.jogador2.imprimirBasicos();
    }

    public void jogar(){

        if (temJogo) {
            imprimeDados(this.jogador1, this.jogador2);
            System.out.println("------------\nResultado do jogo:");

            Random moedas = new Random();
            int qtde1 = moedas.nextInt(31); // Valor aleatório entre 0 e 30;
            for (int i = 0; i < qtde1; i++) {
                this.jogador1.coletarMoedas();
            }

            int qtde2 = moedas.nextInt(31); // Valor aleatório entre 0 e 30;
            for (int i = 0; i < qtde2; i++) {
                this.jogador2.coletarMoedas();
            }

            System.out.println("O primeiro coletou " + qtde1 + " moedas.\nO segundo " + qtde2 + ".");
            System.out.println("\nResultado final:");
            imprimeDados(this.jogador1, this.jogador2);
        }
    }

    // Construtor;
    public Jogo(Personagem jogador1, Personagem jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        if (this.jogador1 != this.jogador2) {
            temJogo = true;
            System.out.println("------------\nJogo de coletar moedas entre:");
        } else {
            System.out.println("Você não pode jogar com o mesmo personagem!\nEscolha dois diferentes.");
        }
    }
}
