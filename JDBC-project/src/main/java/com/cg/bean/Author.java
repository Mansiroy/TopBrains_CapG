package com.cg.bean;

public class Author {
    private int authorId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNo;

    public Author(int authorId, String firstName, String middleName,
                  String lastName, String phoneNo) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
    }

    public int getAuthorId() { return authorId; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }
    public String getPhoneNo() { return phoneNo; }
}