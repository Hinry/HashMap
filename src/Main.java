import java.util.*;

/*
 * Есть 2 HashMap  в которых хранятся пары строк ( строка ключ == строка занчение ).
 * Необходимо написать:
 * 1) метод, который вернет коллекцию ключей, которые есть в одной  одной из 2-х Map, но отсутствуют в другой
 * 2) метод, который вернет коллекцию ключей, которые есть в каждой из 2-х Map, но имеют различные значения
 * 3) метод, который вернет Map-у, содержащую пары ключ-значение, которые есть в первой Map-е, но нет во второй
 */
public class Main {

    static HashMap<String, String> map1 = new HashMap<>();
    static HashMap<String, String> map2 = new HashMap<>();
    static HashMap<String, String> map3 = new HashMap<>();


    public static void main(String[] args){

        //Области в которых есть офисы LifeCell

        map1.put("Днепропетровская", "Днепр");
        map1.put("Киевская", "Киев");
        map1.put("Харьковская", "Изюм");
        map1.put("Львовская", "Самбор");
        map1.put("Одесская", "Подольск");

        //Области в которы есть офисы MTC

        map2.put("Днепропетровская", "Павлоград");
        map2.put("Киевская", "Оранжево");
        map2.put("Полтавская", "Миргород");
        map2.put("Сумская", "Конотоп");
        map2.put("Хмельницкая", "Белогорье");
        map2.put("Одесская", "Подольск");

        method1();
        System.out.println("\n");
        method2();
        System.out.println("\n");
        method3();

    }

    // метод, который вернет коллекцию ключей, которые есть в одной  одной из 2-х Map, но отсутствуют в другой
    public static void method1() {
        Set<String> str1 = new TreeSet<>();
        Set<String> str2 = new TreeSet<>();

        Set<String> keys1 = map1.keySet();
        Set<String> keys2 = map2.keySet();

        for(String a : keys1){
                if(!map2.containsKey(a)){
                    str1.add(a);
                }
        }
        for(String b : keys2){
            if(!map1.containsKey(b)){
                str2.add(b);
            }
        }
        System.out.println("Есть в первой мапе, но нет во второй: "+str1);
        System.out.println("Есть во второй  мапе, но нет в первой: "+str2);
    }

    // метод, который вернет коллекцию ключей, которые есть в каждой из 2-х Map, но имеют различные значения
    public static void method2(){

        List<String> keys = new LinkedList<>();

        for(Map.Entry a : map1.entrySet()){
            for(Map.Entry b : map2.entrySet()){
                if(a.getKey() == b.getKey()){
                    if(a.getValue() != b.getValue()){
                        keys.add(a.getKey().toString());
                    }
                }
            }
        }
        System.out.println(keys);
    }

    // метод, который вернет Map-у, содержащую пары ключ-значение, которые есть в первой Map-е, но нет во второй
    public static void method3(){
        Set<Map.Entry<String, String>> set1 = map1.entrySet();
        Set<Map.Entry<String, String>> set2 = map2.entrySet();

        for(Map.Entry a : set1){
            if(!set2.contains(a)){
                map3.put(a.getKey().toString(), a.getValue().toString());
            }
        }

        System.out.println(map3.entrySet());
    }

}
