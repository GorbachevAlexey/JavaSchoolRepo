import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        while (scanner.hasNext()) {
            str = str + scanner.nextLine() + " ";
        }
        str = str.toLowerCase().replaceAll("\\s+", " ");

        List<String> list = new ArrayList<>(Arrays.asList(str.split(" ")));
        Map<String, Integer> map = new HashMap<>();

        Integer maxCount = 0;
        for (String word : list) {
            Integer oldCount = map.get(word);

            if (oldCount == null) {
                oldCount = 0;
            } else if (oldCount > maxCount) {
                maxCount = oldCount;
            }

            map.put(word, oldCount + 1);
        }
        maxCount++;
        List<String> output = new ArrayList<>();
        Collection<String> collection = map.keySet();
        for (String key : collection) {
            Object obj = map.get(key);
            if (key != null) {
                if (maxCount.equals(obj)) {
                    output.add(key);
                }
            }
        }
        Collections.sort(output);
        for (String out : output) System.out.println(out);

    }
}