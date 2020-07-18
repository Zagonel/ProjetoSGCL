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
public class Supervisor extends Funcionario {

    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void calculaSalario(double salario, double bonus) {
        double aux = salario + bonus;
        super.calculaSalario(aux);
    }

    @Override
    public String toString() {
        return "Supervisor{" + "bonus=" + bonus + "nome=" + super.getNome() + ", cpf=" + getCpf() + ", salario=" + getSalario() + ", id=" + getId() + '}';
    }

}
