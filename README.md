
# MP3 Player

Description: Develop a console application that allows users to manage a collection of songs, albums and artists. 
The application includes classes for representing songs, albums, artists and genres, and interfaces for playing and managing the collection. A user can add, delete, and play songs, as well as view information about songs, albums, and artists.

## Technologies

The following technologies are used in the project:

- **Java** - the main programming language.
- **Hibernate** - ORM (Object-Relational Mapping) for working with database.
- **PostgreSQL** - relational database for storing data about songs, albums and artists.
- **Maven** - a tool for dependency management and project building.
- **S.O.L.I.D.** - principles for creating maintainable and scalable code.
- **Design Patterns** - using design patterns to improve architecture.

### Installation and Startup

- JDK (Java Development Kit) installed.
- Maven installed.
- PostgreSQL installed.

#### Installation Steps

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/yourusername/mp3-player.git
   cd mp3-player
2. Configure the PostgreSQL database:
   ```bsha
   - Scrape the table: https://github.com/thewhitemage13/Spotify/blob/main/Spotify/DB/SpotifySQL.sql
   - Create a new database: CREATE DATABASE mp3playerdb;
   - Set up the database connection configuration in the application.properties file.
3. Соберите и запустите проект с помощью Maven:
   ```bsha
   mvn clean install
   mvn exec:java
