package by.seledtsovaos.departure.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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


    @Autowired
    @Qualifier("passengerFormValidator")
    private Validator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        List<PassengerDto> passengers = passengerService.getAll();
        model.addAttribute("passengers", passengers);
        setAttributeFlightToPage(model);
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
        setAttributeFlightToPage(model);
        return "add_passenger";
    }

    @GetMapping("/update")
    public String updatePassengerPage(@RequestParam("id") Long id, PassengerDto passengerDto, Model model) {
        model.addAttribute("passengerDto", passengerService.findById(id));
        setAttributeFlightToPage(model);
        return "update_passenger";
    }

    @PostMapping("/add")
    public String addUpdatePassenger(@ModelAttribute("passengerDto")
    @Valid PassengerDto passengerDto, BindingResult bindingResult, Model model) {
        setAttributeFlightToPage(model);
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

    private void setAttributeFlightToPage(Model model) {
        model.addAttribute("flights", flightService.getAll());
    }
}
