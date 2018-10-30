package com.baicai.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Music {
    private Integer id;
    private String name;
    private String singer;

    public Music() {
        super();
    }

    public Music(Integer id, String name, String singer) {
        this.id = id;
        this.name = name;
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", singer='" + singer + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    @XmlElement
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    @XmlElement
    public void setSinger(String singer) {
        this.singer = singer;
    }
}
