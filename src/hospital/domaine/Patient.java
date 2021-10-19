package hospital.domaine;


import hospital.exception.IllegalReportException;
import hospital.exception.PatientAtHospitalException;
import hospital.exception.PatientNotAtHospitalException;
import hospital.factory.StayCardFactory;
import hospital.factory.TrackingCardFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ferlicotdelbe on 23/10/15.
 */
public class Patient {

    protected String lastName;
    protected Long numSS;
    protected String address;
    protected Integer age;
    protected Map<Speciality, TrackingCard> trackingCards;
    protected StayCard stayCard;

    public Patient(String lastName, Long numSS, String address, Integer age) {
        this.lastName = lastName;
        this.numSS = numSS;
        this.address = address;
        this.age = age;
        this.trackingCards = new HashMap<>();
        this.stayCard = new NullStayCard(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;

        Patient patient = (Patient) o;

        return !(lastName != null ? !lastName.equals(patient.lastName) : patient.lastName != null) && !(numSS != null ? !numSS.equals(patient.numSS) : patient.numSS != null) && !(address != null ? !address.equals(patient.address) : patient.address != null) && !(age != null ? !age.equals(patient.age) : patient.age != null);

    }

    @Override
    public int hashCode() {
        int result = lastName != null ? lastName.hashCode() : 0;
        result = 31 * result + (numSS != null ? numSS.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    public String lastName() {
        return lastName;
    }

    /**
     * Destroy the "stayingCard" of the Patient = set the "stayingCard"  to null
     */
    public void destroyStayingCard() {
        StayCardFactory.current().destroy(this.stayCard);
        //TODO Export the reports of the StayCard into the TrackingCard
        stayCard = new NullStayCard(this);
    }

    /**
     * Print the stayCard (or not if null) and the reports made
     */
    public void visualizeCards() {
        this.stayCard.printConsultations();
    }

    /**
     * Print all the Reports of a TrackingCard
     *
     * @param speciality
     */
    public void printTrackingCardOf(Speciality speciality) {
        if (this.trackingCards.isEmpty() || this.trackingCards.get(speciality).getReports().isEmpty()) {
            System.out.println(lastName + " n'a aucun compte rendu pour la spécialité " + speciality + ".");
        } else {
            Set<Report> reports = trackingCards.get(speciality).getReports();
            reports.forEach(hospital.domaine.Report::printReport);
        }
    }

    /**
     * TODO
     *
     * @return
     */
    public boolean isAtTheHospital() {
        return this.stayCard.isAtHospital();
    }

    /**
     * TODO
     *
     * @param speciality
     * @param report
     */
    public void addReportFor(Speciality speciality, Report report) throws IllegalReportException, PatientNotAtHospitalException {
        this.stayCard.addReportToSpeciality(speciality, report);
        this.trackingCards.get(speciality).addReport(report);
    }

    public void needConsultationFor(Speciality speciality) throws PatientNotAtHospitalException {
        this.trackingCards.putIfAbsent(speciality, TrackingCardFactory.current().newTrackingCard());
        this.stayCard.needConsultationFor(speciality);
    }

    /**
     * return a boolean, true if the patient need a speciality, else false.
     *
     * @return true if the patient need a speciality, else false.
     * @throws PatientNotAtHospitalException if the patient is not at the hospital.
     */
    public boolean stillNeedConsultation() throws PatientNotAtHospitalException {
        return this.stayCard.stillNeedConsultation();
    }

    public void printNextConsultation() {
        if (stayCard.specialityReportMap.size() == 0) {
            System.out.println("Le patient n'a aucune consultation.");
        } else {
            boolean noConsultationToVisit = true;
            for (Speciality s : stayCard.specialityReportMap.keySet()) {
                if (stayCard.specialityReportMap.get(s) == null) {
                    System.out.println("Prochaine consultation: " + s);
                    noConsultationToVisit = false;
                    break;
                }
            }
            if (noConsultationToVisit) {
                System.out.println("Le patient a terminé ses consultations.");
            }
        }
    }

    /**
     * Make the patient go to the hospital.
     *
     * @throws PatientAtHospitalException if the patient is already at the hospital.
     */
    public void goToHospital() throws PatientAtHospitalException {
        if (this.stayCard != null) {
            throw new PatientAtHospitalException(this);
        }
        this.stayCard = StayCardFactory.current().newStayCardFor(this);

    }

    /**
     * @param speciality
     * @return true is the speciality is already visited, else false
     */
    public boolean isSpecialityAlreadyVisited(Speciality speciality) {
        return (this.stayCard.specialityReportMap.get(speciality) != null);
    }

    /**
     * @param speciality
     * @return true if the speciality is needed, else false
     */
    public boolean isSpecialityNeeded(Speciality speciality) {
        return (this.stayCard.specialityReportMap.containsKey(speciality));
    }

}
