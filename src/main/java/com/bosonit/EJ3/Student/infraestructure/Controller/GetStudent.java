package com.bosonit.EJ3.Student.infraestructure.Controller;


import com.bosonit.EJ3.Student.application.Port.GetStudentPort;
import com.bosonit.EJ3.Student.domain.StudentEnt;
import com.bosonit.EJ3.Student.infraestructure.DTOs.OutputDTOStudentFull;
import com.bosonit.EJ3.Student.infraestructure.DTOs.OutputStudentDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class GetStudent {

    @Autowired
    GetStudentPort getStudentPort;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/id/{id}")
//return DTOs diferentes
    public OutputStudentDTO StudentByID(@PathVariable String id, @RequestParam(defaultValue = "simple",required = false) String outputType) throws Exception {
        if (outputType.equals("full")) {
            return new OutputDTOStudentFull(getStudentPort.getStudentByID(id));
        }else{
            return new OutputStudentDTO(getStudentPort.getStudentByID(id));
        }
    }

    @GetMapping("/all")
    public List<OutputStudentDTO> getAllStudent(){
        List <StudentEnt> studentEntList = getStudentPort.getAllStudent();
        TypeToken<List<OutputStudentDTO>> typeToken = new TypeToken<>() {
        };
        List<OutputStudentDTO> outputStudentDTOList = modelMapper.map(studentEntList, typeToken.getType());
        return outputStudentDTOList;
    }
}
