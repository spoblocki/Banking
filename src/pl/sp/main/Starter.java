package pl.sp.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pl.sp.exceptions.InsufficientBalanceException;
import pl.sp.exceptions.NegativeNumberException;
import pl.sp.model.Account;
import pl.sp.model.Client;

public class Starter {
	static List<Client> clients = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		clients.add(new Client("James", "Bond", "Great Britain", "1"));
		clients.add(new Client("Henryk", "Sienkiewicz", "Poland", "2"));
		clients.add(new Client("Marcel", "Gempel", "France", "3"));
		clients.add(new Client("Albert", "Einstein", "Switzerland", "4"));

		int menu = 0;
		do {

			System.out.println("1 - Pay in");
			System.out.println("2 - Withdrawal");
			System.out.println("3 - List");
			System.out.println("4 - Account balance");
			System.out.println("5 - Transfer");
			System.out.println("0 - Exit\n");

			menu = scanner.nextInt();

			switch (menu) {
			case 1:
				payin();
				break;
			case 2:
				withdrawal();
				break;
			case 3:
				list();
				break;

			case 4:
				accountBalance();
				break;

			case 5:
				transfer();
				break;
			}

		}

		while (menu != 0);

	}

	private static void payin() {
		System.out.println("Type account number: ");
		String number = scanner.next();
		double amount;
		Client accountNumber = findClientbyAccountNumber(number);
		if (accountNumber != null) {
			System.out.println("Type amount: ");
			amount = scanner.nextDouble();
			try {
				payin(accountNumber, amount);
			} catch (NegativeNumberException e) {
	
			}

		}
	}

	private static void withdrawal() {
		System.out.println("Type account number: ");
		String number = scanner.next();
		double amount;
		Client accountNumber = findClientbyAccountNumber(number);
		if (accountNumber != null) {
			System.out.println("Type amount: ");
			amount = scanner.nextDouble();
			try {
				withdrawal(accountNumber, amount);
			} catch (InsufficientBalanceException e ) {

			}
		}
	}

	private static void list() {

		for (Client client : clients) {
			System.out.println(client);
		}
	}

	private static Client findClientbyAccountNumber(String number) {

		for (Client client : clients) {
			if (number.equals(client.getAccountNumber())) {
				return client;

			}
		}
		return null;
	}

	private static Client findClientbyName(String surname) {

		for (Client client : clients) {
			if (surname.equals(client.getSurname())) {
				return client;

			}
		}
		return null;
	}

	static void payin(Client accountNumber, double amount)
			throws NegativeNumberException {

		if (amount < 0) {
			throw new NegativeNumberException();
		} else {

			double balance = accountNumber.getBalance();
			accountNumber.setBalance(balance + amount);
			System.out.println("Money paid into account");
		}
	}

	static void withdrawal(Client accountNumber, double amount)
			throws InsufficientBalanceException {

		double balance = accountNumber.getBalance();

		if (balance < amount) {
			throw new InsufficientBalanceException();
		} else {
			accountNumber.setBalance(balance - amount);
			System.out.println("Money withdrawed from the account");
		}
	}

	static double accountBalance() {
		System.out.println("Type surname: ");
		String surname = scanner.next();
		Client surname2 = findClientbyName(surname);

		if (surname2 != null) {

			System.out.println(surname2.getBalance());
		}
		return 0;

	}

	static void transfer() {

		System.out.println("Type source account: ");
		String number_src = scanner.next();

		System.out.println("Type destination account: ");
		String number_dst = scanner.next();

		Client accountNumber_src = findClientbyAccountNumber(number_src);
		Client accountNumber_dst = findClientbyAccountNumber(number_dst);

		if (accountNumber_src != null && accountNumber_dst != null) {
			System.out.println("Type amount: ");
			double amount = scanner.nextDouble();
			try {
				withdrawal(accountNumber_src, amount);
			} catch (InsufficientBalanceException e) {

			}
			try {
				payin(accountNumber_dst, amount);
			} catch (NegativeNumberException e) {

			
			}

		}

	}

}
