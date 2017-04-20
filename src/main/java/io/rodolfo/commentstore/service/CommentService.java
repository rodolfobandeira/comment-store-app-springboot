package io.rodolfo.commentstore.service;

import java.io.IOException;
import java.util.List;

import io.rodolfo.commentstore.model.CommentModel;

public interface CommentService {

    String put(CommentModel model) throws IOException;
    
    List<CommentModel> list(String pageId) throws IOException;
    
    List<CommentModel> listAll() throws IOException;
    
    CommentModel get(String id);
        
    void delete(String id);
}
