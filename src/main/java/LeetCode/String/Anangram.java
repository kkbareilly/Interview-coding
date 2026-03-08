package LeetCode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

public class Anangram {

    static void removeAnagramsformList(String arr[], int N)
    {
        List<String> result = new ArrayList<String>();

        // data structure to keep a mark
        // of the previously occurred String
        HashSet<String> found = new HashSet<String> ();

        for (int i = 0; i < N; i++) {

            String word = arr[i];
            //sort the word to get character is sorted order
            word = sortByCharactor(word);
             //check the word is already processed or not
            if (!found.contains(word)) {

                result.add(arr[i]);
                found.add(word);
            }
        }

        // Sort the resultant list of Strings
        Collections.sort(result);

        // Print the required array
        for (int i = 0; i < result.size(); ++i) {
            System.out.print(result.get(i)+ " ");
        }
    }
    static String sortByCharactor(String inputString)
    {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    // Driver code
    public static void main(String[] args)
    {
        String arr[]
                = { "code", "doce",
                "ecod", "framer","frame" };
        int N = 5;

        removeAnagramsformList(arr, N);
    }
}
