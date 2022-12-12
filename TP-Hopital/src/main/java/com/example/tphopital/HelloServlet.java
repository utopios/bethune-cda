package com.example.tphopital;

import java.io.*;

import com.example.tphopital.entity.Patient;
import com.example.tphopital.entity.Prescription;
import com.example.tphopital.util.HibernateSession;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Patient patient = new Patient();
        patient.setNss("1 87 00000000000");
        patient.setNom("abadi");
        patient.setPrenom("Ihab");
        HibernateSession.getInstance().save(patient);
        HibernateSession.getInstance().close();
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}