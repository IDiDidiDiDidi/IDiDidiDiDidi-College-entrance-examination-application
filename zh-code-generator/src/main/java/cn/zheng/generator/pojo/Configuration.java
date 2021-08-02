package cn.zheng.generator.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author ZhengHe
 */
@Data
public class Configuration implements Serializable {
    private String author;
    private String packageName;
    private String packageMapperName;
    private Path path;
    private Db db;
    private String filePath;
    private String fileMapperPath ;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Db {
        private String url;
        private String username;
        private String password;
        private String driver;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Path {
        private String controller;
        private String service;
        private String interf;
        private String dao;
        private String entity;
        private String mapper;
        private String vo;
        private String dto;


    }

}
