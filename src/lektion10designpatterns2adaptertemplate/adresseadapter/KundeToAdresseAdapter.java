
package lektion10designpatterns2adaptertemplate.adresseadapter;

public class KundeToAdresseAdapter implements Adresse {
	private Kunde kunde;

	public KundeToAdresseAdapter(Kunde kunde) {
		this.kunde = kunde;
	}
	public String getVejOgHusNr() {
		return kunde.getGadeNavn() + " " + kunde.getHusNr();
	}
	public String getPostNrOgByNavn() {
		return kunde.getPostNr() + " " + kunde.getByNavn();
	}
	public String getLandeKode() {
		return "DK";
	}
}
