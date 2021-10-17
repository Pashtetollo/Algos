package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileLineReader {
    public static ArrayList<ArrayList<Integer>> readFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = "";
        String[] stringArr;
        ArrayList<Integer> dataArr;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        while((line = reader.readLine())!=null){
            stringArr  = new String[10];
            dataArr = new ArrayList<>();
            stringArr = line.split(" ");
            for(String elem: stringArr){
                dataArr.add(Integer.parseInt(elem));
            }
            arr.add(dataArr);
        }
        return arr;
    }
}
