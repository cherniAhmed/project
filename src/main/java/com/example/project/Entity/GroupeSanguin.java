package com.example.project.Entity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = GroupeSanguinDeserializer.class)
public enum GroupeSanguin {
    A_POSITIF("A+"),
    A_NEGATIF("A-"),
    B_POSITIF("B+"),
    B_NEGATIF("B-"),
    AB_POSITIF("AB+"),
    AB_NEGATIF("AB-"),
    O_POSITIF("O+"),
    O_NEGATIF("O-");

    private final String value;

    GroupeSanguin(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static GroupeSanguin fromValue(String value) {
        for (GroupeSanguin groupeSanguin : GroupeSanguin.values()) {
            if (groupeSanguin.value.equalsIgnoreCase(value)) {
                return groupeSanguin;
            }
        }
        throw new IllegalArgumentException("Groupe sanguin invalide : " + value);
    }
}
