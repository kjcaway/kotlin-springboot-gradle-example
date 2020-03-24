package com.example.demo.api.contents

import com.example.demo.api.contents.domain.Content
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/contents")
class ContentsController {
    @GetMapping()
    fun index() = Content(1, "Test title", "TestTestTest")
}