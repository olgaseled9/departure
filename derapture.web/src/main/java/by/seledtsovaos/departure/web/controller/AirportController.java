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

import by.seledtsovaos.departure.service.dto.AirportDto;
import by.seledtsovaos.departure.service.services.AirportService;
import by.seledtsovaos.departure.service.services.CountryService;

/**
 * Handles requests to do CRUD operation with {@link AirportDto}.
 */
@Controller
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/all")
    public String getAllAirports(Model model) {
        List<AirportDto> airports = airportService.getAll();
        model.addAttribute("airports", airports);
        return "all_airports";
    }

    @GetMapping("/remove")
    public String removeAirportById(@RequestParam("id") Long id) {
        if (id != null) {
            airportService.removeById(id);
        }
        return "redirect:/airport/all";
    }

    @GetMapping("/add")
    public String addAirportPage(AirportDto airportDto, Model model) {
        model.addAttribute("countries", countryService.getAll());
        return "add_airport";
    }

    @GetMapping("/update")
    public String updateAirportPage(@RequestParam("id") Long id, AirportDto airportDto, Model model) {
        airportDto = airportService.findById(id);
        model.addAttribute("airportDto", airportDto);
        model.addAttribute("countries", countryService.getAll());
        return "update_airport";
    }

    @PostMapping("/add")
    public String addUpdatePassenger(@ModelAttribute("airportDto")
    @Valid AirportDto airportDto, BindingResult bindingResult, Model model) {
        model.addAttribute("countries", countryService.getAll());
        if (!bindingResult.hasErrors()) {
            if (airportDto.isNew()) {
                airportService.add(airportDto);
            }
            else {
                airportService.update(airportDto);
            }
            return "redirect:/airport/all";
        }
        else {
            return "add_airport";
        }
    }
}
