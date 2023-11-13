package com.example.idenbot.dataBase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserItem {

    @Id
    @Column
    private long chatId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private boolean subscribtion;

    @Override
    public String toString() {
        return "UserItem{" +
                "chatId=" + chatId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", subscribtion=" + subscribtion +
                '}';
    }

    public UserItem() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chat_id) {
        this.chatId = chat_id;
    }

    public boolean isSubscribtion() {
        return subscribtion;
    }

    public void setSubscribtion(boolean subscription) {
        this.subscribtion = subscription;
    }

    public UserItem(String firstName, String lastName, long chatId,boolean subscription) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.chatId = chatId;
        this.subscribtion = subscription;
    }
}
