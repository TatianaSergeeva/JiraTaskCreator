package com.project.petProject.POJOClasses;

public class Fields {
    Project ProjectObject;
    private String summary;
    Issuetype IssuetypeObject;

    public Project getProject() {
        return ProjectObject;
    }

    public String getSummary() {
        return summary;
    }

    public Issuetype getIssuetype() {
        return IssuetypeObject;
    }

    public void setProject(Project projectObject) {
        this.ProjectObject = projectObject;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setIssuetype(Issuetype issuetypeObject) {
        this.IssuetypeObject = issuetypeObject;
    }
}
