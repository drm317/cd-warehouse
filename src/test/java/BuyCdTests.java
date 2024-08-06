import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BuyCdTests {

	@Test
	public void cdAddedToCustomerCollectionWhenCdBought() {

		Customer customer = new Customer("12345");
		Cd cd = new Cd(2, new CdDescription("", ""));
		CreditCard card = new CreditCard(1234567890, "10/25", "890");
		cd.buy(customer, card);
		assertTrue(customer.has(cd));
	}

	@Test
	public void stockReducedWhenCdIsBought() {
		Customer customer = new Customer("12345");
		Cd cd = new Cd(2, new CdDescription("", ""));
		CreditCard card = new CreditCard(1234567890, "10/25", "890");
		cd.buy(customer, card);
		assertEquals(1, cd.getStock());
	}
}
