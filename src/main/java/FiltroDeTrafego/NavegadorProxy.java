package FiltroDeTrafego;

public class NavegadorProxy implements INavegador {

    private NavegadorReal navegador;

    @Override
    public String acessar(String url, Usuario usuario) {
        if (!usuario.isAcessoLivre() && RegrasFirewall.isBloqueado(url)) {
            throw new IllegalArgumentException("Acesso negado pelo Firewall: O site " + url + " está bloqueado.");
        }

        if (this.navegador == null) {
            this.navegador = new NavegadorReal();
        }

        return this.navegador.acessar(url, usuario);
    }

}
