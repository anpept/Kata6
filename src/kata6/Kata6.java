package kata6;

import java.io.File;
import java.util.Iterator;

public class Kata6 {

    public static void main(String[] args) {
        File file = new File("/");
        Iterator<Integer> iterator = megabytes(lengthsOf(iteratorOf(file.listFiles())));
        Histogram histo = new Histogram(megabytes(lengthsOf(iteratorOf(file.listFiles()))));
        //while (iterator.hasNext()) System.out.println(iterator.next());
    }

    private static <T> Iterator<T> iteratorOf(T[] items){
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < items.length;
            }
            @Override
            public T next() {
                return items[index++];
            }
        };
    }
       
    private static Iterator<Long> lengthsOf (Iterator<File> iterator){
        return new Iterator<Long>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Long next() {
                return iterator.next().length();
            }
        };
            
    }
        
    private static Iterator<Integer> megabytes (Iterator<Long> iterator){
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return (int) (iterator.next()/1024*1024);
            }
        };
    }       
        
 }    