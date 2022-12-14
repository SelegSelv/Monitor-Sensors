package com.monitorsensors.util;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class Methods {
    public void adminOrUser(UserDetails userDetails, Model model){
        String name=null;
        if (userDetails!=null) {
            name = userDetails.getUsername();
            if (name.equals("admin"))
                model.addAttribute("admin",name);
            else model.addAttribute("name",name);
        }

    }
}
