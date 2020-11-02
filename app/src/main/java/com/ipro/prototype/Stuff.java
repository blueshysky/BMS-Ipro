package com.ipro.prototype;

public class Stuff {
    private String name;
    private String desc;
    private String location;

    public Stuff () {
        this.name = "fire hydrant";
        this.desc = "ID: 34561235";
        this.location = "Location: 5th floor";
    }
    public Stuff (String a, String b, String c ) {
        this.name = a;
        this.desc = b;
        this.location = c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
