package com.project.pp.parentparadise.ppmain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chungnan on 2017/12/27.
 */

public class Member {
    private int memer_no;
    private String acc_code;
    private String last_name;
    private String first_name;
    private String mb_sex;

    public Member() {

    }

    public Member(String idStr) {
        this.memer_no = 3;
        this.acc_code = "WANG.01";
        this.first_name = "大同";
        this.last_name = "王";
    }

    public Member(int memer_no) {
        if (memer_no == 1) {
            this.memer_no = 1;
            this.acc_code = "LIN.01";
            this.first_name = "小明";
            this.last_name = "林";
        }
        if (memer_no == 2) {
            this.memer_no = 2;
            this.acc_code = "LEE.66";
            this.first_name = "小華";
            this.last_name = "李";
        }
        if (memer_no == 3) {
            this.memer_no = 3;
            this.acc_code = "song";
            this.first_name = "宋";
            this.last_name = "仲基";
        }
    }


    public Member getMemberInfo(String accCode) {
        Member member = new Member();
        if (accCode.equals("LEE.66")) {
            member = new Member(2);
        }

        if (accCode.equals("WANG.01")) {
            member = new Member("WANG.01");
        }
        return member;
    }

    public List<Member> getFriends() {
        List<Member> friends = new ArrayList<Member>();
        Member friend1 = new Member(2);
        Member friend2 = new Member("WANG.01");
        friends.add(friend1);
        friends.add(friend2);
        return friends;
    }

    public int getMemer_no() {
        return memer_no;
    }

    public void setMemer_no(int memer_no) {
        this.memer_no = memer_no;
    }

    public String getAcc_code() {
        return acc_code;
    }

    public void setAcc_code(String acc_code) {
        this.acc_code = acc_code;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMb_sex() {
        return mb_sex;
    }

    public void setMb_sex(String mb_sex) {
        this.mb_sex = mb_sex;
    }
}
