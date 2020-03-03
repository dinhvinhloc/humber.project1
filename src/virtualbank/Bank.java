package virtualbank;

public class Bank {
	private BankAccount[] accounts;
	private String bankName;
	private int bankNumber;
	private int index;

	public Bank() {
		accounts = new BankAccount[20];
		index = 0;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(int bankNumber) {
		this.bankNumber = bankNumber;
	}

	public int openNewAccount(String custName, String accType, double openingBalance) {

		BankAccount b = new BankAccount(custName, accType, openingBalance);
		accounts[index] = b;
		index++;
		return b.getAccountNum();
	}

	public void withdrawFrom(int accountNum, double amount) {
		for (int i = 0; i < index; i++) {
			if (accountNum == accounts[i].getAccountNum()) {
				accounts[i].withdraw(amount);
				return;
			}
		}
		System.out.println("Account number not found.");
	}

	public void transferTo(int accountNum1, int accountNum2, double amount) {
		for (int i = 0; i < index; i++) {
			if (accountNum1 == accounts[i].getAccountNum()) {
				accounts[i].withdraw(amount);
			}
		}

		for (int i = 0; i < index; i++) {
			if (accountNum2 == accounts[i].getAccountNum()) {
				accounts[i].deposit(amount);
			}
		}
		return;
	}

	public void depositTo(int accountNum, double amount) {
		for (int i = 0; i < index; i++) {
			if (accountNum == accounts[i].getAccountNum()) {
				accounts[i].deposit(amount);
				return;
			}
		}
		System.out.println("Account number not found.");
	}

	public void printAccountInfo(int accountNum) {
		for (int i = 0; i < index; i++) {
			if (accountNum == accounts[i].getAccountNum()) {
				System.out.println(accounts[i].getAccountInfo());
				return;
			}
		}
		System.out.println("Account number not found.");
	}

	public void printAllAccount() {
		for (int i = 0; i < index; i++) {
			System.out.println(accounts[i].getAccountInfo());

		}
		return;
	}

}
