package reset.poo.basico;

public class AppPersonagem {

    public static void main(String[] args) {

        Mario mario1 = new Mario();

        // TESTES COGUMELO E LIMITES DE ESTAMINA:
        System.out.println("--------------------------------------\nMario 1");
        mario1.crescer(); // Dobra a altura se ainda não comeu;
        mario1.crescer(); // Pra mostrar que não pode comer 2x (não até ter método encolhimento/dano);
        mario1.ganharEstamina(); // Não ganha os 5 pois já tá com 100;
        mario1.perderEstamina(); // Perde 10;
        mario1.ganharEstamina(); // Ganha 5, fica com 95 (mario1 é padrão, tem 100 no início);

        mario1.imprimirBasicos(); // Este printa os solicitados pela versão do CWI_Reset;

        mario1.imprimirPoderes(); // de método pra printar;

        // Fazendo um novo: Desta vez ele é settado
        System.out.println("\n--------------------------------------\nMario 2");
        Mario mario2 = new Mario("Mario Cogumelo", 25, 80, 1.70);

        // TESTE ESTAMINA:
        mario2.ganharEstamina(); // Ganha 5, fica 85;
        mario2.perderEstamina(); // Perde 10, fica 75;
        mario2.crescer(); // Dobra a altura settada;

        mario2.imprimirBasicos(); // Usando método de impressão só pros básicos!!

        // TESTE MORRER E REVIGORAR:
        System.out.println("\n--------------------------------------\nMario 3");
        Mario mario3 = new Mario();

        mario3.imprimirBasicos();
        for (int i = 0; i < 23; i++) { // 23 moedas (2 vida + 3 moedas)
            mario3.coletarMoedas();
        }
        mario3.imprimirBasicos();
        mario3.morrer();
        mario3.imprimirBasicos();
        mario3.morrer();
        mario3.morrer();
        mario3.morrer(); // Testar vidas e estamina seguirem 0.
        mario3.imprimirBasicos();

        // Testes dos pulos, aula 7:
        System.out.println("\n--------------------------------------\nMario 4 e Luigi 1 (Aula 07)");
        Mario mario4 = new Mario("Mario", 25, 90, 1.50);
        Luigi luigi1 = new Luigi("Luigi", 25, 90, 1.70);
        Luigi luigi2 = new Luigi("Luige", 25, 90, 1.70);
        mario4.saltar();
        luigi1.saltar();
        luigi2.saltar(); // Genere Neutre não pode pular no método antigo (no atual pode pq é só println).

        // Tentando usar mario4 e luigi2 no teste do Jogo:
        System.out.println("\n-------------------------------\nMario 4 e Luigi 2 (Aula 08)");
        Jogo jogo = new Jogo(mario4, luigi2);
        jogo.jogar();

        // Testando os 3 personagens agora que são subclasses:
        Yoshi yoshi1 = new Yoshi("Yoshi", 5, 100, 1.80);

        mario4.montadoYoshi();
        mario4.montarNoYoshi(yoshi1);
        mario4.montadoYoshi();
        luigi1.voar();
        System.out.println("Velocidade do Yoshi: " + yoshi1.getVelocidade());
        yoshi1.comerFruta();
        System.out.println("Velocidade do Yoshi: " + yoshi1.getVelocidade());
        yoshi1.comerFruta(); // Aqui dobra;
        System.out.println("Velocidade do Yoshi: " + yoshi1.getVelocidade());
        yoshi1.comerFruta();
        yoshi1.comerFruta(); // Aqui dobra de novo;
        System.out.println("Velocidade do Yoshi: " + yoshi1.getVelocidade());

        // Testes da aula 10: testando cogumelos e saltar
        System.out.println("------------\nOs três crescendo:");
        mario4.crescer();
        luigi1.crescer();
        yoshi1.crescer();
        System.out.println("------------\nOs três saltando SEM atributo (inscrição):");
        mario4.saltar();
        luigi1.saltar();
        yoshi1.saltar();
        System.out.println("------------\nOs três saltando COM atributo (inscrição):");
        mario4.saltar(2.5);
        luigi1.saltar(4);
        yoshi1.saltar(5.33); // Testar minha formatação hehe... 5.33 * 1.5 = 7.995 (virou 8)
    }
}
