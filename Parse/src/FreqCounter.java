import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class FreqCounter {

public static HashSet<String> connectingWords;
public static Map<String,Integer> frequencyMap;

static  {
    connectingWords = new HashSet<>();
    connectingWords.add("and");
    connectingWords.add("it");
    connectingWords.add("you");
    frequencyMap = new HashMap<>();
}

public static void main(String[] args) {
    BufferedReader reader = null;
    String line;
    try {
        reader = new BufferedReader(new FileReader("//Users//rsalecha//Downloads//jate_test//littleItalyReview.rtf"));
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("-");
            for (String word : words) {
                if(connectingWords.contains(word)) {
                    continue;
                }
                Integer value = frequencyMap.get(word);
                if(value != null) {
                    frequencyMap.put(word,value+1);
                } else {
                    frequencyMap.put(word,0);
                }
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    System.out.println(frequencyMap.values());

}
}