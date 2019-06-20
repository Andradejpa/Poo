package pooprojeto;

import java.io.IOException;
import pooprojeto.Modelo.Cliente;
import pooprojeto.Modelo.FacadeBanco;

public class PooProjeto {

    public static void main(String[] args) throws IOException, Exception {
        FacadeBanco fachada;
        try {

            fachada = FacadeBanco.getFachada();
            Cliente c = new Cliente();
            c.setCpf("09724885");
            c.setNome("Teste");

            fachada.inserirCliente(c);

        } catch (Exception e) {

        }

    }

}
