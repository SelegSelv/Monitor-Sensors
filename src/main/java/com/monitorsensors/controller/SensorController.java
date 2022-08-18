package com.monitorsensors.controller;

import com.monitorsensors.dto.Range;
import com.monitorsensors.dto.SensorRequestDto;
import com.monitorsensors.dto.SensorResponseDto;
import com.monitorsensors.service.SensorService;
import com.monitorsensors.service.SensorTypeService;
import com.monitorsensors.service.SensorUnitService;
import com.monitorsensors.util.Methods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @Autowired
    private SensorTypeService sensorTypeService;
    @Autowired
    private SensorUnitService sensorUnitService;
    @Autowired
    private Methods methods;


    @GetMapping("/main")
    public String mainPage(Model model, @AuthenticationPrincipal UserDetails userDetails,HttpServletRequest request){
        methods.adminOrUser(userDetails, model);

        List<SensorResponseDto> allSensors = sensorService.getAllSensors();
        model.addAttribute("allSensors",allSensors);
        return "mainPage";
    }

    @GetMapping("/updateSensor")
    public String update(@RequestParam("sensorId")int id,Model model){
        model.addAttribute("type",sensorTypeService.getAllSensorType());
        model.addAttribute("unit",sensorUnitService.getAllSensorUnit());
        model.addAttribute("ID",id);
        if (id!=0){
            model.addAttribute("sensor",sensorService.getSensor(id));
            model.addAttribute("update","Редактировать");
            return "update";
        }
        model.addAttribute("create","Добавить");
        return "update";
    }
    @PostMapping("/updateSensor")
    public String postUpdate(@Valid @ModelAttribute("sensor")SensorRequestDto sensorRequestDto,
                             BindingResult bindingResult, Model model, HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        int from=0;
        int to=0;
        try {
            from=Integer.parseInt(request.getParameter("rangeFrom"));
            to=Integer.parseInt(request.getParameter("rangeTo"));
            if (from>to) throw new RuntimeException();
        }
        catch (NumberFormatException e){
            bindingResult.addError(new ObjectError(" ","У полей Range From и Range To должен быть тип int"));
        }
        catch (RuntimeException e1){
            bindingResult.addError(new ObjectError(" ","Поле Range From должно быть меньше Range To"));
        }
        if (bindingResult.hasErrors()){
            model.addAttribute("sensor",sensorRequestDto);
            model.addAttribute("create","Неправильные данные");
            model.addAttribute("type",sensorTypeService.getAllSensorType());
            model.addAttribute("unit",sensorUnitService.getAllSensorUnit());
            model.addAttribute("ID",id);

            List<ObjectError> allErrors = bindingResult.getAllErrors();
            List<String> allDefaultMess=allErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
            model.addAttribute("error",allDefaultMess);
            return "update";
        }

        Range range=new Range(from,to);
        sensorRequestDto.setId(id);
        sensorRequestDto.setFromTo(range);
        sensorService.saveOrUpdateSensor(sensorRequestDto);
        return "redirect:/main";
    }
    @GetMapping("/deleteSensor")
    public String delete(@RequestParam("sensorId") int id){
        sensorService.deleteSensor(id);
        return "redirect:/main";
    }

    @PostMapping("/searchLine")
    public String searchLine(HttpServletRequest request, @AuthenticationPrincipal UserDetails userDetails, Model model){
        methods.adminOrUser(userDetails, model);
        String search=request.getParameter("searchField");
        List<SensorResponseDto> allSensors=sensorService.searchForMatches(search);
        model.addAttribute("allSensors",allSensors);
        return "mainPage";
    }
}
