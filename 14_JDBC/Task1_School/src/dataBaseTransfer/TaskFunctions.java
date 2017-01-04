/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBaseTransfer;

import Objects.*;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author stanislav
 */
public class TaskFunctions {

    final static String DBMS_CONN_STRING = "jdbc:mysql://localhost/school";
    final static String DBMS_USERNAME = "root";
    final static String DBMS_PASSWORD = "";

    public static int insertTeacher(Teacher teacher) throws SQLException {
        int idAddress = insertQuery("addresses", new String[]{"country", teacher.getAddress().getCountry(),
            "city", teacher.getAddress().getCity(),
            "street", teacher.getAddress().getStreet(),
            "number", teacher.getAddress().getNumber(),
            "floor", Integer.toString(teacher.getAddress().getFloor()),
            "apartmentNo", Integer.toString(teacher.getAddress().getApartment())});

        return insertQuery("teachers", new String[]{"name", teacher.getName(),
            "email", teacher.getEmail(), "salary", Double.toString(teacher.getSalary()),
            "id_address", Integer.toString(idAddress)});
    }

    public static Teacher getTeacher(int id) throws SQLException {
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;

        Teacher teacher = null;
        try {
            execQueryWithResult(con, statement, rs, "SELECT * FROM `teachers` JOIN `addresses`"
                    + " ON `teachers`.`id_address`=`addresses`.`id` WHERE "
                    + "`teachers`.`id`='" + id + "';");
            if (rs.next()) {
                teacher = new Teacher(rs.getString("name"), rs.getString("email"),
                        rs.getDouble("salary"), new Address(rs.getString("country"),
                        rs.getString("city"), rs.getString("street"), rs.getString("number"),
                        rs.getInt("floor"), rs.getInt("apartmentNo")));
            }
        } finally {
            if (con!=null) con.close();
            if (statement!=null) statement.close();
            if (rs!=null) rs.close();
        };
        return teacher;
    }

    public static ArrayList<Teacher> teachersWithSpSalary(double bottomSalaryLimit, double topSalaryLimit) throws SQLException {
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;

        ArrayList<Teacher> teachers = new ArrayList<>();
        try {
            execQueryWithResult(con, statement, rs, "SELECT * FROM `teachers` JOIN `addresses`"
                    + " ON `teachers`.`id_address`=`addresses`.`id` WHERE "
                    + "`teachers`.`salary` BETWEEN '" + bottomSalaryLimit + "' AND '"
                    + topSalaryLimit + "';");
            while (rs.next()) {
                teachers.add(new Teacher(rs.getString("name"), rs.getString("email"),
                        rs.getDouble("salary"), new Address(rs.getString("country"),
                        rs.getString("city"), rs.getString("street"), rs.getString("number"),
                        rs.getInt("floor"), rs.getInt("apartmentNo"))));
            }
        } finally {
            con.close();
            statement.close();
            rs.close();
        };
        return teachers;

    }

    public static int insertStudent(String name, LocalDate enrollmentDate, Address address) throws SQLException {
        int idAddress = insertQuery("addresses", new String[]{"country", address.getCountry(),
            "city", address.getCity(),
            "street", address.getStreet(),
            "number", address.getNumber(),
            "floor", Integer.toString(address.getFloor()),
            "apartmentNo", Integer.toString(address.getApartment())});

        return insertQuery("students", new String[]{"name", name,
            "enrollmentDate", enrollmentDate.toString(),
            "id_address", Integer.toString(idAddress)});
    }

    public static Student getStudent(int id) throws SQLException {
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;

        Student student = null;
        try {
            execQueryWithResult(con, statement, rs, "SELECT * FROM `students` JOIN `addresses`"
                    + " ON `students`.`id_address`=`addresses`.`id` WHERE "
                    + "`students`.`id`='" + id + "';");
            if (rs.next()) {
                student = new Student(rs.getString("name"), rs.getDate("enrollmentDate").toLocalDate(),
                        new Address(rs.getString("country"),
                                rs.getString("city"), rs.getString("street"), rs.getString("number"),
                                rs.getInt("floor"), rs.getInt("apartmentNo")));
            }
        } finally {
            con.close();
            statement.close();
            rs.close();
        };
        return student;

    }

    public static ArrayList<Student> getStudents(LocalDate startDate) throws SQLException {
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;

        ArrayList<Student> students = new ArrayList<>();
        try {
            execQueryWithResult(con, statement, rs, "SELECT * FROM `students` JOIN `addresses`"
                    + " ON `students`.`id_address`=`addresses`.`id` WHERE "
                    + "`students`.`enrollmentDate` >= '" + startDate.toString() + "';");
            while (rs.next()) {
                students.add(new Student(rs.getString("name"), rs.getDate("enrollmentDate").toLocalDate(),
                        new Address(rs.getString("country"),
                                rs.getString("city"), rs.getString("street"), rs.getString("number"),
                                rs.getInt("floor"), rs.getInt("apartmentNo"))));
            }
        } finally {
            con.close();
            statement.close();
            rs.close();
        };
        return students;

    }

    public static ArrayList<String> getDisciplinesByTeacherId(int id) throws SQLException {

        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;

        ArrayList<String> disciplines = new ArrayList<>();
        try {
            execQueryWithResult(con, statement, rs, "SELECT * FROM `disciplines_taught`"
                    + " JOIN `disciplines` ON  `disciplines_taught`.`id_discipline`=`disciplines`.`id`"
                    + " WHERE `disciplines_taught`.`id_teacher`=" + id + "';");
            while (rs.next()) {
                disciplines.add(rs.getString("`disciplines`.`name`"));
            }
        } finally {
            con.close();
            statement.close();
            rs.close();
        };
        return disciplines;

    }

    public static ArrayList<Teacher> getTeachersByDisciplineName(String discipline) throws SQLException {
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;

        ArrayList<Teacher> teachers = new ArrayList<>();
        try {
            execQueryWithResult(con, statement, rs, "SELECT * FROM `disciplines_taught`"
                    + " JOIN `disciplines`  ON `disciplines_taught`.`id_discipline`=`disciplines`.`id`"
                    + " JOIN `teachers`  ON `disciplines_taught`.`id_teacher`=`teachers`.`id`"
                    + " JOIN `addresses`  ON `teachers`.`id_address`=`addresses`.`id`"
                    + " WHERE `disciplines`.`name` = '" + discipline + "';");
            while (rs.next()) {
                teachers.add(new Teacher(rs.getString("name"), rs.getString("email"),
                        rs.getDouble("salary"), new Address(rs.getString("country"),
                        rs.getString("city"), rs.getString("street"), rs.getString("number"),
                        rs.getInt("floor"), rs.getInt("apartmentNo"))));
            }
        } finally {
            con.close();
            statement.close();
            rs.close();
        };
        return teachers;
    }

    private static void execQueryWithResult(Connection con, Statement statement, ResultSet rs,
            String query) throws SQLException {
        con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
        statement = con.createStatement();
        rs = statement.executeQuery(query);
    }

    private static int insertQuery(String table, String[] colsAndValues) throws SQLException {
        String select = "SELECT id FROM `" + table + "` WHERE ";
        String insertPart1 = "INSERT INTO `" + table + "` (";
        String insertPart2 = " VALUES (";
        for (int i = 0; i < colsAndValues.length / 2; i++) {
            select += "`" + colsAndValues[i * 2] + "`='" + colsAndValues[i * 2 + 1] + "'";
            insertPart1 += "`" + colsAndValues[i * 2] + "`";
            insertPart2 += "'" + colsAndValues[i * 2 + 1] + "'";
            if (i <colsAndValues.length / 2 -1) {
                select += " AND ";
                insertPart1 += ",";
                insertPart2 += ",";
            } else {
                select += ";";
                insertPart1 += ")";
                insertPart2 += ")";
            }
        }
        ResultSet rs = null;
        try (Connection con = DriverManager.getConnection(DBMS_CONN_STRING, DBMS_USERNAME, DBMS_PASSWORD);
                Statement statement = con.createStatement();) {
            rs = statement.executeQuery(select);
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                statement.execute(insertPart1 + insertPart2,Statement.RETURN_GENERATED_KEYS);
                rs= statement.getGeneratedKeys();
                if(rs.next()){
                    return rs.getInt(1);
                }
            }
        } finally {
            if(rs!=null){
                rs.close();
            }
        }
        return -1;
    }
}
