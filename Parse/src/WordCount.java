import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.Ordering;


public class WordCount {

	public static void main(String[] args) throws IOException {
        Multiset<String> countSet = HashMultiset.create();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("//Users//rsalecha//Downloads//jate_test//littleItalyReview.rtf"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            List<String> words = Arrays.asList(line.split("\\W+"));
            Collections.reverse(words);
            countSet.addAll(words);
        }
        
          
        bufferedReader.close();
        for (Entry<String> entry : countSet.entrySet()) {
          System.out.println(entry.getElement() + "," + entry.getCount());
        }
    }
	
	
}
