
import java.time.LocalDate;

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
    private LocalDate _lastModifiedDate;

    String getContent() {
        return this._content;
    }

    LocalDate getLastModifiedDate() {
        return this._lastModifiedDate;
    }

    void setLastModifiedDate(LocalDate _lastModifiedDate) {
        this._lastModifiedDate = _lastModifiedDate;
    }

    ContentFile(String name, String location, LocalDate creationDate, String content, LocalDate lastModifiedDate) {
        super(name, location, creationDate);
        this.modify(content);
        this.setLastModifiedDate(lastModifiedDate);
    }

    void modify(String data) {
        this._content = data;
    }
}
