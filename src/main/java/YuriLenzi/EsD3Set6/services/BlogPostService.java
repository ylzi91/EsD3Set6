package YuriLenzi.EsD3Set6.services;


import YuriLenzi.EsD3Set6.entities.Autore;
import YuriLenzi.EsD3Set6.entities.BlogPost;
import YuriLenzi.EsD3Set6.exceptions.NotFoundException;
import YuriLenzi.EsD3Set6.payloads.NuovoBlogPostPayload;
import YuriLenzi.EsD3Set6.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogPostService {

    @Autowired
    BlogPostRepository blogPostRepository;
    @Autowired
    AutoreService autoreService;


    public Page<BlogPost> trovaTutti(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return blogPostRepository.findAll(pageable);
    }

    public BlogPost saveBlogPost(NuovoBlogPostPayload body) {
        Autore found = autoreService.findById(body.getIdAutore());
        BlogPost newBlogPost = new BlogPost(body.getCategoria(), body.getTitolo(), body.getContenuto(), body.getTempoLettura(), found);
        blogPostRepository.save(newBlogPost);
        return newBlogPost;
    }

    public BlogPost trovaConId(long blogPostId) {
        BlogPost found = null;
        found = blogPostRepository.findById(blogPostId).orElseThrow(() -> new NotFoundException(blogPostId));
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
