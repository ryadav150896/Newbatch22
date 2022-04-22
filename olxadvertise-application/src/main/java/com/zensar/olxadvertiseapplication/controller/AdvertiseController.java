package com.zensar.olxadvertiseapplication.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxadvertiseapplication.entity.Advertisement;

@RestController
public class AdvertiseController {

	static List<Advertisement> ListOfAdvertisement = new ArrayList();

	// static {
	// ListOfAdvertisement.add(new Advertisement(1,""))

	// }
	// post a new Advertisement
	// http//localhost:1010/advertise
	@PostMapping(value = "/advertise", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Advertisement>> createNewAdvertise(@RequestBody Advertisement advertise,
			@RequestHeader("auth-token") String token) {

		if (token.equals("ry66540")) {

			ListOfAdvertisement.add(advertise);

		} else {
			return new ResponseEntity<List<Advertisement>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Advertisement>>(ListOfAdvertisement, HttpStatus.OK);
	}

	// Reads specific advertisement posed by logged in user
	// http//localhost:1010/user/advertise/
	@GetMapping(value = "/user/advertise/{id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public Advertisement getAdvertise(@PathVariable long id) {
		Optional<Advertisement> advertise1 = ListOfAdvertisement.stream().filter(advertise -> advertise.getId() == id)
				.findAny();

		if (advertise1.isPresent()) {
			return advertise1.get();
		}

		return advertise1.orElseGet(() -> {
			return new Advertisement();
		});
	}

	// to update existing Advertisement
	// http//localhost:1010/advertise/
	@PutMapping(value = "/advertise/{id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public Advertisement updateAdvertisement(@PathVariable int id, @RequestBody Advertisement advertise,
			@RequestHeader("auth-token") String token) {
		if (token.equals("ry66540")) {

			Advertisement availableadvertise = getAdvertise(id);
			availableadvertise.setTitle(advertise.getTitle());
			availableadvertise.setCategory(advertise.getCategory());
			availableadvertise.setDescription(advertise.getDescription());
			return availableadvertise;
		} else {
			return new Advertisement();
		}
	}

	// Reads all advertisements posted by logged in user
	// http//localhost:1010/user/advertise
	@GetMapping(value = "/user/advertise", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Advertisement>> getAllAdvertisements(@RequestHeader("auth-token") String token) {
		if (token.equals("ry66540")) {

		} else {
			return new ResponseEntity<List<Advertisement>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Advertisement>>(ListOfAdvertisement, HttpStatus.ACCEPTED);
	}

	// Deletes specific advertisement posted by logged in user
	// http//localhost:1010/user/advertise/
	@DeleteMapping("/user/advertise/{id}")
	public ResponseEntity<String> deleteAdvertisement(@PathVariable int id, @RequestHeader("auth-token") String token) {
		for (Advertisement advertise : ListOfAdvertisement) {

			if (token.equals("ry66540") && advertise.getId() == id) {

				ListOfAdvertisement.remove(advertise);

			} else {
				return new ResponseEntity<String>("Advertise Not found", HttpStatus.BAD_GATEWAY);
			}

		}
		return new ResponseEntity<String>("advertise deleted successfuly", HttpStatus.OK);
	}

	// get the details of advertise
	// http//localhost:1010/advertise/
	@GetMapping(value = "/advertise/{id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Advertisement> getAdvertisedetails(Advertisement advertise, int id,
			@RequestHeader("auth-token") String token) {
		if (token.equals("ry66540") && advertise.getId() == id) {
			return new ResponseEntity<Advertisement>(advertise, HttpStatus.OK);

		} else {
			return new ResponseEntity<Advertisement>(HttpStatus.BAD_REQUEST);
		}
	}
}