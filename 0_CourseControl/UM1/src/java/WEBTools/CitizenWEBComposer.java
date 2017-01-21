/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBTools;

import Exceptions.DALException;
import MySQLClasses.MySQLCitizenStorage;
import education.*;
import insurance.SocialInsuranceRecord;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import personaldetails.Citizen;

/**
 *
 * @author stanislav
 */
public class CitizenWEBComposer implements Serializable {

    Citizen citizen;
    int id;
    int total;
    int numIns, totIns;
    final String canUseMsg = "Can use social benefits amounting to ";
    final String cantUseMsg = "Can't use social benefits!";
    boolean showCanUse, canUse;
    float amountBenefit;

    public CitizenWEBComposer(int id) throws DALException {
        this.id = id;
        MySQLCitizenStorage storage = new MySQLCitizenStorage();
        this.citizen = storage.getCitizenById(id);
        this.total = storage.getCitizensCount();
        this.numIns = 0;
        this.totIns = this.citizen.getSocialInsuranceRecords().size();
        this.showCanUse = false;
    }

    public String webComposer(int education, int insRec) {
        String html = showButtonsBeforeCitizen() + "<br/><br/>";
        String[] nameCols = new String[]{"id", "first name", "middle name", "last name",
            "height", "birth date", "gender"};
        String[] records = new String[]{String.valueOf(id), citizen.getFirstName(),
            citizen.getMiddleName(), citizen.getLastName(), String.valueOf(citizen.getHeight()),
            citizen.getDateOfBirth().format(DateTimeFormatter.ofPattern("d.M.u")),
            citizen.getGender().toString()};

        html += tableCompose(nameCols, records);

        nameCols = new String[]{"country", "city", "municipality", "postal_code",
            "street", "number", "floor", "apartmentNo"};
        records = new String[]{citizen.getAddress().getCountry(), citizen.getAddress().getCity(),
            citizen.getAddress().getMunicipality(), citizen.getAddress().getPostalCode(),
            citizen.getAddress().getStreet(), citizen.getAddress().getNumber(),
            String.valueOf(citizen.getAddress().getFloor()),
            String.valueOf(citizen.getAddress().getApartmentNo())};

        html += tableCompose(nameCols, records) + "<br/><br/><br/>";
        nameCols = new String[]{"type", "institution_name", "enrollment_date",
            "graduation_date", "graduated", "final_grade"};

        for (int i = 0; i < this.citizen.getEducations().size(); i++) {
            Education current = citizen.getEducations().get(education);
            String finalGrade = "";
            if (current.isGraduated() && !(current instanceof PrimaryEducation)) {
                finalGrade = String.format("%.3f", ((SecondaryEducation) current).getFinalGrade());
            }
            records = new String[]{current.getDegree().toString(), current.getInstitutionName(),
                current.getEnrollmentDate().format(DateTimeFormatter.ofPattern("d.M.u")),
                current.getGraduationDate().format(DateTimeFormatter.ofPattern("d.M.u")),
                String.valueOf(current.isGraduated()), finalGrade};
            html += tableCompose(nameCols, records);
        }

        html += "<br/><br/><br/>";

        nameCols = new String[]{"year", "mount", "amount"};
        records = new String[]{String.valueOf(citizen.getSocialInsuranceRecords().get(insRec).getYear()),
            String.valueOf(citizen.getSocialInsuranceRecords().get(insRec).getMonth()),
            String.format("%.2f", citizen.getSocialInsuranceRecords().get(insRec).getAmount())};
        html += tableCompose(nameCols, records);
        return html;
    }

    private String showButtonsBeforeCitizen() {
        String showCanGetBenefits;
        if (this.showCanUse) {
            if (this.canUse) {
                showCanGetBenefits = this.canUseMsg + this.amountBenefit;
            } else {
                showCanGetBenefits = this.cantUseMsg;
            }
        } else {
            showCanGetBenefits = "<form name=\"checkCanUseSocBenefits\" action=\"newjsp.jsp\" "
                    + "method=\"POST\" enctype=\"multipart/form-data\">\n<input "
                    + "type=\"submit\" value=\"checkCanUseSocBenefit\" "
                    + "name=\"checkCanUseSocBenefits\" /></form>";
        }

        return "<table border=\"1\">\n"
                + "            <tbody>\n"
                + "                <tr>\n"
                + "                    <td><form action=\"newjsp.jsp\"><input type=\"text\" name=\"id\" value=\"00\" />\n"
                + "                            <input type=\"submit\" value=\"GetCitizeFromInputedID\" name=\"getCitById\" /></form></td>\n"
                + "                    <td>"+showCanGetBenefits+"</td>\n"
                + "                    <td><form name=\"newEducation\" action=\"newEducation.jsp\">\n"
                + "                            <input type=\"submit\" value=\"newEducation\" name=\"newEducation\" /></form></td>\n"
                + "                    <td><form name=\"newSIR\" action=\"newSocialInsuranceRecord.jsp\" method=\"POST\" enctype=\"multipart/form-data\">\n"
                + "                            <input type=\"submit\" value=\"newSIR\" name=\"newSIR\" /></form></td>\n"
                + "                </tr>\n"
                + "            </tbody>\n"
                + "        </table>";
    }

    private String tableCompose(String[] names, String[] values) {
        String result = "<table>";
        for (int i = 0; i < names.length; i++) {
            result += "<tr><td>" + names[i] + "</td><td>" + values[i] + "</td></tr>";
        }
        result += "</table>";
        return result;
    }

    public void checkCanUseSocBenefits() {
        boolean fl = false;
        for (Education edu : this.citizen.getEducations()) {
            if (edu instanceof SecondaryEducation && edu.isGraduated()) {
                fl = true;
                break;
            }
        }
        LocalDate compareDate = LocalDate.of(LocalDate.now().minusMonths(3).getYear(),
                LocalDate.now().minusMonths(3).getMonth(), 1);
        if (fl) {
            this.amountBenefit = 0;
            for (SocialInsuranceRecord sir : this.citizen.getSocialInsuranceRecords()) {
                if (LocalDate.of(sir.getYear(), sir.getMonth(), 1).compareTo(compareDate) >= 0) {
                    fl = false;
                    break;
                }
                if (LocalDate.of(sir.getYear(), sir.getMonth(), 1).compareTo(compareDate) < 0
                        && LocalDate.of(sir.getYear(), sir.getMonth(), 1).compareTo(compareDate.minusYears(2)) >= 0) {
                    this.amountBenefit += sir.getAmount();
                }
            }
            this.amountBenefit /= 24;
        }
        this.showCanUse = true;
        this.canUse = fl;
    }

}
