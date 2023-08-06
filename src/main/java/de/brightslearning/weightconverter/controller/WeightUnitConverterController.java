package de.brightslearning.weightconverter.controller;

import de.brightslearning.weightconverter.model.DataTransferObject;
import de.brightslearning.weightconverter.model.Unit;
import de.brightslearning.weightconverter.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
public class WeightUnitConverterController {

    private final ApplicationContext context;

    private final ConverterService service;

    @Autowired
    public WeightUnitConverterController(ApplicationContext context, ConverterService service) {
        this.context = context;
        this.service = service;
    }

    @GetMapping(value = "/")
    public String index(@ModelAttribute("result") DataTransferObject result, Model model, DataTransferObject dataTransferObject) {
        Map<String, Unit> units = (Map<String, Unit>) context.getBean("units");

        model.addAttribute("dataTransferObject", dataTransferObject);
        model.addAttribute("units", units);

        if (result != null) {
            model.addAttribute("result", result);
        }

        return "/index";
    }

    @PostMapping(value = "/convert")
    public String convert(@ModelAttribute DataTransferObject dataTransferObject, RedirectAttributes redirectAttributes) {
        DataTransferObject result = service.convert(dataTransferObject.getFrom(), dataTransferObject.getTo(), dataTransferObject.getValue());

        redirectAttributes.addFlashAttribute("result", result);
        return "redirect:/";
    }
}
