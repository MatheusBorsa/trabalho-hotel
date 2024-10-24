import classes.Hotel;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSistema de Gerenciamento de Hotel");
            System.out.println("1. Cadastrar Quarto");
            System.out.println("2. Cadastrar Reserva");
            System.out.println("3. Realizar Check-in");
            System.out.println("4. Realizar Check-out");
            System.out.println("5. Gerar Relatório de Ocupação");
            System.out.println("6. Gerar Histórico de Reservas");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Numero do quarto: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Tipo de quarto (casal, solteiro, suite): ");
                    String tipo = scanner.nextLine();

                    System.out.print("Valor da diaria: ");
                    BigDecimal diaria = scanner.nextBigDecimal();
                    scanner.nextLine();

                    hotel.cadastrarQuarto(numero, tipo, diaria);
                    break;
                case 2:
                    System.out.print("Nome do hospede: ");
                    String nomeHospede = scanner.nextLine();

                    System.out.print("Tipo de quarto (solteiro, casal, suite): ");
                    String tipoQuarto = scanner.nextLine();

                    System.out.print("Data de check-in (dd/mm/aaaa): ");
                    String dataCheckIn = scanner.nextLine();

                    System.out.print("Data de check-out (dd/mm/aaaa): ");
                    String dataCheckOut = scanner.nextLine();

                    System.out.print("Número de quartos: ");
                    int numeroQuartos = scanner.nextInt();
                    scanner.nextLine();

                    hotel.cadastrarReserva(nomeHospede, tipoQuarto, dataCheckIn, dataCheckOut, numeroQuartos);
                    break;
                case 3:
                    System.out.print("Nome do hospede para check-in: ");
                    String nomeCheckIn = scanner.nextLine();
                    hotel.checkIn(nomeCheckIn);
                    break;
                case 4:
                    System.out.print("Nome do hospede para check-out: ");
                    String nomeCheckOut = scanner.nextLine();
                    hotel.checkOut(nomeCheckOut);
                    break;
                case 5:
                    hotel.gerarRelatorioOcupacao();
                    break;
                case 6:
                    System.out.print("Nome do hospede para historico de reservas: ");
                    String nomeHistorico = scanner.nextLine();
                    hotel.gerarHistoricoReservas(nomeHistorico);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    System.exit(0);

                default:
                    System.out.println("Opcao invalida \n Tente novamente:");
            }
        }
    }
}
