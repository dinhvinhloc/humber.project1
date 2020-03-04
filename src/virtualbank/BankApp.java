package virtualbank;

import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) {

		String[] lastName = { "Lira", "Clinton", "Daniel", "Fanning", "Stone", "Potter", "Lawrence", "Walker", "Ronald",
				"Matthew" };
		String[] firstName = { "James", "Mary", "John", "Robert", "Jennifer", "Gonzalez", "Karen", "Anthony", "Ashley",
				"Buckley" };

		Scanner input = new Scanner(System.in);
		input.useDelimiter("\n");
		Bank myBank = new Bank();
		myBank.setBankName("Nova Scotia Bank - Wilson Avenue Branch ");
		myBank.setBankNumber(100);

		// Create 10 first random accounts

		for (int i = 0; i < 10; i++) {
			String randomAccountType;
			int randomFirstName = (int) (Math.random() * 10);
			int randomLastName = (int) (Math.random() * 10);
			String randomName = firstName[randomFirstName] + " " + lastName[randomLastName];

			if (Math.round(Math.random()) == 0)
				randomAccountType = "Checking";
			else
				randomAccountType = "Saving";

			int randomBalance = (int) (Math.random() * 1000);
			myBank.openNewAccount(randomName, randomAccountType, randomBalance);

		}

		int choice = 2;

		do {

			System.out.println("--------------------------------------------");
			System.out.println(myBank.getBankName() + myBank.getBankNumber());
			System.out.println("--------------------------------------------");
			System.out.println("1) Open a new bank account");
			System.out.println("2) Deposit to a bank account");
			System.out.println("3) Withdraw from bank account");
			System.out.println("4) Print account balance");
			System.out.println("5) Transfer money");
			System.out.println("6) Print all acounts");
			System.out.println("7) Quit");
			System.out.println("--------------------------------------------");
			System.out.print("Enter choice [1-7]: ");
			choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter a customer name");
				String name = input.next();
				System.out.println("Enter account Type");
				String type = input.next();
				System.out.println("Enter a opening balance");
				double cash = input.nextDouble();
				System.out.println("Account was created and it has the following number: "
						+ myBank.openNewAccount(name, type, cash));
				break;
			case 2:
				System.out.println("Enter a account number");
				int accNum = input.nextInt();
				System.out.println("Enter a deposit amount");
				double cash1 = input.nextDouble();
				myBank.depositTo(accNum, cash1);
				break;
			case 3:
				System.out.println("Enter a account number");
				int accNum1 = input.nextInt();
				System.out.println("Enter a withdraw amount");
				double cash2 = input.nextDouble();
				myBank.withdrawFrom(accNum1, cash2);
				break;
			case 4:
				System.out.println("Enter a account number");
				int anum = input.nextInt();
				myBank.printAccountInfo(anum);
				break;
			case 5:
				System.out.println("Enter account number to transfer From: ");
				int aNum1 = input.nextInt();
				System.out.println("Enter account number to transder To: ");
				int aNum2 = input.nextInt();
				System.out.println("Enter amount to transfer");
				double cash3 = input.nextDouble();
				myBank.transferTo(aNum1, aNum2, cash3);
				break;
			case 6:
				myBank.printAllAccount();
				break;
			case 7:
				System.exit(0);
			}
		} while (choice != '7');
		input.close();
	}

}