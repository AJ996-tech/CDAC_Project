package com.sunbeam.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("/routes")
	public ResponseEntity<?> getStations() {
		List<Station> stations = stationService.findAllStation();
		List<StationDTO> result = new ArrayList<>();

		for (Station station : stations)
			result.add(StationDTO.fromEntity(station));
		return Response.success(result);
	}

	@GetMapping("/stationlist")
	public ResponseEntity<?> findStationAll() {
		List<Station> list = stationService.findStationAll();
		List<StationDTO> result = new ArrayList<>();
		for (Station station : list)
			result.add(StationDTO.fromEntity(station));
		return Response.success(result);
	}

	@PostMapping("/addstation")
	public ResponseEntity<?> save(StationDTO stationDto) {
		Station station = StationDTO.toEntity(stationDto);
		Station s = stationService.saveStation(station);
		return Response.success(s);
	}

	@DeleteMapping("/stationlist/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
		boolean success = stationService.deleteById(id);
		return ResponseEntity.ok(success);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllStations(){
		List<String> list= stationService.findAll();
		if(list!=null)
			return Response.success(list);
		return Response.error("Stations not Found..!");
	}
}
