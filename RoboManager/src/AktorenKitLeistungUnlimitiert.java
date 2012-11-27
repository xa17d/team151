
public class AktorenKitLeistungUnlimitiert extends AktorenKit{
	
	@Override
	public String vonBedienerBenutzt(Bediener bediener, SoftwareStufe softwareStufe) {
		return softwareStufe.vonBedienerVerwendet(bediener, this);
	}
	
	@Override
	public String vonGesellschafterBenutzt(Gesellschafter gesellschafter,
			SoftwareStufe softwareStufe) {
		return softwareStufe.vonGesellschafterVerwendet(gesellschafter, this);
	}
	
	@Override
	public String vonSchwerarbeiterBenutzt(
			Schwerarbeiter schwerarbeiter, SoftwareStufe softwareStufe) {
		return softwareStufe.vonSchwerarbeiterVerwendet(schwerarbeiter, this);
	}
	
	@Override
	public String vonBeschuetzerBenutzt(Beschuetzer beschuetzer, SoftwareStufe softwareStufe) {
		return softwareStufe.vonBeschuetzerVerwendet(beschuetzer, this);
	}

	@Override
	public String vonKaempferBenutzt(Kaempfer kaempfer, SoftwareStufe softwareStufe) {
		return softwareStufe.vonKaempferVerwendet(kaempfer,this);
	}
	
	@Override
	public String toString() {
		return "AkotrenKit Leistung: unlimitiert";
	}
}
