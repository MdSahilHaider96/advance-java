package org.first.common.util;

public class Constants {
    public static final String NAME_REGEX = "^[A-Z](?=.{1,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$";
    public static final String EMAIL_REGEX = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
    public static final String NUMBER_REGEX =  "[0-9]+";
    public static final String PASSWORD_REGEX =  "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
    public static final String USER_2_CREATE = "/WEB-INF/jsps/user2/user2-create.jsp";

}
