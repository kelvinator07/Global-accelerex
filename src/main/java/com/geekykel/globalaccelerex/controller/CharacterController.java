package com.geekykel.globalaccelerex.controller;

import com.geekykel.globalaccelerex.model.Character;
import com.geekykel.globalaccelerex.response.CharacterResponse;
import com.geekykel.globalaccelerex.service.CharacterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kelvin on 09/03/2020
 *
 */
@RestController
@RequestMapping("/api")
public class CharacterController {

    @Autowired
    private CharacterService characterService;


    @GetMapping("/character/{id}")
    @ApiOperation(value = "Get Character By ID")
    public Character getCharacterById(@PathVariable long id) {

        return characterService.getCharacter(id);

    }

    @GetMapping("/character")
    @ApiOperation(value = "Get List of Characters By Name, Gender or Species in Ascending or Descending Order")
    public ResponseEntity<CharacterResponse> getCharacterByNameOrGenderOrSpecies(@RequestParam String sortBy,
                                                                                @RequestParam(defaultValue = "ASC", required = false) String order) throws Exception {

        List<Character> characterList = characterService.getCharacterByNameOrGenderOrSpecies(sortBy, order);

        return new ResponseEntity<>(new CharacterResponse(characterList.size(), characterList), HttpStatus.OK);

    }

}
