package reset.poo.basico;

import java.text.DecimalFormat;

public class Luigi extends Personagem {

    // Métodos:
    public void voar() {
        System.out.println("-----------------");
        System.out.println(this.nome + " está voando! Weeeee!");
    }


    // Construtor:
    public Luigi(String nome, int idade, int estamina, double altura) {
        super(nome, idade, estamina, altura);
    }

    @Override
    protected void crescer() {
        if (comer == true){
            System.out.println("Este Luigi já comeu um cogumelo!!");
        } else {
            this.comer = true;
            DecimalFormat arredonda = new DecimalFormat("#.00");
            this.altura = this.altura  * 1.75;
            String format = arredonda.format(this.altura); // Teve que virar String nessa formatação!
            System.out.println("Cogumelo Ingerido por " + this.nome + ".\nAltura nova: " + format + "m.");
        }
    }
}
