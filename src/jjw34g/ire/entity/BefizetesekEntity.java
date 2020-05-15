package jjw34g.ire.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "befizetesek", schema = "jjw34g")
public class BefizetesekEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "who_paid")
    private LakasokEntity who_paid;

    @OneToOne
    @JoinColumn(name = "what_paid")
    private LakokEntity what_paid;

    @Basic
    @Column(name = "when_paid")
    private Timestamp when_paid;

    @Column(name = "when_stornoed")
    private Timestamp when_stornoed;

    @Column(name = "delayed_days")
    private int delayed_days;

    @Transient 
    private boolean isLate;

    @Transient
    private int late_payment_days;

    public BefizetesekEntity() {

    }

    public BefizetesekEntity(LakasokEntity who_paid, LakokEntity what_paid, Timestamp when_paid, Timestamp when_stornoed, int late_payment_days) {
        this.who_paid = who_paid;
        this.what_paid = what_paid;
        this.when_paid = when_paid;
        this.when_stornoed = when_stornoed;
        this.late_payment_days = late_payment_days;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LakasokEntity getWho_Paid() {
        return who_paid;
    }

    public void setWho_paid(LakasokEntity who_paid) {
        this.who_paid = who_paid;
    }

    public LakokEntity getWhat_Paid() {
        return what_paid;
    }

    public void setWhat_paid(LakokEntity what_paid) {
        this.what_paid = what_paid;
    }

    public Timestamp getWhen_paid() {
        return when_paid;
    }

    public void setWhen_paid(Timestamp when_paid) {
        this.when_paid = when_paid;
    }

    public Timestamp getwhen_stornoed() {
        return when_stornoed;
    }

    public void setwhen_stornoed(Timestamp when_stornoed) {
        this.when_stornoed = when_stornoed;
    }

    public int getlate_payment_days() {
        return late_payment_days;
    }

    public void setlate_payment_days(int late_payment_days) {
        this.late_payment_days = late_payment_days;
    }

    public boolean isLate() {
        return isLate;
    }

    public void setLate(boolean late) {
        isLate = late;
    }

    public int getLate_payment_days() {
        return late_payment_days;
    }

    public void setLate_payment_days(int late_payment_days) {
        this.late_payment_days = late_payment_days;
    }

    @Override
    public String toString() {
        return "Befizetesek{" +
                "id=" + id +
                ", who_paid=" + who_paid +
                ", what_paid=" + what_paid +
                ", when_paid=" + when_paid +
                ", when_stornoed=" + when_stornoed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BefizetesekEntity befizetesek = (BefizetesekEntity) o;
        return id == befizetesek.id &&
                who_paid.equals(befizetesek.who_paid) &&
                what_paid.equals(befizetesek.what_paid) &&
                when_paid.equals(befizetesek.when_paid) &&
                when_stornoed.equals(befizetesek.when_stornoed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, who_paid, what_paid, when_paid, when_stornoed);
    }
}
