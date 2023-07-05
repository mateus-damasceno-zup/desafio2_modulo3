package vendas;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        VendasController vendasController = new VendasController();
        Cliente cliente;
        Vendedor vendedor;
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("digite uma das opçoes abaixo");
            System.out.println("" +
                    "1- adicionar uma venda ao banco" +
                    "\n2- listar vendas" +
                    "\n3- excluir venda" +
                    "\n4- listar clientes" +
                    "\n5- cadastrar clientes" +
                    "\n6- listar Vendedores" +
                    "\n7- cadastrar Vendedores" +
                    "\n8- lista vendas do cliente" +
                    "\n9- lista vendas por vendedor" +
                    "\n-1 para sair");




            opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> {
                    sc.nextLine();
                    System.out.println("=======Cadastro de vendas===============");
                    System.out.println("digite o cpf do cliente");
                    String cpfCliente = sc.nextLine();
                    Cliente clienteEncontrado = vendasController.buscaCliente(cpfCliente);
                    System.out.println("digite o cpf do vendedor");
                    String cpfVendedor = sc.nextLine();
                    Vendedor vendedorEncontrado = vendasController.buscaVendedor(cpfVendedor);
                    System.out.println("digite o valor da compra");
                    double valor = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("digite a data da compra");
                    String data = sc.nextLine();
                    Vendas vendas = new Vendas(clienteEncontrado, vendedorEncontrado, valor, data);
                    vendasController.cadastrarVendas(vendas);
                }
                case 2 -> {
                    System.out.println("====HISTORICO DE VENDAS===========");
                    vendasController.listaDeVendas();
                }
                case 3 -> {
                    System.out.println("========Excluir uma venda=========");
                    System.out.println("digite o id da lista para excluir");
                    int idVenda = sc.nextInt();
                    vendasController.excluirListaDeVendas(idVenda);
                }
                case 4 -> {
                    System.out.println("========lista de clientes=========");
                    vendasController.listaClientes();
                }
                case 5 -> {
                    sc.nextLine();
                    System.out.println("=======cadastro de cliente=======");
                    System.out.println("digite o nome do cliente");
                    String nomeCliente = sc.nextLine();
                    System.out.println("digite o cpf do cliente");
                    String cpfCliente = sc.nextLine();
                    String cpfClienteVerificado = vendasController.validaCPFCliente(cpfCliente);
                    System.out.println("digite o email do cliente");
                    String emailCliente = sc.nextLine();
                    String emailClienteVerificado = vendasController.validaEmailCliente(emailCliente);
                    cliente = new Cliente(nomeCliente, cpfClienteVerificado, emailClienteVerificado);
                    vendasController.cadastrarCliente(cliente);
                }
                case 6 -> {
                    System.out.println("=======lista de vendedores======");
                    vendasController.listaDeVendedores();
                }
                case 7 -> {
                    sc.nextLine();
                    System.out.println("=======cadastro de vendedores=======");
                    System.out.println("digite o nome do vendedor");
                    String nomeVendedor = sc.nextLine();
                    System.out.println("digite o cpf do vendedor");
                    String cpfVendedor = sc.nextLine();
                    String cpfVendedorValidado = vendasController.validaCPFVendedor(cpfVendedor);
                    System.out.println("digite o email do vendedor");
                    String emailVendedor = sc.nextLine();
                    String emailVendedorValidado = vendasController.validaEmailVendedor(emailVendedor);
                    vendedor = new Vendedor(nomeVendedor, cpfVendedorValidado, emailVendedorValidado);
                    vendasController.cadastrarVendedor(vendedor);
                }
                case 8 -> {
                    sc.nextLine();
                    System.out.println("====busca venda por cpf======");
                    System.out.println("digite o cpf do cliente");
                    String cpfCliente = sc.nextLine();
                    System.out.println(vendasController.buscaVendaCliente(cpfCliente));
                }
                case 9 -> {
                    sc.nextLine();
                    System.out.println("====busca vendas por email do vendedor======");
                    System.out.println("digite o email do vendedor");
                    String emailVendedor = sc.nextLine();
                    System.out.println(vendasController.buscaVendaVendedor(emailVendedor));
                }
                default -> System.out.println("digite um valor valido");
            }
        } while (opcao != -1);
    }
}


