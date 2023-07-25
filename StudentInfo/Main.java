import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {

        Map<String, Integer> studentInfo = new HashMap<>();

        studentInfo.put("John Logan Curt", 4);
        studentInfo.put("Sophia Sullivan", 6);
        studentInfo.put("Nathan Logan", 4);
        studentInfo.put("Matthew Thompson", 8);
        studentInfo.put("Morgan Smith", 3);
        studentInfo.put("Alice Suzan Johnson", 5);
        studentInfo.put("Robert Morgan", 6);
        studentInfo.put("Jonathan Dave Smith", 7);
        studentInfo.put("Emily Anderson", 8);
        studentInfo.put("Olivia Duncan", 3);


        ArrayList<String> nameList = new ArrayList<>(studentInfo.keySet());

        System.out.println("Students whose names end with 'an':");
        for (String name : nameList) {
            String[] nameParts = name.split(" ");
            if (nameParts.length <= 2 && nameParts[0].endsWith("an")) {
                System.out.println(name + " Grade:" + studentInfo.get(name));
            } else if (nameParts.length > 2 && (nameParts[0].endsWith("an") || nameParts[1].endsWith("an"))) {
                System.out.println(name + " Grade:" + studentInfo.get(name));
            }
        }

    }

}




