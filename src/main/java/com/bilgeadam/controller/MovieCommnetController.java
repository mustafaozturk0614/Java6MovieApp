package com.bilgeadam.controller;

import com.bilgeadam.repository.entity.MovieComment;
import com.bilgeadam.service.MovieCommentService;
import com.bilgeadam.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class MovieCommnetController {


private final MovieCommentService movieCommentService;
    @GetMapping("/findymovieid/{movieId}")
    public ResponseEntity <List<MovieComment>> findAllByMovieId(Long movieId){
        return ResponseEntity.ok( movieCommentService.findAllByMovieId(movieId));
    }
    @GetMapping("/findyuserid/{userId}")
    public  ResponseEntity <List<MovieComment>> findAllByUserId(Long userId){
        return ResponseEntity.ok(movieCommentService.findAllByUserId(userId));
    }
    @GetMapping("/findymovieidanddate")
    public  ResponseEntity <List<MovieComment>> findAllByMovieIdAndDateBetween(Long movieId, String start, String end){
        return  ResponseEntity.ok(movieCommentService.findAllByMovieIdAndDateBetween(movieId,start,end));
    }
    @GetMapping("/findyuseridanddate")
    public   ResponseEntity <List<MovieComment>> findAllByUserIdAndDateBetween(Long userId, String start, String end){
        return ResponseEntity.ok( movieCommentService.findAllByUserIdAndDateBetween(userId,start,end));
    }

}
