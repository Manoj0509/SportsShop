package com.services;

import java.util.List;

import com.entities.Profile;

public interface IProfileService {
	
	List<Profile> getProfiles();
	Profile addProfile(Profile profile);
	void deleteProfile(int profileId);
	Profile updateProfile(int profileId, Profile profile);
	Profile getProfileById(int profileId);

}