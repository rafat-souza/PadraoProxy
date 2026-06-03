package Testes;

import FiltroDeTrafego.INavegador;
import FiltroDeTrafego.NavegadorProxy;
import FiltroDeTrafego.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NavegadorProxyTest {

    @Test
    void devePermitirAcessoSiteNaoBloqueadoParaUsuarioSemAcessoLivre() {
        Usuario usuario = new Usuario("João", false);
        INavegador navegador = new NavegadorProxy();

        String retorno = navegador.acessar("google.com", usuario);

        assertEquals("Página google.com carregada com sucesso para o usuário João.", retorno);
    }

    @Test
    void deveBloquearAcessoSiteBloqueadoParaUsuarioSemAcessoLivre() {
        Usuario usuario = new Usuario("Maria", false);
        INavegador navegador = new NavegadorProxy();

        Exception excecao = assertThrows(IllegalArgumentException.class, () -> {
            navegador.acessar("facebook.com", usuario);
        });

        assertEquals("Acesso negado pelo Firewall: O site facebook.com está bloqueado.", excecao.getMessage());
    }

    @Test
    void devePermitirAcessoSiteBloqueadoParaUsuarioComAcessoLivre() {
        Usuario usuario = new Usuario("Ana (Gerente)", true);
        INavegador navegador = new NavegadorProxy();

        String retorno = navegador.acessar("youtube.com", usuario);

        assertEquals("Página youtube.com carregada com sucesso para o usuário Ana (Gerente).", retorno);
    }

    @Test
    void devePermitirAcessoSiteNaoBloqueadoParaUsuarioComAcessoLivre() {
        Usuario usuario = new Usuario("Carlos (Diretor)", true);
        INavegador navegador = new NavegadorProxy();

        String retorno = navegador.acessar("uol.com.br", usuario);

        assertEquals("Página uol.com.br carregada com sucesso para o usuário Carlos (Diretor).", retorno);
    }

}
