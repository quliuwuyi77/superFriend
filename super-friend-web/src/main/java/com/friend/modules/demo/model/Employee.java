package com.friend.modules.demo.model;

public class Employee {

    private Integer id;

    private String name;

    private Integer shardingId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getShardingId() {
        return shardingId;
    }

    public void setShardingId(Integer shardingId) {
        this.shardingId = shardingId;
    }
}