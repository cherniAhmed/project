package com.example.project.Entity;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class GroupeSanguinDeserializer extends JsonDeserializer<GroupeSanguin> {

    @Override
    public GroupeSanguin deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.getText();
        try {
            return GroupeSanguin.fromValue(value);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Groupe sanguin invalide : " + value);
        }
    }
}
