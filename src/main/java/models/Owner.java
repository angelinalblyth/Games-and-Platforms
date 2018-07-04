package models;

import javax.persistence.*;

@Entity
@Table(name = "owners")
public class Owner {
    private int id;
    private String name;
    private Game game;

    public Owner() {
    }

    public Owner(String name, Game game) {
        this.name = name;
        this.game = game;
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
            name = "name"
    )
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(
            name = "game",
            nullable = false
    )
    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}

