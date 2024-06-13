package com.project.petProject.utills;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.petProject.POJOClasses.jira.JsonFormatter;

import java.io.IOException;

public class JsonSerialize {

    public static String parseObjToJson(JsonFormatter test) throws IOException {
        return new ObjectMapper().writeValueAsString(test);
    }
}