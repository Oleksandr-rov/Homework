package module_9.MyMap;

public class TestMyMap {
    public static void main(String[] args) {
        MyMap<String, String> myHash = new MyHashMap<String, String>();
        myHash.put("1","Oleksandr");
        myHash.put("2","Alex");
        myHash.put("3","Mykola");
        myHash.put("4","Ivan");
        myHash.put("4","Ivanka");
        myHash.put("5","Olga");
        myHash.put("121","Andrii");
        myHash.put("132","Vlad");
        myHash.put("231","Ruslan");
        System.out.println("myHash.size() = " + myHash.size());
        System.out.println(myHash);

        System.out.println("myHash.get(\"132\") = " + myHash.get("132"));
        System.out.println("myHash.get(\"121\") = " + myHash.get("121"));
        System.out.println("myHash.get(\"3\") = " + myHash.get("3"));

        System.out.println("myHash.remove(\"132\") = " + myHash.remove("132"));
        System.out.println(myHash);
        System.out.println("myHash.remove(\"231\") = " + myHash.remove("231"));
        System.out.println(myHash);
        System.out.println("myHash.remove(\"4\") = " + myHash.remove("4"));
        System.out.println(myHash);

        myHash.clear();
        System.out.println("Clear()");
        System.out.println(myHash);
    }
}
