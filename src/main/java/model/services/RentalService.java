package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

import java.time.Duration;

public class RentalService { // Serviço de Locação

    //Atributos
    private Double pricePerHour;
    private Double pricePerDay;
    private TaxService taxService;


    //Construtor
    public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }


    //Metodo
    public void processInvoice(CarRental carRental){ //metodo para calcular a quantidade de horas com minutos
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes(); //Duration.between = serve para calcular a duração entre dois instantes
        double hours = minutes / 60;

        double basicPayment;
        if(hours <= 12.0){
            basicPayment = pricePerHour * Math.ceil(hours);  //Math.ceil = serve para arredondar as horas para cima
        }else {
            basicPayment = pricePerDay * Math.ceil(hours / 24.0);
        }

        double tax = taxService.taxService(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }


    //Metodos especiais
    public Double getPricePerHour() {
        return pricePerHour;
    }
    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
    public Double getPricePerDay() {
        return pricePerDay;
    }
    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
    public void setTaxService(BrasilTaxService taxService) {
        this.taxService = taxService;
    }
}
