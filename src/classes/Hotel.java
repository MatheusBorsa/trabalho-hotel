package classes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    public List<Quarto> quartos = new ArrayList<>();
    public List<Reserva> reservas = new ArrayList<>();

    public void cadastrarQuarto(int numero, String tipo, BigDecimal valorDiaria){
        Quarto quarto = new Quarto();
        quarto.numero = numero;
        quarto.tipo = tipo;
        quarto.valorDiaria = valorDiaria;
        quarto.disponivel = true;
        quartos.add(quarto);
        System.out.println("Quarto "  + numero + " cadastrado com sucesso!");
    }

    public void cadastrarReserva(String nomeHospede, String tipoQuarto, String dataCheckIn, String dataCheckOut, int numeroQuartos) {
        int quartosDisponiveis = 0;

        for (Quarto quarto : quartos) {
            if (quarto.tipo.equals(tipoQuarto) && quarto.disponivel) {
                quartosDisponiveis++;
            }
        }

        if (quartosDisponiveis >= numeroQuartos) {
            Reserva reserva = new Reserva();
            reserva.nomeHospede = nomeHospede;
            reserva.tipo = tipoQuarto;
            reserva.checkIn = dataCheckIn;
            reserva.checkOut = dataCheckOut;
            reserva.numeroQuartos = numeroQuartos;
            reservas.add(reserva);
            System.out.println("Reserva cadastrada com sucesso para " + nomeHospede);
        } else {
            System.out.println("Erro: Nao tem quartos disponiveis suficientes para o tipo " + tipoQuarto + ". Quartos disponiveis: " + quartosDisponiveis);
        }
    }


    public void checkIn(String nomeHospede){
        boolean reservaEncontrada = false;
        for (Reserva reserva : reservas){
            if (reserva.nomeHospede.equals(nomeHospede)){
                reservaEncontrada = true;
                for (Quarto quarto: quartos){
                    if (quarto.tipo.equals(reserva.tipo) && quarto.disponivel){
                        quarto.disponivel = false;
                        System.out.println("Check-in realizado para " + nomeHospede + " no quarto " + quarto.numero);
                        return;
                    }
                }
                System.out.println("Nenhum quarto disponivel para o tipo reservado.");
                return;
            }
        }
        if (!reservaEncontrada) {
            System.out.println("Reserva nao encontrada para o hospede " + nomeHospede);
        }
    }


    public void checkOut(String nomeHospede){
        for (Reserva reserva : reservas){
            if (reserva.nomeHospede.equals(nomeHospede)){
                for (Quarto quarto : quartos){
                    if (quarto.tipo.equals(reserva.tipo) && !quarto.disponivel){
                        quarto.disponivel = true;
                        System.out.println("Check-out realizado para " + nomeHospede + "no quarto " + quarto.numero);
                    }
                }
            }
        }
    }

    public void gerarRelatorioOcupacao() {
        System.out.println("Relatorio de Ocupacao:");
        for (Quarto quarto : quartos) {
            String status = quarto.disponivel ? "Disponivel" : "Ocupado";
            System.out.println("Quarto " + quarto.numero + " (" + quarto.tipo + "): " + status);
        }
    }

    public void gerarHistoricoReservas(String nomeHospede) {
        System.out.println("Historico de Reservas para " + nomeHospede + ":");
        for (Reserva reserva : reservas) {
            if (reserva.nomeHospede.equals(nomeHospede)) {
                System.out.println("Reserva: " + reserva.numeroQuartos + " quarto(s) tipo " + reserva.tipo +
                        " de " + reserva.checkIn + " ate " + reserva.checkOut);
            }
        }
    }

}
