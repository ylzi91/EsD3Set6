package YuriLenzi.EsD3Set6.controllers;


import YuriLenzi.EsD3Set6.entities.BlogPost;
import YuriLenzi.EsD3Set6.payloads.NuovoBlogPostPayload;
import YuriLenzi.EsD3Set6.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BlogPostController {

    @Autowired
    BlogPostService blogPostService;

    @GetMapping("/blogposts")
    public Page<BlogPost> vediTuttiIBlogPost(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return blogPostService.trovaTutti(page, size);
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
