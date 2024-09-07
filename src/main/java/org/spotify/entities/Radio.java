package org.spotify.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Radio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long radioId;
    private String city;
    private String country;
    private String radioName;
    private String radioUrl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Radio radio = (Radio) o;
        return Objects.equals(radioId, radio.radioId) && Objects.equals(city, radio.city) && Objects.equals(country, radio.country) && Objects.equals(radioName, radio.radioName) && Objects.equals(radioUrl, radio.radioUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radioId, city, country, radioName, radioUrl);
    }

    @Override
    public String toString() {
        return "Radio{" +
                "radioId=" + radioId +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", radioName='" + radioName + '\'' +
                ", radioUrl='" + radioUrl + '\'' +
                '}';
    }
}
