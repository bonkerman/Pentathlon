package Pentathlon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import Pentathlon.data.AthleteRepository;
import utils.Reader;
import Pentathlon.data.Athlete;

@RestController
public class PentathlonController {

	@Autowired
	private final AthleteRepository repository;

	public PentathlonController(AthleteRepository repository) {
		this.repository = repository;
	}

	@GetMapping(value = "/athletes")
	public @ResponseBody List<Athlete> athletes() {
		return repository.findAll();
	}

	@GetMapping(value = "/athletes/{count}")
	public @ResponseBody List<Athlete> athletes(@PathVariable int count) {
		return repository.findAll().subList(0, count);
	}

	@GetMapping(value = "/athlete/id/{id}")
	@ResponseBody
	Athlete idAthlete(@PathVariable Integer id) {
		return repository.findById(id).get();
	}
	
	@GetMapping(value = "/athlete/id/delete/{id}")
	@ResponseBody
	private RedirectView idAthleteDelete(@PathVariable Integer id) {
		repository.deleteById(id);
		return new RedirectView("/");
				
	}

	@GetMapping(value = "/athlete/name/{name}")
	@ResponseBody
	Athlete athleteName(@PathVariable String name) {
		return repository.findByName(name);
	}
	
	@GetMapping(value = "/athlete/name/delete/{name}")
	@ResponseBody
	private RedirectView athleteNameDelete(@PathVariable String name) {
		repository.deleteByName(name);
		return new RedirectView("/");
	}

	@PostMapping("/showFile")
	public RedirectView showTableFromFile(@RequestParam("file") MultipartFile file) {
		
		if (file.isEmpty() || !file.getOriginalFilename().contains(".csv")) {
			return new RedirectView("/");
		}
		try {
			byte[] bytes = file.getBytes();
			ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
			Reader.readData(inputStream, repository);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new RedirectView("/");
	}
	
	@PostMapping("/addFile")
	public RedirectView addTableFromFile(@RequestParam("file") MultipartFile file) {

		if (file.isEmpty() || !file.getOriginalFilename().contains(".csv")) {
			return new RedirectView("/");
		}
		try {
			byte[] bytes = file.getBytes();
			ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
			Reader.readDataAdd(inputStream, repository);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new RedirectView("/");
	}
}
