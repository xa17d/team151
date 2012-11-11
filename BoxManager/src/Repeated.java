/**
 * 
 * @author daniel
 *
 */
public class Repeated<P> implements Pict {
	public Repeated(P[][] content)
	{
		this.content = content;
	}
	
	private P[][] content;
	private double scaleFactor = 1;
	
	public void scale(double factor) {
		scaleFactor *= factor;
	}
	
	@Override
	public String toString() {
		int[] columnWidth;
		int[] rowHeight;
		String[][][] contentText;
		
		int rows = content.length;
		int columns = 0;
		if (rows > 0) { columns = content[0].length; }
		
		contentText = new String[rows][columns][];
		columnWidth = new int[columns];
		rowHeight = new int[rows];
		
		// Groesse bestimmen
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < columns; x++) {
				
				String cell = content[y][x].toString();
				String[] cellLines = cell.split("\n");
				int lines = cellLines.length;
				contentText[y][x] = new String[lines];
				
				rowHeight[y] = Math.max(lines, rowHeight[y]);
				
				for (int i = 0; i < cellLines.length; i++) {
					String line = cellLines[i];
					contentText[y][x][i] = line;
					columnWidth[x] = Math.max(line.length(), columnWidth[x]);
				}
			}
		}
		
		// Gesamtgroesse berechnen
		int totalHeight = 0;
		int totalWidth = 0;
		for (int i = 0; i < rowHeight.length; i++) {
			totalHeight += rowHeight[i];
		}
		
		for (int i = 0; i < columnWidth.length; i++) {
			totalWidth += columnWidth[i];
		}
		
		totalHeight = (int)Math.round(totalHeight * scaleFactor);
		totalWidth = (int)Math.round(totalWidth * scaleFactor);
		
		// Ausgabe
		StringBuilder out = new StringBuilder();
		int y = 0;
		int r = -1;
		for (int cy = 0; cy < totalHeight; cy++) {
			
			r++;
			if (r >= rowHeight[y]) {
				r = 0;
				y = (y+1) % rows;
			}
			
			int x = 0;
			int c = -1;
			
			for (int cx = 0; cx < totalWidth; cx++) {
				
				c++;
				if (c >= columnWidth[x]) {
					c = 0;
					x = (x+1) % columns;
				}
				
				if ((contentText[y][x].length > r)&&(contentText[y][x][r].length() > c))
				{ out.append(contentText[y][x][r].charAt(c)); }
				else
				{ out.append(':'); }
			}
			
			out.append("\n");
		}
		
		return out.toString();
	}
}
