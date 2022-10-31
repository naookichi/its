package com.example.its.web.issue;

import com.example.its.domain.issue.IssueEntity;
import com.example.its.domain.issue.IssueSurvice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("issues")
@RequiredArgsConstructor
public class issueController {

    private final IssueSurvice issueSurvice;

    // GET/issuesが来た時に動く
    @GetMapping
    public String showList(Model model){
        model.addAttribute("issueList",issueSurvice.findAll());
        return "issues/list";
    }

    // GET/issues/creationForm
    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute IssueForm form){
        return "issues/creationForm";
    }

    // POST /issues
    @PostMapping
    public String create(@Validated IssueForm form, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return showCreationForm(form);
        }

        issueSurvice.create(form.getSummary(),form.getDescription());
        //return showList(model);//TODO リロードボタン対策が必要
        return "redirect:/issues";
    }

    // GET localhost:8080/issues/1
    @GetMapping("{issueId}")
    public String showDatail(@PathVariable("issueId") long issueId,Model model){
        Model issue = model.addAttribute("issue", issueSurvice.findById(issueId));
        return "issues/detail";
    }
}
