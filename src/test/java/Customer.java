import java.util.ArrayList;
import java.util.List;

public class Customer {

	private final String customerNumber;

	private final List<Cd> cdCollection;

	public Customer(String customerNumber) {
		this.customerNumber = customerNumber;
		this.cdCollection = new ArrayList();
	}

	public boolean has(Cd cd) {
		return cdCollection.contains(cd);
	}

	public void addToCollection(Cd cd) {
		this.cdCollection.add(cd);
	}
}
