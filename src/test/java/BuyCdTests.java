import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BuyCdTests {

	@Test
	public void cdAddedToCustomerCollectionWhenCdBought() throws OutOfStockException {

		Customer customer = new Customer("12345");
		Cd cd = new Cd(2, new CdDescription("David Bowie", "Hunky Dory"));
		CreditCard card = new CreditCard(1234567890, "10/25", "890");
		Payment payment = new Payment(true);
		cd.buy(customer, card, payment);
		assertTrue(customer.has(cd));
	}

	@Test
	public void stockReducedWhenCdIsBought() throws OutOfStockException {
		Customer customer = new Customer("12345");
		Cd cd = new Cd(2, new CdDescription("David Bowie", "Hunky Dory"));
		CreditCard card = new CreditCard(1234567890, "10/25", "890");
		Payment payment = new Payment(true);
		cd.buy(customer, card, payment);
		assertEquals(1, cd.getStock());
	}

	@Test
	public void stockNotReducedWhenPaymentRejected() throws OutOfStockException {
		Customer customer = new Customer("12345");
		Cd cd = new Cd(2, new CdDescription("David Bowie", "Hunky Dory"));
		CreditCard card = new CreditCard(1234567890, "10/25", "890");
		Payment payment = new Payment(false);
		cd.buy(customer, card, payment);
		assertEquals(2, cd.getStock());
	}

	@Test
	public void exceptionThrownWhenOutOfStock() {
		Customer customer = new Customer("12345");
		Cd cd = new Cd(0, new CdDescription("David Bowie", "Hunky Dory"));
		CreditCard card = new CreditCard(1234567890, "10/25", "890");
		Payment payment = new Payment(true);
		assertThrows(OutOfStockException.class,
			() -> cd.buy(customer, card, payment)
		);
	}
}
