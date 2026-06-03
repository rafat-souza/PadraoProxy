package FiltroDeTrafego;

public class NavegadorReal implements INavegador {

    public NavegadorReal() {
    }

    @Override
    public String acessar(String url, Usuario usuario) {
        return "Página " + url + " carregada com sucesso para o usuário " + usuario.getNome() + ".";
    }

}
