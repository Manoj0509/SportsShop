package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.IProfileRepository;
import com.entities.Profile;

@Service
public class ProfileServiceImpl implements IProfileService {

	@Autowired
	IProfileRepository profileDao;
	
	@Override
	public List<Profile> getProfiles() {
		return profileDao.findAll();
	}

	@Override
	public Profile addProfile(Profile profile) {
		return null;
	}

	@Override
	public void deleteProfile(int profileId) {
		

	}

	@Override
	public Profile updateProfile(int profileId, Profile profile) {
		
		return null;
	}

	@Override
	public Profile getProfileById(int profileId) {
		
		return null;
	}

}