/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author igor_
 */
public class Horista extends Funcionario {

    private int horasTrabalhadas;

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public void calculaSalario(double salario, int horasTrabalhadas) {
        double aux = (salario * horasTrabalhadas / salario);
        super.calculaSalario(aux);
    }

    @Override
    public String toString() {
        return "Horista{" + "horasTrabalhadas=" + horasTrabalhadas + '}';
    }

}
