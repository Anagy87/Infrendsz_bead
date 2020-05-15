package jjw34g.ire.entity;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "lakasok", schema = "jjw34g")
public class LakasokEntity {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "alapterulet", length = 25)
    private String alapterulet;

    @Basic
    @Column(name = "legter", length = 25)
    private String legter;

    @Basic
    @Column(name = "letrehozas_datuma")
    private Timestamp letrehozas_datuma;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private alapteruletkTypeEntity type;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private alapteruletkStatusEntity status;

    public alapteruletkEntity() {
    }

    public alapteruletkEntity(String alapterulet, String legter, Timestamp letrehozas_datuma, alapteruletkTypeEntity type, alapteruletkStatusEntity status) {
        this.alapterulet = alapterulet;
        this.legter = legter;
        this.letrehozas_datuma = letrehozas_datuma;
        this.type = type;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getalapterulet() {
        return alapterulet;
    }

    public void setalapterulet(String alapterulet) {
        this.alapterulet = alapterulet;
    }

    public String getlegter() {
        return legter;
    }

    public void setlegter(String legter) {
        this.legter = legter;
    }

    public Timestamp getletrehozas_datuma() {
        return letrehozas_datuma;
    }

    public void setletrehozas_datuma(Timestamp letrehozas_datuma) {
        this.letrehozas_datuma = letrehozas_datuma;
    }

    public alapteruletkTypeEntity getType() {
        return type;
    }

    public void setType(alapteruletkTypeEntity type) {
        this.type = type;
    }

    public alapteruletkStatusEntity getStatus() {
        return status;
    }

    public void setStatus(alapteruletkStatusEntity status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        alapteruletkEntity LakasokEntity = (alapteruletkEntity) o;
        return id == LakasokEntity.id &&
                alapterulet.equals(LakasokEntity.alapterulet) &&
                legter.equals(LakasokEntity.legter) &&
                letrehozas_datuma.equals(LakasokEntity.letrehozas_datuma) &&
                type == LakasokEntity.type &&
                status == LakasokEntity.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, alapterulet, legter, letrehozas_datuma, type, status);
    }

    @Override
    public String toString() {
        return "Lakasok{" +
                "id=" + id +
                ", alapterulet='" + alapterulet + '\'' +
                ", legter='" + legter + '\'' +
                ", letrehozas_datuma=" + letrehozas_datuma +
                ", type=" + type +
                ", status=" + status +
                '}';
    }
}