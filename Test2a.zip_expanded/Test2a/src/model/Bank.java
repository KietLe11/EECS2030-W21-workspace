package model;

public class Bank {

	private Account[] accounts = new Account[5];
	private int noa;
	
	public Bank() {}
	
	public Bank(Bank b) {
		this.accounts = b.getReferencesOfAccounts();
		this.noa = b.noa;
	}
	
	//Accessors
	public int getNumberOfAccounts() {
		return noa;
	}
	
	public Account[] getReferencesOfAccounts() {
		Account[] returningAccount = new Account[noa];
		for(int i =0; i<noa; i++){
			returningAccount[i] = accounts[i];
		}
		return returningAccount;
	}
	
	public Account[] getCopiesOfAccounts() {
		Account[] returningAccount = new Account[noa];
		for(int i =0; i<noa;i++) {
			returningAccount[i] = new Account(accounts[i]);
		}
		return returningAccount;
	}
	
	//Mutators
	public void addAccount(Account a) {
		accounts[noa] = a;
		noa++;
	}
	
	public void addAccounts(Account[] a) {
		for(int i =0; i<a.length; i++) {
			this.addAccount(a[i]);
		}
	}
	
	public boolean equals(Object obj) {
		if(this ==obj) {return true;}
		if(obj ==null||this.getClass() != obj.getClass()) {return false;}
		
		Bank other = (Bank)obj;
		if(this.getReferencesOfAccounts().length == other.getReferencesOfAccounts().length) {
			for(int i = 0; i<this.getReferencesOfAccounts().length; i++) {
				boolean bruh = this.getReferencesOfAccounts()[i] == other.getReferencesOfAccounts()[i];
				if(!bruh) {
					return false;
				}
			}
		}
		else {
			return false;
		}
		return(this.noa == other.noa);
	}
}
