package learn;

import java.util.ArrayList;
import java.util.Random;

public class TestUil {
    public static void main(String[] args) {
        System.out.println(geCode());

    }
    private static String geCode(){
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a'+i));
            list.add((char)('A'+i));
        }
        StringBuilder sb = new StringBuilder();
        Random r =new Random();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(list.size());
            char c = list.get(index);
            sb.append(c);

        }
        int num = r.nextInt(10);
        sb.append(num);
        char [] arr=sb.toString().toCharArray();
        int randIndex = r.nextInt(sb.length());
        char temp = arr[randIndex];
        arr[randIndex] = arr[arr.length-1];
        arr[arr.length-1]=temp;
        return new String(arr);
    }
}
