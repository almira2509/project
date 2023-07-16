package kz.bitlab.ashygali.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "t_books")
@Getter
@Setter
public class Books extends BaseModel {
    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "description", columnDefinition = "TEXT")
    private String  description;

    @ManyToOne(fetch = FetchType.EAGER)
    private User users;

}
