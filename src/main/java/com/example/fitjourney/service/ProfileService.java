package com.example.fitjourney.service;

import java.util.List;

import com.example.fitjourney.dto.request.ProfileRequestDTO;
import com.example.fitjourney.dto.response.ProfileResponseDTO;

public interface ProfileService {

	ProfileResponseDTO createProfile(ProfileRequestDTO dto);

	ProfileResponseDTO getById(Long id);

	ProfileResponseDTO getByUserId(Long userId);

	List<ProfileResponseDTO> getAll();

	ProfileResponseDTO update(Long id, ProfileRequestDTO dto);

	void delete(Long id);

}
