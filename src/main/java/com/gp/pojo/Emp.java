package com.gp.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "emp")
@Getter
@Setter
@ToString
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String type;
    String name;
    String sex;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @Column(name = "entry_time")
    Date entryTime;
    String description;

}
