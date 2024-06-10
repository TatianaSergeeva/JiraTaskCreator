package com.project.petProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.io.IOException;
import java.util.Base64;


public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String path = "src/main/resources/test.yaml";
        URL endPoint = new URL("https://tanyushkadurneva15.atlassian.net/rest/api/3/issue");
        Epic epic = parseYamlToObject(path);

        for (Task task : epic.getTaskList()) {
            JsonFormatter jsonFormatter = new JsonFormatter();
            Fields fields = new Fields();
            fields.setSummary(task.getNameTask());
            Project project = new Project();
            project.setKey(epic.getTitle());
            Issuetype issuetype = new Issuetype();
            issuetype.setName("Task");
            fields.setProject(project);
            fields.setIssuetype(issuetype);
            jsonFormatter.setFields(fields);

            parseObjToJson(jsonFormatter);
            sendJsonToEndPoint(parseObjToJson(jsonFormatter), endPoint);
        }
    }


    public static Epic parseYamlToObject(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Epic test = mapper.readValue(new File(path), Epic.class);
        System.out.println(test.toString());
        return test;
    }

    public static String parseObjToJson(JsonFormatter test) throws IOException {
        String serialized = new ObjectMapper().writeValueAsString(test);
        System.out.println(serialized);
        return serialized;
    }

    public static void sendJsonToEndPoint(String json, URL endPoint) throws IOException, URISyntaxException {

        final Content postResult = Request.Post(endPoint.toURI())
                .bodyString(json, ContentType.APPLICATION_JSON)
                .setHeader("Authorization", getBasicAuthenticationHeader("tanyushkadurneva15@gmail.com",
                        "ATATT3xFfGF09zQGLENJXmxxjg7Qmu8WjLiyJXC2L6jpelnYjUIkhicUGyeXA4QNy81HbiWTt_8tx_gSEzPlnzulev7JszRH-7BhVI7XZFGZVqkvJp4Q2fIwCmBffTJnH-nBObx-nxit5Ghd_bCmTg5JB1XmvNAALcRqkiGKf6I_HTJPSkBprQQ=D4C74F29"))
                .execute().returnContent();
        System.out.println(postResult.asString());
    }

    private static final String getBasicAuthenticationHeader(String username, String password) {
        String valueToEncode = username + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }


}
