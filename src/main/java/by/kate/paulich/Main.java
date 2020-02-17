package by.kate.paulich;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        Sort sort = new Sort();
        List<String> list = reader.read();
        List<String> listResult = new ArrayList<String>();
        List<String[]> listOrigin = new ArrayList<String[]>();
        String[] array;
        int index = 0;
        for (String listStr: list) {
            listStr = index + "\t" + listStr;
            array = listStr.split("\t");
            listOrigin.add(array);
            index++;
        }

        List<String[]> listGeneral = sort.sort(listOrigin,1);

        for (String[] aListGeneral : listGeneral) {
            listResult.add(list.get(Integer.parseInt(aListGeneral[0])));
        }

        Writer writer = new Writer();
        writer.write(listResult);
    }
}
