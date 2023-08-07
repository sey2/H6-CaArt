package com.softeer.caart.domain.model.controller;

import com.softeer.caart.global.response.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tests")
@AllArgsConstructor
@Tag(name = "Test", description = "test API")
public class ModelController {
    @Operation(summary = "test", description = "api for swagger test")
    @PostMapping("")
    public ResponseDto test(){
        return ResponseDto.success();
    }
}