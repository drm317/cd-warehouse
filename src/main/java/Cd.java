public class Cd {

	private int stock;
	private final CdDescription cdDescription;

	public Cd(int stock, CdDescription cdDescription) {
		this.stock = stock;
		this.cdDescription = cdDescription;
	}

	public void buy(Customer customer, CreditCard card, Payment payment) throws OutOfStockException {
		boolean paymentAccepted = payment.isAccepted();
		if (paymentAccepted) {
			if (stock == 0)
				throw new OutOfStockException();
			this.stock = stock - 1;
			customer.addToCollection(this);
		}
	}

	public int getStock() {
		return stock;
	}

	public CdDescription getCdDescription() {
		return cdDescription;
	}
}
