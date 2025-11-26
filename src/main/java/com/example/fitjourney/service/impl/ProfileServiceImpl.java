package com.example.fitjourney.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.fitjourney.dto.request.ProfileRequestDTO;
import com.example.fitjourney.dto.response.ProfileResponseDTO;
import com.example.fitjourney.entity.Profile;
import com.example.fitjourney.entity.User;
import com.example.fitjourney.exception.ResourceNotFoundException;
import com.example.fitjourney.mapper.ProfileMapper;
import com.example.fitjourney.repository.ProfileRepository;
import com.example.fitjourney.repository.UserRepository;
import com.example.fitjourney.service.ProfileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileServiceImpl implements ProfileService {

	private final ProfileRepository profileRepo;

	private final UserRepository userRepo;

	private final ProfileMapper profileMapper;

	@Override
	public ProfileResponseDTO createProfile(ProfileRequestDTO dto) {
		log.info("Creating profile of user Id:{}", dto.getUserId());

		User user = userRepo.findById(dto.getUserId()).orElseThrow(() -> {
			log.error("User not found for Id:{}", dto.getUserId());
			return new ResourceNotFoundException("User not found!!!");
		});

		Profile profile = profileMapper.toEntity(dto);
		profile.setUser(user);

		Profile savedProfile = profileRepo.save(profile);

		log.info("Profile created with profileId:{}", profile.getProfileId());

		return profileMapper.toDto(savedProfile);
	}

	@Override
	public ProfileResponseDTO getById(Long id) {
		log.info("Fetching profile by profileId: {}", id);

		Profile profile = profileRepo.findById(id).orElseThrow(() -> {
			log.warn("Profile not found for profileId: {}", id);
			return new ResourceNotFoundException("Profile not found");
		});

		log.debug("Profile found for profileId: {}", profile.getProfileId());
		return profileMapper.toDto(profile);
	}
	
	

	@Override
	public ProfileResponseDTO getByUserId(Long userId) {
		log.info("Fetching profile for userId: {}", userId);

		Profile profile = profileRepo.findByUserUserId(userId).orElseThrow(() -> {
			log.warn("Profile not found for userId: {}", userId);
			return new ResourceNotFoundException("Profile not found");
		});

		log.debug("Profile found with profileId: {} for userId: {}", profile.getProfileId(), userId);
		return profileMapper.toDto(profile);
	}

	
	
	@Override
	public List<ProfileResponseDTO> getAll() {
		log.info("Fetching all profiles");

		List<ProfileResponseDTO> profiles = profileRepo.findAll().stream().map(profileMapper::toDto)
				.collect(Collectors.toList());

		log.debug("Total profiles fetched: {}", profiles.size());
		return profiles;
	}
	
	

	@Override
	public ProfileResponseDTO update(Long id, ProfileRequestDTO dto) {
		log.info("Updating profile with profileId: {}", id);

		Profile profile = profileRepo.findById(id).orElseThrow(() -> {
			log.warn("Cannot update. Profile not found for profileId: {}", id);
			return new ResourceNotFoundException("Profile not found");
		});

		profile.setAge(dto.getAge());
		profile.setHeight(dto.getHeight());
		profile.setWeight(dto.getWeight());
		profile.setFitnessLevel(dto.getFitnessLevel());

		Profile updated = profileRepo.save(profile);

		log.debug("Profile updated successfully for profileId: {}", id);
		return profileMapper.toDto(updated);
	}
	
	

	@Override
	public void delete(Long id) {
		log.info("Deleting profile with profileId: {}", id);

		if (!profileRepo.existsById(id)) {
			log.warn("Cannot delete. Profile not found for profileId: {}", id);
			throw new ResourceNotFoundException("Profile not found");
		}

		profileRepo.deleteById(id);
		log.info("Profile deleted successfully. profileId: {}", id);
	}

}
