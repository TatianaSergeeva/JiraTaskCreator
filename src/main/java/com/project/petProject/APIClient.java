package com.project.petProject;

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Base64;
import java.util.Properties;

public class APIClient {

   static final String pathProperty = "src/main/resources/config.properties";

    public static Content sendPostRequest(String json, String endPoint) throws IOException, URISyntaxException {

        final Content postResult = Request.Post(endPoint.toString())
                .bodyString(json, ContentType.APPLICATION_JSON)
                .setHeader("Authorization", getBasicAuthenticationHeader(readLoginProperties(pathProperty),
                        readPasswordProperties(pathProperty)))
                .execute().returnContent();
        return postResult;
    }

    private static final String getBasicAuthenticationHeader(String username, String password) {
        String valueToEncode = username + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }

    private static String readLoginProperties(String pathProperty) {

        FileInputStream fis;
        Properties property = new Properties();

        String login = null;
        try {
            fis = new FileInputStream(pathProperty);
            property.load(fis);

            login = property.getProperty("jira.login");

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }

        return login;
    }

    private static String readPasswordProperties(String pathProperty) {

        FileInputStream fis;
        Properties property = new Properties();

        String password = null;
        try {
            fis = new FileInputStream(pathProperty);
            property.load(fis);

            password = property.getProperty("jira.password");

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }

        return password;
    }

    public static String readURLProperties(String pathProperty) {

        FileInputStream fis;
        Properties property = new Properties();

        String url = null;
        try {
            fis = new FileInputStream(pathProperty);
            property.load(fis);

            url = property.getProperty("jira.url");

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }

        return url;
    }

}
