package com.education.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.education.entity.Notes;
import com.education.model.NotesDTO;
import com.education.model.ResponseWithList;
import com.education.model.ResponseWithObject;
import com.education.services.NotesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@CrossOrigin(origins="*")
@RequestMapping("api")
@Tag(name="Note-API")
public class NoteController {
	
	
	@Autowired
	NotesService notesService;
	@PostMapping(value="/addNotes",consumes=MediaType.MULTIPART_FORM_DATA_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary="add Notes",description="this api is basically to add notes")
	public ResponseEntity<?>  addNote(@ModelAttribute NotesDTO noteDTO)
	{
		NotesDTO sDTO=notesService.saveNote(noteDTO);
		if(sDTO!=null)
		{
			return new ResponseWithObject().generateResponse("Notes are saved successfully",HttpStatus.OK,"200",sDTO);
			
		}
		else
		{
			return new ResponseWithObject().generateResponse("Notes are not saved successfully",HttpStatus.INTERNAL_SERVER_ERROR,"500","");
		}
		
	}
	@GetMapping(value="/findNote")
	@Operation(summary="to get all the notes",description="this api is used to get the list of all notes")
	public ResponseEntity<?> getAllNotes()
	{
		List<NotesDTO> c=notesService.getAllNote();
		return new ResponseWithList().generateResponse("provide",HttpStatus.OK,"200",c);
	}
	
	
	@GetMapping(value = "/findNoteByClassCode")
	@Operation(summary="to get notes by class code",description="this api is to get notes through classcode")
	public ResponseEntity<?> getNotesByClassCode(@RequestParam("classcode") String classCode) {
	    //List<Notes> notesList = notesService.getNotesByClassCode(classCode);
	    List<NotesDTO> notesDTOList = notesService.getAllNotesByClass(classCode);
	    return new ResponseWithList().generateResponse("provide", HttpStatus.OK, "200", notesDTOList);
	}
	

}
