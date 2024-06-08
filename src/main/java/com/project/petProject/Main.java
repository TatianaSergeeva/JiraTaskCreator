package com.project.petProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.http.auth.AuthOption;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Base64;


public class Main {
    public static void main(String[] args) throws IOException {
        String path = "src/main/resources/test.yaml";
        parseObjToJson(parseYamlToObject(path));

        URL endPoint = new URL("https://tanyushkadurneva15.atlassian.net/rest/api/3/issue");
        String json = "{\n" +
                "  \"fields\": {\n" +
                "    \"project\":\n" +
                "    {\n" +
                "        \"key\": \"PR\"\n" +
                "    },\n" +
                "    \"summary\": \"Java make this task\",\n" +
                "    \"issuetype\": {\n" +
                "        \"name\": \"Task\"\n" +
                "}\n" +
                "  }\n" +
                "}";
        sendJsonToEndPoint(json, endPoint);
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
