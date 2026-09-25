package br.dev.juniorlatalisa.quarkus.banking.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agencias")
public class Agencia {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String nome;

        @Column(name = "razao_social")
        private String razaoSocial;

        private String cnpj;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getRazaoSocial() {
                return razaoSocial;
        }

        public void setRazaoSocial(String razaoSocial) {
                this.razaoSocial = razaoSocial;
        }

        public String getCnpj() {
                return cnpj;
        }

        public void setCnpj(String cnpj) {
                this.cnpj = cnpj;
        }

        public Endereco getEndereco() {
                return endereco;
        }

        public void setEndereco(Endereco endereco) {
                this.endereco = endereco;
        }

        @Embedded
        private Endereco endereco;

}
