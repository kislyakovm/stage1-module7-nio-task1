package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


public class FileReader {

    public Profile getDataFromFile(File file) {

        List<String> atrList = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(file.toPath())) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] str = line.split(" ");
                atrList.add(str[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Profile(atrList.get(0), Integer.parseInt(atrList.get(1)), atrList.get(2), Long.parseLong(atrList.get(3)));
    }
}
