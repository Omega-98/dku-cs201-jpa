// 
// Created by Jiang Long
// Spring 2022 for CS201 DKU
//
import java.util.Arrays;
public class Zipf { 
    

    // Note: nested class for sort freq/key pair
    static class Pair implements Comparable<Pair> {
        // Complete the code here, see README on course website for problem description and instructions.
        private int freq;
        private String key;
        public Pair(int freq, String key){
            this.freq = freq;
            this.key = key;
        }
        public int compareTo(Pair b){
            if(this.freq < b.freq){
                return 1;
            }else if(this.freq > b.freq){
                return -1;
            }else{
                return this.key.compareTo(b.key);
            }
        }
    } ;
    public static void main(String[] args)
    { 
        /*
          To read input stream from a file, use this

          In in = new In (args[0]);
          while (!in.isEmpty()){
             String key = in.readString();
             ...
          } 
         */
        
        // Complete the code here, see README on course website for problem description and instructions.
        BST<String, Integer> bst = new BST<String, Integer>();
        In in = new In (args[0]);
          while (!in.isEmpty()){
             String word = in.readString();
             if(bst.contains(word)){
                bst.put(word, bst.get(word) + 1);
             }else{
                bst.put(word, 1);
             }
          } 
        
        
        int size = bst.size();
        Pair[] pairArray = new Pair[size];
        int i = 0;
        for(String word : bst.keys()){
            pairArray[i] = new Pair(bst.get(word), word);
            i ++;
        }
        Arrays.sort(pairArray);
        int iteration = Math.min(20, pairArray.length);
        for (int j = 0; j < iteration; j++) {
            System.out.printf("%10d %s\n", pairArray[j].freq, pairArray[j].key);
        }
    }
}