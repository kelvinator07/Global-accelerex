package com.geekykel.globalaccelerex.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.geekykel.globalaccelerex.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;

/**
 * @author Kelvin on 09/03/2020
 *
 */
@Service
public class CharacterServiceImpl implements CharacterService {

    @Value("${rickandmortyapi.character}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Character getCharacter(long id) {

        return restTemplate.getForObject(apiUrl + "/" + id, Character.class);

    }

    @Override
    public List<Character> getCharacterByNameOrGenderOrSpecies(String sortBy, String order) throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response.getBody());
        JsonNode results = root.path("results");
        ObjectReader reader = objectMapper.readerFor(new TypeReference<List<Character>>(){});
        List<Character> charactersList = reader.readValue(results);

        // Sort CharactersList by name, gender or species in ascending or descending order
        switch(sortBy) {
            case "name" :
                if (order.equals("DESC")) {
                    charactersList.sort(Comparator.comparing(Character::getName).reversed());
                } else {
                    charactersList.sort(Comparator.comparing(Character::getName));
                }
                break;

            case "gender" :
                if (order.equals("DESC")) {
                    charactersList.sort(Comparator.comparing(Character::getGender).reversed());
                } else {
                    charactersList.sort(Comparator.comparing(Character::getGender));
                }
                break;

            case "species" :
                if (order.equals("DESC")) {
                    charactersList.sort(Comparator.comparing(Character::getSpecies).reversed());
                } else {
                    charactersList.sort(Comparator.comparing(Character::getSpecies));
                }
                break;
        }

        return charactersList;
    }
}
