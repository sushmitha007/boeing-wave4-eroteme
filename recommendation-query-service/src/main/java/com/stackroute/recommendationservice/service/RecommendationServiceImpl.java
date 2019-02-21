package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.model.Question;
import com.stackroute.recommendationservice.model.QuestionRequested;
import com.stackroute.recommendationservice.model.User;
import com.stackroute.recommendationservice.repository.RecommendationRepository;
import com.stackroute.recommendationservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RecommendationServiceImpl  implements RecommendationService {


//    @Autowired
    private UserRepository userRepository;

//    @Autowired
    private RecommendationRepository recommendationRepository;

    @Override
    public List<Question> getAllUnansweredQuestions(String userName) {
        return userRepository.findAllUnansweredQuestion(userName);
    }

    @Override
    public QuestionRequested getDocumentByQuestionId(long questionId) {
        Optional<QuestionRequested> questionDocument = recommendationRepository.findById(questionId);
        return questionDocument.orElseGet(() -> {
            log.info("Document not found for the ID {}. Returning empty document", questionId);
            return questionDocument.get();
        });
    }

    @Override
    public List<User> getAllUsers() {
//        return userRepository.findAllUsers();
        return null;
    }

    @Override
    public List<Question> getTrendingQuestionsForUser(String username) {
//        return userRepository.getAllTrendingQuestionsForUser(username);
        return null;
    }



}