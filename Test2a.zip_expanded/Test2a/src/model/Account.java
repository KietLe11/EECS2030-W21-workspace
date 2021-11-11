package model;

public class Account {

	private String name;
	private int monies;
	private int VIPDeposit;
	private boolean isVIP;

	private String stringIt;

	
	//Constructors
	public Account(String name, int initialMoney) {
		this.name= name;
		this.monies = initialMoney;
		this.isVIP = false;
		stringIt = String.format("A regular account owned by %s with balance $%d", name, monies);
	}
	
	public Account(Account otherAccount) {
		this.name = otherAccount.name;
		this.monies = otherAccount.monies;
		this.VIPDeposit = otherAccount.VIPDeposit;
		this.isVIP = otherAccount.isVIP;
		
		this.stringIt = otherAccount.stringIt;
	}

	//toString
	public String toString() {		
		return stringIt;
	}

	//Mutators
	public void switchToVIP(int deposit) throws InvalidStatusToSwitchException, InsufficientBalanceException {

		if(isVIP) {
			throw new InvalidStatusToSwitchException("Account Type is already VIP");
		}
		else if(deposit>monies) {
			throw new InsufficientBalanceException("Account has insufficient");
		}

		this.isVIP = true;
		VIPDeposit = deposit;
		monies -=VIPDeposit;

		stringIt = String.format("A VIP account owned by %s with balance $%d ($%d deposited for maintaining the VIP stauts)", name, monies, VIPDeposit);
	}

	public void switchToRegular() throws InvalidStatusToSwitchException{
		if(!isVIP) {
			throw new InvalidStatusToSwitchException("Account Type is already Regular");
		}

		this.isVIP = false;
		monies += VIPDeposit;
		VIPDeposit = 0;

		stringIt = String.format("A regular account owned by %s with balance $%d", name, monies);
	}
	
	public boolean equals(Object obj) {
		if(this ==obj) {return true;}
		if(obj ==null||this.getClass() != obj.getClass()) {return false;}
		
		Account other = (Account)obj;
		
		return(this.isVIP == other.isVIP 
				&& this.name == other.name
				&& this.monies == other.monies);
	}
}
