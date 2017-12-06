package logic;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class CsvReader extends AbstractFileReader {
	private String separator;
	public CsvReader(String pathToFile, String separator) {
		super(pathToFile);
		this.separator = separator;
		
	}
	
	@Override
	public Vector<String> read() {
		
		File csvFile = new File(pathToFile);
        List<List<String>> lines = new ArrayList<>();
        Vector<String> result = new Vector<String>();
        Scanner inputStream;

        try{
            inputStream = new Scanner(csvFile);

            while(inputStream.hasNext()){
                String line= inputStream.next();
                String[] values = line.split(separator);
                lines.add(Arrays.asList(values));
            }

            inputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(List<String> l : lines) 
        	for(String s : l) 
        		result.add(s.replaceAll("\\D+",""));
        	
        result.removeAll(Arrays.asList("",null));
		return result;
	}

		
}
