package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dto")
public class PersonDTOContrroller {

    public List<String> programingSkills(Model model){
            List<String> list = new ArrayList<String>();

        return list;
    }

}
