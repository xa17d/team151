
public class AktorenKitLeistung10 extends AktorenKit{

	@Override
	public String vonAndroidSoftwareStufe1(SoftwareStufe1 softwareStufe1) {
		return "Ein Android mit Software 1 darf kein AktorenKit Leistung: 10KW benutzen";

	}

	@Override
	public String vonAndroidSoftwareStufe2(SoftwareStufe2 softwareStufe2) {
		return "Ein Android mit Software 2 darf kein AktorenKit Leistung: 10KW benutzen";

	}

	@Override
	public String vonAndroidSoftwareStufe3(SoftwareStufe3 softwareStufe3) {
		return "Ein Android mit Software 3 darf kein AktorenKit Leistung: 10KW benutzen";
	}

	@Override
	public String vonAndroidSoftwareStufe4(SoftwareStufe4 softwareStufe4) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String vonAndroidSoftwareStufe5(SoftwareStufe5 softwareStufe5) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "AkotrenKit Leistung: 10KW";
	}
}
