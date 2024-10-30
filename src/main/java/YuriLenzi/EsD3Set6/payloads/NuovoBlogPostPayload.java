package YuriLenzi.EsD3Set6.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString

public class NuovoBlogPostPayload {
    private String categoria, titolo, contenuto;
    private Integer tempoLettura;
    private Long idAutore;
}
