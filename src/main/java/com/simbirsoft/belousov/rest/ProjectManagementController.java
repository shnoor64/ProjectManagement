package com.simbirsoft.belousov.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Управление")
@RequestMapping("/api/projectManagement")
@RestController
public class ProjectManagementController {
}
