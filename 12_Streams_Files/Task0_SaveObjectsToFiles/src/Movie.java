
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stanislav Stanislavov
 */
public class Movie implements Serializable {

    private String _title, _director;
    private List<String> _actors;

    public Movie(String _title, String _director, List<String> _actors) {
        this.setTitle(_title);
        this.setDirector(_director);
        this._actors = _actors;
    }

    public Movie(String _title, String _director) {
        this.setTitle(_title);
        this.setDirector(_director);
        this._actors = new LinkedList<>();        
    }

    public Movie(String _title, String _director,String[] actors) {
        this(_title,_director);
        for(String st:actors){
           this._actors.add(st);
        }        
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Movie)){
            return false;
        }
        return (this._title.equals(((Movie) o).getTitle()) &&
                this._director.equals(((Movie) o).getDirector()) &&
                this._actors.equals(((Movie) o).getActors()));
    }
    
    public void addActor(String actor) {
        this._actors.add(actor);
    }

    public boolean removeActor(String actor) {
        return this._actors.remove(actor);
    }

    public List<String> getActors() {
        return _actors;
    }

    public String getDirector() {
        return _director;
    }

    public void setDirector(String _director) {
        this._director = _director;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String _title) {
        this._title = _title;
    }

}
