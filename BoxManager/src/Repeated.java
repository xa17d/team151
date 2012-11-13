/**
 * Enthaelt Elemente eines rechteckigen Arrays.
 * Mit toString werden diese Elemente als String nebeneinander und uebereinander liegend zurueckgegeben.
 * Ist der durch (wiederholte) Aufrufe von scale gesetzte Skalierungsfaktor kleiner 1.0, so liefert
 * toString nur die entsprechend grosse linke obere Ecke. Ist der Skalierungsfaktor groesser als 1.0,
 * so wird der Text entsprechend oft neben- bzw. uebereinander wiederholt. 
 * @author daniel
 *
 */
public class Repeated<P> implements Pict {
	
	/**
	 * Konstruktor
	 * @param content rechteckiges Array. Array-Elemente die null sind, sind nicht erlaubt. Erster Index gibt die Zeile, der zweite die Spalte an (content[zeile][spalte])
	 */
	public Repeated(P[][] content)
	{
		this.content = content;
	}
	
	/**
	 * rechteckiges Array. jedes Element != null.
	 * Erster Index gibt die Zeile, der zweite die Spalte an (content[zeile][spalte])
	 */
	private P[][] content;
	
	/**
	 * Speichert den momentanen Skalierungsfaktor dieser Instanz 
	 */
	private double scaleFactor = 1;
	
	/**
	 * resize the picture
	 * @param factor 0.1 <= factor <= 10.0
	 */
	public void scale(double factor) {
		scaleFactor *= factor;
	}
	
	/**
	 * Elemente des rechteckigen Arrays werden als String nebeneinander und uebereinander liegend zurueckgegeben.
	 * Haben die Elemente unterschiedliche Hoehe bzw. Breite, werden die kleineren Elemente unterhalb bzw. rechts
     * mit Leerzeichen aufgefuellt.
     * Ist der durch (wiederholte) Aufrufe von scale gesetzte Skalierungsfaktor kleiner 1.0, so liefert toString
     * nur die entsprechend grosse linke obere Ecke. Ist der Skalierungsfaktor groesser als 1.0, so wird der Text
     * entsprechend oft neben- bzw. uebereinander wiederholt.
	 */
	@Override
	public String toString() {
		int[] columnWidth; // Zeichenbreite jeder Element-Spalte
		int[] rowHeight;   // Zeichenzeilen jeder Element-Zeile 
		
		// Array mit allen Elementen als String (toString)
		// Index1: Element-Zeile
		// Index2: Element-Spalte
		// Index3: Zeile im toString-Text des Elements
		String[][][] contentText;
		
		int rows = content.length; // Anzahl Element-Zeilen
		
		// Anzahl Element-Spalten
		int columns = 0;
		if (rows > 0) { columns = content[0].length; }
		
		// Array Initialisierungen
		contentText = new String[rows][columns][];
		columnWidth = new int[columns];
		rowHeight = new int[rows];
		
		///
		/// Groesse bestimmen
		///
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < columns; x++) {
				
				String cell = content[y][x].toString();  // Element toString
				String[] cellLines = cell.split("\n");   // Array mit String fuer jede Zeile
				int lines = cellLines.length;
				contentText[y][x] = new String[lines];   // Textzeilen-Array in contentText-Array speichern 
				
				rowHeight[y] = Math.max(lines, rowHeight[y]); // Zeilenhoehe vergroessern falls erforderlich
				
				// Spaltenbreite vergroessern falls erforderlich (die Laenge jeder Zeile wird ueberprueft)
				for (int i = 0; i < cellLines.length; i++) {
					String line = cellLines[i];
					contentText[y][x][i] = line;
					columnWidth[x] = Math.max(line.length(), columnWidth[x]);
				}
			}
		}
		
		///
		/// Gesamtgroesse berechnen
		///
		int totalHeight = 0; // Gesamthoehe in Zeichen
		int totalWidth = 0;  // Gesamtbreite in Zeichen
		for (int i = 0; i < rowHeight.length; i++) {
			totalHeight += rowHeight[i];
		}
		
		for (int i = 0; i < columnWidth.length; i++) {
			totalWidth += columnWidth[i];
		}
		
		// die Hoehe fuer die Ausgabe berechnen (mittels Skalierungsfaktor)
		int outputHeight = (int)Math.ceil(totalHeight * scaleFactor);
		int outputWidth = (int)Math.ceil(totalWidth * scaleFactor);
		
		///
		/// Ausgabe
		///
		StringBuilder out = new StringBuilder();
		int y = 0;  // aktuelle Element-Zeile
		int r = -1; // aktuelle Text-Zeile im Element [x][y]
		for (int cy = 0; cy < outputHeight; cy++) {
			
			r++;
			if (r >= rowHeight[y]) { // wenn Text-Zeile die Element-Zeilen-Hoehe uebersteigt -> naechste Zeile
				r = 0;
				y = (y+1) % rows; // falls Zeilen-Anzahl ueberschritten wird -> wieder bei erster anfangen
			}
			
			int x = 0;  // aktuelle Element-Spalte
			int c = -1; // aktuelles Zeichen im Element [x][y] in der Zeile [r]
			
			for (int cx = 0; cx < outputWidth; cx++) {
				
				c++;
				if (c >= columnWidth[x]) { // wenn Zeichen die Spaltenbreite uebersteigt -> naechste Spalte
					c = 0;
					x = (x+1) % columns; // falls Spalten-Anzahl ueberschritten wird -> wieder bei erster anfangen
				}
				
				if ((contentText[y][x].length > r)&&(contentText[y][x][r].length() > c)) // Pruefen ob Zeilenanzahl im Text und Zeichen-Index ueberschritten wird.
				{ out.append(contentText[y][x][r].charAt(c)); } // Zeichen zum Output hinzufuegen
				else
				{ out.append(' '); } // Diemensionen des Texts wurde ueberschritten -> Leerzeichen einfuegen
			}
			
			out.append("\n"); // Zeilenumbruch
		}
		
		return out.toString();
	}
}
