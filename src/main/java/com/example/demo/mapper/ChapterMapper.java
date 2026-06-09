package com.example.demo.mapper;

import com.example.demo.dto.Chapter.ChapterResponse;
import com.example.demo.models.Chapter.Chapter;
import org.springframework.stereotype.Component;

@Component
public class ChapterMapper {

    public ChapterResponse toResponse(Chapter chapter) {

        ChapterResponse response = new ChapterResponse();

        response.setId(chapter.getId());
        response.setTitle(chapter.getTitle());
        response.setChapterNumber(chapter.getChapterNumber());

        response.setMangaId(
                chapter.getManga().getId()
        );
        response.setContentImage(
                chapter.getContentImage()
        );
        response.setMangaTitle(
                chapter.getManga().getTitle()
        );

        response.setCreatedAt(
                chapter.getCreatedAt()
        );


        return response;
    }
}