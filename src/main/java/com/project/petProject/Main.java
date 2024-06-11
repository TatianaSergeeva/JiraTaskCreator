package com.project.petProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.project.petProject.POJOClasses.Fields;
import com.project.petProject.POJOClasses.Issuetype;
import com.project.petProject.POJOClasses.JsonFormatter;
import com.project.petProject.POJOClasses.Project;
import com.project.petProject.SerializeClasses.Epic;
import com.project.petProject.SerializeClasses.Task;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.io.IOException;
import java.util.Base64;

import static com.project.petProject.APIClient.sendJsonToEndPoint;
import static com.project.petProject.JsonSerialize.getPojoObj;
import static com.project.petProject.JsonSerialize.parseObjToJson;
import static com.project.petProject.YamlParse.parseYamlToObject;


public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String path = "src/main/resources/test.yaml";
        URL endPoint = new URL("https://tanyushkadurneva15.atlassian.net/rest/api/3/issue");
        Epic epic = parseYamlToObject(path);

        for (Task task : epic.getTaskList()) {
            JsonFormatter getPOJOToSerialize = getPojoObj(epic, task);
            sendJsonToEndPoint(parseObjToJson(getPOJOToSerialize), endPoint);
        }
    }
}
