package io.rodolfo.commentstore.restapi;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.rodolfo.commentstore.model.CommentModel;
import io.rodolfo.commentstore.service.CommentService;

@Controller
public class WriteController {

    @Autowired
    private CommentService service;
    

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody String create(
            
        @RequestParam("comment") final String comment,
        @RequestParam("pageId") final String pageId,
        @RequestParam("emailAddress") final String email,
        @RequestParam("username") final String username
        
    ) throws IOException {
       
        CommentModel model = new CommentModel();
        
        model.setPageId(pageId);
        model.setEmailAddress(email);
        model.setComment(comment);
        model.setUsername(username);
        
        String id = service.put(model);
        
        return id;
    }
}
