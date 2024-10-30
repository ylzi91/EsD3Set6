package YuriLenzi.EsD3Set6.services;

import YuriLenzi.EsSet6D2.entities.BlogPost;
import YuriLenzi.EsSet6D2.exceptions.NotFoundException;
import YuriLenzi.EsSet6D2.payloads.NuovoBlogPostPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogPostService {
    private List<BlogPost> blogPosts = new ArrayList<>();


    public List<BlogPost> trovaTutti() {
        return this.blogPosts;
    }

    public BlogPost saveBlogPost(NuovoBlogPostPayload body) {
        BlogPost newBlogPost = new BlogPost(body.getCategoria(), body.getTitolo(), body.getContenuto(), body.getTempoLettura());
        blogPosts.add(newBlogPost);
        return newBlogPost;
    }

    public BlogPost trovaConId(int blogPostId) {
        BlogPost found = null;
        for (BlogPost blogPost : blogPosts) {
            if (blogPost.getId() == blogPostId) {
                found = blogPost;
                break;
            }
        }
        if (found == null) throw new NotFoundException(blogPostId);
        return found;
    }

    public BlogPost trovaAggiorna(int blogPostId, NuovoBlogPostPayload body) {
        BlogPost found = null;
        if (trovaConId(blogPostId) != null) {
            found = trovaConId(blogPostId);
            if (body.getCategoria() != null)
                found.setCategoria(body.getCategoria());
            if (body.getTitolo() != null)
                found.setTitolo(body.getTitolo());
            if (body.getContenuto() != null)
                found.setContenuto(body.getContenuto());
            if (body.getTempoLettura() != null)
                found.setTempoLettura(body.getTempoLettura());

        }
        return found;
    }
}
