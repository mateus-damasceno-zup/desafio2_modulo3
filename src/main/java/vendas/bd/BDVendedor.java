package vendas.bd;

import vendas.Model.Vendedor;
import java.util.ArrayList;
import java.util.List;

public class BDVendedor {

    private List<Vendedor> listaVendedor = new ArrayList<>();

    public BDVendedor(){
        iniciarBancoVendedor();
    }


    public void iniciarBancoVendedor(){
        Vendedor vendedor = new Vendedor("gilberto","191","gilberto@email.com");
        Vendedor vendedor1 = new Vendedor("robalo","147","robalo@vendas.com");
        Vendedor vendedor2 = new Vendedor("Dulcato","910","dulcato@gema.com");
        Vendedor vendedor3 = new Vendedor("Claudio","777","cleber@bmail.com");
        Vendedor vendedor4 = new Vendedor("Hermes","666","hermes@hmail.com");
        adicionarVendedor(vendedor);
        adicionarVendedor(vendedor1);
        adicionarVendedor(vendedor2);
        adicionarVendedor(vendedor3);
        adicionarVendedor(vendedor4);
    }
    public void adicionarVendedor(Vendedor listaDeVendedor){
        this.listaVendedor.add(listaDeVendedor);
        System.out.println("vendedor adicionado");
    }

    public List<Vendedor> listaDeVendedores(){

        return new ArrayList<>(this.listaVendedor);
    }
    public boolean listaDeVendedoresJaExistente(String listaDeVendedores){
        for (Vendedor vendedor : this.listaVendedor) {
            if(listaDeVendedores.contains(vendedor.getCpf())){
                return true;
            }
        }
        return false;
    }

    public Vendedor retornarVendedor(String cpfVendedor) {
        for (Vendedor v : this.listaVendedor) {
            if(cpfVendedor.equalsIgnoreCase(v.getCpf())){
                String cpf = v.getCpf();
                String nome = v.getNome();
                String email= v.getEmail();
                Vendedor vendedor = new Vendedor();
                vendedor.setCpf(cpf);
                vendedor.setNome(nome);
                vendedor.setEmail(email);
                return vendedor;
            }
        }
        return null;
    }
}
