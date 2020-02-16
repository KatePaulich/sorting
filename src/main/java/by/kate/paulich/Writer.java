package by.kate.paulich;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class Writer  {
    void write(List<String[]> list) throws IOException {
        FileWriter fileWriter = new FileWriter("out.txt");

        for (String[] aList : list) {
            fileWriter.write(Arrays.toString(aList)
                    .replace(",", "")
                    .replace("[", "")
                    .replace("]", "") + " \n");
        }

        fileWriter.close();
    }
}
