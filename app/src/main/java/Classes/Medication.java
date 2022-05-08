package Classes;

public class Medication {
    String medicationName;

    public Medication(String medicationName) {
        this.medicationName = medicationName;
    }



    public Medication(){}

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }
}
