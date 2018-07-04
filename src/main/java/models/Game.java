package models;

import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {
    private int id;
    private String title;
    private Genre genre;
    private List<Console> consoles;
    private List<Owner> owners;

    public Game() {
    }

    public Game(String title, Genre genre) {
        this.title = title;
        this.genre = genre;
        this.consoles = new ArrayList();
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(
            name = "title"
    )
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Enumerated(EnumType.STRING)
    public Genre getGenre() {
        return this.genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @ManyToMany
    @JoinTable(
            name = "console_games",
            joinColumns = {@JoinColumn(name = "game_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "console_id", nullable = false, updatable = false)})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public List<Console> getConsoles() {
        return this.consoles;
    }

    public void setConsoles(List<Console> consoles) {
        this.consoles = consoles;
    }

    public void addConsole(Console console) {
        this.consoles.add(console);
    }

    @OneToMany(
            mappedBy = "game",
            fetch = FetchType.LAZY
    )
    public List<Owner> getOwners() {
        return this.owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }
}

