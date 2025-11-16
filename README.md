# 🏠 Roommate Finder and Listing System (Java Console Project)

This project is a simple Java console application designed to manage room listings and match potential roommates based on user preferences. It demonstrates basic file handling for data persistence and core Object-Oriented Programming (OOP) concepts.

---

## ✨ Features

* **Room Listing Management:** Allows users to add detailed room listings (location, rent, type, size, preferences).
* **Seeker Matching:** Takes a user's profile (name, budget, preferred location, etc.) and finds the best available rooms.
* **Filtering Logic:** Matches are based on multiple exact criteria, including: **Budget** (user must afford the rent), **Location**, **Room Type**, and **Gender Preference**.
* **Data Persistence:** Automatically saves all room listings to and loads them from a local text file (`data/rooms.txt`).
* **Room Allotment:** When a seeker chooses a matched room, the room is removed from the list, and the saved data is updated.

---

## 💻 OOP Concepts Demonstrated

| Concept | Class/Method Example | Description |
| :--- | :--- | :--- |
| **Encapsulation** | `Room` and `User` classes | All attributes (`rent`, `name`, `location`, etc.) are declared `private`, and access is controlled via public **getter methods**. |
| **Aggregation/Composition** | `RoommateFinder` class | The `RoommateFinder` object manages a `List<Room>`, demonstrating how one class controls a collection of other objects. |
| **Abstraction** | `saveRoomsToFile()` method | Hides the complex I/O details (creating directories, writing CSV lines) behind a single, simple method call. |

---

## 🛠️ How to Run

1.  **Save the Code:** Ensure your Java code is separated into the following four files in one directory: `Main.java`, `Room.java`, `User.java`, and `RoommateFinder.java`.
2.  **Compile:** Open your terminal or command prompt and compile the source files.
    ```bash
    javac Main.java Room.java User.java RoommateFinder.java
    ```
3.  **Run:** Execute the main class to start the interactive program.
    ```bash
    java Main
    ```

### Example Interaction

The program starts with a simple menu, loading any existing rooms from the `data/rooms.txt` file:

1.  **Select `1` (Add a Room):** You'll be prompted to input all room details, and the listing will be saved.
2.  **Select `2` (Add a Roommate/Seeker):** You'll input your preferences, and the system will list any matching rooms and prompt you for a selection.

---

## 📂 Class Structure

### 1. `Room`

* **Purpose:** Data model for a single room listing.
* **Key Fields:** `location`, `rent`, `roomType`, `genderPreference`.

### 2. `User`

* **Purpose:** Data model for a person seeking a room.
* **Key Fields:** `name`, `budget`, `preferredRoomType`, `preferredLocation`.

### 3. `RoommateFinder`

* **Purpose:** Contains the core application logic.
* **Key Methods:** `addRoom()`, `saveRoomsToFile()`, `loadRoomsFromFile()`, and the critical matching function, `findBestMatch(User user)`.

### 4. `Main`

* **Purpose:** The entry point and primary user interface handler.
* **Key Action:** Initializes the `RoommateFinder` and handles the main menu loop and user input capture.

---

## 💾 Data Persistence

Room listings are saved as comma-separated values (CSV) in the `data/rooms.txt` file.
