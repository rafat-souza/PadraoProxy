package FiltroDeTrafego;

public class Usuario {

    private String nome;
    private boolean acessoLivre;

    public Usuario(String nome, boolean acessoLivre) {
        this.nome = nome;
        this.acessoLivre = acessoLivre;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAcessoLivre() {
        return acessoLivre;
    }

    public void setAcessoLivre(boolean acessoLivre) {
        this.acessoLivre = acessoLivre;
    }

}
