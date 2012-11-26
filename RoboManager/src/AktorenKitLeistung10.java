
public class AktorenKitLeistung10 extends AktorenKit{

	@Override
	public String toString() {
		return "AkotrenKit Leistung: 10KW";
	}

	@Override
	public String vonBedienerBenutzt(Bediener bediener) {
		return "Ein Bediener darf kein AktorenKit Leistung: > 10KW benutzen";
	}

	@Override
	public String vonSchwerarbeiterBenutzt(
			Schwerarbeiter schwerarbeiter, SoftwareStufe3 softwareStufe3) {
		return "Ein Schwerarbeiter mit Software Stufe 3 darf kein AktorenKit Leistung: > 10KW benutzen";
	}

	@Override
	public String vonSchwerarbeiterBenutzt(
			Schwerarbeiter schwerarbeiter, SoftwareStufe4 softwareStufe4) {
		return null;
	}
	
	@Override
	public String vonLeibwaechterBenutzt(Leibwaechter leibwaechter) {
		return null;
	}

	@Override
	public String vonObjektbewacherBenutzt(Objektbewacher objektbewacher) {
		return null;
	}

	@Override
	public String vonKaempferBenutzt(Kaempfer kaempfer) {
		return null;
	}
}
