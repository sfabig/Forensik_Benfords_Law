package logic;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

public class PicReader extends AbstractFileReader {
	private BufferedImage img;
	
	public PicReader(String pathToFile) {
		super(pathToFile);
		
		try {
		    img = ImageIO.read(new File(pathToFile));
		} 
		catch (IOException e) {
		}
	}
	
	public BufferedImage getImg() {
		return img;
	}
	
	@Override
	public Vector<String> read() {
		Vector<String> result = new Vector<>();
		
		for (int y = 0; y < img.getHeight(); y++) {
		    for (int x = 0; x < img.getWidth(); x++) {
		    	Color cur = new Color(img.getRGB(x, y));
		    	int r = cur.getRed();
		    	int b = cur.getBlue();
		    	int g = cur.getGreen();
		    	
		         result.add(""+r);
		         result.add(""+b);
		         result.add(""+g);
		    }
		}
		return result;
	} 
}
