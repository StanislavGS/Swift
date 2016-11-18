/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public abstract class SchoolObject {
    Class[] classes;
    int numClasses;
    Teacher[] teachers;
    int numTeachers;
    Discipline[] disciplines;
    int numDisciplines;
    
    protected String name;
    
    
    public String getName(){
        return this.name;
    }

    void removeClass(Class trash) {
        int i=find(trash,classes,numClasses);
        if (i>=0){
            this.classes[i]=this.classes[numClasses-1];
            this.classes[numClasses-- -1]=null;
        }
    }
    
    void addClass(Class sclass) {
        int i=find(sclass,classes,numClasses);
        if (i<0){
            classes[numClasses++]=sclass;
        }
    }
    
    void removeDiscipline(Discipline trash) {
        int i=find(trash,disciplines,numDisciplines);
        if (i>=0){
            this.disciplines[i]=this.disciplines[numDisciplines-1];
            this.disciplines[numDisciplines-- -1]=null;
        }
    }
    
    void addDiscipline(Discipline discipline) {
        int i=find(discipline,disciplines,numDisciplines);
        if (i<0){
            disciplines[numDisciplines++]=discipline;
        }
    }
    
    void removeTeacher(Teacher trash) {
        int i = find(trash, teachers, numTeachers);
        if (i >= 0) {
            this.teachers[i] = this.teachers[numTeachers - 1];
            this.teachers[numTeachers-- - 1] = null;
        }
    }

    void addTeacher(Teacher teacher) {
        int i = find(teacher, teachers, numTeachers);
        if (i < 0) {
            teachers[numTeachers++] = teacher;
        }
    }
    
    protected int find(Object trash,Object[] trashes,int numTrashes) {
        int i=0;
        while(i<numTrashes && !trashes[i].equals(trash)){
            i++;
        }
        if (i>=numTrashes){
            i=-1;
        }
        return i;
    }   
}
