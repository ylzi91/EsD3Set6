package YuriLenzi.EsD3Set6.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "blogposts")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BlogPost {

    @Id
    @GeneratedValue
    private long id;
    private String categoria;
    private String titolo;
    private String immagine;
    private String contenuto;
    private Integer tempoLettura;
    @ManyToOne
    @JsonBackReference
    private Autore autore;

    public BlogPost(String categoria, String titolo, String contenuto, int tempoLettura, Autore autore) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempoLettura = tempoLettura;
        this.immagine = "https://fastly.picsum.photos/id/921/200/300";
        this.autore = autore;
    }

}
