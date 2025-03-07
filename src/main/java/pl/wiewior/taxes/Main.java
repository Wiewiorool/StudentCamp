package pl.wiewior.taxes;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        TaxWay single = new SingleChildLess();
        TaxWay singleRelation = new InRelationshipChildLess();
        TaxWay relationChild = new InRelationshipHasChild();

        Citizen citizen = new Citizen(BigDecimal.valueOf(10000),"Adam","Smith",relationChild);
        System.out.println(citizen.calculateYearlyTax());

        Citizen citizen1 =  new Citizen.CitizenBuilder()
                .firstName("Joe")
                .lastName("Greg")
                .monthlySalary(BigDecimal.valueOf(5000))
                .taxWay(singleRelation)
                .build();

        System.out.println(citizen1.calculateYearlyTax());



    }
}