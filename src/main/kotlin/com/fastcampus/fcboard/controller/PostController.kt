package com.fastcampus.fcboard.controller

import com.fastcampus.fcboard.controller.dto.*
import org.springdoc.core.parsers.ReturnTypeParser
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
class PostController(@Qualifier("genericReturnTypeParser") private val genericReturnTypeParser: ReturnTypeParser) {

   @PostMapping("/posts")
   fun createPost(
      @RequestBody postCreateRequest: PostCreateRequest,
   ): Long {
      return 1L
   }

   @PutMapping("/posts/{id}")
   fun updatePost(
      @PathVariable id: Long,
      @RequestBody postUpdateRequest: PostUpdateRequest,
   ): Long {
      return 1L
   }

   @DeleteMapping("/posts/{id}")
   fun deletePost(
      @PathVariable id: Long,
      @RequestParam createdBy: String,
   ): Long {
      return id
   }

   @GetMapping("/posts/{id}")
   fun getPost(
      @PathVariable id: Long,
   ): PostDetailResponse {
      return PostDetailResponse(1L, "title", "content", "createdBy", LocalDateTime.now().toString())
   }

   @GetMapping("/posts")
   fun getPosts(
      pageable: Pageable,
      postSearchRequest: PostSearchRequest,
   ): Page<PostSummaryResponse> {
      println("title: ${postSearchRequest.title}")
      println("createdBy: ${postSearchRequest.createdBy}")
      return Page.empty()
   }
}
