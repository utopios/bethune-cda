package com.example.correctionhotel.controller;

import com.example.correctionhotel.entity.Room;
import com.example.correctionhotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("rooms")
@ResponseBody
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("")
    public List<Room> get() {
        return roomRepository.findAll();
    }
}
