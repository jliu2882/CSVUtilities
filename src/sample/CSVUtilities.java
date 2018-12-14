package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class CSVUtilities {
    private ArrayList<String> CSVData;
    private int numColumns;

    //20
    public CSVUtilities(File csv) {
        Path pathToFile = Paths.get("src/" + csv.toString());

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                this.numColumns = attributes.length;
                for(String attribute : attributes){
                    CSVData.add(attribute);
                }

                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public List<String> getColumnHeaders() {
        List<String> header = new ArrayList<>();
        for(int i = 0 ; i< numColumns;i++){
            header.add(CSVData.get(i));
        }
        return header;
    }

    public List<String> getDataString(int column) {
        List<String> columnData = new ArrayList<>();
        System.out.println(column+numColumns);
        System.out.println(CSVData.size());
        for(int i = column+numColumns; i< CSVData.size();i+=numColumns){
            columnData.add(CSVData.get(i));
        }
        return columnData;
    }

    public List<Integer> getDataInt(int column) {
        List<Integer> columnData = new ArrayList<>();
        for(int i = column+numColumns; i< CSVData.size();i+=numColumns){
            columnData.add(Integer.parseInt(CSVData.get(i)));
        }
        return columnData;
    }

    public List<Double> getDataDouble(int column) {
        List<Double> columnData = new ArrayList<>();
        for(int i = column+numColumns; i< CSVData.size();i+=numColumns){
            columnData.add((double)(Integer.parseInt(CSVData.get(i))));
        }
        return columnData;
    }
}
