package model.services;

public class BrasilTaxService implements TaxService {


    @Override
    public double taxService(double amount) {
        if(amount <= 100.00){
            return amount * 0.20;
        }
        else
            return amount * 0.15;
    }
}
