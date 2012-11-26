
public class AktorenKitLeistungUnlimitiert extends AktorenKit{
	
	@Override
	public String vonBedienerBenutzt(Bediener bediener) {
		return "Ein Bediener darf kein AktorenKit Leistung: unbegrenzt benutzen";
	}

	@Override
	public String vonSchwerarbeiterBenutzt(
			Schwerarbeiter schwerarbeiter, SoftwareStufe3 softwareStufe3){
		return "Ein Schwerarbeiter Software 3 darf kein AktorenKit Leistung: unbegrenzt benutzen";
	}

	@Override
	public String vonSchwerarbeiterBenutzt(
			Schwerarbeiter schwerarbeiter, SoftwareStufe4 softwareStufe4) {
		return "Ein Schwerarbeiter Software 4 darf kein AktorenKit Leistung: unbegrenzt benutzen";
	}
	
	@Override
	public String vonLeibwaechterBenutzt(Leibwaechter leibwaechter) {
		return "Ein Leibwaechter darf kein AktorenKit Leistung: unbegrenzt benutzen";
	}

	@Override
	public String vonObjektbewacherBenutzt(Objektbewacher objektbewacher) {
		return "Ein Objektbewacher darf kein AktorenKit Leistung:unbegrenzt benutzen";
	}

	@Override
	public String vonKaempferBenutzt(Kaempfer kaempfer) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return "AkotrenKit Leistung: unlimitiert";
	}
}
