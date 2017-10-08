package com.example.amor.csedu;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amor on 10/7/2017.
 */

public class CSVFile {
    private static final CSVFile instance = new CSVFile();
    static  CSVReader reader = null;
    private CSVFile() {}

    public static CSVFile getInstance()
    {
        return instance;
    }

    public static  List<String[]> readCSVFile()
    {
        List<String[]> l = new ArrayList<String[]>();
        CSVFile csvfile = CSVFile.getInstance();
        try {
            l = csvfile.reader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return l;
    }

}
