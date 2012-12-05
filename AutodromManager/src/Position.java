/**
 * Stellt Position und Richtung eines Autos dar
 * @author Daniel
 */
public class Position {
	/**
	 * Erzeugt ein neues Objekt
	 * @param richtung Richtung in Grad (Werte von 0 bis 359)
	 * @param x X-Position
	 * @param y Y-Position
	 */
	public Position(int richtung, int x, int y) {
		this.richtung = (richtung + 360) % 360;
		this.x = x;
		this.y = y;
	}
	
	private int richtung; // Richtung in Grad (hat immer einen Wert von 0 bis 359)
	private int x;        // X-Position
	private int y;        // Y-Position
	
	/**
	 * Gibt die Richtung in Grad zurueck
	 * @return Richtung in Grad
	 */
	public int getRichtung() { return richtung; }
	
	/**
	 * Gibt die X-Position zurueck
	 * @return X-Position
	 */
	
	public int getX() { return x; }
	
	/**
	 * Gibt die Y-Position zurueck
	 * @return Y-Position
	 */
	public int getY() { return y; }
	
	/**
	 * Erzeugt ein neues Position-Objekt das sich um einen Schritt in eine
	 * bestimmte Richtung, relativ zu diesem Objekt bewegt hat.
	 * @param relativeRichtung relative Richtungsaenderung zur Richtung dieses Objekts
	 * @return das neue Position-Objekt
	 */
	private Position bewegen(int relativeRichtung) {
		
		int r = (richtung + relativeRichtung + 360) % 360;
		
		int dy = -(int)Math.round(Math.sin(r * Math.PI / 180));
		int dx = (int)Math.round(Math.cos(r * Math.PI / 180));
		
		return new Position(r, x + dx, y + dy);
	}
	
	/**
	 * @return neue Position mit einem Schritt in die Richtung dieses Objekts
	 */
	public Position vorwaerts() {
		return bewegen(0);
	}

	/**
	 * @return neue Position mit Richtungsaenderung um 45Grad und einen Schritt in diese Richtung
	 */
	public Position halbLinks() {
		return bewegen(45);
	}

	/**
	 * @return neue Position mit Richtungsaenderung um -45Grad und einen Schritt in diese Richtung
	 */
	public Position halbRechts() {
		return bewegen(-45);
	}

	/**
	 * @return neue Position mit Richtungsaenderung um 90Grad und einen Schritt in diese Richtung
	 */
	public Position links() {
		return bewegen(90);
	}

	/**
	 * @return neue Position mit Richtungsaenderung um -90Grad und einen Schritt in diese Richtung
	 */
	public Position rechts() {
		return bewegen(-90);
	}
	
	@Override
	public String toString() {
		return "("+richtung+"Grad; "+x+"; "+y+")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		if (obj.getClass().equals(getClass()))
		{
			Position o = (Position)obj;
			return ((richtung == o.richtung)&&(x == o.x)&&(y == o.y));
		}
		else { return false; }
	}
}
