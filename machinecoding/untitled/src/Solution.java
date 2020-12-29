import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
*/
        //Scanner
        Scanner s = new Scanner(System.in);
        //String number = s.nextLine();                 // Reading input from STDIN
        int n = 3;//Integer.parseInt(s.nextLine());
        String input = "abc";//s.nextLine();

        // Set<Character> set = new HashSet<>();
        // char [] charArray = strin.charArray();
        // for(char c : charArray){
        //     if(set.contains(c)) continue;
        //     set.add(c);
        // }

        // int len = set.size();
        int i =1;
        while(i <= 26){
            int res =0;
            if(i <= n){
                res = getSubStringsCount(input, i);
            }
            i++;
            System.out.print(res+ " ");
        }


        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT



        // Write your code here

    }

    private static int getSubStringsCount(String s, int k){
        //System.out.println("s = "+s );
        //system.out.println("k = " +i);


        Map<Character, Integer> map = new HashMap<>();

        int res=0;
        for(int i = 0; i < s.length() ; i++){
            int distCount =0;
            int count[] = new int[26];
          //  Arrays.fill(count, 0);

            for(int j =i; j < s.length(); j++){

                if(count[s.charAt(j)- 'a'] == 0){
                    distCount++;
                }
                count[s.charAt(j)- 'a']++;

                if(distCount <= k){
                    res++;
                }
                if(distCount > k) break;
            }
        }
        return res;
    }
}
