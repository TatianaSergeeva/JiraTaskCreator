package com.project.petProject;

public class Fields {
    Project ProjectObject;
    private String summary;
    Issuetype IssuetypeObject;


    // Getter Methods

    public Project getProject() {
        return ProjectObject;
    }

    public String getSummary() {
        return summary;
    }

    public Issuetype getIssuetype() {
        return IssuetypeObject;
    }

    // Setter Methods

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
