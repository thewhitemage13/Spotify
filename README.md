# MP3 Player 🎵

## Overview 📖
MP3 Player is a console application designed for managing a collection of songs, albums, and artists. This project showcases structured and scalable architecture with a focus on OOP, S.O.L.I.D. principles, and design patterns. It provides a seamless experience for adding, managing, and playing songs through a command-line interface.

## Features ⚡
- **Add Artists:** Create a database of music artists.
- **Add Songs and Albums:** Organize music into structured collections.
- **Play Songs and Albums:** Enjoy your music directly via the application.
- **Play Radio:** Simulate a playlist or random song playback.
- **View Information:** Display details about songs, albums, and artists.

## Technologies ⚙️
- **Java**: Core language for developing the application.
- **Hibernate**: ORM tool for interacting with the database.
- **PostgreSQL**: Relational database for storing song, album, and artist data.
- **Maven**: Dependency and build management tool.
- **JUnit 5**: Framework for writing unit tests.
- **Mockito**: Library for mocking in tests.
- **S.O.L.I.D. Principles**: Ensures maintainability and scalability.
- **Design Patterns**: Improves software architecture and development process.

## Installation 💻
To run the application, follow these steps:

1. **Install Prerequisites:**
   - [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
   - [Maven](https://maven.apache.org/download.cgi)
   - [PostgreSQL](https://www.postgresql.org/download/)

2. **Clone the Repository:**
   ```bash
   git clone https://github.com/yourusername/mp3-player.git
   cd mp3-player
   ```

3. **Set Up Database:**
   - Create a PostgreSQL database.
   - Update the database connection details in the `hibernate.cfg.xml` file.

   ```XML
<hibernate-configuration>
  <session-factory>
    <property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
    <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/spotify</property>
    <property name="hibernate.connection.username">postgres</property>
    <property name="hibernate.connection.password">root</property>
    <property name="hibernate.hikari.maximumPoolSize">10</property>
    <property name="hibernate.hikari.connectionTimeout">20000</property>
    <property name="hibernate.dialect">org.hibernate.dialect.PostgreSQL10Dialect</property>
    <property name="hibernate.hbm2ddl.auto">update</property>
    <property name="show_sql">true</property>
    <property name="format_sql">true</property>
    <mapping class="org.spotify.entities.Song"/>
    <mapping class="org.spotify.entities.MusicCollection"/>
    <mapping class="org.spotify.entities.Performer"/>
    <mapping class="org.spotify.entities.Radio"/>
  </session-factory>
</hibernate-configuration>
```

4. **Build the Project:**
   ```bash
   mvn clean install
   ```

5. **Run the Application:**
   ```bash
   java -jar target/mp3-player.jar
   ```

## Achievements 
- **Optimized Architecture:**
  Designed a maintainable and scalable application structure.
- **Performance Enhancements:**
  Implemented efficient database interactions using Hibernate.
- **Test Coverage:**
  Comprehensive testing using JUnit 5 and Mockito.
- **Command-Line Interface:**
  Created an intuitive and user-friendly CLI for managing music collections.

## Future Improvements
- Add a graphical user interface (GUI) for enhanced usability.
- Implement advanced search and filter options.

## License 📑
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Links 🔗
- [Documentation](https://thewhitemage13.github.io/Spotify/)

---
Made with ❤️ by [Mukhammed Lolo](https://github.com/thewhitemage13).
