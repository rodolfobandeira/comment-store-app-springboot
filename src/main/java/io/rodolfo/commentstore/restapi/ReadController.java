package io.rodolfo.commentstore.restapi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.rodolfo.commentstore.model.CommentModel;
import io.rodolfo.commentstore.model.commons.CommentDTO;
import io.rodolfo.commentstore.service.CommentService;

@RestController
public class ReadController {

    @Autowired
    private CommentService service;
    
    @RequestMapping(value = "/list/{id}")
    public List<CommentDTO> getComments(@PathVariable(value = "id") String pageId) throws IOException {
        List<CommentModel> r = service.list(pageId);
        
        
        if (null == r) {
            throw new FileNotFoundException("/list/" + pageId);
        }
        return transformToDTO(r);
    }
    
    @RequestMapping(value = "/listall")
    public List<CommentDTO> getAllComments() throws IOException {
        List<CommentModel> r = service.listAll();
        
        if (null == r) {
            throw new FileNotFoundException("/listall");
        }
        return transformToDTO(r);
    }
    
    private List<CommentDTO> transformToDTO(List<CommentModel> r) {
        List<CommentDTO> result = new LinkedList<CommentDTO>();

        for (CommentModel m : r) {
            CommentDTO dto = new CommentDTO();
            dto.setId(m.getId());
            dto.setUsername(m.getUsername());
            dto.setEmailAddress(m.getEmailAddress());
            dto.setComment(m.getComment());
            dto.setCreated(m.getCreationDate());
            result.add(dto);
        }
        return result;
    }
}

