package com.stackroute.recommendationcommandservice.service;


import com.stackroute.recommendationcommandservice.model.Answer;
import com.stackroute.recommendationcommandservice.model.Question;
import com.stackroute.recommendationcommandservice.model.User;
import com.stackroute.recommendationcommandservice.repository.AnswerRepository;
import com.stackroute.recommendationcommandservice.repository.QuestionRepository;
import com.stackroute.recommendationcommandservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RecommendationCommandServiceImpl implements RecommendationCommandService {
    private UserRepository userRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    @Autowired
    public RecommendationCommandServiceImpl(UserRepository userRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public User saveUserToDb(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public Collection<User> getUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public Question saveQuestionToDb(Question question) {
        questionRepository.save(question);
        return question;
    }

    @Override
    public Collection<Question> getQuestions() {

        return questionRepository.getAllQuestions();
    }

    @Override
    public Answer saveAnswerToDb(Answer answer) {

        answerRepository.save(answer);
        return answer;
    }

    @Override
    public Collection<Answer> getAnswers() {

        return answerRepository.getAllAnswers();
    }

//    @Override
//    public void deleteAnswers(long answerId) {
//
//
//        answerRepository.deleteById(answerId);
//    }

    @Override
    public User userfollowstopic(String userName, String Name) {

        return userRepository.userfollowstopicrelationship(userName, Name);

    }

    @Override
    public User getByUser(int reputation) {

        return userRepository.getByUser(reputation);
    }

    @Override
    public Question questionbelongstopic(int questionId, String Name) {

        return questionRepository.questionbelongstopicrelationship(questionId, Name);
    }

    @Override
    public User useransweredanswer(String userName, int answerId) {

        return answerRepository.useransweredanswerrelationship(userName, answerId);
    }

    @Override
    public User userviewedquestion(String userName, int questionId) {

        return questionRepository.userviewedquestionrelationship(userName, questionId);

    }

    @Override
    public Answer answerisanswerofquestion(int answerId, int questionId) {

        return questionRepository.answerisanswerofquestionrelationship(answerId, questionId);

    }

    @Override
    public User useraskedquestion(String userName, int questionId) {

        return questionRepository.useraskedquestionrelationship(userName, questionId);

    }

    @Override
    public User useracceptedanswer(String userName, int answerId) {

        return answerRepository.useracceptedanswerrelationship(userName, answerId);

    }

    @Override
    public User userupvotedanswer(String userName, int answerId) {

        return answerRepository.userupvotedanswerrelationship(userName, answerId);

    }

    @Override
    public User userdownvotedanswer(String userName, int answerId) {

        return answerRepository.userdownvotedanswerrelationship(userName, answerId);

    }

    @Override
    public User userupvotequestion(String userName, int questionId) {

        return questionRepository.userupvotequestionrelationship(userName, questionId);

    }

    @Override

    public User userdownvotequestion(String userName, int questionId) {

        return questionRepository.userdownvotequestionrelationship(userName, questionId);

    }


}