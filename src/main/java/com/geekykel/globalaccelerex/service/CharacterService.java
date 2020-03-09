package com.geekykel.globalaccelerex.service;

import com.geekykel.globalaccelerex.model.Character;

import java.util.List;

/**
 * @author Kelvin on 09/03/2020
 *
 */
public interface CharacterService {

    Character getCharacter(long id);

    List<Character> getCharacterByNameOrGenderOrSpecies(String sortBy, String order) throws Exception;

}
