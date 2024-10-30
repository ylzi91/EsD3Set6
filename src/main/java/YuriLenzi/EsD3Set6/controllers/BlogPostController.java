package YuriLenzi.EsD3Set6.controllers;

import YuriLenzi.EsSet6D2.entities.BlogPost;
import YuriLenzi.EsSet6D2.payloads.NuovoBlogPostPayload;
import YuriLenzi.EsSet6D2.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogPostController {

    @Autowired
    BlogPostService blogPostService;

    @GetMapping("/blogposts")
    public List<BlogPost> vediTuttiIBlogPost() {
        return blogPostService.trovaTutti();
    }

    @PostMapping("/blogposts")
    public BlogPost addBlogPost(@RequestBody NuovoBlogPostPayload body) {
        return blogPostService.saveBlogPost(body);
    }

    @GetMapping("blogposts/{blogpostid}")
    public BlogPost trovaBlogPostConId(@PathVariable int blogpostid) {
        return blogPostService.trovaConId(blogpostid);
    }

    @PutMapping("blogposts/{blogpostid}")
    public BlogPost trovaAggiorna(@PathVariable int blogpostid, @RequestBody NuovoBlogPostPayload body) {
        return blogPostService.trovaAggiorna(blogpostid, body);
    }


}
