import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;

public class pop_words extends LinkedHashMap<String, Integer>{

    public static String filename = "input.txt";
    public static String filename1 = "output.txt";
    
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hmap1){
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hmap1.entrySet());
               Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
                {
                    return (o1.getValue()).compareTo(o2.getValue());
                }
            });
            HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
            for (Map.Entry<String, Integer> en : list) {
                temp.put(en.getKey(), en.getValue());
            }
            return temp;
    }

    public static void main(String args[]) {
        HashMap<String,Integer> hmap = new HashMap();
        
        try {

            BufferedReader   in;

						// open file
            in  = new BufferedReader(new FileReader(filename));

						// read from file
						String line = in.readLine();
						while( line != null ){
                            boolean keyExists = hmap.containsKey(line);
                            if(keyExists == false){
                                hmap.put(line,0);
                            } else{
                                int n = (int)hmap.get(line);
                                n++;
                                hmap.put(line,n);
                            }
							System.out.println(line);
              line = in.readLine();
						}

						// clse file
            in.close();;
            Map<String, Integer> hmap2 = sortByValue(hmap);
            PrintWriter  out;

            // open file for writing
            // (deleting current contents if the file already exists)
            out = new PrintWriter(new FileWriter(filename));

            // write to the file
            for (Map.Entry<String, Integer> en : hmap2.entrySet()) {
                out.print("Key = " + en.getKey() + ", Value = " + en.getValue());
            }
            // close the file
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: Cannot open file \"" + filename + "\" for reading");
        } catch (IOException e) {
            System.out.println("Error: Cannot read from file \"" + filename + "\"");
        }
    }
}