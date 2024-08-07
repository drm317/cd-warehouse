import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class SearchForCdTests {

	@Test
	public void cdFoundInCatalogue() {
		CdDescription cdDescription = new CdDescription(
			"David Bowie", "Hunky Dory");
		Cd cd = new Cd(1, cdDescription);
		Catalogue catalogue = new Catalogue(List.of(cd));

		assertEquals(cd, catalogue.find(cdDescription));
	}
}
