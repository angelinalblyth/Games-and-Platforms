# Lab

Games and Platforms.

## MVP
Create a console and games tracker.

## MVP

- Create an `Console` class.
- `Console` should have `Manufacturer`, `Model` and `region`.(E.G. Sony, PS4, Europe)
- Create a `Game` class.
- `Game` should have a `title` and an Enum for `genre` (ARCADE, RPG, FPS, etc).
- A console can have many games, and a game can be available on many consoles.
- Update the Console class to have an List of Game objects.
- Update the Game class to have a List of Console objects.
- Create a many to many relationship using annotations
- Write the CRUD functions in a `DBHelper` class. (`save`, `update`, `delete`, `getAll` and `find`)
- Write a method in DBConsole to return available games.
- Write a method in DBGame to return all the console platforms on which the game is available.

## Extensions

- (One to Many)
- Create an owner class.
- Owner should have a favourite game. A game can be many owner's favourite game.
- Implement this one to many relationship, including a method to return all the players who have made a given game their favourite.

- (One to One)
- Add a 'gameBeingPlayed' attribute to the console class.
- Add a 'hostConsole' attribute to the game class (this will be null if the game is not being played).
- Implement this relationship.



