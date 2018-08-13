package com.optica.controllers;

import com.optica.domain.ShortMessage;
import com.optica.entity.User;
import com.optica.services.ShortMessageService;
import com.optica.services.login.SecurityService;
import com.optica.util.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
public class SmsController {


    @Autowired
    private ShortMessageService shortMessageService;

    @Autowired
    private SecurityService securityService;

    String phoneNumberSender = "+18647547518";

    String indicative = "+57";

    @PostMapping("/app/sms/sendSms")
    public String sendSms(String sms, String phoneNumber) {
        User user = securityService.getCurrentUser();
        ShortMessage shortMessage = new ShortMessage();
        shortMessage.setUserId(user.getId());
        shortMessage.setCreation(LocalDate.now());
        shortMessage.setToNumber(phoneNumber);
        shortMessage.setMessage(sms);
        shortMessageService.createMessage(shortMessage);

       // SmsSender.sendSms(sms, indicative + phoneNumber, phoneNumberSender);

        return "redirect:/people";
    }

    @GetMapping("/app/sms/list")
    public String getSmsList(Model model) {
        User user = securityService.getCurrentUser();
        Page<ShortMessage> smsList = shortMessageService.getMessages(PageRequest.of(0, 10), user.getId());
        model.addAttribute("smsList",smsList.getContent());
        return "";
    }

}
