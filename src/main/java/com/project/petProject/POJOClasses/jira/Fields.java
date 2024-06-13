package com.project.petProject.POJOClasses.jira;

public class Fields {

    private Project projectObject;
    private String summary;
    private IssueType issueTypeObject;

    public Project getProject() {
        return projectObject;
    }

    public String getSummary() {
        return summary;
    }

    public IssueType getIssuetype() {
        return issueTypeObject;
    }

    public void setProject(Project projectObject) {
        this.projectObject = projectObject;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setIssuetype(IssueType issueTypeObject) {
        this.issueTypeObject = issueTypeObject;
    }
}