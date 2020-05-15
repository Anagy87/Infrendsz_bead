package jjw34g.ire.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "lakok", schema = "jjw34g")
public class LakokEntity {


@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Basic //for not null constraint
@Column(name = "full_name", length = 50)
private String full_name;

@Basic
@Column(name = "tartozas", length = 11)
private String tartozas;

@Basic
@Column(name = "id_card_number", length = 8)
private String id_card_number;

@Basic
@Column(name = "home_address", length = 250)
private String home_address;

@Basic
@Column(name = "deleted_lako")
private boolean deleted_lako;

public LakasokEntity() {
}

public LakasokEntity(String full_name, String tartozas, String id_card_number, String home_address, boolean deleted_lako) {
    this.full_name = full_name;
    this.tartozas = tartozas;
    this.id_card_number = id_card_number;
    this.home_address = home_address;
    this.deleted_lako = deleted_lako;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getFull_name() {
    return full_name;
}

public void setFull_name(String full_name) {
    this.full_name = full_name;
}

public String gettartozas() {
    return tartozas;
}

public void settartozas(String tartozas) {
    this.tartozas = tartozas;
}

public String getId_card_number() {
    return id_card_number;
}

public void setId_card_number(String id_card_number) {
    this.id_card_number = id_card_number;
}

public String getHome_address() {
    return home_address;
}

public void setHome_address(String home_address) {
    this.home_address = home_address;
}

public boolean isdeleted_lako() {
    return deleted_lako;
}

public void setDeleted_Lakas(boolean deleted_lako) {
    this.deleted_lako = deleted_lako;
}

@Override
public String toString() {
    return "UsersEntity{" +
            "id=" + id +
            ", full_name='" + full_name + '\'' +
            ", tartozas=" + tartozas +
            ", id_card_number=" + id_card_number +
            ", home_address='" + home_address + '\'' +
            ", is_deleted_lako=" + deleted_lako +
            '}';
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LakasokEntity that = (LakasokEntity) o;
    return id == that.id &&
            tartozas == that.tartozas &&
            id_card_number == that.id_card_number &&
            deleted_lako == that.deleted_lako &&
            full_name.equals(that.full_name) &&
            home_address.equals(that.home_address);
}

@Override
public int hashCode() {
    return Objects.hash(id, full_name, tartozas, id_card_number, home_address, deleted_lako);
}
}

