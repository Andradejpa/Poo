package pooprojeto;

public interface IrepG<T> {

    public void inserir(T object)throws Exception;

    public void remover(String numero)throws Exception;

    public T procurar(String numero)throws Exception;

    public void atualizar(T object)throws Exception;

    public boolean existe(String numero) throws Exception;

    public int getTam();

    public int procurarIndice(String cpf)throws Exception;
}
