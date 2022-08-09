package by.seledtsovaos.departure.web.controller;

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

import by.seledtsovaos.departure.service.dto.FlightDto;
import by.seledtsovaos.departure.service.services.AirportService;
import by.seledtsovaos.departure.service.services.CountryService;
import by.seledtsovaos.departure.service.services.FlightService;

/**
 * Handles requests to do CRUD operation with {@link FlightDto}.
 */
@Controller
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;
    @Autowired
    private AirportService airportService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/all")
    public String getAllFlights(Model model) {
        model.addAttribute("flights", flightService.getAll());
        model.addAttribute("airports", airportService.getAll());
        return "all_flights";
    }

    @GetMapping("/remove")
    public String removeFlightById(@RequestParam("id") Long id) {
        if (id != null) {
            flightService.removeById(id);
        }
        return "redirect:/flight/all";
    }

    @GetMapping("/add")
    public String addFlightPage(FlightDto flightDto, Model model) {
        setAttributeToFlightPage(model);
        return "add_flight";
    }

    @GetMapping("/update")
    public String updateAirportPage(@RequestParam("id") Long id, FlightDto flightDto, Model model) {
        flightDto = flightService.findById(id);
        model.addAttribute("flightDto", flightDto);
        setAttributeToFlightPage(model);
        return "update_flight";
    }

    @PostMapping("/add")
    public String addFlight(@ModelAttribute("flightDto")
    @Valid FlightDto flightDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (flightDto.isNew()) {
                flightService.add(flightDto);
            }
            else {
                flightService.update(flightDto);
            }
            return "redirect:/flight/all";
        }
        else {
            return "add_flight";
        }
    }

    private void setAttributeToFlightPage(Model model) {
        model.addAttribute("airports", airportService.getAll());
        model.addAttribute("countries", countryService.getAll());
    }
}
