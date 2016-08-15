package com.brauliomendez.realm.model;

import io.realm.RealmObject;

/**
 * @author Braulio Méndez Jiménez
 * @since 14/08/16
 */
public class Subject extends RealmObject{

    private String mId;
    private String mTeacher;
    private String mAssistant;
    private String mHour;
    private String mClassroom;

    public String getId() { return mId; }

    public void setId(String id) { this.mId = id; }

    public String getTeacher() { return mTeacher; }

    public void setTeacher(String teacher) { this.mTeacher = teacher; }

    public String getAssistant() { return mAssistant; }

    public void setAssistant(String mAssistant) { this.mAssistant = mAssistant; }

    public String getHour() { return mHour; }

    public void setHour(String hour) { this.mHour = hour; }

    public String getClassroom() { return mClassroom; }

    public void setClassroom(String classroom) { this.mClassroom = classroom; }
}
