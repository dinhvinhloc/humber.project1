package virtualbank;

public class BankAccount {
	private int accountNum;
	private String customerName;
	private String accountType;
	private double accountBalance;
	private static int accountIndex = 0;

	public String getAccountInfo() {
		return "Account number: " + accountNum + "\nCustomer Name: " + customerName + "\nAccount Type: " + accountType
				+ "\nBalance: " +"$" +String.format("%.2f", accountBalance) + "\n";
	}

	public BankAccount(String name, String type, double balance) {
		customerName = name;
		accountType = type;
		accountBalance = balance;
		accountIndex++;
		accountNum = 100000 + accountIndex;
	}

	public int getAccountNum() {
		return accountNum;
	}

	public void deposit(double amount) {

		if (amount <= 0) {
			System.out.println("Amount to be deposited should be positive");
		} else {
			accountBalance = accountBalance + amount;
			System.out.println("Amount deposited successfully");
		}
	}

	public void withdraw(double amount) {
		if (amount <= 0) {
			System.out.println("Amount to be withdrawn should be positive");
		} else {
			if (accountBalance < amount) {
				System.out.println("Insufficient balance");
			} else {
				accountBalance = accountBalance - amount;
				System.out.println("Amount withdrawn successfully");

			}
		}
	}

}
