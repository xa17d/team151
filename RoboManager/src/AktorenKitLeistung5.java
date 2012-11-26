
public class AktorenKitLeistung5 extends AktorenKit{

	@Override
	public String vonBedienerBenutzt(Bediener bediener) {
		return "Ein Bediener darf kein AktorenKit Leistung: > 5KW benutzen";
	}

	@Override
	public String vonSchwerarbeiterBenutzt(
			Schwerarbeiter schwerarbeiter, SoftwareStufe3 softwareStufe3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String vonSchwerarbeiterBenutzt(
			Schwerarbeiter schwerarbeiter, SoftwareStufe4 softwareStufe4) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String vonLeibwaechterBenutzt(Leibwaechter leibwaechter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String vonObjektbewacherBenutzt(Objektbewacher objektbewacher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String vonKaempferBenutzt(Kaempfer kaempfer) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return "AkotrenKit Leistung: 5KW";
	}
}
