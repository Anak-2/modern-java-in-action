package study.javalang.ch08;

import study.javalang.ch05.Transaction;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.entry;

public class CollectionFactory {
    public static void main(String[] args) {
        List<String> friends = Arrays.asList("kim","dong","hyun");
//        error!
        //        friends.add("Hello");
//        System.out.println(friends);

        List<String> friends2 = List.of("kim","dong","hyun");
//        System.out.println(friends2);

        Map<String, Integer> ageOfFriends = Map.of("Kim",30,"Dong",20,"Hyun",10);
        ageOfFriends.forEach((key, value) -> System.out.println("key: "+key+ "\nvalue: "+value));
//        System.out.println(ageOfFriends);

        Map<String, Integer> map1 = Map.ofEntries(entry("a",1),
                entry("b",2),
                entry("c",3));
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("a",4);
        map2.put("b",5);
        map2.put("c",6);
//        System.out.println(sumMap(map2, map1));
        mergeMap(map1, map2);
//        map.put("d",4);

        List<String> strings = new ArrayList<>();
        strings.add("kim");
        strings.add("dong");
        strings.add("hyun");

        removeString2(strings, 'k');

//        List<String> upperString = strings.stream().map(s ->{
//            return Character.toUpperCase(s.charAt(0)) + s.substring(1);
//        }).toList();

        firstCharUpper(strings);
        System.out.println(strings);
    }
    // Error Occurs
    public static void removeString(List<String> strings, char c){
        for(String s : strings){
            if(s.charAt(0) == c){
                strings.remove(s);
            }
        }
    }

    public static void removeString2(List<String> strings, char c){
        for(Iterator<String> iterator = strings.iterator(); iterator.hasNext();){
            String s = iterator.next();
            if(s.charAt(0) == c){
                iterator.remove();
            }
        }
        System.out.println("Strings: "+strings);
    }

    public static void removeString3(List<String> strings, char c){
        strings.removeIf(s -> {
            return s.charAt(0) == 'k';
        });
    }

    public static void firstCharUpper(List<String> strings){
        strings.replaceAll(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1));
    }

    public static <K,V> Map<K, V> sumMap(Map<K, V> map1, Map<K, V> map2){
        map1.putAll(map2);
        return map1;
    }

    public static <K> void mergeMap(Map<K, Integer> map1, Map<K, Integer> map2){
        map1.forEach((k, v) -> {
            map2.merge(k, v , (v1, v2) -> {
                return v1 + v2;
            });
        });
        System.out.println("mergeMap Result: "+map2);
    }
}
