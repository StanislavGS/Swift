/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQLClasses;

import Exceptions.DALException;
import static MySQLClasses.TypeResult.Education;
import education.*;
import insurance.SocialInsuranceRecord;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import personaldetails.Citizen;
import personaldetails.Gender;

/**
 *
 * @author stanislav
 */
public class MySQLRequest {

    final String DBMS_CONN_STRING = "jdbc:mysql://localhost:3306/citizen_insurance"
            + "?useUnicode=true&characterEncoding=utf-8";
    final String DBMS_USERNAME = "root";
    final String DBMS_PASSWORD = "llIIB+Yfr";
    String SQLtext;
    TypeStatement typeStatement;
    TypeResult typeRsult;
    private Object result;

    public MySQLRequest(String SQLtext, TypeStatement typeStatement, TypeResult typeRsult) {
        this.SQLtext = SQLtext;
        this.typeStatement = typeStatement;
        this.typeRsult = typeRsult;
        this.result = null;
    }

    public void setSQLtext(String SQLtext) {
        this.SQLtext = SQLtext;
    }

    public Object getResult() {
        return result;
    }

    public void execute() throws SQLException {
        CallableStatement cStatement = null;
        PreparedStatement pStatement = null;
        Statement statement = null;
        ResultSet rs = null;

        if (this.typeStatement == TypeStatement.execute && this.typeRsult != TypeResult.Boolean
                && this.typeRsult != TypeResult.Void) {
            throw new IllegalArgumentException();
        }

        //Connection con =DriverManager.getConnection(DBMS_CONN_STRING+"?user=" +DBMS_USERNAME+"&password="+DBMS_PASSWORD+
        //        "&useUnicode=true&characterEncoding=UTF-8");
        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);) {
            String qwr = new String(this.SQLtext.getBytes(Charset.forName("UTF-8")));
            switch (typeStatement) {
                case callable:
                    if(this.typeRsult==TypeResult.Insurance){
                        cStatement = con.prepareCall("{call insert_insurance_and_get_id(?, ?, ?, ?)}");
                        String[] inParams=this.SQLtext.split("@@@");
                        //ParameterMetaData ob=cStatement.getParameterMetaData();
                        cStatement.setShort("new_year",Short.parseShort(inParams[0]));
                        cStatement.setByte("new_mount",Byte.parseByte(inParams[1]));
                        cStatement.setDouble("amount",Double.parseDouble(inParams[2]));
                        cStatement.registerOutParameter("new_id", Types.INTEGER);
                        cStatement.executeQuery();
                        this.result = cStatement.getInt("new_id");
                    }
                    break;
                case prepared:
//                    pStatement = con.prepareStatement(qwr);
//                    pStatement.setString(1, "xxxxxxx");
//                    rs = pStatement.executeQuery();
                    break;
                case execute:
                    statement = con.createStatement();
                    Boolean boo = statement.execute(qwr);
                    this.result = boo;
                    break;
                case executeQuery:
                    statement = con.createStatement();
                    rs = statement.executeQuery(qwr);
                    if (typeRsult == TypeResult.numRows) {
                        this.result = (int) 0;
                        if (rs.last()) {
                            this.result = (int) rs.getRow();
                        }

                    } else if (typeRsult == TypeResult.Citizen) {
                        this.result = new ArrayList<Object>();
                        if (rs.next()) {
                            int idAddress = rs.getInt("addresses_id");
                            LocalDate bDate=rs.getDate("birth_date").toLocalDate();
                            Citizen citizen = new Citizen(rs.getString("first_name"),
                                    rs.getString("middle_name"), rs.getString("last_name"),
                                    rs.getInt("genders_id") == 1 ? Gender.Male : Gender.Female,
                                    (int) rs.getFloat("height"),
                                    bDate);
                            ((ArrayList<Object>) this.result).add(citizen);
                            ((ArrayList<Object>) this.result).add(idAddress);
                        } else {
                            throw new DALException("Can'find citizen by id", new IllegalArgumentException());
                        }

                    } else if (typeRsult == TypeResult.Address) {
                        if (rs.next()) {
                            this.result = new address.Address(rs.getString("country"),
                                    rs.getString("city"), rs.getString("municipality"),
                                    rs.getString("postal_code"), rs.getString("street"),
                                    rs.getString("number"), rs.getInt("floor"), rs.getInt("apartmentNo"));
                        } else {
                            throw new DALException("Can'find address by id", new IllegalArgumentException());
                        }
                    } else if (typeRsult == TypeResult.EducationList) {
                        this.result = new ArrayList<Education>();
                        while (rs.next()) {
                            LocalDate enrollmentDate = rs.getDate("enrollment_date").toLocalDate();
                            LocalDate graduationDate = rs.getDate("graduation_date").toLocalDate();
                            Education edu = makeEducationClass(rs.getInt("type_id"),
                                    rs.getString("institution_name"), enrollmentDate,
                                    graduationDate, rs.getBoolean("graduated"),
                                    rs.getInt("final_grade"));
                            ((ArrayList<Education>) this.result).add(edu);
                        }
                    } else if (typeRsult == TypeResult.InsuranceList) {
                        this.result = new ArrayList<SocialInsuranceRecord>();
                        while (rs.next()) {
                            ((ArrayList<SocialInsuranceRecord>) this.result).add(
                                    new SocialInsuranceRecord(rs.getInt("year"), rs.getInt("mount"),
                                            rs.getDouble("amount")));
                        }
                    }
            }
        } finally {
            if (cStatement != null) {
                cStatement.close();
            }
            if (pStatement != null) {
                pStatement.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

    }

    private Education makeEducationClass(int type, String institutionName, LocalDate enrollmentDate,
            LocalDate graduationDate, boolean graduated, float finalGrade) {
        Education edu;
        switch (type) {
            case 1:
                edu = new PrimaryEducation(institutionName, enrollmentDate, graduationDate);
                if (graduated) {
                    ((PrimaryEducation) edu).gotGraduated();
                }
                break;
            case 2:
                edu = new SecondaryEducation(institutionName, enrollmentDate, graduationDate);
                if (graduated) {
                    ((SecondaryEducation) edu).gotGraduated(finalGrade);
                }
                break;
            default:
                edu = new HigherEducation(institutionName, enrollmentDate, graduationDate,
                        (type == 3) ? EducationDegree.Bachelor
                                : (type == 4) ? EducationDegree.Master : EducationDegree.Doctorate);
                if (graduated) {
                    ((HigherEducation) edu).gotGraduated(finalGrade);
                }
                break;
        }

        return edu;
    }
}
