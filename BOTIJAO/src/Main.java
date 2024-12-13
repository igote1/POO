
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Pedido> pedidos = new ArrayList<>();
    private static final double PRECO_UNITARIO = 90.00; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println(" ");
            System.out.println("Menu:");
            System.out.println("1. Fazer pedido");
            System.out.println("2. Confirmar entrega");
            System.out.println("3. Ver pedidos confirmados");
            System.out.println("4. Ver pedidos entregues");
            System.out.println("5. Sair");
            System.out.println("Escolha uma opção: ");
          
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    fazerPedido(scanner);
                    break;
                case 2:
                    confirmarEntrega(scanner);
                    break;
                case 3:
                    verPedidos("Confirmado");
                    break;
                case 4:
                    verPedidos("Entregue");
                    break;
                case 5:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void fazerPedido(Scanner scanner) {
        System.out.println(" ");
        System.out.print("Informe o endereço de entrega: ");
        String endereco = scanner.nextLine();
        Pedido pedido = new Pedido(endereco);

        System.out.println("Dados do pedido:");
        System.out.println(pedido);
        System.out.print("Deseja mudar o endereço? (s/n): ");
        if ("s".equalsIgnoreCase(scanner.nextLine())) {
            System.out.print("Informe o novo endereço: ");
            pedido.setEnderecoEntrega(scanner.nextLine());
            System.out.println("Endereço atualizado:");
            System.out.println(pedido);
        }

        System.out.print("Informe a quantidade de botijões desejada: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Informe o número do cartão de crédito: ");
        String cartao = scanner.nextLine();

        pedido.confirmarPedido(quantidade, PRECO_UNITARIO, cartao);

        System.out.println("Pedido confirmado:");
        System.out.println(pedido);
        pedidos.add(pedido);
    }

    private static void confirmarEntrega(Scanner scanner) {
        System.out.print("Informe o código do pedido para confirmar a entrega: ");
        int cod = scanner.nextInt();
        scanner.nextLine(); 
        Pedido pedidoEncontrado = null;
        for (Pedido pedido : pedidos) {
            if (pedido.getcod() == cod) {
                pedidoEncontrado = pedido;
                break;
            }
        }

        if (pedidoEncontrado != null && pedidoEncontrado.isConfirmado()) {
            pedidoEncontrado.confirmarEntrega();
            System.out.println("Entrega confirmada:");
            System.out.println(pedidoEncontrado);
        } else {
            System.out.println("Pedido não localizado ou já entregue.");
        }
    }

    private static void verPedidos(String status) {
        System.out.printf("Pedidos com status '%s':%n", status);
        boolean encontrou = false;

        for (Pedido pedido : pedidos) {
            if ((status.equals("Confirmado") && pedido.isConfirmado()) ||
                (status.equals("Entregue") && pedido.isEntregue())) {
                System.out.println(pedido);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum pedido encontrado.");
        }
    }
}