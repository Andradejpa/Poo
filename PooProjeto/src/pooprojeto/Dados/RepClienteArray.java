package pooprojeto.Dados;

import pooprojeto.Modelo.Cliente;
import pooprojeto.IrepCliente;

public class RepClienteArray implements IrepCliente {

    private final int TAM = 100;
    private Cliente[] cliente;
    private int indice;
   

    public RepClienteArray() {
        cliente = new Cliente[TAM];
        indice = 0;
    }

    public void inserir(Cliente c) throws Exception {
        if (this.indice > 100) {
            throw new Exception("Vetor cheio");
        } else {
            this.cliente[indice] = c;
            this.indice++;
            
        }

    }

    public void remover(String cpf) throws Exception {
        if (existe(cpf)) {
            int i = this.procurarIndice(cpf);
            cliente[i] = cliente[indice - 1];
            cliente[indice - 1] = null;
            indice = indice - 1;
            this.indice--;
        } else {
            throw new Exception("Cliente nao encontrado");
        }

    }

    public void atualizar(Cliente c) throws Exception {
        int achado = procurarIndice(c.getCpf());
        if (achado != -1) {
            cliente[achado] = c;
        } else {
            throw new Exception("Cliente não encontrado");
        }

    }

    public Cliente procurar(String cpf) throws Exception {
        Cliente c = null;
        if (existe(cpf)) {
            int i = this.procurarIndice(cpf);
            c = cliente[i];
        } else {
            throw new Exception("Cliente nao encontrada");
        }
        return c;
    }

    public int procurarIndice(String cpf) {
        int i = 0;
        int aux = -1;
        for (Cliente c : cliente) {
            if (c.getCpf().equals(cpf)) {
                aux = i;
                break;
            }
            i++;
        }
        return aux;

    }

    public boolean existe(String cpf) {
        int i = this.procurarIndice(cpf);

        if (i != -1) {
            return true;
        }

        return false;
    }

    public int getTam() {
        return this.TAM;
    }

}
