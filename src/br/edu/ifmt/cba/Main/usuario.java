/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.Main;

/**
 *
 * @author igor_
 */
public class usuario {

        private String user;
        private String pass;
        private String Nome;
        private String CPF;
        private String Afiliacao;
        private String Departamento;
        private String Cargo;

        public int getCargaHoraria() {
            return cargaHoraria;
        }

        public void setCargaHoraria(int cargaHoraria) {
            this.cargaHoraria = cargaHoraria;
        }
        private int cargaHoraria;

        public String getUser() {
            return user;
        }

        public String getPass() {
            return pass;
        }

        public String getNome() {
            return Nome;
        }

        public String getCPF() {
            return CPF;
        }

        public String getAfiliacao() {
            return Afiliacao;
        }

        public String getDepartamento() {
            return Departamento;
        }

        public String getCargo() {
            return Cargo;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        public void setNome(String Nome) {
            this.Nome = Nome;
        }

        public void setCPF(String CPF) {
            this.CPF = CPF;
        }

        public void setAfiliacao(String Afiliacao) {
            this.Afiliacao = Afiliacao;
        }

        public void setDepartamento(String Departamento) {
            this.Departamento = Departamento;
        }

        public void setCargo(String Cargo) {
            this.Cargo = Cargo;
        }

    }
