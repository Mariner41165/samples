package com.efimchick.ifmo.collections.countwords;

import java.util.*;

public class Words {

    public String countWords(List<String> lines) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] str = null;
        for (String line : lines) {
            str = line.toLowerCase(Locale.ROOT).split("[^а-яА-яёЁA-Za-z]+");
            for (String s : str) {
                if (s.toCharArray().length >= 4) {
                    Integer count = map.get(s);
                    if (count != null) {
                        map.put(s, ++count);
                    } else {
                        map.put(s, 1);
                    }
                }
            }
        }
        for (Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() < 10) {
                iterator.remove();
            }
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int i = 0;
                if (Objects.equals(o2.getValue(), o1.getValue())) {
                    i = o1.getKey().compareTo(o2.getKey());
                } else {
                    i = o2.getValue().compareTo(o1.getValue());
                }
                return i;
            }
        });
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> item : list) {
            sortedMap.put(item.getKey(), item.getValue());
        }

        String result = "";
        for (Map.Entry<String, Integer> pair : sortedMap.entrySet()) {
            result += pair.getKey() + " - " + pair.getValue() + "\n";
        }
        return result.trim();
    }
}
