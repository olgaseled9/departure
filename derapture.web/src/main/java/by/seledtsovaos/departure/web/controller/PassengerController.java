package by.seledtsovaos.departure.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.seledtsovaos.departure.service.dto.PassengerDto;
import by.seledtsovaos.departure.service.services.FlightService;
import by.seledtsovaos.departure.service.services.PassengerService;

/**
 * Handles requests to do CRUD operation with {@link PassengerDto}.
 */
@Controller
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;
    @Autowired
    private FlightService flightService;

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        List<PassengerDto> passengers = passengerService.getAll();
        model.addAttribute("passengers", passengers);
        model.addAttribute("flights", flightService.getAll());
        return "all_passengers";
    }

    @GetMapping("/remove")
    public String removePassengerById(@RequestParam("id") Long id) {
        if (id != null) {
            passengerService.removeById(id);
        }
        return "redirect:/passenger/all";
    }

    @GetMapping("/add")
    public String addPassengerPage(PassengerDto passengerDto, Model model) {
        model.addAttribute("flights", flightService.getAll());
        return "add_passenger";
    }

    @GetMapping("/update")
    public String updatePassengerPage(@RequestParam("id") Long id, PassengerDto passengerDto, Model model) {
        passengerDto = passengerService.findById(id);
        model.addAttribute("passengerDto", passengerDto);
        model.addAttribute("flights", flightService.getAll());
        return "update_passenger";
    }

    @PostMapping("/add")
    public String addUpdatePassenger(@ModelAttribute("passengerDto")
    @Valid PassengerDto passengerDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (passengerDto.isNew()) {
                passengerService.add(passengerDto);
            }
            else {
                passengerService.update(passengerDto);
            }
            return "redirect:/passenger/all";
        }
        else {
            return "add_passenger";
        }
    }
}
