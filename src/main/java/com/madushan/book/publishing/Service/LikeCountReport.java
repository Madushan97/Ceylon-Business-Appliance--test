package com.madushan.book.publishing.Service;

import com.madushan.book.publishing.Entity.Author;
import com.madushan.book.publishing.Repository.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LikeCountReport {

    private static final Logger logger = LoggerFactory.getLogger(LikeCountReport.class);

    @Autowired
    private AuthorRepository authorRepository;

    @Scheduled(fixedRate = 300000)
    public void generateLikeCountReport() {

        logger.info("Generating like count report...");

        Iterable<Author> authors = authorRepository.findAll();

        for (Author author : authors ) {

            int likeCount = author.getLikeCount();

            logger.info("Author: {} | Like Count: {}", author.getFirstName(), likeCount);
        }

        logger.info("Like count report generation completed.");
    }
}
