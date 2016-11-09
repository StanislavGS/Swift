/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class Worker extends Person{

    private double _weekSalary;
    private double _workHoursPerDay;

    double getWeekSalary() {
        return this._weekSalary;
    }

    void setWeekSalary(double _weekSalary) {
        this._weekSalary = _weekSalary;
    }

    double getWorkHoursPerDay() {
        return this._workHoursPerDay;
    }

    void setWorkHoursPerDay(double _workHoursPerDay) {
        this._workHoursPerDay = _workHoursPerDay;
    }

    Worker(String firstName, String lastName, double _weekSalary, double _workHoursPerDay) {
        super(firstName, lastName);
        this._weekSalary = _weekSalary;
        this._workHoursPerDay = _workHoursPerDay;
    }
    @Override
    public String toString(){
        return String.format("First name: %s%nLast name: %s%nOccupation: Worker%n" +
                            "Week salary: %.2f%nHours per day: %.1f%nSalary per hour:%.2f%n",
                getFirstName(),getLastName(),getWeekSalary(),
                getWorkHoursPerDay(),getWeekSalary()/(5*getWorkHoursPerDay()));
    }

}
