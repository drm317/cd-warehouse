public class Cd {

	private int stock;
	private CdDescription cdDescription;

	public Cd(int stock, CdDescription cdDescription) {
		this.stock = stock;
		this.cdDescription = cdDescription;
	}

	public void buy(Customer customer, CreditCard card) {
		boolean paymentAccepted = true;
		if (paymentAccepted) {
			this.stock = stock - 1;
			customer.addToCollection(this);
		}
	}

	public int getStock() {
		return stock;
	}
}
