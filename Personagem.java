package reset.poo.basico;

import java.text.DecimalFormat;

public abstract class Personagem {
    // Características:

    protected double altura; // Ficam protected no momento em que Personagem vira classe ABSTRATA!!
    protected int idade, estamina, QtdeMoedas, QtdeVidas; // Para poder puxar this.nome etc nas subClasses!!
    protected String nome;
    protected boolean comer;

    // Getters e Setters para os atributos privados:

    public Personagem() { // A partir da aula 7, com Luigi, este construtor não é mais usado!
        this.nome = "Mario Bros"; // Mantido só para fins de estudo.
        this.idade = 40;
        this.estamina = 100;
        this.altura = 1.50;
        this.comer = false; // Estes três atributos ficam padrão mesmo no construtor definido;
        this.QtdeVidas = 1;
        this.QtdeMoedas = 0;
    }

    public Personagem(String nome, int idade, int estamina, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.estamina = estamina;
        this.altura = altura;
        this.comer = false;
        this.QtdeVidas = 1;
        this.QtdeMoedas = 0;
    }

    private void revigorar(){
        this.estamina = 100;
    }

    public void saltar(){
        DecimalFormat arredonda = new DecimalFormat("0.00");
        double salto = this.altura  * 0.5; // Pular metade;
        String format = arredonda.format(salto); // Teve que virar String nessa formatação!
        System.out.println("Personagem está pulando 50% de sua altura: " + format + " metros.");
    }

    public void saltar(double alturaObjeto){
        DecimalFormat arredonda = new DecimalFormat("0.00");
        double salto = alturaObjeto  * 1.5; // Este salto é um POLIMORFISMO DE SOBRECARGA (por isso tem outro acima)
        String format = arredonda.format(salto); // Teve que virar String nessa formatação!
        System.out.println(this.nome + " pula sobre obstáculo de " + alturaObjeto
                + " metros.\n" + "Altura do pulo: "
                + format + " metros.");
    }

    public void coletarMoedas(){
        this.QtdeMoedas++;
        if (this.QtdeMoedas % 10 == 0){
            this.QtdeVidas++;
        }
    }

    public void morrer(){
        this.estamina = 0;
        this.QtdeVidas--;
        if (this.QtdeVidas >= 0){
            this.revigorar();
        } else{
            this.QtdeVidas = 0;
        }
    }

    public void perderEstamina(){ // Perder/Ganhar Estamina e comer cogumelo são aula 05 de POO!!
        if (this.estamina >= 10){
            this.estamina = this.estamina - 10;
        } else {
            this.estamina = 0;
        }
    }

    public void ganharEstamina(){
        if (this.estamina >= 95){
            this.estamina = 100;
        } else {
            this.estamina = this.estamina + 5;
        }
    }

    // Este crescer serviu para o POLIMORFISMO DE SOBRESCRIÇÃO (Override)
    protected abstract void crescer(); // Onde cada subclasse tem o seu definido.

    public void imprimirBasicos(){
        System.out.println("------------------------------");
        System.out.println("Nome: " + this.nome + "\nIdade: " + this.idade
                + "\nEstamina: " + this.estamina + "\nAltura: " + this.altura
                + "\nVidas: " + this.QtdeVidas + "\nMoedas: " + this.QtdeMoedas);
    }

    // superPoderes:
    protected void imprimirPoderes(){ // Protected é restrito aos pais-filhos (aplicar e mario);
        System.out.println("\nPoderes: \nPulo Dimensional;\nPular/Saltar;\nPirotecnia;\n"
                + "Velocidade;\nSuper Força; entre outros.");
    }
}

