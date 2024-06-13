package com.project.petProject;

import com.project.petProject.POJOClasses.jira.Fields;
import com.project.petProject.POJOClasses.jira.IssueType;
import com.project.petProject.POJOClasses.jira.JsonFormatter;
import com.project.petProject.POJOClasses.jira.Project;
import com.project.petProject.POJOClasses.yaml.YamlObject;
import com.project.petProject.POJOClasses.yaml.Task;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.project.petProject.utills.APIClient.*;
import static com.project.petProject.utills.FileHelper.getParamFromProperties;
import static com.project.petProject.utills.JsonSerialize.parseObjToJson;
import static com.project.petProject.utills.YamlParse.parseYamlToObject;
import static com.project.petProject.constants.Path.PATH_PROPERTY;


public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {

        String endPoint = getParamFromProperties(PATH_PROPERTY.getPath(), "jira.url");
        YamlObject yamlObject = parseYamlToObject(getParamFromProperties(PATH_PROPERTY.getPath(), "yaml.path"));

        for (Task task : yamlObject.getTaskList()) {
            JsonFormatter getPOJOToSerialize = getPojoObj(yamlObject, task);
            sendPostRequest(parseObjToJson(getPOJOToSerialize), endPoint);
        }
    }

    public static JsonFormatter getPojoObj(YamlObject yamlObject, Task task) {

        JsonFormatter jsonFormatter = new JsonFormatter();
        Fields fields = new Fields();
        Project project = new Project();
        IssueType issuetype = new IssueType();

        fields.setSummary(task.getNameTask());
        project.setKey(yamlObject.getTitle());
        issuetype.setName("Task");
        fields.setProject(project);
        fields.setIssuetype(issuetype);
        jsonFormatter.setFields(fields);

        return jsonFormatter;
    }
}