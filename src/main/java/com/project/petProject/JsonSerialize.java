package com.project.petProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.petProject.POJOClasses.JsonFormatter;

import java.io.IOException;

public class JsonSerialize {

    public static String parseObjToJson(JsonFormatter test) throws IOException {
        return new ObjectMapper().writeValueAsString(test);
    }
}
