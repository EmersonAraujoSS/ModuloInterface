package model.entities;

import java.time.LocalDateTime;

public class Invoice {  //INVOICE = fatura

    //ATRIBUTOS
    private Double basicPayment;
    private Double tax;


    //CONSTRUTORES
    public Invoice(){

    }

    public Invoice(Double basicPayment, Double tax) {
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    //METODOS
    public Double getTotalPayment(){
        return getBasicPayment() + getTax();
    }


    //METODOS ESPECIAIS
    public Double getBasicPayment() {
        return basicPayment;
    }
    public void setBasicPayment(Double basicPayment) {
        this.basicPayment = basicPayment;
    }
    public Double getTax() {
        return tax;
    }
    public void setTax(Double tax) {
        this.tax = tax;
    }

}

