package com.mobiusVision.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Author {

    //Author
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private Date birthdate;
    private String added;

    public Author(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long time = new Long(445555000);
        String str = format.format(time);
        try {
            Date date = format.parse(str);
        }catch (Exception e){}
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                ", added='" + added + '\'' +
                '}';
    }
}
