package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class algo_7662_이주형 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        int k, input;
        String calculation;
    }

    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        int k, input;
        String calculation;

        TreeMap<Integer, Integer> treeMap;

        for (int i = 0; i < t; i++) {
            k = Integer.parseInt(br.readLine());

            treeMap = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                calculation = st.nextToken();
                input = Integer.parseInt(st.nextToken());

                if (calculation.equals("I")) {
                    if(treeMap.containsKey(input)){
                        treeMap.put(input, treeMap.get(input) + 1);
                        continue;
                    }
                    treeMap.put(input, 1);
                } else{
                    if(treeMap.isEmpty()) continue;
                    int key, value;

                    key = input == 1 ? treeMap.lastKey() : treeMap.firstKey();
                    value = treeMap.get(key);
                    if(value != 1){
                        treeMap.put(key, value - 1);
                    } else{
                        treeMap.remove(key);
                    }
                }
            }

            if (treeMap.size() == 0) bw.append("EMPTY");
            else {
                bw.append(String.valueOf(treeMap.lastKey())).append(" ").append(String.valueOf(treeMap.firstKey()));
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}