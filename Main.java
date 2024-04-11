import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);

        List<Integer> list2 = list.stream().filter((item) -> item < 3).collect(Collectors.toList());


        for(Integer e : list2){
            System.out.println(e);
        }
    }
    public static int count(List<?> list) {
        return list.size();
    }
}
