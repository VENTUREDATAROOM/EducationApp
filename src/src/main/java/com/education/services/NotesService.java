package com.education.services;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.multipart.MultipartFile;

import com.education.entity.Notes;
import com.education.model.NotesDTO;
import com.education.repository.NotesRepo;
@Service
public class NotesService 
{
   @Autowired
   NotesRepo notesRepo;
	
	@Autowired
	ModelMapper mapper;
	
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NotesService.class);
	public NotesDTO saveNote(NotesDTO notesDTO)
	{
		try
		{
		Notes n=new Notes();
		n.setNoteNames(notesDTO.getNotesName());
		//String classCode=generateUniqueClassCode();
		n.setClassCode(notesDTO.getClassCode());
		//n.setClassCode(notesDTO.getClassCode());
		byte[] noteBytes=Base64.getEncoder().encode(notesDTO.getNotePdf().getBytes());
		n.setNotesPdf(Base64.getEncoder().encode(noteBytes));
		String baseNotePdf=Base64.getEncoder().encodeToString(notesDTO.getNotePdf().getBytes());		notesRepo.save(n);
		//NotesDTO sDTO=mapper.map(n, NotesDTO.class);
		
		notesDTO.setNotePdf(null);
		notesDTO.setBaseNotePdf(baseNotePdf);
		return notesDTO;
		}catch(Exception e)
		{
			log.error("There is error for note {} ",e.getMessage());
			return notesDTO;
		}
		
	}
	public List<NotesDTO> getAllNote()
	{
		List<Notes> noteList= notesRepo.findAll();
		return noteList.stream().map(this::convertToDTO).collect(Collectors.toList());
	}
	/*public List<Notes> getTestSeriesByClassCode(String classCode)
	{
		
		return notesRepo.findByClassCode(classCode);
	}*/
	/*public NotesDTO mapToDTOWithDecodedPdf(Notes notes) {
	    NotesDTO notesDTO = new NotesDTO();
	    notesDTO.setNoteId(notes.getNotesId());
	    notesDTO.setNoteNames(notes.getNoteNames());
	    notesDTO.setClassCode(notes.getClassCode());
	    // Decode the Base64 encoded PDF
	    byte[] decodedPdf = Base64.getDecoder().decode(notes.getNotesPdf());
	    notesDTO.setBaseNotePdf(new String(decodedPdf));
	    return notesDTO;
	}*/
	public List<NotesDTO>  getAllNotesByClass(String classCode)
	{
		List<Notes> noteList=notesRepo.findByClassCode(classCode);
		return noteList.stream().map(this::convertToDTO).collect(Collectors.toList());
		
		
	}
	private NotesDTO  convertToDTO(Notes notes)
	{
		NotesDTO notesDTO=new NotesDTO();
		notesDTO.setNoteId(notes.getNotesId());
		//String classCode=generateUniqueClassCode();
		notesDTO.setNotesName(notes.getNoteNames());
		notesDTO.setClassCode(notes.getClassCode());
		//notesDTO.setBaseNotePdf(baseNotePdf);
		byte[] decodedPdf = Base64.getDecoder().decode(notes.getNotesPdf());
		String baseNotePdf=new String(decodedPdf,StandardCharsets.UTF_8);
		notesDTO.setBaseNotePdf(baseNotePdf);
		return notesDTO;
	}


}

