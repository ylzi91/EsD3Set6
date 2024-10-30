package YuriLenzi.EsD3Set6.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autori")
@Getter
@Setter
@NoArgsConstructor
public class Autore {
    @Id
    @GeneratedValue
    private long id;
    private String nome, cognome, email, avatar;
    private LocalDate dataNascita;
    @OneToMany(mappedBy = "autore")
    private List<BlogPost> blogPosts;

    public Autore(String nome, String cognome, String email, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.avatar = "https://ui-avatars.com/api/?name=" + nome + "+" + cognome;
        this.dataNascita = dataNascita;
    }
}
