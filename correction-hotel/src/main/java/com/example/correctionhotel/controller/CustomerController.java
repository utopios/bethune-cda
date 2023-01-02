package com.example.correctionhotel.controller;

import com.example.correctionhotel.service.CustomerService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService _customerService;

    @GetMapping("")
    public ModelAndView get() throws Exception {
        ModelAndView mv = new ModelAndView("customers");
        mv.addObject("customers", _customerService.getAllCustomers());
        return mv;
    }

    @PostMapping("/submitForm")
    public ModelAndView post(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phone, HttpServletResponse response) throws Exception {
        try {
            _customerService.create(firstName, lastName, phone);
            response.sendRedirect("/customer");
            return null;
        }catch (Exception ex) {
            ModelAndView mv = new ModelAndView("customers");
            mv.addObject("customers", _customerService.getAllCustomers());
            mv.addObject("messageError", ex.getMessage());
            return mv;
        }
    }
}
