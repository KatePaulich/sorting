package by.kate.paulich;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Reader {
   List<String> read() throws IOException {
        FileReader fileReader = new FileReader("in.txt");
        Scanner scanner = new Scanner(fileReader);

        List<String> list = new ArrayList<String>();
        while (scanner.hasNextLine()){
            list.add(scanner.nextLine());
        }

        fileReader.close();
        return list;
    }
}
