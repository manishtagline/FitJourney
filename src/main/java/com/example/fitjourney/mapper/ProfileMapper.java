package com.example.fitjourney.mapper;

import org.springframework.stereotype.Component;

import com.example.fitjourney.dto.request.ProfileRequestDTO;
import com.example.fitjourney.dto.response.ProfileResponseDTO;
import com.example.fitjourney.entity.Profile;

@Component
public class ProfileMapper {

	public static Profile toEntity(ProfileRequestDTO request) {
		if (request == null)
			return null;

		Profile profile = new Profile();

		profile.setAge(request.getAge());
		profile.setHeight(request.getHeight());
		profile.setWeight(request.getWeight());
		profile.setFitnessLevel(request.getFitnessLevel());

		return profile;

	}

	public ProfileResponseDTO toDto(Profile p) {
		if (p == null)
			return null;
		
		ProfileResponseDTO response = new ProfileResponseDTO();
		
		response.setProfileId(p.getProfileId());
		response.setAge(p.getAge());
		response.setHeight(p.getHeight());
		response.setWeight(p.getWeight());
		response.setBmi(p.calculateBMI());
		response.setFitnessLevel(p.getFitnessLevel());
		if(p.getUser() != null) response.setUserId(p.getUser().getUserId());
		
		return response;
		
	}

}
