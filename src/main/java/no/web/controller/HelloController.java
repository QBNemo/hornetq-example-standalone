package no.web.controller;

import no.web.jms.producer.JMSProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jms.JMSException;

@Controller
public class HelloController{

    @Autowired
    JMSProducer jMSProducer;

    @RequestMapping(value = "/hellohornet", method = RequestMethod.GET)
    public String printHello(ModelMap model) {

        String jmsMessage = null;

        try {
            jMSProducer.sendMessages();
        } catch (JMSException e) {
            e.printStackTrace();
        }

        try {
            jmsMessage = jMSProducer.receiveMessages();
        } catch (JMSException e) {
            e.printStackTrace();
        }

        model.addAttribute("message", jmsMessage);
        return "hello";
    }
}