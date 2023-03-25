package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Subject {
@Id
private int id;
private String name;
private String stream;
private String filePath;
}
