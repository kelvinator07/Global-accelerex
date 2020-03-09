package com.geekykel.globalaccelerex.response;

import com.geekykel.globalaccelerex.model.Character;

import java.util.List;

/**
 * @author Kelvin on 09/03/2020
 *
 */
public class CharacterResponse {

    private int count;
    private List<Character> characters;

    public CharacterResponse(int count, List<Character> characters) {
        this.count = count;
        this.characters = characters;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
