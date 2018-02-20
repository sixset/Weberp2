package pl.dmdev.weberp.domain.model;

import javax.persistence.*;

@Entity
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String obiektName;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inspektor", nullable = false)
    private Employee employee;
    private String startData;
    private String endData;

    public Settlement() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObiektName() {
        return obiektName;
    }

    public void setObiektName(String obiektName) {
        this.obiektName = obiektName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getStartData() {
        return startData;
    }

    public void setStartData(String startData) {
        this.startData = startData;
    }

    public String getEndData() {
        return endData;
    }

    public void setEndData(String endData) {
        this.endData = endData;
    }
}
