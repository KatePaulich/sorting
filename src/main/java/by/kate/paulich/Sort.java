package by.kate.paulich;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Sort {
    private static String numDouble ="^[-]?([0-9]+)\\." + "([0-9]+)$";
    private static String numInt = "[-]?[0-9]+";
    private Pattern pattern1 = Pattern.compile(numDouble);
    private Pattern pattern2 = Pattern.compile(numInt);
    private List<String[]> listResult = new ArrayList<String[]>();

    List<String[]> sort(List<String[]> listStr, int indexColumn){
        List<String[]> list;
        list = splitNumberString(listStr, indexColumn); //отсортированный список строк

        for (int line =0; line< list.size(); line++){
            List<String[]> listForSort = new ArrayList<String[]>();
            if (line == list.size() - 1) {
                listResult.add(list.get(line));
                break;
            }
            if (list.get(line).length == 1 || list.get(line+1).length == 1){
                listResult.add(list.get(line));
            }else
                if (indexColumn == list.get(line).length) {
                listResult.add(list.get(line));
                } else {
                    boolean isEquels = false;
                    int newLine = line;
                    while (list.get(newLine)[indexColumn].equals(list.get(newLine + 1)[indexColumn])) {
                        listForSort.add(list.get(newLine));
                        newLine++;
                        isEquels = true;
                        //выход из while
                        if (newLine == list.size() - 1) {
                            break;
                        }
                }
                line = newLine;
                if (isEquels) {
                    listForSort.add(list.get(line));
                    int newIndexColumn = indexColumn + 1;
                    this.sort(listForSort, newIndexColumn);
                } else
                    listResult.add(list.get(line));
            }
        }

        return listResult;
    }

    // разделяем строки и цифры
    private List<String[]> splitNumberString(List<String[]> listStr, int indexColumn){

        List<String[]> listNumber = new ArrayList<String[]>();
        List<String[]> listString = new ArrayList<String[]>();
        List<String[]> listEmpty = new ArrayList<String[]>();
        List<String[]> list1;
        List<String[]> list2;
        List<String[]> mainList = new ArrayList<String[]>();

        for (String[] aListStr : listStr) {
            if (aListStr.length == 1){
                listEmpty.add(aListStr);
            }else if (indexColumn == aListStr.length ){
                mainList.add(aListStr);
            }else {
                Matcher regexp1 = pattern1.matcher(aListStr[indexColumn]);
                Matcher regexp2 = pattern2.matcher(aListStr[indexColumn]);
                if (!aListStr[indexColumn].equals("")) {
                    if (regexp1.matches() || regexp2.matches()) { //если числа
                        listNumber.add(aListStr);
                    } else if (!regexp1.matches() || !regexp2.matches()) { // если строки
                        listString.add(aListStr);
                    }
                }
            }
        }

        list1 = sortNumber(listNumber, indexColumn);
        list2 = sortString(listString, indexColumn);
        mainList.addAll(list1);
        mainList.addAll(listEmpty);
        mainList.addAll(list2);
        return mainList;
    }

    // сортировка цифр
    private List<String[]> sortNumber(List<String[]> listNumber, int indexColumn){

        List<String[]> listNumberSort = new ArrayList<String[]>();
        Double[] strings = new Double[listNumber.size()];

        for (int j=0; j< listNumber.size(); j++){
            strings[j] = Double.valueOf(listNumber.get(j)[indexColumn]);
        }

        Arrays.sort(strings);
        for (Double string : strings) {
            for (int k = 0; k < listNumber.size(); k++) {
                if (string.equals(Double.valueOf(listNumber.get(k)[indexColumn]))) {
                    listNumberSort.add(listNumber.get(k));
                    listNumber.remove(listNumber.get(k));
                    break;
                }
            }
        }
        return listNumberSort;
    }

    //сортировка строк
    private List<String[]> sortString(List<String[]> listString, int indexColumn){

        List<String[]> listStringSort = new ArrayList<String[]>();
        String[] strings = new String[listString.size()];

        for (int j=0; j< listString.size(); j++){
            strings[j] = listString.get(j)[indexColumn];
        }

        Arrays.sort(strings);
        for (String string : strings) {
            for (int k = 0; k < listString.size(); k++) {
                if (string.equals(listString.get(k)[indexColumn])) {
                    listStringSort.add(listString.get(k));
                    listString.remove(listString.get(k));
                    break;
                }
            }
        }

        return listStringSort;
    }
}
