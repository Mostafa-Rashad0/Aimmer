# Aim Trainer Game

A simple yet engaging aim trainer game built with Java Swing that helps users improve their mouse accuracy and reaction time. This project was developed as a team effort during our college coursework.

![Game Background](620478.jpg)

## Technical Overview

This project is a desktop application developed in Java using Object-Oriented Programming principles and the Swing GUI framework. The game presents players with a target that moves randomly across the screen, challenging them to click it as many times as possible within a time limit.

## Team Project

This aim trainer was created collaboratively by our college team as part of our programming coursework. We applied our knowledge of Java OOP concepts, GUI development, and event-driven programming to create an interactive and functional game.

## Architecture

The application follows a modular design with three main classes:

### `start.java`
- Serves as the entry point and main menu for the application
- Features a space-themed background with stylized buttons
- Implements event listeners for navigation between screens
- Uses custom painting to render the background image

### `levels.java`
- Provides difficulty selection interface
- Implements three difficulty levels that control target movement speed:
  - Easy: Target moves every 3000ms
  - Medium: Target moves every 2000ms
  - Medium: Target moves every 1000ms
- Passes the selected difficulty parameter to the game screen

### `space.java`
- Contains the core gameplay implementation
- Includes two nested classes:
  - `AimerFrame`: Main game window with timers and event handling
  - `CounterPanel`: Manages score tracking and time display
- Features include:
  - Randomly moving target using a Timer-based system
  - Click detection and score incrementing
  - 30-second countdown timer
  - Game over handling with score display

## Key Technical Features

### Custom UI Components
- Transparent buttons with custom styling
- Layered JPanels for component organization
- Custom painted backgrounds for visual appeal

### Event-Driven Architecture
- ActionListeners for button interactions
- Timer-based game mechanics for target movement
- Countdown timer implementation

### Game Logic
- Random positioning algorithm for the target
- Score tracking system
- Difficulty scaling based on user selection
- Game state management (start, play, end)

## Dependencies
- Java Standard Edition
- Swing GUI Library
- AWT (Abstract Window Toolkit)

## Installation and Running

1. Ensure you have Java JDK installed on your system
2. Clone this repository
3. Place the required image files in the project directory:
   - `620478.jpg` - Space background
   - `ali.png` - Target image
4. Compile the Java files:
   ```
   javac start.java levels.java space.java
   ```
5. Run the application:
   ```
   java start
   ```

## Future Enhancements
- High score system with persistence
- Additional game modes
- Customizable game duration
- More target variations
- Sound effects and background music
