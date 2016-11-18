/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class School extends SchoolObject {

    School(String name) {
        this.name = name;
        this.numDisciplines = 0;
        this.numTeachers = 0;
        this.numClasses = 0;
        this.teachers = new Teacher[100];
        this.classes = new Class[100];
        this.disciplines = new Discipline[200];
    }

    public boolean crateClass(String name) {
        int i = findByName(name, classes, numClasses); //findClass(name);
        if (i < 0) {
            this.classes[numClasses++] = new Class(name);
        }
        return i < 0;
    }

    public boolean createTeacher(String name) {
        int i = findByName(name, teachers, numTeachers);//findTeacher(name);
        if (i < 0) {
            this.teachers[numTeachers++] = new Teacher(name);
        }
        return i < 0;
    }

    public boolean createDiscipline(String name) {
        int i = findByName(name, disciplines, numDisciplines);//findDiscipline(name);
        if (i < 0) {
            this.disciplines[numDisciplines++] = new Discipline(name);
        }
        return i < 0;
    }

    public boolean removeClassFromSchool(String name) {
        int i = findByName(name, classes, numClasses);
        if (i >= 0) {
            Class trash = classes[i];
            this.classes[i] = this.classes[numClasses - 1];
            this.classes[numClasses-- - 1] = null;
            for (Teacher teacher : teachers) {
                teacher.removeClass(trash);
            }
            for (Discipline discipline : disciplines) {
                discipline.removeClass(trash);
            }
        }
        return i >= 0;
    }

    public boolean removeTeacherFromSchool(String name) {
        int i = findByName(name, teachers, numTeachers);
        if (i >= 0) {
            Teacher trash = teachers[i];
            this.teachers[i] = this.teachers[numTeachers - 1];
            this.teachers[numTeachers-- - 1] = null;
            for (Class sclass : classes) {
                sclass.removeTeacher(trash);
            }
            for (Discipline discipline : disciplines) {
                discipline.removeTeacher(trash);
            }
        }
        return i >= 0;
    }

    public boolean removeDisciplineFromSchool(String name) {
        int i = findByName(name, disciplines, numDisciplines);
        if (i >= 0) {
            Discipline trash = disciplines[i];
            this.disciplines[i] = this.disciplines[numDisciplines - 1];
            this.disciplines[numDisciplines-- - 1] = null;
            for (Class sclass : classes) {
                sclass.removeDiscipline(trash);
            }
            for (Teacher teacher : teachers) {
                teacher.removeDiscipline(trash);
            }
        }
        return i >= 0;
    }

    public boolean connectDisciplineToTeacher(String nameDiscipline, String nameTeacher) {
        int i = findByName(name, disciplines, numDisciplines), i1 = findByName(name, teachers, numTeachers);
        if (i >= 0 && i1 >= 0) {
            disciplines[i].addTeacher(teachers[i1]);
            teachers[i1].addDiscipline(disciplines[i]);
            return true;
        }
        return false;
    }

    public boolean connectDisciplneToClass(String nameDiscipline, String nameClass) {
        int i = findByName(name, disciplines, numDisciplines), i1 = findByName(name, classes, numClasses);
        if (i >= 0 && i1 >= 0) {
            disciplines[i].addClass(classes[i1]);
            classes[i1].addDiscipline(disciplines[i]);
            return true;
        }
        return false;
    }

    public boolean connectTeacherToClass(String nameClass, String nameteacher) {
        int i = findByName(name, teachers, numTeachers), i1 = findByName(name, classes, numClasses);
        if (i >= 0 && i1 >= 0) {
            teachers[i].addClass(classes[i1]);
            classes[i1].addTeacher(teachers[i]);
            return true;
        }
        return false;
    }

    public void putStudentInClass(String name, Student student) {
        int i = findByName(name, classes, numClasses);
        if (i >= 0) {
            classes[i].addStudent(student);
        }
    }

    public void removeStudenFromClass(String nameClass, int numberStudent) {
        int i = findByName(name, classes, numClasses);
        if (i >= 0) {
            classes[i].removeStudent(numberStudent);
        }
    }

    private int findByName(String name, Object[] objects, int numObjects) {
        int i = 0;
        while (i < numObjects && !((SchoolObject) objects[i]).getName().equals(name)) {
            i++;
        }
        if (i >= numObjects) {
            i = -1;
        }
        return i;
    }
}
