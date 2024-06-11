package com.project.petProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.project.petProject.SerializeClasses.Epic;

import java.io.File;
import java.io.IOException;

public class YamlParse {

    public static Epic parseYamlToObject(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Epic test = mapper.readValue(new File(path), Epic.class);
        return test;
    }
}
