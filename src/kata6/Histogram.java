package kata6;

import java.util.HashMap;
import java.util.Iterator;

public class Histogram <T>{
    
    private final HashMap<T, Integer> map = new HashMap<>();

    public Histogram(Iterator <T> iterator) {
            while (iterator.hasNext()) add(iterator.next());
    }
    
    public Histogram (Iterable<T> iterable) {
        Iterator<T> iterator = iterable.iterator();
        while(iterator.hasNext()) add(iterator.next());
    }

    public int get(T item) {
        return map.containsKey(item) ? map.get(item) : 0;
    }
    public void add(T item) {
        map.put(item, get(item)+1);
    }    
}
