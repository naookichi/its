package com.example.its.domain.issue;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueSurvice {
    private final IssueRepository issueRepository;//RequiredArgsConstructorによって自動的にインジェクションされる 自動的に継承もされている

    public IssueEntity findById(long issueId) {
        return issueRepository.findById(issueId);
    }

    public List<IssueEntity> findAll(){
        return issueRepository.findAll();
    }

    @Transactional
    public void create(String summary, String description) {
        issueRepository.insert(summary,description);
    }
}
