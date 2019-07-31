package com.jy.template;

import org.apache.commons.lang3.RandomStringUtils;
import com.jy.template.Beans.Data;
import com.jy.template.Configurations.UserService;
import com.jy.template.Repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    DataRepository dataRepository;

    private AtomicLong theId = new AtomicLong();

    ArrayList<Data> allData = new ArrayList<>();

    //------------------------------------------------------------------------------------------------------------------
    @RequestMapping("/")
    public String index(Model model)
    {
        model.addAttribute("datas",dataRepository.findAll());

        if(userService.getUser() != null)
        {
            model.addAttribute("user_id", userService.getUser().getId());
        }
        return "index";
    }

    //------------------------------------------------------------------------------------------------------------------
    @RequestMapping("/adddata")
    public String showdata(Model model)
    {
        if(userService.getUser() != null)
        {
            model.addAttribute("user_id", userService.getUser().getId());
        }
        Data moredata = new Data();
        long thisAtomicLong;
        moredata.setId(theId.incrementAndGet());
        moredata.setData("Another item "+RandomStringUtils.randomAlphabetic(3));
        allData.add(moredata);
        dataRepository.save(moredata);

        return "redirect:/";
    }
    //------------------------------------------------------------------------------------------------------------------
    @RequestMapping("/showdata")
    public @ResponseBody  ArrayList<Data> showAllData()
    {
//      Any authenticated user can come here
        return allData;
    }
}
