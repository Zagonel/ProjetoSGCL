package main;

import Utilitario.Teclado;
import classes.Funcionario;
import classes.Horista;
import classes.Supervisor;

public class Home {

    //limitado para 5 funcionarios
    public static Funcionario funcionariosCadastrados[] = new Funcionario[5];

    public static int menuprincipal() {
        System.out.println("|--------------------Menu-----------------------|");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Pesquisar");
        System.out.println("3 - Sair \n");

        int opcao = Teclado.leInt("Digite uma opção : ");
        return opcao;
    }

    public static void cadastrarFuncionario() {
        System.out.println("--------------------Cadastrar-----------------------");
        System.out.println("1 - Funcionario Horista");
        System.out.println("2 - Funcionario Supervisor");
        System.out.println("3 - Voltar\n");

        int opcao = Teclado.leInt("Digite uma opcao: ");

        switch (opcao) {
            case 1:
                Horista f1 = new Horista();
                f1.setCpf(Teclado.leString("Digite o CPF : "));
                System.out.println("\n");
                f1.setNome(Teclado.leString("Digite o Nome : "));
                System.out.println("\n");
                f1.setId(Teclado.leString("Digite o ID : "));
                System.out.println("\n");
                double aux2 = Teclado.leDouble("Digite o salario base : ");
                System.out.println("\n");
                f1.setSalario(aux2);
                int aux = Teclado.leInt("Digite a quantidade de horas trabalhadas : ");
                System.out.println("\n");
                f1.setHorasTrabalhadas(aux);
                f1.calculaSalario(aux2, aux);

                for (int i = 0; i < 5; i++) {
                    if (funcionariosCadastrados[i] == null) {
                        funcionariosCadastrados[i] = f1;
                        menuprincipal();
                    }
                }
                break;

            case 2:
                Supervisor f2 = new Supervisor();
                f2.setCpf(Teclado.leString("Digite o CPF : "));
                System.out.println("\n");
                f2.setNome(Teclado.leString("Digite o Nome : "));
                System.out.println("\n");
                f2.setId(Teclado.leString("Digite o ID : "));
                System.out.println("\n");
                double aux3 = Teclado.leDouble("Digite o salario base : ");
                System.out.println("\n");
                f2.setSalario(aux3);
                int aux1 = Teclado.leInt("Digite a Bonificação do supervisor : ");
                System.out.println("\n");
                f2.setBonus(aux1);
                f2.calculaSalario(aux3, aux1);

                for (int i = 0; i < 5; i++) {
                    if (funcionariosCadastrados[i] == null) {
                        funcionariosCadastrados[i] = f2;
                        menuprincipal();
                    }
                }
                break;
            case 3:
                menuprincipal();
                break;
            default:
                System.out.println("Opção invalida");
                cadastrarFuncionario();

        }

    }

    public static void buscaFuncionario() {

        System.out.println("--------------------Pesquisar-----------------------");
        System.out.println("1 - CPF");
        System.out.println("2 - Identificador");

        int opcao = Teclado.leInt("Digite uma opção : ");

        switch (opcao) {
            case 1:
                String cpf = Teclado.leString("Digite o cpf a ser procurado: ");
                for (int i = 0; i < 5; i++) {
                    if (funcionariosCadastrados[i].getCpf().equals(cpf) && funcionariosCadastrados[i] != null) {
                        System.out.println(funcionariosCadastrados[i]);
                    } else {
                        System.out.println("Nao foi encontrado !!!!!");
                    }
                }
                break;
            case 2:
                String id = Teclado.leString("Digite o id a ser procurado: ");
                for (int i = 0; i < 5; i++) {
                    if (funcionariosCadastrados[i].getId().equals(id) && funcionariosCadastrados[i] != null) {
                        System.out.println(funcionariosCadastrados[i]);
                    } else {
                        System.out.println("Nao foi encontrado !!!!!");
                    }
                }
                break;
            default:
                System.out.println("Opção invalida");
                buscaFuncionario();
        }

    }

    public static void main(String[] args) {
        switch (menuprincipal()) {
            case 1:
                cadastrarFuncionario();
                break;
            case 2:
                buscaFuncionario();
                break;
            case 3:
                System.exit(0);
        }

    }

}
