package com.project.petProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.*;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "src/main/resources/test.yaml";
        parseObjToJson(parseYamlToObject(path));
    }


    public static Epic parseYamlToObject(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Epic test = mapper.readValue(new File(path), Epic.class);
        System.out.println(test.toString());
        return test;
    }

    public static void parseObjToJson(Epic test) throws IOException {
        String serialized = new ObjectMapper().writeValueAsString(test);
        System.out.println(serialized);
    }
}
