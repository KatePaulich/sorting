package by.kate.paulich;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        Sort sort = new Sort();
        Writer writer = new Writer();
        List<String[]> listResult = sort.sort(reader.read(), 0);
        writer.write(listResult);
    }
}
