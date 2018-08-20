package com.example.acac;

public class Photo {
    private int id;
    private String source;
    private int accidentID;

    public Photo(int id, String source, int accidentID) {
        this.id = id;
        this.source = source;
        this.accidentID = accidentID;
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
}
