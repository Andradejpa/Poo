package pooprojeto.Dados;

import pooprojeto.Modelo.ContaAbstrata;
import pooprojeto.IrepConta;

public class RepContaArray implements IrepConta {

    private final int TAM = 100;
    private ContaAbstrata[] contas;
    private int indice;

    public RepContaArray() {
        contas = new ContaAbstrata[TAM];
        indice = 0;
    }

    public void inserir(ContaAbstrata conta) throws Exception {
        if (this.indice > TAM) {
            throw new Exception("Array cheio");
        } else {
            this.contas[indice] = conta;
            this.indice++;

        }

    }

    public void remover(String numero) throws Exception {
        if (existe(numero)) {
            int i = this.procurarIndice(numero);
            contas[i] = contas[indice - 1];
            contas[indice - 1] = null;
            indice = indice - 1;
            this.indice--;
        } else {
            throw new Exception("Conta nao encontrada");
        }

    }

    public void atualizar(ContaAbstrata conta) throws Exception {
        int achado = procurarIndice(conta.getNumero());
        if (achado != -1) {
            contas[achado] = conta;
        } else {
            throw new Exception("Conta nao encontrada");
        }

    }

    public ContaAbstrata procurar(String num) throws Exception {
        ContaAbstrata conta = null;
        if (existe(num)) {
            int i = this.procurarIndice(num);
            conta = contas[i];
        } else {
            throw new Exception("Conta nao encontrada");
        }
        return conta;
    }

    public int procurarIndice(String numero) {
        int i = 0;
        int aux = -1;
        for (ContaAbstrata c : contas) {
            if (c.getNumero().equals(numero)) {
                aux = i;
                break;
            }
            i++;
        }
        return aux;

    }

    public boolean existe(String numero) {
        int i = this.procurarIndice(numero);

        if (i != -1) {
            return true;
        }

        return false;
    }

    public int getTam() {
        return this.TAM;
    }

}
