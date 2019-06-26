package it.ictgroup.accounts.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account extends PanacheEntityBase {

    @Id
    public String uuid;
    public String number;
    public String nickname;


    public Account() {
    }

    public Account(String uuid, String number, String nickname) {
        this.uuid = uuid;
        this.number = number;
        this.nickname = nickname;
    }
}
