package anq10.controller;

import anq10.dto.PostDataDTO;
import anq10.model.Post;
import anq10.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.UnknownEntityException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostRepository postRepository;
    Logger logger = LoggerFactory.getLogger(PostController.class);


    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    public ResponseEntity<?> index() {
        logger.info("Getting all posts");
        return ResponseEntity.ok(postRepository.findAll());
    }

    @PostMapping("/")
    public void add(@ModelAttribute PostDataDTO post) throws UnknownEntityException {
        logger.info("Post" + post.getPid() + " is added!");
        Post newPost = Post.builder().author(post.getAuthor()).content(post.getContent()).build();
        postRepository.save(newPost);
    }

    @PostMapping("/{id}/delete")
    public void delete(@PathVariable String id) {
        logger.info("Post" + id + "is deleted");
        postRepository.delete(Long.valueOf(id));
    }

    @PostMapping("/{id}")
    public void update(@PathVariable String id, @ModelAttribute PostDataDTO post) {
        logger.info("Post " + id + "is updated!");
        Post newPost = Post.builder().author(post.getAuthor()).content(post.getContent()).build();
        postRepository.save(newPost);
    }
}
