package com.example.acac;

public class Photo {
    private int id;
    private String source;
    private int accidentID;
    private int memberID;
    private String Description;

    public Photo(String source, int accidentID, int memberID, String description) {

        this.source = source;
        this.accidentID = accidentID;
        this.memberID = memberID;
        Description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getAccidentID() {
        return accidentID;
    }

    public void setAccidentID(int accidentID) {
        this.accidentID = accidentID;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}

