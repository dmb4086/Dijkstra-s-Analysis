import java.util.HashMap;

public class test {
    public static HashMap<Character,Integer> map = new HashMap<>();


    protected static int LetterToNum(Character letter) {

        return map.get(letter);
    }

    protected static void PopulateMap(int vertices){
        int start = 'A';
        for (int i = 0; i <= vertices; i++) {
            map.put((char)start,i);
            start++;
        }
        }



    public static void main(String[] args) {
        PopulateMap(6);
        System.out.print(LetterToNum('G'));

    }
}
