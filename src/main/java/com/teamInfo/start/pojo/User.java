package com.teamInfo.start.pojo;

/**
 * @author jijngbao
 * @date 19-4-6
 */
public class User
{
    private String phone;
    private String name;
    private String psw;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public User(String phone, String name, String psw) {
        this.phone = phone;
        this.name = name;
        this.psw = psw;
    }
}
