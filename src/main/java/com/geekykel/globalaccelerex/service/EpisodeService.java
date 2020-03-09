package com.geekykel.globalaccelerex.service;

import com.geekykel.globalaccelerex.model.Episode;

import java.util.List;

/**
 * @author Kelvin on 09/03/2020
 *
 */
public interface EpisodeService {

    Episode getEpisode(long id);

    List<Episode> getAllEpisodes() throws Exception;

}
