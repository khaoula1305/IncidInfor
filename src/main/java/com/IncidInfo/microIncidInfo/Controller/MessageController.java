package com.IncidInfo.microIncidInfo.Controller;

import com.IncidInfo.microIncidInfo.dao.MessageRepository;
import com.IncidInfo.microIncidInfo.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MessageController {
   @Autowired
    private MessageRepository messageRepository;


    @RequestMapping(value="/messages/{id}/responses", method= RequestMethod.PUT)
    public Message addResponse(@PathVariable Long id, @RequestBody Message message1) {
        Optional<Message> message;
        message = messageRepository.findById(id);
     //   java.util.Set<java.lang.String> responses=message.get().getResponses();
     //   responses.add(message1.)
        messageRepository.save(message1);
        //messageRepository.addResponse(message1.getResponses());
        System.out.println("hey hey");
        return message1;
    }
    @RequestMapping(value="/messages/{id}/read", method= RequestMethod.PUT)
    public void readMessage(@PathVariable("id") Long id, @RequestBody Message message1) {
        messageRepository.save(message1);
        System.out.println("hey hey");
    }
/*    @RequestMapping(value="/messages/{id}/parent", method= RequestMethod.PUT)
    public void addParent(@PathVariable("id") Long id, @RequestBody Message message1) {
        message1.setParent(messageRepository.findById(id).get());
        messageRepository.save(message1);
        messageRepository.save(messageRepository.findById(id).get());
        System.out.println("hey hey");
    }*/

}
