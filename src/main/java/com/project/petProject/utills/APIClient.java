package com.project.petProject.utills;

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.util.Base64;

import static com.project.petProject.constants.Path.PATH_PROPERTY;
import static com.project.petProject.utills.FileHelper.getParamFromProperties;

public class APIClient {

    public static Content sendPostRequest(String json, String endPoint) {

        Content postResult = null;
        try {
            postResult = Request.Post(endPoint)
                    .bodyString(json, ContentType.APPLICATION_JSON)
                    .setHeader("Authorization",
                            getBasicAuthenticationHeader
                                    (getParamFromProperties(PATH_PROPERTY.getPath(), "jira.login"),
                                            getParamFromProperties(PATH_PROPERTY.getPath(), "jira.password"))
                    )
                    .execute().returnContent();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return postResult;
    }

    private static String getBasicAuthenticationHeader(String username, String password) {
        String valueToEncode = username + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }
}