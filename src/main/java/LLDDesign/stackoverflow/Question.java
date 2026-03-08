package LLDDesign.stackoverflow;

import java.util.List;

public class Question extends Entity{
    List<EditHistory> editHistory;
    List<Answer> anserList;
    List<Tag> tags;
    String title;
    String description;
    QuestionStatus status;
    public boolean addQuestion();
    public boolean addTag(Tag tag);

}
