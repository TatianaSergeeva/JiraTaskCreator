package com.project.petProject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.petProject.POJOClasses.Fields;
import com.project.petProject.POJOClasses.Issuetype;
import com.project.petProject.POJOClasses.JsonFormatter;
import com.project.petProject.POJOClasses.Project;
import com.project.petProject.SerializeClasses.Epic;
import com.project.petProject.SerializeClasses.Task;

import java.io.IOException;

public class JsonSerialize {

    public static JsonFormatter getPojoObj(Epic epic, Task task) {
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

        return jsonFormatter;
    }

    public static String parseObjToJson(JsonFormatter test) throws IOException {
        String serialized = new ObjectMapper().writeValueAsString(test);
        return serialized;
    }
}
