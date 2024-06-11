package com.project.petProject;

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Base64;

public class APIClient {
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
