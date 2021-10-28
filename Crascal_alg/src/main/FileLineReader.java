package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class FileLineReader {
    public static ArrayList<ArrayList<Integer>> readFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = "";
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        ArrayList<String> stringArr;
        while((line = reader.readLine())!=null){
            stringArr = (ArrayList<String>) Arrays.stream(line.split(" ")).collect(Collectors.toList());
            //add random weight for vertex
            stringArr.add(Integer.toString(ThreadLocalRandom.current().nextInt(3, 11)));
            ArrayList<Integer> data = new ArrayList<>();
            stringArr.forEach(elem -> data.add(Integer.parseInt(elem)));
            arr.add(data);
        }
        return arr;
    }
}
