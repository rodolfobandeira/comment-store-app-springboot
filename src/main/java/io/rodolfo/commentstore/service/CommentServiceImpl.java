package io.rodolfo.commentstore.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import io.rodolfo.commentstore.model.CommentModel;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentModelRepository repository;
    
    @Override
    public CommentModel get(String id) {
        return repository.findOne(id);
    }

    @Override
    public String put(CommentModel model) throws IOException {
        if (StringUtils.isEmpty(model.getId())) {
            model.setId(UUID.randomUUID().toString());
        }
        
        final CommentModel dbModel = get(model.getId());
        if (null != dbModel) {
            dbModel.setUsername(model.getUsername());
            dbModel.setComment(model.getComment());
            dbModel.setLastModificationDate(Calendar.getInstance());
            repository.save(dbModel);
            
        } else {
            model.setCreationDate(Calendar.getInstance());
            model.setLastModificationDate(Calendar.getInstance());
            repository.save(model);
        }
        
        return model.getId();
    }

    @Override
    public List<CommentModel> list(String pageId) throws IOException {
        return repository.findByPageId(pageId);
    }
    
    @Override
    public List<CommentModel> listAll() throws IOException {
        return (List<CommentModel>) repository.findAll();
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }
}
