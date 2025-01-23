package application;

import model.entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe os dados da conta");
        System.out.print("Numero: ");
        int numero = sc.nextInt();
        System.out.print("Titular: ");
        sc.nextLine();
        String titular = sc.nextLine();
        System.out.print("Saldo inicial: ");
        double balance = sc.nextDouble();
        System.out.print("Limite de saque: ");
        double withdrawLimit = sc.nextDouble();

        Account acc = new Account(numero, titular, balance, withdrawLimit);

        System.out.println();
        System.out.print("Infome a quantia para sacar: ");
        double amount = sc.nextDouble();

        String erro = acc.validateWithdraw(amount);
        if (erro != null) {
            System.out.println(erro);
        }
        else {
            acc.withdraw(amount);
            System.out.printf("Novo Saldo: %.2f", acc.getBalance());
        }

        sc.close();
    }
}
