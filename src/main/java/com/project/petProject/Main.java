package com.project.petProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Path;
import java.io.IOException;


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

    public static void sendJsonToEndPoint(String json, URL endPoint) throws IOException {
        HttpURLConnection con = (HttpURLConnection) endPoint.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = json.getBytes("utf-8");
            os.write(input, 0, input.length);
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }
        }
    }
}
