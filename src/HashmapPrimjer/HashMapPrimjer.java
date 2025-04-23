package HashmapPrimjer;

import java.util.HashMap;

public class HashMapPrimjer {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap();
        map.put("Alen",18);
        map.put("Monika",25);
        map.put("Bob",19);
        map.put("Danijel",32);
        System.out.println(map.get("Monika"));
        map.forEach((k,v)-> System.out.println(k+" "+v));
    }
}
