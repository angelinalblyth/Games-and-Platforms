package models;

public enum Genre {
    FPS("First Person Shooter"),
    ACTION("Action"),
    RPG("Role-playing"),
    SIMULATION("Simulation");

    private String genreType;

    private Genre(String genreType) {
        this.genreType = genreType;
    }

    public String getGenreType() {
        return this.genreType;
    }
}