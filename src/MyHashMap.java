import java.util.*;

public class MyHashMap {
    private Scanner scanner = new Scanner(System.in);
    private Map<Integer, String> myHashMap = new HashMap<>();

    boolean quit = false;

    public MyHashMap(List<Integer> x, List<String> y) {
        int counter = 0;
        while (counter != x.size()) {
            myHashMap.put(x.get(counter), y.get(counter));
            counter++;
        }
    }

    public void addKVPair() {
        System.out.print("Give me the hashmap key: ");
        Integer intKey = scanner.nextInt();
        System.out.print("Give me the hashmap value: ");
        String stringValue = scanner.next();
        myHashMap.put(intKey, stringValue);
    }

    public void deleteAgeLimit() {
        Integer[] nameArr = myHashMap.keySet().toArray(new Integer[0]);
        System.out.println("HashMap: " + myHashMap);

        System.out.print("KEYS below the entered value will be deleted: ");
        int ageLimit = scanner.nextInt();

        for (Integer emp : nameArr) {
            //your code goes here
            if (emp <= ageLimit) {
                myHashMap.remove(emp);
            }
        }
    }

    public void removeBV2() {
//        scanner.nextLine();
        System.out.print("Enter the VALUE you want to delete: ");
        String word = scanner.nextLine();
        if(!myHashMap.containsValue(word)){
            System.out.println("The HashMap doesn't contain the searched value");
            removeBV2();
        }else {
            List<Integer> keys = new ArrayList<>();
            List<String> values = new ArrayList<>();

            Integer[] keys2 = myHashMap.keySet().toArray(new Integer[0]);

            for (Integer a : keys2) {
                if (myHashMap.get(a).equals(word)) {
                    keys.add(a);
                    values.add(myHashMap.get(a));
                }
            }
            System.out.println(keys);
            System.out.println(values);
            System.out.println("Enter the index, which KV pair you want to delete: ");
            int delete = Integer.parseInt(scanner.nextLine());
            myHashMap.remove(keys.get(delete), values.get(delete));
        }
    }

    public void sortHashMap() {
        System.out.println("\nHashMap in sorted order by KEY: ");
        myHashMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
    }

    public void printData() {
        System.out.println("HashMap: " + myHashMap + "\n");
    }

    public void removeBK() {
        System.out.print("Write in the KEY(number) what you want to delete: ");
        Integer deleteTheInt = scanner.nextInt();

        if (myHashMap.containsKey(deleteTheInt)) {
            myHashMap.remove(deleteTheInt);
        } else System.out.println("The KEY is not exist");
    }

    public void removeBV() {
        System.out.print("Write in the VALUE(word) what you want to delete: ");
        String deleteTheWord = scanner.next();

        if (myHashMap.containsValue(deleteTheWord)) {
            myHashMap.values().remove(deleteTheWord);
        } else System.out.println("The VALUE is not exist");
    }

    public static void printActions() {
        System.out.println("\nAvailable actions: ");
        System.out.println("0 - EXIT\n" +
                        "1 - print hashmap\n" +
                        "2 - add KV pair\n" +
                        "3 - remove by KEY\n" +
                        "4 - remove by VALUE\n" +
                        "5 - delete KEY limit\n" +
                        "6 - SORT map by KEY\n"
//                "7 - print actions"
        );
    }

    public void display() {
        System.out.print("HashMap: " + myHashMap);
    }

    public MyHashMap() {
        myHashMap.put(10, "Geeks");
        myHashMap.put(15, "4");
        myHashMap.put(20, "Geeks");
        myHashMap.put(25, "Welcomes");
        myHashMap.put(30, "You");
        myHashMap.put(23, "You");
    }

    public MyHashMap(int x, String y) {
        myHashMap.put(x, y);
    }

    public Map<Integer, String> getHashMap() {
        return myHashMap;
    }

    public void actions(){
        boolean quit = false;
        while (!quit) {
//            printData();
            printActions();
            System.out.print("\nEnter action: ");

            int action = Integer.parseInt(scanner.nextLine());

//            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("\nExit");
                    quit = true;
                    break;
                case 1:
                    printData();
                    break;
                case 2:
                    addKVPair();
                    break;
                case 3:
                    removeBK();
                    break;
                case 4:
                    removeBV2();
                    break;
                case 5:
                    deleteAgeLimit();
                    break;
                case 6:
                    sortHashMap();
                    break;
                case 7:
                    printActions();
                    break;
            }
        }
    }


}
