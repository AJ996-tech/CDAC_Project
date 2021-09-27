package com.sunbeam.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Station;
import com.sunbeam.models.Response;
import com.sunbeam.models.StationDTO;
import com.sunbeam.services.StationService;

@CrossOrigin
@RequestMapping("/station")
@RestController
public class StationController {
	@Autowired
	private StationService stationService;
//	@Autowired
//	private StationDTO stationDto;
	
	@GetMapping("/routes")
	public ResponseEntity<?> getStations(){
//		List<Artist> list = artistService.findArtistAll();
//		//Stream<ArtistDTO> result = list.stream().map(artist -> ArtistDTO.fromEntity(artist));
//		List<ArtistDTO> result = new ArrayList<ArtistDTO>();
//		for (Artist artist : list)
//			result.add( ArtistDTO.fromEntity(artist) );
//		return Response.success(result);
		
		List<Station> stations = stationService.findAllStation();
		List<StationDTO> result = new ArrayList<>();
	
		for (Station station : stations)
			result.add( StationDTO.fromEntity(station) );
		return Response.success(result);
	}
}
