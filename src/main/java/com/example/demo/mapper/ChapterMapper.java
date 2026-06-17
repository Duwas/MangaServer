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

        response.setContentImages(chapter.getContentImages());

        response.setViews(chapter.getViews());

        response.setCreatedAt(chapter.getCreatedAt());

        if (chapter.getManga() != null) {

            response.setMangaId(
                    chapter.getManga().getId()
            );

            response.setMangaTitle(
                    chapter.getManga().getTitle()
            );
        }

        return response;
    }
}