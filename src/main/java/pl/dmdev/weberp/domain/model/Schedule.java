package pl.dmdev.weberp.domain.model;

import javax.persistence.*;
import java.util.List;

//@Entity
public class Schedule {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id",updatable = false,nullable = false)
    private int id;
    private String mounth;
    private String year;
    private String sendtime;
    private String edittime;
//    private String

    private Object object;

    private Inspector inspector;

    private Employee employee;


}
