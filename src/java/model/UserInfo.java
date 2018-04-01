/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author emsnguyen
 */
public class UserInfo implements IModel {
    private User user;
    private String nickname;
    private String aboutMe;
    private Date birthDate;
    private String work;
    private String address;
    private boolean online;
    private boolean preferMale;
    private boolean gender;
    private String avatarLink;

    public UserInfo(User user, String nickname, String aboutMe, Date birthDate, String work, String address, boolean online, boolean preferMale, boolean gender, String avatarLink) {
        this.user = user;
        this.nickname = nickname;
        this.aboutMe = aboutMe;
        this.birthDate = birthDate;
        this.work = work;
        this.address = address;
        this.online = online;
        this.preferMale = preferMale;
        this.gender = gender;
        this.avatarLink = avatarLink;
    }

    public UserInfo(User user, String nickname, String aboutMe, Date birthDate, String work, String address, boolean online, boolean preferMale) {
        this.user = user;
        this.nickname = nickname;
        this.aboutMe = aboutMe;
        this.birthDate = birthDate;
        this.work = work;
        this.address = address;
        this.online = online;
        this.preferMale = preferMale;
    }
    
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isPreferMale() {
        return preferMale;
    }

    public void setPreferMale(boolean preferMale) {
        this.preferMale = preferMale;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
    }
    
}
