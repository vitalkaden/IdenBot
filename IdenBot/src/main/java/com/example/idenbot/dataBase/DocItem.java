package com.example.idenbot.dataBase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "idenValidDocTable")
public class DocItem {

    @Id
    @Column
    private String TZ;
    @Column
    private LocalDate greenCard;
    @Column
    private LocalDate whiteCert;
    @Column
    private LocalDate mytne;
    @Column
    private LocalDate teh;
    @Column
    private LocalDate cyvilka;
    @Column
    private LocalDate tacho;

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public DocItem() {

    }

    public DocItem(String TZ, String greenCard, String whiteCert, String mytne, String teh, String cyvilka, String tacho) {
        this.TZ = TZ;
        this.greenCard = greenCard.isEmpty() ? null : LocalDate.parse(greenCard,formatter);
        this.whiteCert = whiteCert.isEmpty() ? null : LocalDate.parse(whiteCert,formatter);
        this.mytne = mytne.isEmpty() ? null : LocalDate.parse(mytne,formatter);
        this.teh = teh.isEmpty() ? null : LocalDate.parse(teh,formatter);
        this.cyvilka = cyvilka.isEmpty() ? null : LocalDate.parse(cyvilka,formatter);
        this.tacho = tacho.isEmpty() ? null : LocalDate.parse(tacho,formatter);
    }

    public DocItem(String TZ) {
        this.TZ = TZ;
    }

    @Override
    public String toString() {
        return TZ + "\nЗеленка до - " + greenCard + "\n" +
                "Білий сертифікат до - " + whiteCert + "\n" +
                "Митне свідоцтво до - " + mytne + "\n" +
                "Технічний огляд до - " + teh + "\n" +
                "Цивтльне страхування до - " + cyvilka + "\n" +
                "Тахограф сертифікат до - " + tacho + "\n";
    }

    public LocalDate getGreenCard() {
        return greenCard;
    }

    public void setGreenCard(LocalDate greenCard) {
        this.greenCard = greenCard;
    }

    public LocalDate getWhiteCert() {
        return whiteCert;
    }

    public void setWhiteCert(LocalDate whiteSert) {
        this.whiteCert = whiteSert;
    }

    public LocalDate getMytne() {
        return mytne;
    }

    public void setMytne(LocalDate mytne) {
        this.mytne = mytne;
    }

    public LocalDate getTeh() {
        return teh;
    }

    public void setTeh(LocalDate teh) {
        this.teh = teh;
    }

    public LocalDate getCyvilka() {
        return cyvilka;
    }

    public void setCyvilka(LocalDate cyvilka) {
        this.cyvilka = cyvilka;
    }

    public LocalDate getTacho() {
        return tacho;
    }

    public void setTacho(LocalDate tacho) {
        this.tacho = tacho;
    }

    public String getTZ() {
        return TZ;
    }

    public void setTZ(String TZ) {
        this.TZ = TZ;
    }


}
