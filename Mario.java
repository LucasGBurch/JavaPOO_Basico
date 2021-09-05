package reset.poo.basico;

import java.text.DecimalFormat;

public class Mario extends Personagem {

    // Atributos extras:
    private Yoshi yoshi;

    // Métodos:
    public void montarNoYoshi(Yoshi yoshi) {
        this.yoshi = yoshi;
    }

    public void montadoYoshi() {
        if (this.yoshi != null){ // Se ele existe no Mario;
            System.out.println("-----------------");
            System.out.println("Mario está montado no Yoshi.");
        } else {
            System.out.println("-----------------");
            System.out.println("Mario não está montado no Yoshi.");
        }
    }

    // Construtores e Métodos especiais
    public Mario() { // Vou deixar o sem atributos aqui, para os testes mais antigos.
    }

    public Mario(String nome, int idade, int estamina, double altura) {
        super(nome, idade, estamina, altura); // Super classe = "mãe" Personagem.
    }

    @Override
    protected void crescer() {
        if (comer == true){
            System.out.println("Este Mario já comeu um cogumelo!!");
        } else {
            this.comer = true;
            DecimalFormat arredonda = new DecimalFormat("0.00");
            this.altura = this.altura  * 1.5;
            String format = arredonda.format(this.altura); // Teve que virar String nessa formatação!
            System.out.println("Cogumelo Ingerido por " + this.nome + ".\nAltura nova: " + format + "m.");
        }
    }
}
