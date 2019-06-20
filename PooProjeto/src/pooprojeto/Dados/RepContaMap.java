package pooprojeto.Dados;

import java.util.HashMap;
import java.util.Map;
import pooprojeto.Modelo.ContaAbstrata;
import pooprojeto.IrepConta;

public class RepContaMap implements IrepConta {

    private Map<String, ContaAbstrata> hashMap;

    RepContaMap() {
        hashMap = new HashMap<String, ContaAbstrata>();
    }

    @Override
    public void inserir(ContaAbstrata conta) throws Exception {
        if (hashMap.containsKey(conta.getNumero())) {
            hashMap.put(conta.getNumero(), conta);
        } else {
            throw new Exception("Array cheio");
        }
    }

    @Override
    public void remover(String numero) throws Exception {
        if (hashMap.containsKey(numero)) {
            hashMap.remove(numero);
        } else {
            throw new Exception("Não existe");
        }
    }

    @Override
    public ContaAbstrata procurar(String numero) throws Exception {
        ContaAbstrata conta = null;
        conta = (ContaAbstrata) hashMap.get(numero);
        if (conta == null) {
            throw new Exception("não encontrado");
        }
        return conta;

    }

    @Override
    public void atualizar(ContaAbstrata conta) throws Exception {
        if (hashMap.containsKey(conta.getNumero())) {
            remover(conta.getNumero());
            inserir(conta);
        } else {
            throw new Exception("erro");
        }
    }

    @Override
    public boolean existe(String numero) throws Exception {
        return false;

    }

    @Override
    public int getTam() {
        return 0;

    }

    @Override
    public int procurarIndice(String cpf) throws Exception {
        return 0;

    }

}
