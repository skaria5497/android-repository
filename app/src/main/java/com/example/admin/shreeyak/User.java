package com.example.admin.shreeyak;

public class User {

    private String userID;
    private String userfnm;
    private String userlnm;
    private String Userphn;

    public User(){}

    public User( String UserId,String userfnm, String userlnm, String userphn) {
        this.userID = userID;
        this.userfnm = userfnm;
        this.userlnm = userlnm;
        Userphn = userphn;
    }


    public String getUserID() {
        return userID;
    }

    public String getUserfnm() {
        return userfnm;
    }

    public String getUserlnm() {
        return userlnm;
    }

    public String getUserphn() {
        return Userphn;
    }
}
