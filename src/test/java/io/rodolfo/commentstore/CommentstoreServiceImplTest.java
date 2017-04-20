package io.rodolfo.commentstore;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import io.rodolfo.commentstore.model.CommentModel;
import io.rodolfo.commentstore.service.CommentModelRepository;
import io.rodolfo.commentstore.service.CommentService;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class CommentstoreServiceImplTest {
    
    @Autowired
    private CommentModelRepository repository;

    @Autowired
    private CommentService service;

    private CommentModel model;

    @Before
    public void setup() {
        model = new CommentModel();
        model.setUsername("testuser");
        model.setId("kj12h3kj1h2k3j123");
        model.setPageId("product12345");
        model.setEmailAddress("example@example.org");
        model.setComment("Simple comment yeah!");
        repository.deleteAll();
    }
    
    @Test
    public void testPutAndGet() throws IOException {
        service.put(model);

        CommentModel dbModel = service.get(model.getId());
        assertNotNull(dbModel);
        assertEquals(model.getComment(), dbModel.getComment());
        assertEquals(model.getId(), dbModel.getId());
        assertEquals(model.getPageId(), dbModel.getPageId());
        assertEquals(model.getUsername(), dbModel.getUsername());
        assertEquals(model.getEmailAddress(), dbModel.getEmailAddress());

        assertNotNull(dbModel.getLastModificationDate());
        assertNotNull(dbModel.getCreationDate());
        assertFalse(model.isSpam());
    }

    @Test
    public void testListNotFound() throws IOException {
        service.put(model);
        List<CommentModel> r = service.list("aaaaaaaa123");
        assertTrue(null == r);
    }

    @Test
    public void testList() throws IOException {
        service.put(model);
        List<CommentModel> r = service.list(model.getPageId());
        assertNotNull(r);
        assertEquals(1, r.size());
        assertEquals(model.getId(), r.get(0).getId());
    }   
}

