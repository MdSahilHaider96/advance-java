package org.first.common.util;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaUtil {
    public static boolean validateField(String regex, String field) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(field);
        return m.matches();
    }
    public static void setJspPage(HttpServletRequest req, HttpServletResponse resp, String jspName) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(jspName);
        requestDispatcher.forward(req,resp);
    }
}
