package dao.cliente;

import entidade.Cliente;
import java.io.File;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class TestRAFClienteDAO {

    /**
     * Testa se o arquivo não existe.
     *
     */
    @Test
    public void testAbrirArquivo() {
        RAFClienteDAO rafclientedao = new RAFClienteDAO();
        assertFalse(rafclientedao.abrirArquivo("tes\\te//.txt"));
    }

    /**
     * Testa uma inclusão de cliente em arquivo inexistente no RAF.
     */
    @Test
    public void testInclusaoRAF() {
        String NOMEARQUIVO = "cliente.dat";

        Cliente cliente = new Cliente("-1", "Cliente Existente", "11111111111");

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        rafClienteDAO.fecharArquivo();

        //Apaga o arquivo para gerar exceção
        File file = new File(NOMEARQUIVO);
        file.delete();

        assertFalse(rafClienteDAO.inserir(cliente));
    }

    /**
     * Testa o getLista em arquivo inexistente no RAF.
     */
    @Test
    public void testGetListaRAF() {
        String NOMEARQUIVO = "cliente.dat";

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        rafClienteDAO.fecharArquivo();

        //Apaga o arquivo para gerar exceção
        File file = new File(NOMEARQUIVO);
        file.delete();

        //Consulta
        List lista = rafClienteDAO.getLista();
        System.out.println("lista.size():" + lista.size());

        assertEquals(0, lista.size());
    }

    /**
     * Testa a consulta com filtro clienteid em RAF inexistente.
     */
    @Test
    public void testAplicarFiltroClienteIdRAF() {
        Cliente cliente = new Cliente("131", "", "");
        String NOMEARQUIVO = "cliente.dat";

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        rafClienteDAO.fecharArquivo();

        //Apaga o arquivo para gerar exceção
        File file = new File(NOMEARQUIVO);
        file.delete();

        //Consulta
        List lista = rafClienteDAO.aplicarFiltro(cliente);

        assertEquals(0, lista.size());
    }

    /**
     * Testa a consulta com filtro nome em RAF inexistente.
     */
    @Test
    public void testAplicarFiltroNomeRAF() {
        Cliente cliente = new Cliente("", "Nome", "");
        String NOMEARQUIVO = "cliente.dat";

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        rafClienteDAO.fecharArquivo();

        //Apaga o arquivo para gerar exceção
        File file = new File(NOMEARQUIVO);
        file.delete();

        //Consulta
        List lista = rafClienteDAO.aplicarFiltro(cliente);

        assertEquals(0, lista.size());
    }

    /**
     * Testa a consulta com filtro CPF em RAF inexistente.
     */
    @Test
    public void testAplicarFiltroCPFRAF() {
        Cliente cliente = new Cliente("", "", "111");
        String NOMEARQUIVO = "cliente.dat";

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        rafClienteDAO.fecharArquivo();

        //Apaga o arquivo para gerar exceção
        File file = new File(NOMEARQUIVO);
        file.delete();

        //Consulta
        List lista = rafClienteDAO.aplicarFiltro(cliente);

        assertEquals(0, lista.size());
    }
}
