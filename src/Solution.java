import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = "src//input1.txt";
        String content = Files.lines(Paths.get(fileName)).reduce("",(a,b) -> a + " " + b);
        System.out.println(content);
        List<String> list = new ArrayList<String>(Arrays.asList(content.split(" ")));

        for (String str:list) {
            int count = Collections.frequency(list, str);
            System.out.println(count);
        }

//


    }
}
