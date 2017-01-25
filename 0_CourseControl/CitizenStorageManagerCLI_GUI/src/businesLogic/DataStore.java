/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesLogic;

import Exceptions.DALException;
import MySQLClasses.MySQLCitizenStorage;
import MySQLClasses.MySQLEducationStorage;
import MySQLClasses.MySQLSocialInsuranceStorage;
import MySQLClasses.MySqlAddressStorage;
import static MySQLClasses.TypeResult.Address;
import address.Address;
import education.*;
import insurance.SocialInsuranceRecord;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Pattern;
import javafx.collections.transformation.SortedList;
import personaldetails.Citizen;
import personaldetails.Gender;

/**
 *
 * @author stanislav
 */
public class DataStore {

    private ArrayList<String> _fileLines;
    private ArrayList<Citizen> citizens;

    public DataStore(ArrayList<String> _fileLines) {
        this._fileLines = _fileLines;
        this.citizens = new ArrayList<>();
    }

    public DataStore(String fileName) throws IOException, DataReadException {
        File file = new File(fileName);
        if (file.canRead()) {
            this._fileLines = ((ArrayList<String>) Files.readAllLines(Paths.get(fileName),
                    Charset.forName("UTF-8")));
        } else {
            throw new DataReadException("", new IOException("\"file can't read\""));
        }
        this.citizens = new ArrayList<>();
    }

    public int getCitizensCount() {
        return citizens.size();
    }

    public void fillObjects() throws DataReadException {

        int length = Integer.parseInt(this._fileLines.get(0));
        if (this._fileLines.size() != 2 * length + 1) {
            throw new DataReadException("", new IllegalArgumentException("Bad data strucure in file"));
        }

        for (int j = 0; j < length; j++) {
            String[] person = this._fileLines.get(j * 2 + 1).split(";");
            String[] insRec = this._fileLines.get(j * 2 + 2).split(";");
            LocalDate dateOfBirth = LocalDate.parse(person[4], DateTimeFormatter.ofPattern("d.M.u"));

            Citizen citizen = new Citizen(person[0], person[1], person[2],
                    (person[3].trim().toLowerCase().equals("м") || person[3].trim().toLowerCase().equals("m"))
                    ? Gender.Male : Gender.Female,
                    Integer.parseInt(person[5]),
                    dateOfBirth);
            int idx = 12;
            while (idx < person.length && !Pattern.matches("^[PSBMDNpsbmdn]{1}$", person[idx])
                    && idx < 14) {
                idx++;
            }
            int floor = 0, apartment = 0;
            if (idx > 12) {
                if (!person[12].trim().equals("")) {
                    floor = Integer.parseInt(person[12]);
                }
            }
            if (idx > 13) {
                if (!person[13].trim().equals("")) {
                    apartment = Integer.parseInt(person[13]);
                }
            }

            citizen.setAddress(new Address(person[6], person[7], person[8], person[9],
                    person[10], person[11], floor, apartment));
            while (idx < person.length) {
                LocalDate enrollmentDate = LocalDate.parse(person[idx + 2], DateTimeFormatter.ofPattern("d.M.u"));
                LocalDate graduationDate = LocalDate.parse(person[idx + 3], DateTimeFormatter.ofPattern("d.M.u"));
                Education currentEducation = null;
                char degree = person[idx].trim().toLowerCase().charAt(0);
                switch (degree) {
                    case 'p':
                        currentEducation = new PrimaryEducation(person[idx + 1],
                                enrollmentDate, graduationDate);
                        break;
                    case 's':
                        currentEducation = new SecondaryEducation(person[idx + 1],
                                enrollmentDate, graduationDate);
                        break;
                    case 'b':
                        currentEducation = new HigherEducation(person[idx + 1],
                                enrollmentDate, graduationDate, EducationDegree.Bachelor);
                        break;
                    case 'm':
                        currentEducation = new HigherEducation(person[idx + 1],
                                enrollmentDate, graduationDate, EducationDegree.Master);
                        break;
                    case 'd':
                        currentEducation = new HigherEducation(person[idx + 1],
                                enrollmentDate, graduationDate, EducationDegree.Doctorate);
                        break;
                    default:
                        throw new DataReadException("Bad data for education", new IllegalArgumentException());
                }
                idx += 4;
                if (degree == 'p') {
                    if (graduationDate.compareTo(LocalDate.now()) < 0) {
                        ((PrimaryEducation) currentEducation).gotGraduated();
                    }
                } else {
                    if (graduationDate.compareTo(LocalDate.now()) < 0) {
                        if (degree == 's') {
                            ((SecondaryEducation) currentEducation).gotGraduated(Float.parseFloat(person[idx]));
                        } else {
                            ((HigherEducation) currentEducation).gotGraduated(Float.parseFloat(person[idx]));
                        }
                        idx += 1;
                    }
                }
                citizen.addEducation(currentEducation);
            }

            for (int i = 0; i < insRec.length / 3; i++) {
                citizen.addSocialInsuranceRecord(new SocialInsuranceRecord(Integer.parseInt(insRec[i * 3]),
                        Integer.parseInt(insRec[i * 3 + 1]), Double.parseDouble(insRec[i * 3 + 2])));

            }
            this.citizens.add(citizen);
            //System.out.println(j);
        }
        this._fileLines = null;
    }

    public Citizen getCitizenAt(int index) {
        if (citizens == null || index < 0 || index >= citizens.size()) {
            throw new ArrayIndexOutOfBoundsException("Can't find citizen ith this number!");
        }
        return citizens.get(index);
    }

    public void putToDB() throws DALException {
        class AddressPlusIdx implements Comparable<AddressPlusIdx> {

            private Address address;
            ArrayList<Integer> citizens;

            public AddressPlusIdx(Address address) {
                this.address = address;
                this.citizens = new ArrayList<>();
            }

            @Override
            public int compareTo(AddressPlusIdx o) {
                if (o == null) {
                    return 1;
                }
                int i = this.getAddress().getCountry().compareTo(o.getAddress().getCountry());
                if (i != 0) {
                    return i;
                }
                i = this.getAddress().getCity().compareTo(o.getAddress().getCity());
                if (i != 0) {
                    return i;
                }
                i = this.getAddress().getMunicipality().compareTo(o.getAddress().getMunicipality());
                if (i != 0) {
                    return i;
                }
                i = this.getAddress().getPostalCode().compareTo(o.getAddress().getPostalCode());
                if (i != 0) {
                    return i;
                }
                i = this.getAddress().getStreet().compareTo(o.getAddress().getStreet());
                if (i != 0) {
                    return i;
                }
                i = this.getAddress().getNumber().compareTo(o.getAddress().getNumber());
                if (i != 0) {
                    return i;
                }
                i = this.getAddress().getFloor() - o.getAddress().getFloor();
                if (i != 0) {
                    return i;
                }
                i = this.getAddress().getApartmentNo() - o.getAddress().getApartmentNo();
                return i;
            }

            public Address getAddress() {
                return address;
            }

            public ArrayList<Integer> getCitizens() {
                return citizens;
            }

        }
        long begMilis=System.currentTimeMillis();
        System.out.println("Start:0");
        
        ArrayList<Education> educations = new ArrayList<>();
        ArrayList<Integer> educationPersonIdx=new ArrayList<>();
        ArrayList<SocialInsuranceRecord> insurances = new ArrayList<>();
        LinkedList<AddressPlusIdx> adresses = new LinkedList<AddressPlusIdx>();
        //
        //int[][] personsEdications = new int[this.citizens.size()][2];
        //ArrayList<Integer> insurancePersonIdx=new ArrayList<>();
        int[][] personsInsurances = new int[this.citizens.size()][2];
        int idxEdu=0,idxIns=0;
        
        for(int i=0;i<this.citizens.size();i++){
            Citizen current=this.citizens.get(i);
            
            AddressPlusIdx adr=new AddressPlusIdx(current.getAddress());
            adr.getCitizens().add(i);
            adresses.add(adr);
            
            for (int j=0;j<current.getEducations().size();j++){
                educations.add(idxEdu, current.getEducations().get(j));
                educationPersonIdx.add(idxEdu++,i);
            }
            
            personsInsurances[i][0]=idxIns;
            for (int j=0;j<current.getSocialInsuranceRecords().size();j++){
                insurances.add(idxIns++, current.getSocialInsuranceRecords().get(j));
            }
            personsInsurances[i][1]=idxIns-1;
        }
        
        Collections.sort(adresses);
//        for (int i = 0; i < adresses.size() - 1; i++) {
//            if (adresses.get(i).compareTo(adresses.get(i + 1)) == 0) {
//                adresses.get(i).getCitizens().addAll(adresses.get(i + 1).getCitizens());
//                adresses.remove(i + 1);
//                i = i - 1;
//            }
//        }
        AddressPlusIdx prevois = null;
        Iterator<AddressPlusIdx> adr = adresses.iterator();
        while (adr.hasNext()) {
            AddressPlusIdx current = adr.next();
            if (current.compareTo(prevois) == 0) {
                prevois.getCitizens().addAll(current.getCitizens());
                adr.remove();
            } else {
                prevois = current;
            }
        }
        
        
        
        int[] personAddress=new int[this.citizens.size()];
        LinkedList<Address> addressesToDB=new LinkedList<>();
        adr = adresses.iterator();
        int i=0;
        while (adr.hasNext()) {
            AddressPlusIdx current = adr.next();
            addressesToDB.add(current.getAddress());
            for(int k:current.getCitizens()){
                personAddress[k]=i;
            }
            i++;
        }


//        for(int j=0;j<adresses.size();j++){
//            AddressPlusIdx current=adresses.get(j);
//            addressesToDB.add(current.getAddress());
//            for(int k:current.getCitizens()){
//                personAddress[j]=k;
//            }            
//        }
        adresses=null;      
        
        
        System.out.println("End calculations:"+(System.currentTimeMillis()-begMilis));
        //Create SQL querry for addresses
        MySqlAddressStorage addressesSQL=new MySqlAddressStorage();
        addressesSQL.putAddressesInDB(addressesToDB);
        addressesSQL=null;
        addressesToDB=null;
        System.out.println("End writing addresses inDB:"+(System.currentTimeMillis()-begMilis));
        
        MySQLCitizenStorage citizensSQL=new MySQLCitizenStorage();
        citizensSQL.putCitizensInDB(citizens,personAddress);
        citizensSQL=null;        
        personAddress=null;
        citizens=null;
        System.out.println("End writing citizens inDB:"+(System.currentTimeMillis()-begMilis));
        
        MySQLEducationStorage educationsSQL=new MySQLEducationStorage();
        educationsSQL.putEducationsInDB(educations, educationPersonIdx);
        educationsSQL=null;
        educations=null;
        educationPersonIdx=null;
        System.out.println("End writing educations inDB:"+(System.currentTimeMillis()-begMilis));
        
        MySQLSocialInsuranceStorage socIns=new MySQLSocialInsuranceStorage();
//        int parts= insurances.size()/100000;
//        for (int j = 0; j < parts; j++) {
//            socIns.putInsurancesInDB(insurances.subList(parts*100000,( parts+1)*100000),
//                    personsInsurances.subList(parts*100000,( parts+1)*100000));
//        }
//        
//        insurances.subList(idxIns, i)



        socIns.putInsurancesInDB(insurances,personsInsurances);
        System.out.println("End writing socInsurances inDB:"+(System.currentTimeMillis()-begMilis));
    }
}
