package com.sunbeam.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.StationDao;
import com.sunbeam.entities.Station;

@Transactional
@Service
public class StationServiceImpl implements StationService{
	@Autowired
	private StationDao stationDao;

	@Override
	public List<Station> findAllStation() {
		List<Station> stations = stationDao.findAll();
		return stations;
	}
}
