package com.geekykel.globalaccelerex.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.geekykel.globalaccelerex.model.Episode;
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
public class EpisodeServiceImpl implements EpisodeService {

    @Value("${rickandmortyapi.episode}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Episode getEpisode(long id) {

        return restTemplate.getForObject(apiUrl + "/" + id, Episode.class);

    }

    @Override
    public List<Episode> getAllEpisodes() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response.getBody());
        JsonNode results = root.path("results");
        ObjectReader reader = objectMapper.readerFor(new TypeReference<List<Episode>>(){});
        List<Episode> episodeList = reader.readValue(results);

        // Sort EpisodeList by Date
        episodeList.sort(Comparator.comparing(Episode::getCreated));

        return episodeList;
    }

}
