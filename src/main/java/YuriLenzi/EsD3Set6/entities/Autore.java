package YuriLenzi.EsD3Set6.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "autori")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Autore {
    @Id
    @GeneratedValue
    private long id;
    private String nome, cognome, email, avatar;
    private LocalDate dataNascita;

    public Autore(String nome, String cognome, String email, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.avatar = "https://ui-avatars.com/api/?name=" + nome + "+" + cognome;
        this.dataNascita = dataNascita;
    }
}
