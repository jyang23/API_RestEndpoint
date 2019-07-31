package com.jy.template.Beans;

import javax.persistence.*;

@Entity
@Table(name="Data_Data")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String data;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataClass{" + "id=" + id + ", data='" + data + '\'' + '}';
    }

}
