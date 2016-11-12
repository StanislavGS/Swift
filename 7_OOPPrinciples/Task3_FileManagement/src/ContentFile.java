
import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stanislav Stanislavov
 */
public abstract class ContentFile extends File {

    private String _content;
    private LocalDateTime _lastModifiedDate;

    String getContent() {
        return this._content;
    }

    LocalDateTime getLastModifiedDate() {
        return this._lastModifiedDate;
    }

    void setLastModifiedDate(LocalDateTime _lastModifiedDate) {
        this._lastModifiedDate = _lastModifiedDate;
    }

    ContentFile(String name, String location,  String content) {
        super(name, location);
        this.modify(content);
    }

    final void modify(String data) {
        this._content = data;
        this.setLastModifiedDate(LocalDateTime.now());
    }
    
    @Override
    String getInfo(){
        return String.format("%s%nLast modification date:%s", 
                super.getInfo(),this.getLastModifiedDate().toString());
    }
}
