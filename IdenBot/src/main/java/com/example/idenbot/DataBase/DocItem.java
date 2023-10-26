package com.example.idenbot.DataBase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@Entity
//@Table(name = "idenValidDocTable")
public class DocItem {
    @Id
    @Column(name = "ТЗ")
    private Long TZ;
    @Column(name = "Зелений Сертифікат")
    private Date greenCard;
    @Column(name = "Білий сертифікат")
    private Date whiteSert;
    @Column(name = "Митне свідоцтво")
    private Date mytne;
    @Column(name = "Тех. Огляд")
    private Date teh;
    @Column(name = "Цивілка")
    private Date cyvilka;
    @Column(name = "Тахо сертифікат")
    private Date Tacho;

    public DocItem(Long TZ) {
        this.TZ = TZ;
    }

    @Override
    public String toString() {
        return String.valueOf(TZ);
    }

    public Date getGreenCard() {
        return greenCard;
    }

    public void setGreenCard(Date greenCard) {
        this.greenCard = greenCard;
    }

    public Date getWhiteSert() {
        return whiteSert;
    }

    public void setWhiteSert(Date whiteSert) {
        this.whiteSert = whiteSert;
    }

    public Date getMytne() {
        return mytne;
    }

    public void setMytne(Date mytne) {
        this.mytne = mytne;
    }

    public Date getTeh() {
        return teh;
    }

    public void setTeh(Date teh) {
        this.teh = teh;
    }

    public Date getCyvilka() {
        return cyvilka;
    }

    public void setCyvilka(Date cyvilka) {
        this.cyvilka = cyvilka;
    }

    public Date getTacho() {
        return Tacho;
    }

    public void setTacho(Date tacho) {
        Tacho = tacho;
    }

    public Long getTZ() {
        return TZ;
    }

    public void setTZ(Long TZ) {
        this.TZ = TZ;
    }


}
