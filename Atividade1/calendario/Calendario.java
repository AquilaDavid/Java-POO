package calendario;

import java.util.Scanner;

public class Calendario {
    int dia, mes, ano;

    public Calendario(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String nomeMes(int m) {
        String nomeMes;
        switch (m) {
            case 1:
                nomeMes = "Janeiro";
                break;
            case 2:
                nomeMes = "Fevereiro";
                break;
            case 3:
                nomeMes = "Março";
                break;
            case 4:
                nomeMes = "Abril";
                break;
            case 5:
                nomeMes = "Maio";
                break;
            case 6:
                nomeMes = "Junho";
                break;
            case 7:
                nomeMes = "Julho";
                break;
            case 8:
                nomeMes = "Agosto";
                break;
            case 9:
                nomeMes = "Setembro";
                break;
            case 10:
                nomeMes = "Outubro";
                break;
            case 11:
                nomeMes = "Novembro";
                break;
            case 12:
                nomeMes = "Dezembro";
                break;
            default:
                nomeMes = "Mês inválido";
                break;
        }
        return nomeMes;
    }

    public void mostrarData() {
        System.out.printf("%d/%s/%d\n", dia, nomeMes(mes), ano);
    }

    public void anoBissexto() {
        if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
            System.out.println(ano + " é um ano bissexto.");
        } else {
            System.out.println(ano + " não é um ano bissexto.");
        }
    }

    public void respostaFinal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o dia: ");
        this.dia = scanner.nextInt();
        System.out.print("Informe o mês em número (exemplo: 1 -> Janeiro): ");
        this.mes = scanner.nextInt();
        System.out.print("Informe o ano: ");
        this.ano = scanner.nextInt();

        mostrarData();
        anoBissexto();
        scanner.close();
    }
}
