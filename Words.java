import java.util.*;
import java.util.stream.Collectors;

public class Words {

    public String countWords(List<String> lines) {

        HashMap<String, Integer> map = new HashMap<>();
        List<String[]> listOfArrays = lines.stream()
                .map(line -> line.toLowerCase(Locale.ROOT)
                .split("[^а-яА-яёЁA-Za-z]+"))
                .collect(Collectors.toList());

        listOfArrays.forEach(arr -> fillMap(arr, map));

        map.entrySet().removeIf(entry -> entry.getValue() < 10);

        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> {
            int i = 0;
            i = Objects.equals(o2.getValue(), o1.getValue()) ? o1.getKey()
                    .compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue());
            return i;
        });
        Map<String, Integer> sortedMap = list.stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (a, b) -> b, LinkedHashMap::new));

        String result = sortedMap.entrySet().stream()
                .map(pair -> pair.getKey() + " - " + pair.getValue() + "\n")
                .collect(Collectors.joining());
        return result.trim();
    }

    public void fillMap(String[] array, HashMap<String, Integer> map) {
        Arrays.stream(array).filter(this::filterByLength)
                .forEachOrdered(element -> map.put(element, map.get(element) != null ? map.get(element) + 1 : 1));
    }

    public boolean filterByLength(String s) {
        return s.toCharArray().length >= 4;
    }
}
