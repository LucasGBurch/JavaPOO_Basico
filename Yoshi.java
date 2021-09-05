package reset.poo.basico;

import java.text.DecimalFormat;

public class Yoshi extends Personagem {

    // Atributos:
    private int qtdeFrutas;
    private int velocidade;

    // Métodos:
    public void comerFruta() {
        qtdeFrutas++;
        if (qtdeFrutas % 2 == 0){ // A cada 2 frutas, a velocidade dobra.
            this.velocidade *= 2;
        }
    }

    // Construtor e Métodos Especiais:

    public Yoshi(String nome, int idade, int estamina, double altura) {
        super(nome, idade, estamina, altura);
        this.qtdeFrutas = 0;
        this.velocidade = 10;
    }

    @Override
    protected void crescer() {
        if (comer == true){
            System.out.println("Este Yoshi já comeu um cogumelo!!");
        } else {
            this.comer = true;
            DecimalFormat arredonda = new DecimalFormat("#.00");
            this.altura = this.altura  * 1.1;
            String format = arredonda.format(this.altura); // Teve que virar String nessa formatação!
            System.out.println("Cogumelo Ingerido por " + this.nome + ".\nAltura nova: " + format + "m.");
        }
    }

    public int getVelocidade() {
        return velocidade;
    }
}
