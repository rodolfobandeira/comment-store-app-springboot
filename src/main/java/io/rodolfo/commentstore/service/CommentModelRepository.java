package io.rodolfo.commentstore.service;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import io.rodolfo.commentstore.model.CommentModel;

public interface CommentModelRepository extends CrudRepository<CommentModel, String>{
    List<CommentModel> findByPageId(String pageId);
    
    List<CommentModel> findByPageIdAndSpamIsTrue(String pageId);
}
