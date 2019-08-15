package com.example.wangy.demo.model;

import lombok.Data;

@Data
public class Location {
    private String id;
    private String desc;

    public Location(String id, String desc) {
        this.id = id;
        this.desc = desc;
    }
}
