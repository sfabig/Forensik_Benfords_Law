import java.io.IOException;
import java.util.Vector;

public abstract class AbstractFileReader {
	String pathToFile;
	
	public AbstractFileReader(String path) {
		pathToFile = path;
	}
	
	public abstract Vector<String> read();
	
	public abstract String showTextPdf();
}
