import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        count(list);
    }
    public static int count(List<?> list) {
        return list.size();
    }
}
