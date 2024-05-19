# Rock Paper Scissors Game - Java Implementation

This project implements a classic Rock-Paper-Scissors game in Java, utilizing design patterns to promote code reusability and maintainability. It allows two players (one human and one computer) to compete and displays the final winner after a specified number of rounds.

## Features:
- Play Rock-Paper-Scissors against a computer opponent.
- Customize player names and the number of rounds.
- Clear and interactive gameplay experience.
- Unit tests for core game logic.

## Design Patterns:
- The GameFactory class implements the Factory Method design pattern, allowing for the creation of different game types without modifying the main game runner logic. Currently, it supports the Rock-Paper-Scissors game, but it can be extended to create other games.
- The Game and Player interfaces define the expected functionalities for games and players, respectively. This promotes loose coupling and allows for different implementations (e.g., different game types, human vs. AI players).

## Running the Game:
- Compile the Java source files (e.g., using javac).
- Run the GameRunner class using java GameRunner.
- set the number of rounds.
- set the human player name
- choose one of the valid moves
- repeat until the game ends i.e all the rounds completes
  
  
