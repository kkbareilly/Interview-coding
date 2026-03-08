package LLDDesign.stackoverflow;

import javax.xml.stream.events.Comment;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Entity {
    int entityId;
    Members creator;
    Map<VoteType,Integer>votes;
    Date creationDate;
    List<Comment> comments;
    public boolean flagEntity(Members members);
    public boolean voteEntity(VoteType voteType);
    public boolean addComment(Comment comment);
}
