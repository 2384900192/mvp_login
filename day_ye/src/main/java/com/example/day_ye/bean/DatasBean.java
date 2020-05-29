package com.example.day_ye.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class DatasBean {
    @Id
    Long id_db;
    private String id;
    private String description;
    private String thumbnail;
    @Generated(hash = 326653042)
    public DatasBean(Long id_db, String id, String description, String thumbnail) {
        this.id_db = id_db;
        this.id = id;
        this.description = description;
        this.thumbnail = thumbnail;
    }
    @Generated(hash = 128729784)
    public DatasBean() {
    }
    public Long getId_db() {
        return this.id_db;
    }
    public void setId_db(Long id_db) {
        this.id_db = id_db;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getThumbnail() {
        return this.thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
