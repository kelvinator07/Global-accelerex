package com.geekykel.globalaccelerex.controller;

import com.geekykel.globalaccelerex.model.Episode;
import com.geekykel.globalaccelerex.service.EpisodeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kelvin on 09/03/2020
 *
 */
@RestController
@RequestMapping("/api")
public class EpisodeController {

    @Autowired
    private EpisodeService episodeService;


    @GetMapping("/episodes")
    @ApiOperation(value = "Get All Episodes")
    public List<Episode> getAllEpisodes() throws Exception {

        return episodeService.getAllEpisodes();

    }

    @GetMapping("/episodes/{id}")
    @ApiOperation(value = "Get Episode By ID")
    public Episode getEpisodeById(@PathVariable long id) {

        return episodeService.getEpisode(id);

    }

}
