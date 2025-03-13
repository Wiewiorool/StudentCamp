package pl.wiewior.taxes;


public class Officer {
    public Report getReport(Citizen citizen) {
        if(citizen!= null) {
            Report report = Report.builder()
                .citizenFirstName(citizen.getFirstName())
                .citizenLastName(citizen.getLastName())
                .yearlySalary(citizen.yearlySalary())
                .tax(citizen.calculateYearlyTax())
                .build();
            return report;
        } else {
            return null; // TODO - homework implement what to return if citizen was null + test
        }
    }

}
