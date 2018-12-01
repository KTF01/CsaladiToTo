package hu.inf.elte.csaladitodo.csaladitodo2000.modell;

import hu.inf.elte.csaladitodo.csaladitodo2000.modell.Tag;
import hu.inf.elte.csaladitodo.csaladitodo2000.modell.Task;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String author;
    @Column
    private String text;
    
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Task task;

    @ManyToMany
    @JoinTable
    private List<Tag> tags;

}