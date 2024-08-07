import java.util.List;

public class Catalogue {

	private final List<Cd> cdCatalogue;

	public Catalogue(List<Cd> list) {
		this.cdCatalogue = list;
	}

	public Cd find(CdDescription cdDescription) {
		return cdCatalogue.stream().filter(
				cd ->
					cd.getCdDescription().getArtist()
						.equals(cdDescription.getArtist()) &&
						cd.getCdDescription().getTitle()
							.equals(cdDescription.getTitle()))
			.findFirst().orElse(null);
	}
}
