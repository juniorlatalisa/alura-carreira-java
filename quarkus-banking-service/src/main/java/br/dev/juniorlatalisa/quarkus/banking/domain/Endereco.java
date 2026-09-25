package br.dev.juniorlatalisa.quarkus.banking.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {

        private String rua;
        private String logradouro;
        private String complemento;
        private Integer numero;

        public String getRua() {
                return rua;
        }

        public void setRua(String rua) {
                this.rua = rua;
        }

        public String getLogradouro() {
                return logradouro;
        }

        public void setLogradouro(String logradouro) {
                this.logradouro = logradouro;
        }

        public String getComplemento() {
                return complemento;
        }

        public void setComplemento(String complemento) {
                this.complemento = complemento;
        }

        public Integer getNumero() {
                return numero;
        }

        public void setNumero(Integer numero) {
                this.numero = numero;
        }

}
