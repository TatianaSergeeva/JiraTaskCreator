package com.project.petProject;

import com.project.petProject.POJOClasses.Fields;
import com.project.petProject.POJOClasses.Issuetype;
import com.project.petProject.POJOClasses.JsonFormatter;
import com.project.petProject.POJOClasses.Project;
import com.project.petProject.SerializeClasses.Epic;
import com.project.petProject.SerializeClasses.Task;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import static com.project.petProject.APIClient.*;
import static com.project.petProject.JsonSerialize.parseObjToJson;
import static com.project.petProject.YamlParse.parseYamlToObject;


public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String path = "src/main/resources/test.yaml";
        String endPoint = readURLProperties(pathProperty);
        Epic epic = parseYamlToObject(path);


        for (Task task : epic.getTaskList()) {
            JsonFormatter getPOJOToSerialize = getPojoObj(epic, task);
            sendPostRequest(parseObjToJson(getPOJOToSerialize), endPoint);
        }
    }

    public static JsonFormatter getPojoObj(Epic epic, Task task) {
        JsonFormatter jsonFormatter = new JsonFormatter();
        Fields fields = new Fields();
        Project project = new Project();
        fields.setSummary(task.getNameTask());
        Issuetype issuetype = new Issuetype();
        project.setKey(epic.getTitle());
        issuetype.setName("Task");
        fields.setProject(project);
        fields.setIssuetype(issuetype);
        jsonFormatter.setFields(fields);

        return jsonFormatter;
    }
}
