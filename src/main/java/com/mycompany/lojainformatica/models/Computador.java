
package com.mycompany.lojainformatica.models;

public class Computador {

    private Integer id;
    private static String marca = "Diana Lina Emidio";
    private String hd;
    private String processador;

    // Construtor vazio
    public Computador() {
    }

    //construtores
    public Computador(String hd, String processador) {
        this.hd = hd;
        this.processador = processador;
        this.marca = marca;
    }

    public Computador(Integer id, String hd, String processador) {
        this.id = id;
        this.hd = hd;
        this.processador = processador;
        this.marca = marca;
    }

    // Getter e Setter para o atributo ID
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter e Setter para o atributo HD
    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    // Getter e Setter para o atributo Processador
    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    // Getter para o atributo marca (como é estático, não tem Setter)
    public static String getMarca() {
        return marca;
    }

    public String getIdComputador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
