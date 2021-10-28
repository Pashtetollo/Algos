package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FileLineReader {
    private FileLineReader(){}
    public static ArrayList<ArrayList<Integer>> readFile(String path) throws IOException {
        String line = "";
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        ArrayList<String> stringArr;
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            while((line = reader.readLine())!=null){
                stringArr = (ArrayList<String>) Arrays.stream(line.split(" ")).collect(Collectors.toList());
                //add random weight for vertex
                if(stringArr.size() < 3) {
                    stringArr.add(Integer.toString(ThreadLocalRandom.current().nextInt(3, 11)));
                }
                ArrayList<Integer> data = new ArrayList<>();
                stringArr.forEach(elem -> data.add(Integer.parseInt(elem)));
                arr.add(data);
            }
        } catch (IOException e){
            Logger logger = Logger.getAnonymousLogger();
            logger.log(Level.SEVERE, "could not open file", e);
        }

        return arr;
    }
}
