/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wEBTools;

import Exceptions.DALException;
import MySQLClasses.MySQLCitizenStorage;
import MySQLClasses.MySQLEducationStorage;
import MySQLClasses.MySQLSocialInsuranceStorage;
import education.*;
import insurance.SocialInsuranceRecord;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        this.totIns = this.citizen.getSocialInsuranceRecords().size() - 1;
        this.showCanUse = false;
    }

    public String webComposer(String cURL, String cPath) {
        String html = showButtonsBeforeCitizen(cURL, cPath) ;

        html += "<table border=\"1\"><tr><td style=\"text-align: center;\">";
            html +="<h3>Personal info</h3></td></tr><tr><td>";
        
        html += "<table border=\"1\"><tr><td>";
        String[] nameCols = new String[]{"id", "first name", "middle name", "last name",
            "height", "birth date", "gender"};
        String[] records = new String[]{String.valueOf(id), citizen.getFirstName(),
            citizen.getMiddleName(), citizen.getLastName(), String.valueOf(citizen.getHeight()),
            citizen.getDateOfBirth().format(DateTimeFormatter.ofPattern("d.M.u")),
            citizen.getGender().toString()};

        html += tableCompose(nameCols, records);
        html += "</td><td>";
        nameCols = new String[]{"country", "city", "municipality", "postal_code",
            "street", "number", "floor", "apartmentNo"};
        records = new String[]{citizen.getAddress().getCountry(), citizen.getAddress().getCity(),
            citizen.getAddress().getMunicipality(), citizen.getAddress().getPostalCode(),
            citizen.getAddress().getStreet(), citizen.getAddress().getNumber(),
            String.valueOf(citizen.getAddress().getFloor()),
            String.valueOf(citizen.getAddress().getApartmentNo())};
        html += tableCompose(nameCols, records) + "</td></tr></table>";
        html += "</td></tr></table>" ;
        

        if (this.citizen.getEducations().size() > 0) {
            html += "<table border=\"1\"><tr><td style=\"text-align: center;\">";
            html +="<h3>Educations</h3></td></tr><tr><td>";
            nameCols = new String[]{"type", "institution_name", "enrollment_date",
                "graduation_date", "graduated", "final_grade"};
            html += "<table border=\"1\"><tr><td>";
            for (int i = 0; i < this.citizen.getEducations().size(); i++) {
                if (i > 0) {
                    html += "</td><td>";
                }
                Education current = citizen.getEducations().get(i);
                String finalGrade = "";
                if (current.isGraduated() && !(current instanceof PrimaryEducation)) {
                    if (current instanceof SecondaryEducation) {
                        finalGrade = String.format("%.3f", ((SecondaryEducation) current).getFinalGrade());
                    } else {
                        finalGrade = String.format("%.3f", ((HigherEducation) current).getFinalGrade());
                    }
                }
                records = new String[]{current.getDegree().toString(), current.getInstitutionName(),
                    current.getEnrollmentDate().format(DateTimeFormatter.ofPattern("d.M.u")),
                    current.getGraduationDate().format(DateTimeFormatter.ofPattern("d.M.u")),
                    String.valueOf(current.isGraduated()), finalGrade};
                html += tableCompose(nameCols, records);
            }

            html += "</td></tr></table>";
            html += "</td></tr></table>" ;
        }
        
        
        
        html +=  showButtonsBeforeSIR(cURL);
        nameCols = new String[]{"year", "mount", "amount"};
        records = new String[]{String.valueOf(citizen.getSocialInsuranceRecords().get(numIns).getYear()),
            String.valueOf(citizen.getSocialInsuranceRecords().get(numIns).getMonth()),
            String.format("%.2f", citizen.getSocialInsuranceRecords().get(numIns).getAmount())};
        html += tableCompose(nameCols, records);
        return html;
    }

    private String showButtonsBeforeCitizen(String url, String path) {
        String showCanGetBenefits;
        if (this.showCanUse) {
            if (this.canUse) {
                showCanGetBenefits = this.canUseMsg + this.amountBenefit;
            } else {
                showCanGetBenefits = this.cantUseMsg;
            }
        } else {
            showCanGetBenefits = "<form name=\"checkCanUseSocBenefits\" action=\"" + url + "\" "
                    + "method=\"POST\" >\n<input "
                    + "type=\"submit\" value=\"checkCanUseSocBenefit\" "
                    + "name=\"checkCanUseSocBenefits\" /></form>";
        }
        return "<table border=\"1\">\n"
                + "            <tbody>\n"
                + "                <tr>\n"
                + "                    <td><form action=\"" + url + "\">"
                + "                            <input type=\"text\" name=\"idCitizen\" value=\"\" style=\" width: 50px;\"/>\n"
                + "                            <input type=\"submit\" value=\"GetCitizeFromInputedID\" name=\"getCitById\" />"
                + "                        </form>"
                + "                    </td>\n"
                + "                    <td>" + showCanGetBenefits + "</td>\n"
                + "                    <td><form name=\"newEducation\" action=\"" + path + "newEducation.jsp\">\n"
                + "                            <input type=\"submit\" value=\"newEducation\" name=\"newEducation\" />"
                + "                     </form></td>\n"
                + "                    <td><form name=\"newSIR\" action=\"" + path + "newSocialInsuranceRecord.jsp\" method=\"POST\" >\n"
                + "                            <input type=\"submit\" value=\"newSIR\" name=\"newSIR\" />"
                + "                        </form>"
                + "                    </td>\n"
                + "                </tr>\n"
                + "            </tbody>\n"
                + "        </table>";
    }

    private String showButtonsBeforeSIR(String url) {
        return "<form name=\"navigateSIR\" action=\"" + url + "\" method=\"POST\" >\n"
                + "            <input type=\"submit\" value=\"Prevois\" name=\"PrevoisSIR\" />\n"
                + "            <input type=\"submit\" value=\"next\" name=\"nextSIR\" /><br/>\n"
                + "            <input type=\"text\" name=\"goToSIRiD\" value=\"" + this.numIns + "\" style=\" width: 30px;\"/>\n"
                + "            <input type=\"submit\" value=\"goToSocInsRec\" name=\"goToSIR\" />\n"
                + "        </form>";
    }

    private String tableCompose(String[] names, String[] values) {
        String result = "<table border=\"2\">";
        for (int i = 0; i < names.length; i++) {
            result += "<tr><td style=\"text-align: right;background-color: rgb(190,190,190);\" >"
                    + names[i] + "</td><td>" + values[i] + "</td></tr>";
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

    public void goToSIR(int socInsRec) {
        if (socInsRec > this.totIns) {
            socInsRec = this.totIns;
        }
        if (socInsRec < 0) {
            socInsRec = 0;
        }
        this.numIns = socInsRec;
    }

    public void nextSIR() {
        goToSIR(numIns + 1);
    }

    public void prevoisSIR() {
        goToSIR(numIns - 1);
    }

    public void addSIR(SocialInsuranceRecord sIR) throws DALException {
        this.citizen.getSocialInsuranceRecords().add(sIR);
        this.totIns++;
        MySQLSocialInsuranceStorage dbClass = new MySQLSocialInsuranceStorage();
        dbClass.putInsuranceInDB(sIR, this.id);
    }

    public boolean addSIR(String[] sirData) {
        int year;
        int month;
        double amount;
        SocialInsuranceRecord sir;
        if (sirData.length != 3) {
            return false;
        }
        try {
            year = Integer.parseInt(sirData[0]);
            month = Integer.parseInt(sirData[1]);
            amount = Double.parseDouble(sirData[2]);
            sir = new SocialInsuranceRecord(year, month, amount);
            addSIR(sir);
        } catch (NumberFormatException | DALException ex) {
            return false;
        }
        return true;
    }

    public void addEducation(Education education) throws DALException {
        this.citizen.getEducations().add(education);
        MySQLEducationStorage dbClass = new MySQLEducationStorage();
        dbClass.putEducationInDB(education, this.id);
    }

    public boolean addEducation(String[] eduData) {

        if (eduData.length != 10) {
            return false;
        }
        if (!eduData[8].equals("ON") && !eduData[8].equals("OFF")) {
            return false;
        }
        boolean graduated = eduData[8].equals("ON");
        if (!eduData[0].equals("Primary") && !eduData[0].equals("Secondary") && !eduData[0].equals("Bachelor")
                && !eduData[0].equals("Master") && !eduData[0].equals("Doctorate")) {
            return false;
        }
        EducationDegree degree = EducationDegree.valueOf(eduData[0]);
        Pattern regex = Pattern.compile("(drop)|(delete)|(=)|(')|(;)(or)|(table)");
        Matcher matcher = regex.matcher(eduData[1].toLowerCase());
        if (matcher.find()) {
            return false;
        }
        String institutionName = eduData[1];
        LocalDate enrollmentDate, graduationDate;
        float finalGrade;
        try {
            enrollmentDate = LocalDate.of(Integer.parseInt(eduData[2]), Integer.parseInt(eduData[3]),
                    Integer.parseInt(eduData[4]));
            graduationDate = LocalDate.of(Integer.parseInt(eduData[5]), Integer.parseInt(eduData[6]),
                    Integer.parseInt(eduData[7]));
            finalGrade = 0;
            if (degree != EducationDegree.Primary && graduated && graduationDate.compareTo(LocalDate.now()) <= 0) {
                finalGrade = Float.parseFloat(eduData[9]);
            }
        } catch (DateTimeException | NumberFormatException ex) {
            return false;
        }
        Education edu;
        if (degree.equals(EducationDegree.Primary)) {
            edu = new PrimaryEducation(institutionName,
                    enrollmentDate, graduationDate);
            if (graduationDate.compareTo(LocalDate.now()) < 0 && graduated) {
                ((PrimaryEducation) edu).gotGraduated();
            }
        } else if (degree.equals(EducationDegree.Secondary)) {
            edu = new SecondaryEducation(institutionName, enrollmentDate, graduationDate);
            if (graduationDate.compareTo(LocalDate.now()) < 0 && graduated) {
                ((SecondaryEducation) edu).gotGraduated(finalGrade);
            }
        } else {
            edu = new HigherEducation(institutionName, enrollmentDate, graduationDate, degree);
            if (graduationDate.compareTo(LocalDate.now()) < 0 && graduated) {
                ((HigherEducation) edu).gotGraduated(finalGrade);
            }
        }
        try {
            this.addEducation(edu);
        } catch (DALException ex) {
            return false;
        }
        return true;
    }
}
