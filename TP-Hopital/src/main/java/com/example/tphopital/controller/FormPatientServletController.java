package com.example.tphopital.controller;

import com.example.tphopital.repository.impl.PatientRepository;
import com.example.tphopital.service.PatientService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "PatientServletController", value = "/patient/formulaire")
public class FormPatientServletController extends HttpServlet {
    private PatientService patientService;
    public void init() {
        patientService = new PatientService(new PatientRepository());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/formulaire-patient.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String nss = request.getParameter("nss");
        String telephone = request.getParameter("telephone");
        String dateNaissance = request.getParameter("dateNaissance");
        String sexe = request.getParameter("sexe");
        String adresse = request.getParameter("adresse");
        //Verification des champs par le service
        try {
            patientService.add(nom, prenom, telephone, adresse, nss, dateNaissance, sexe);
            response.sendRedirect("/");
        }catch (Exception ex) {
            request.setAttribute("nom", nom);
            request.setAttribute("prenom", prenom);
            request.setAttribute("telephone", telephone);
            request.setAttribute("adresse", adresse);
            request.setAttribute("dateNaissance", dateNaissance);
            request.setAttribute("sexe", sexe);
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/formulaire-patient.jsp").forward(request,response);
        }
    }

    public  void destroy() {

    }
}
