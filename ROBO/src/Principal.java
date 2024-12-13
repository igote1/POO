import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		  int passo=1, opcao;
	        Robo R1 = new Robo(0,0);
	        Scanner input = new Scanner(System.in);
	        R1.MostrarPosicaoAtual();
	        do {
	            System.out.println("Digite a direcao: 1 - cima, 2 - baixo, 3 - esquerda, 4- direita, 0 - encerrar :");
	            opcao = input.nextInt();
	            switch (opcao) {
	                case 1:
	                    R1.AndarCima();
	                    R1.MostrarPosicaoAtual();
	                    break;

	                case 2:
	                    R1.andarBaixo();
	                    R1.MostrarPosicaoAtual();
	                    break;
	                case 3:
	                    R1.andarEsquerda();
	                    R1.MostrarPosicaoAtual();
	                    break;
	                case 4:
	                    R1.andarDireita();
	                    R1.MostrarPosicaoAtual();
	                    break;
	                case 0:
	                    System.out.println("FIM");
	                    break;
	                default:
	                    System.out.println("Opcao invalida");
	                    break;
	            }
	        }while (opcao!=0);
	    }
	}